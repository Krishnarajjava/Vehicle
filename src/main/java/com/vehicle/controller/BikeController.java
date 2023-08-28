package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.entity.Bike;
import com.vehicle.service.BikeService;

@RestController
public class BikeController {
	@Autowired
	BikeService bs;
	@PostMapping(value="/setBike")
	public String setBike(@RequestBody Bike bike) {
		return bs.setBike(bike);
	}
	@PostMapping(value="/setAllBike")
	public String setAllBike(@RequestBody List<Bike> bikes) {
		return bs.setAllBike(bikes);
	}
	@GetMapping(value="/getBike")
	public List<Bike> getBike(){
		return bs.getBike();
	}
	@GetMapping(value="/getById/{a}")
	public Bike getById(@PathVariable int a) {
		return bs.getById(a);
	}
	@DeleteMapping(value="/delete/{a}")
	public String delete(@PathVariable int a) {
		return bs.delete(a);
	}
	@GetMapping(value="/getByBrand/{brand}")
	public List<Bike> getByBrand(@PathVariable String brand){
		return bs.getByBrand(brand);
	}
	@GetMapping(value="/getByRange/{p1}/{p2}")
	public List<Bike> getByRange(@PathVariable int p1,@PathVariable int p2){
		return bs.getByRange(p1,p2);
	}
	@GetMapping(value="/getBrandByColor/{color}")
	public List<String> getBrandByColor(@PathVariable String color) {
		return bs.getBrandByColor(color);
	}
	@GetMapping(value="/getMax")
	public Bike getMax() {
		return bs.getMax();
	}
	@GetMapping(value="/getMin")
	public Bike getMin() {
		return bs.getMin();
	}
	@GetMapping(value="/getReducedBike/{per}")
	public List<Bike> getReducedBike(@PathVariable int per){
		return bs.getReducedBike(per);
	}
	@GetMapping(value="/getPetrolBike/{a}")
	public long getPetrolBike(@PathVariable String a) {
		return bs.getPetrolBike(a);
	}
}
