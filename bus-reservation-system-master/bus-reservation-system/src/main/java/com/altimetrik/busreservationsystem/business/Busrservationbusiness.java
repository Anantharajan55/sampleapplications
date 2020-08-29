package com.altimetrik.busreservationsystem.business;

import com.altimetrik.busreservationsystem.entity.Bus;
import com.altimetrik.busreservationsystem.entity.Passenger;
import com.altimetrik.busreservationsystem.entity.Reserve;

public interface Busrservationbusiness {

	void saveReservationDetail(Reserve reserve) throws Exception;

	void saveBusDetail(Bus bus) throws Exception;

	void savePassengerDetail(Passenger passenger) throws Exception;

}
