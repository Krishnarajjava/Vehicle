package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Bus;
import com.vehicle.exception.BrandNotFoundException;
import com.vehicle.exception.IdNotFoundException;
import com.vehicle.exception.InvalidBoardException;
import com.vehicle.service.BusService;

@RestController
@RequestMapping(value="/bus")
public class BusController {
	@Autowired
	BusService bs;
	@PutMapping(value="/setBus")
	public String setBus(@RequestBody Bus bus) throws InvalidBoardException{
		return bs.setBus(bus);
	}
	@PostMapping(value="/setAllBus")
	public String setAllBus(@RequestBody List<Bus> buss) throws InvalidBoardException{
		return bs.setAllBus(buss);
	}
	@GetMapping(value="/getById/{a}")
	public Bus getById(@PathVariable int a ) throws IdNotFoundException {
		return bs.getById(a);
	}
	@GetMapping(value="/getByBrand/{a}")
	public List<Bus> getByBrand(@PathVariable String a) throws BrandNotFoundException{
		return bs.getByBrand(a);
	}
	@PutMapping(value="/update/{a}")
	public String update(@PathVariable int a,@RequestBody Bus bus) throws IdNotFoundException {
		return bs.update(a,bus);
	}
	
}
