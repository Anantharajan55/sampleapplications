package com.altimetrik.busreservationsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.busreservationsystem.business.Busrservationbusiness;
import com.altimetrik.busreservationsystem.entity.Bus;
import com.altimetrik.busreservationsystem.entity.Passenger;
import com.altimetrik.busreservationsystem.entity.Reserve;
import com.altimetrik.busreservationsystem.service.BusreservationService;

@Service
public class BusreservationServiceImpl implements BusreservationService{
	
	@Autowired
	Busrservationbusiness busreservationBusiness;

	@Override
	public void saveReservationDetail(Reserve reserve) throws Exception {
		// TODO Auto-generated method stub
		busreservationBusiness.saveReservationDetail(reserve);
	}

	@Override
	public void saveBusDetail(Bus bus) throws Exception {
		// TODO Auto-generated method stub
		busreservationBusiness.saveBusDetail(bus);
	}

	@Override
	public void savePassengerDetail(Passenger passenger) throws Exception {
		// TODO Auto-generated method stub
		busreservationBusiness.savePassengerDetail(passenger);
	}

}
