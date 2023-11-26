package com.tap.starbucks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.starbucks.entity.TaxiEntity;
import com.tap.starbucks.service.TaxiService;

@Controller
public class TaxiController {

	private TaxiService taxiService;

	@Autowired
	public TaxiController(TaxiService taxiService) {
		super();
		this.taxiService = taxiService;
	}

	@RequestMapping(value = "/saveTaxi")
	public String saveTaxi(@RequestParam String model, @RequestParam String driverName,
			@RequestParam String currLocation, @RequestParam String availability, Model model1) {

		System.out.println("invoked saveTaxi()");
		System.out.println("model " + model);
		System.out.println("driverName " + driverName);
		System.out.println("currLocation " + currLocation);
		System.out.println("availability " + availability);

		boolean isValid = taxiService.validateTaxiObject(model, driverName, currLocation, availability);
		if (isValid) {
			model1.addAttribute("responseMessage", "DATA IS VALID & SAVED");
			model1.addAttribute("isValid", true);
		} else {
			model1.addAttribute("responseMessage", "DATA IS INVALID & NOT SAVED");
			model1.addAttribute("isValid", false);
		}
		return "/taxi.jsp";

	}

	@RequestMapping(value = "/updateTaxiByID")
	public String updateTaxiByID(@RequestParam int taxiID, @RequestParam String model, @RequestParam String driverName,
			@RequestParam String currLocation, @RequestParam String availability, Model model1) {
		System.out.println("invoked updateTaxiByID()");
		if (taxiService.validateTaxiID(taxiID)) {
			if (taxiService.validateTaxiModel(model)) {
				if (taxiService.validateTaxiDriverName(driverName)) {
					if (taxiService.validateTaxiCurrLocation(currLocation)) {
						if (taxiService.validateTaxiAvailability(availability)) {

						} else {
							model1.addAttribute("responseMessage", "availability can't be null or empty");
						}
					} else {
						model1.addAttribute("responseMessage", "currLocation can't be null or empty");
					}
				} else {
					model1.addAttribute("responseMessage", "driverName can't be null or empty");
				}
			} else {
				model1.addAttribute("responseMessage", "model can't be null or empty");
			}
		} else {
			model1.addAttribute("responseMessage", "Invalid ID id cannot be zero or  -ve values");
		}
		return "/taxi.jsp";
	}

	@RequestMapping(value = "/getAllTaxi")
	public String getAll(Model model) {
		System.out.println("invoked getAll()");
		List<TaxiEntity> taxiList = taxiService.getAll();
		model.addAttribute("taxiList", taxiList);

		return "/taxi.jsp";
	}

	@RequestMapping(value = "/editTaxi/{id}")
	public String editTaxiByID(@PathVariable int id, Model model) {
		System.out.println("invoked editTaxiByID()");
		TaxiEntity entity = taxiService.getTaxiEntityByID(id);
		model.addAttribute("ID", entity.getTaxiID());
		model.addAttribute("Model", entity.getModel());
		model.addAttribute("Driver_Name", entity.getDriverName());
		model.addAttribute("Curr_Location", entity.getCurrLocation());
		model.addAttribute("Availability", entity.getAvailability());

		return "/WEB-INF/TaxiEdit.jsp";

	}
	
	@RequestMapping(value = "/updateTaxi")
	public String updateTaxi(@RequestParam int taxiID, @RequestParam String model, @RequestParam String driverName,
			@RequestParam String currLocation, @RequestParam String availability, Model model1) {
		System.out.println("invoked updateRunway()");
		int rowsAffected = taxiService.updateTaxiByID(taxiID, model, driverName, currLocation, availability);
		if (rowsAffected > 0) {
			model1.addAttribute("responseMessage", "Successfully updated");
		} else {
			model1.addAttribute("responseMessage", "Data didn't exist with this TaxiID");
		}
		return "redirect:/getAllTaxi";
	}
	
	
	@RequestMapping(value="/deleteTaxiByID/{taxiID}")
	public String deleteRunwayByID(@PathVariable int taxiID, Model model) {
		
		System.out.println("invoked deleteByID() "+taxiID);
		
		boolean result = taxiService.validateTaxiID(taxiID);
		
		if(result) {
			int rowsAffected = taxiService.deleteByID(taxiID);
		
			if(rowsAffected>0) {
				model.addAttribute("responseMessage", "Successfully deleted");
			}else {
				model.addAttribute("responseMessage", "Data didn't exist with this ID");
			}
		}else {
			model.addAttribute("responseMessage", "Invalid ID, ID cannot be zero or negative");
		}
		
		return "redirect:/getAllTaxi";
		
	}
}









