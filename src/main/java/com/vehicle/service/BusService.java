package com.vehicle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vehicle.deo.BusDeo;
import com.vehicle.entity.Bus;
import com.vehicle.exception.BrandNotFoundException;
import com.vehicle.exception.IdNotFoundException;
import com.vehicle.exception.InvalidBoardException;

@Service
public class BusService {
	@Autowired
	BusDeo bd;

	public String setBus(Bus bus) throws InvalidBoardException {
		try {
			if (bus.getBoard().equalsIgnoreCase("white")) {
				return bd.setBus(bus);
			} else {
				throw new InvalidBoardException("Invalid Data");
			}
		} catch (InvalidBoardException a) {
			return "Invalid Data";

		}
	}

	public String setAllBus(List<Bus> buss) throws InvalidBoardException {
		List<Bus> s = buss.stream()
				.filter(x -> x.getBoard().equalsIgnoreCase("white") || x.getBoard().equalsIgnoreCase("yellow"))
				.toList();

		if (s.isEmpty()) {
			throw new InvalidBoardException("Invalid data");
		}

		else {
			return bd.setAllBus(s);
		}

	}

	public Bus getById(int a) throws IdNotFoundException {

		return bd.getById(a);
	}

	public List<Bus> getByBrand(String a) throws BrandNotFoundException {
		List<Bus> b = bd.getByBrand(a);
		if (b.isEmpty()) {

			throw new BrandNotFoundException("Invalid Data");

		} 
		else {
			return b;
		}

	}

	public String update(int a,Bus bus) throws IdNotFoundException {
	 Bus x=getById(a);
	 Bus y=bus;
	 x.setId(a);
	 x.setBrand(y.getBrand());
	 x.setBoard(y.getBoard());
	 x.setColor(y.getColor());	
	 
		 bd.setBus(x);
		 return "Successfuly Updated";
	}
}
