package com.altimetrik.busreservationsystem.business.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.altimetrik.busreservationsystem.business.Busrservationbusiness;
import com.altimetrik.busreservationsystem.entity.Bus;
import com.altimetrik.busreservationsystem.entity.Passenger;
import com.altimetrik.busreservationsystem.entity.Reserve;
import com.altimetrik.busreservationsystem.util.Constants;


@Service
public class BusrservationbusinessImpl implements Busrservationbusiness{

	@Override
	public void savePassengerDetail(Passenger passenger) throws Exception {
		 Map<Integer, Passenger> passengerCache = Constants.registerPassengerMapCache;
		 if(passengerCache.containsKey(passenger.getId())) {
			 throw new Exception("passengerId already exists");
		 }else {
			 Constants.registerPassengerMapCache.put(passenger.getId(), passenger);
		 }
	}
	
	@Override
	public void saveBusDetail(Bus bus) throws Exception {
		 Map<Integer, Bus> busCache = Constants.registerBusMapCache;
		 if(busCache.containsKey(bus.getId())) {
			 throw new Exception("passengerId already exists");
		 }else {
			 Constants.registerBusMapCache.put(bus.getId(), bus);
		 }
	}
	
	@Override
	public void saveReservationDetail(Reserve reserve) throws Exception {
		if(!Constants.registerBusMapCache.containsKey(reserve.getBusID())) {
			throw new Exception("busId specified incorrectly.No available bus found");
		}else {
			Bus bus = Constants.registerBusMapCache.get(reserve.getBusID());
			if(bus.getAvailablityCount() <= reserve.getSeat()) {
				Constants.reservationCache.put(reserve.getId(), reserve);
				int balAvailability = bus.getAvailablityCount() - reserve.getSeat();
				bus.setAvailablityCount(balAvailability);
				Constants.registerBusMapCache.put(bus.getId(), bus);
			}else {
				throw new Exception("Seats are filled.No available seat for the specified count");
			}
		}
	}
}
