package com.tap.starbucks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.starbucks.entity.RunwayEntity;
import com.tap.starbucks.service.RunwayService;

@Controller
public class RunwayController {

	private RunwayService runwayService;

	@Autowired
	public RunwayController(RunwayService runwayService) {
		super();
		this.runwayService = runwayService;
	}

	@RequestMapping(value = "/saveData")
	public String saveData(@RequestParam int length, @RequestParam int width, @RequestParam String surfaceType,
			@RequestParam String direction, Model model) {
		System.out.println("invoked saveData()");
		System.out.println("length " + length);
		System.out.println("width " + width);
		System.out.println("surfaceType " + surfaceType);
		System.out.println("direction " + direction);
		boolean isValid = runwayService.validateRunwayObject(length, width, surfaceType, direction);
		if (isValid) {
			model.addAttribute("responseMessage", "DATA IS VALID & SAVED");
			model.addAttribute("isValid", true);
		} else {
			model.addAttribute("responseMessage", "DATA IS INVALID & NOT SAVED");
			model.addAttribute("isValid", false);
		}

		return "/runway.jsp";
	}

	@RequestMapping(value = "/updateRunwayByID")
	public String updateRunwayByID(@RequestParam int runwayID, @RequestParam int length, @RequestParam int width,
			@RequestParam String surfaceType, @RequestParam String direction, Model model) {
		System.out.println("invoked updateRunwayByID()");
		if (runwayService.validateRunwayID(runwayID)) {
			if (runwayService.validateLength(length)) {
				if (runwayService.validateWidth(width)) {
					if (runwayService.validateSurfaceType(surfaceType)) {
						if (runwayService.validateDirection(direction)) {
							int rowsAffected = runwayService.updateRunwayByID(runwayID, length, width, surfaceType,
									direction);
							if (rowsAffected > 0) {
								model.addAttribute("responseMessage", "Successfully updated");
							} else {
								model.addAttribute("responseMessage", "Data didn't exist with this ID");
							}
						} else {
							model.addAttribute("responseMessage", "direction can't be null or empty");
						}
					} else {
						model.addAttribute("responseMessage", "surfaceType can't be null or empty");
					}
				} else {
					model.addAttribute("responseMessage", "Invalid width ,width cannot be zero or  -ve values");
				}
			} else {
				model.addAttribute("responseMessage", "Invalid length ,length cannot be zero or  -ve values");
			}
		} else {
			model.addAttribute("responseMessage", "Invalid ID id cannot be zero or  -ve values");
		}
		return "/runway.jsp";

	}
	
	@RequestMapping(value = "/getAllRunways")
	public String getAll(Model model) {
		System.out.println("invoked getAll()");
		List<RunwayEntity> runwayList = runwayService.getAll();
		model.addAttribute("runwayList", runwayList);

		return "/runway.jsp";
	}
	
	@RequestMapping(value = "/editRunway/{id}")
	public String editRunwayByID(@PathVariable int id, Model model) {
		System.out.println("invoked editRunwayByID()" + id);
		RunwayEntity entity = runwayService.getRunwayEntityByID(id);
		model.addAttribute("ID", entity.getRunwayID());
		model.addAttribute("Length", entity.getLength());
		model.addAttribute("Width", entity.getWidth());
		model.addAttribute("Surface_Type", entity.getSurfaceType());
		model.addAttribute("Direction", entity.getDirection());

		return "/WEB-INF/RunwayEdit.jsp";
	}

	@RequestMapping(value = "/updateRunway")
	public String updateRunway(@RequestParam int runwayID, @RequestParam int length, @RequestParam int width,
			@RequestParam String surfaceType, @RequestParam String direction, Model model) {
		System.out.println("invoked updateRunway()");
		int rowsAffected = runwayService.updateRunwayByID(runwayID, length, width, surfaceType, direction);
		if (rowsAffected > 0) {
			model.addAttribute("responseMessage", "Successfully updated");
		} else {
			model.addAttribute("responseMessage", "Data didn't exist with this runwayID");
		}
		return "redirect:/getAllRunways";
	}
	
	@RequestMapping(value="/deleteRunwayByID/{runwayID}")
	public String deleteRunwayByID(@PathVariable int runwayID, Model model) {
		
		System.out.println("invoked deleteByID() "+runwayID);
		
		boolean result = runwayService.validateRunwayID(runwayID);
		
		if(result) {
			int rowsAffected = runwayService.deleteByID(runwayID);
		
			if(rowsAffected>0) {
				model.addAttribute("responseMessage", "Successfully deleted");
			}else {
				model.addAttribute("responseMessage", "Data didn't exist with this ID");
			}
		}else {
			model.addAttribute("responseMessage", "Invalid ID, ID cannot be zero or negative");
		}
		
		return "redirect:/getAllRunways";
		
	}

}
