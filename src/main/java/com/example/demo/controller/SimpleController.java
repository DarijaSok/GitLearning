package com.example.demo.controller;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Car;
import com.example.demo.repo.CarRepo;

@Controller

public class SimpleController{
	
	@Autowired
	CarRepo carRepo;
	
	
	@GetMapping(value="/testdata")
	public String testdata()
		//**INSERT*/
	{
		Car car1 = new Car("Fuel", 150, 2001, "silver");
		Car car2 = new Car("Electric", 100, 2018, "gold");
		Car car3 = new Car("Gasoline", 100, 2017, "yellow");
		
		//save in the db using repo
		carRepo.save(car1);
		carRepo.save(car2);
		carRepo.save(car3);
		//**SELECT ALL*/
		for(Car c: carRepo.findAll()) {
			System.out.println(c.getEngine() + " " + c.getSpeed());
		}
		
		//**SELECT ONE*/
		
		Car carIdOne = carRepo.findById(1).get();
		if(carIdOne != null)
			System.out.println(carIdOne.getEngine() + " " + carIdOne.getId());
		
		
		//**UPDATE*/
		Car carUpdate = carRepo.findById(1).get();
			if(carUpdate != null) {
				carUpdate.setColor("bronza");
				carRepo.save(carUpdate);
			}
				   
						
				//
		
		//**DELETE*/	
		Car carDelete = carRepo.findById(2).get();
		 	if(carDelete != null)
		 		carRepo.delete(carDelete);
		 	
		ArrayList<Car> carYear2017 = carRepo.findByYear(2017);
		for(Car car: carYear2017) {
			System.out.println(car.toString());
		}
		//
		return "testdata";
	}

}
