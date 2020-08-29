package com.altimetrik.busreservationsystem.util;

import java.util.HashMap;
import java.util.Map;

import com.altimetrik.busreservationsystem.entity.Bus;
import com.altimetrik.busreservationsystem.entity.Passenger;
import com.altimetrik.busreservationsystem.entity.Reserve;

public class Constants {

	public static Map<Integer,Passenger> registerPassengerMapCache = new HashMap<>();
	public static Map<Integer,Bus> registerBusMapCache = new HashMap<>();
	public static Map<Integer,Reserve> reservationCache = new HashMap<>();
	
	
}
