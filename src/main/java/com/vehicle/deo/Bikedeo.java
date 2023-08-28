package com.vehicle.deo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.entity.Bike;
import com.vehicle.repository.BikeRepository;
@Repository
public class Bikedeo {
	@Autowired
	BikeRepository br;

	public String setBike(Bike bike) {
		br.save(bike);
		return "Success";
	}

	public String setAllBike(List<Bike> bikes) {
		br.saveAll(bikes);
		return "Success";
	}

	public List<Bike> getBike() {
		
		return br.findAll();
	}

	public Bike getById(int a) {
		
		return br.findById(a).get();
	}

	public String delete(int a) {
		br.deleteById(a);
		return "Delete";
	}

}
