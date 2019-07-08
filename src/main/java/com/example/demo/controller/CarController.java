package com.example.demo.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Car;
import com.example.demo.repo.CarRepo;
import com.example.demo.services.CarServiceImpl;
@Controller
@RequestMapping(value="/car")


public class CarController {
	@Autowired
	CarServiceImpl carServiceImpl;
	
	
	@GetMapping(value="/carview") 
	public String carview(Model model) {	
		model.addAttribute("object", carServiceImpl.selectAll());
		return "carview";
	}
	
	
	
	@GetMapping(value="/carview/{id}") 
	public String carviewbyid(@PathVariable(name="id") int id, Model model) {	
		model.addAttribute("object", carServiceImpl.selectById(id));
		return "carview";
	}
	
	
	
    @GetMapping(value="/addcar") // 
	public String addcarGet(Car car) {
		// method
		return "addcar";	 // this is addcar.html page
	}
	
	@PostMapping(value="/addcar")// after submit button pressed
	public String addcarPost(@Valid Car car, BindingResult result) {
		if(result.hasErrors()) {
			return "addcar";
		}
		else
		{
		carServiceImpl.insertNewCar(car);
		
		return "redirect:/car/carview";
		}
	}
	
	@GetMapping(value="/editcar/{id}") 
	
	public String editCarGet(@PathVariable(name="id") int id, Model model) {
		model.addAttribute("car", carServiceImpl.selectById(id));
		return "editcar";
	}
		// method
		
	
	
	@PostMapping(value="/editcar/{id}")// after submit button pressed
	public String editCarPost(@PathVariable(name="id") int id, Car car) {	
		carServiceImpl.updateCarById(car, id);
		return "redirect:/car/carview";
	}
	
	@GetMapping(value="/deleteCar/{id}")
	public String deleteCarById(@PathVariable(name="id") int id)
	
	{
		carServiceImpl.deleteCarById(id);
		return "redirect:/car/carview";
	}
}
	
