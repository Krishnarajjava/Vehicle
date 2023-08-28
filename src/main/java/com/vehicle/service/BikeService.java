package com.vehicle.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.deo.Bikedeo;
import com.vehicle.entity.Bike;
@Service
public class BikeService {
	@Autowired
	Bikedeo bd;
	
	public String setBike(Bike bike) {
		return bd.setBike(bike);
	}

	public String setAllBike(List<Bike> bikes) {
	
		return bd.setAllBike(bikes);
	}

	public List<Bike> getBike() {
	
		return bd.getBike();
	}

	public Bike getById(int a) {
	
		return bd.getById(a);
	}

	public String delete(int a) {
		
		return bd.delete(a);
	}

	public List<Bike> getByBrand(String brand) {
		List<Bike> x=getBike();
		List<Bike> y=x.stream().filter(a->a.getBrand().equalsIgnoreCase(brand))
				.collect(Collectors.toList());
		return y;
	}

	public List<Bike> getByRange(int p1, int p2) {
		List<Bike> c=getBike();
		List<Bike> d=c.stream().filter(m->m.getPrice()>=p1 && m.getPrice()<=p2).collect(Collectors.toList());
		return d;
	}

	public List<String> getBrandByColor(String color) {
		List<Bike> a=getBike();
		List<String> b=a.stream().filter(x->x.getColor().equalsIgnoreCase(color)).map(y->y.getBrand()).toList();

		return b;
	}

	public Bike getMax() {
		List<Bike> a=getBike();
		Bike b=a.stream().max(Comparator.comparing(Bike::getPrice)).get();
		return b;
	}

	public Bike getMin() {
		List<Bike> a=getBike();
		Bike b=a.stream().min(Comparator.comparing(Bike::getPrice)).get();
		return b;
	}

	public List<Bike> getReducedBike(int per) {
		List<Bike> a=getBike();
	
		List<Bike> b=a.stream().peek(x->x.setPrice(x.getPrice()-x.getPrice()*per/100)).toList();
		return b;
	}

	public long getPetrolBike(String a) {
	
		return getBike().stream().filter(x->x.getFuelType().equalsIgnoreCase(a)).count();
	}

}
