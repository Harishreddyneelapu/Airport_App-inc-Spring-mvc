package com.tap.starbucks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.starbucks.entity.AirportEntity;
import com.tap.starbucks.service.AirportService;

@Controller
public class AirportController {

	private AirportService airportService;

	@Autowired
	public AirportController(AirportService airportService) {
		this.airportService = airportService;

	}

	@RequestMapping(value = "/getDataFromHtml")
	public String acceptFirstRequest(@RequestParam String airportName, @RequestParam String airportLocation,
			@RequestParam int noOfPlanes, @RequestParam int noOfRunways, Model model) {
		System.out.println("invoked acceptFirstRequest()");
		System.out.println("airportName " + airportName);
		System.out.println("airportLocation " + airportLocation);
		System.out.println("noOfPlanes " + noOfPlanes);
		System.out.println("noOfRunways " + noOfRunways);

		boolean isValid = airportService.validateAiportObject(airportName, airportLocation, noOfPlanes, noOfRunways);

		if (isValid) {
			model.addAttribute("responseMessage", "DATA IS VALID & SAVED");
			model.addAttribute("isValid", true);
		} else {
			model.addAttribute("responseMessage", "DATA IS INVALID & NOT SAVED");
			model.addAttribute("isValid", false);
		}

		return "/welcome.jsp";
	}

	@RequestMapping(value = "/searchAirport")
	public String searchAirportObject(@RequestParam int airportID, Model model) {
		System.out.println("invoked searchAirportObject()");
		System.out.println("airportID =" + airportID);

		boolean result = airportService.validateAirportID(airportID);
		if (result) {
			AirportEntity entity = airportService.getAirportEntityByID(airportID);
			if (entity != null) {
				model.addAttribute("ID", entity.getAirportID());
				model.addAttribute("AirportName", entity.getAirportName());
				model.addAttribute("AirportLocation", entity.getAirportLocation());
				model.addAttribute("NO_OF_Planes", entity.getNoOfPlanes());
				model.addAttribute("NO_OF_Runways", entity.getNoOfRunways());

			} else {
				 
				model.addAttribute("responseMessage", "AirportEntiy does not exist... try with valid id");

			}
		} else {
			model.addAttribute("responseMessage", "Invalid ID id cannot be zero or  -ve values");
		}
		return "/welcome.jsp";
	}

	@RequestMapping(value = "/searchAirportByName")
	public String searchAirportByName(@RequestParam String airportName, Model model) {
		System.out.println("invoked searchAirportByName()");
		if (airportService.validateAirportName(airportName)) {
			AirportEntity entity = airportService.getAirportEntityByName(airportName);
			if (entity != null) {
				model.addAttribute("ID", entity.getAirportID());
				model.addAttribute("AirportName", entity.getAirportName());
				model.addAttribute("AirportLocation", entity.getAirportLocation());
				model.addAttribute("NO_OF_Planes", entity.getNoOfPlanes());
				model.addAttribute("NO_OF_Runways", entity.getNoOfRunways());

			} else {
				model.addAttribute("responseMessage", "AirportEntiy does not exist... try with valid Name");
			}
		} else {
			model.addAttribute("responseMessage", "airportName can't be null or empty");
		}
		return "/welcome.jsp";
	}

	

	@RequestMapping(value = "/deleteByName")
	public String deleteByName(@RequestParam String airportName, Model model) {
		System.out.println("invoked deleteByName()");
		if (airportService.validateAirportName(airportName)) {
			int result = airportService.deleteByName(airportName);
			if (result > 0) {
				model.addAttribute("responseMessage", "Successfully deleted");
			} else {
				model.addAttribute("responseMessage", "Data didn't exist with this airportName");
			}
		} else {
			model.addAttribute("responseMessage", "airportName can't be null or empty");
		}

		return "/welcome.jsp";

	}

