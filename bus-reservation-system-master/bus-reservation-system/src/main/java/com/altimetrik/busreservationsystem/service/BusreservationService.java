package com.altimetrik.busreservationsystem.service;

import com.altimetrik.busreservationsystem.entity.Bus;
import com.altimetrik.busreservationsystem.entity.Passenger;
import com.altimetrik.busreservationsystem.entity.Reserve;

public interface BusreservationService {

	void saveReservationDetail(Reserve reserve) throws Exception;

	void saveBusDetail(Bus bus) throws Exception;

	void savePassengerDetail(Passenger passenger) throws Exception;
}
