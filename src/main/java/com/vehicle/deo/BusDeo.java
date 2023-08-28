package com.vehicle.deo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicle.entity.Bus;
import com.vehicle.exception.BrandNotFoundException;
import com.vehicle.exception.IdNotFoundException;
import com.vehicle.repository.BusRepository;
@Repository
public class BusDeo {
	@Autowired
	BusRepository br;
	public String setBus(Bus bus) {
		br.save(bus);
		return "Success";
	}
	public String setAllBus(List<Bus> buss) {
		br.saveAll(buss);
		return "Saved All";
	}
	public Bus getById(int a)throws IdNotFoundException {
		
		return br.findById(a).orElseThrow(()->new IdNotFoundException("Id Not Found"));
	}
	public List<Bus> getByBrand(String a) {
		
		return br.getByBrand(a);
	}

}