	@RequestMapping(value = "/updateByID")
	public String updateByID(@RequestParam int airportID, @RequestParam String airportName,
			@RequestParam String airportLocation, @RequestParam int noOfPlanes, @RequestParam int noOfRunways,
			Model model) {
		System.out.println("invoked updateByID()");
		if (airportService.validateAirportID(airportID)) {
			if (airportService.validateAirportName(airportName)) {
				if (airportService.validateAirportLocation(airportLocation)) {
					if (airportService.validateNoOfPlanes(noOfPlanes)) {
						if (airportService.validateNoOfRunways(noOfRunways)) {
							int rowsAffected = airportService.updateByID(airportID, airportName, airportLocation,
									noOfPlanes, noOfRunways);
							if (rowsAffected > 0) {
								model.addAttribute("responseMessage", "Successfully updated");
							} else {
								model.addAttribute("responseMessage", "Data didn't exist with this ID");
							}
						} else {
							model.addAttribute("responseMessage", "Invalid noOfRunways cannot be zero or  -ve values");
						}
					} else {
						model.addAttribute("responseMessage", "Invalid noOfPlanes  cannot be zero or  -ve values");
					}
				} else {
					model.addAttribute("responseMessage", "airportLocation can't be null or empty");
				}
			} else {
				model.addAttribute("responseMessage", "airportName can't be null or empty");
			}
		} else {
			model.addAttribute("responseMessage", "Invalid ID id cannot be zero or  -ve values");
		}
		return "/welcome.jsp";
	}

	@RequestMapping(value = "/updateByName")
	public String updateByName(@RequestParam String airportName, @RequestParam String airportLocation,
			@RequestParam int noOfPlanes, int noOfRunways, Model model) {
		System.out.println("invoked updateByID()");
		if (airportService.validateAirportName(airportName)) {
			if (airportService.validateAirportLocation(airportLocation)) {
				if (airportService.validateNoOfPlanes(noOfPlanes)) {
					if (airportService.validateNoOfRunways(noOfRunways)) {
						int rowsAffected = airportService.updateByName(airportName, airportLocation, noOfPlanes,
								noOfRunways);
						if (rowsAffected > 0) {
							model.addAttribute("responseMessage", "Successfully updated");
						} else {
							model.addAttribute("responseMessage", "Data didn't exist with this airportName");
						}
					} else {
						model.addAttribute("responseMessage", "Invalid noOfRunways cannot be zero or  -ve values");
					}
				} else {
					model.addAttribute("responseMessage", "Invalid noOfPlanes  cannot be zero or  -ve values");
				}
			} else {
				model.addAttribute("responseMessage", "airportLocation can't be null or empty");
			}
		} else {
			model.addAttribute("responseMessage", "airportName can't be null or empty");
		}

		return "/welcome.jsp";
	}

	@RequestMapping(value = "/getAll")
	public String getAll(Model model) {
		System.out.println("invoked getAll()");
		List<AirportEntity> airportList = airportService.getAll();
		model.addAttribute("airportList", airportList);
		return "/welcome.jsp";
	}
	
	@RequestMapping(value = "/deleteByID/{airportID}")
	public String deleteByID(@PathVariable int airportID, Model model) {
		System.out.println("airportID =" + airportID);
		boolean result = airportService.validateAirportID(airportID);

		if (result) {
			int rowsAffected = airportService.deleteByID(airportID);

			if (rowsAffected > 0) {
				model.addAttribute("responseMessage", "Successfully deleted");
			} else {
				model.addAttribute("responseMessage", "Data didn't exist with this ID");
			}
		} else {
			model.addAttribute("responseMessage", "Invalid ID, ID cannot be zero or negative");
		}

		return "redirect:/getAll";
	}
	@RequestMapping(value = "/editAirport/{id}")
	public String editAirportByID(@PathVariable int id, Model model) {
		System.out.println("invoked editAirportByID()" + id);
		AirportEntity entity = airportService.getAirportEntityByID(id);
		model.addAttribute("ID", entity.getAirportID());
		model.addAttribute("AirportName", entity.getAirportName());
		model.addAttribute("AirportLocation", entity.getAirportLocation());
		model.addAttribute("NO_OF_Planes", entity.getNoOfPlanes());
		model.addAttribute("NO_OF_Runways", entity.getNoOfRunways());

		return "/WEB-INF/AirportEdit.jsp";
	}

	@RequestMapping(value = "/updateAirport")
	public String updateAirport(@RequestParam int airportID, @RequestParam String airportName,
			@RequestParam String airportLocation, @RequestParam int noOfPlanes, @RequestParam int noOfRunways,
			Model model) {

		System.out.println("invoked updateAirport()");
		int rowsAffected = airportService.updateByID(airportID, airportName, airportLocation, noOfPlanes, noOfRunways);
		if(rowsAffected>0) {
			model.addAttribute("responseMessage", "Successfully updated");
		}else {
			model.addAttribute("responseMessage", "Data didn't exist with this airportID");
		}
		return "redirect:/getAll";
	}
}
