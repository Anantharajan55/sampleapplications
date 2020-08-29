package com.altimetrik.busreservationsystem.controller;

import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.busreservationsystem.entity.Bus;
import com.altimetrik.busreservationsystem.entity.Passenger;
import com.altimetrik.busreservationsystem.entity.Reserve;
import com.altimetrik.busreservationsystem.service.BusreservationService;
import com.altimetrik.busreservationsystem.util.Constants;
import com.altimetrik.busreservationsystem.util.ResponseMessage;

@RestController
@RequestMapping("/busreservation")
public class BusrservationController {

	@Autowired
	BusreservationService busreservationService;

	@PostMapping("/registerPassenger")
	public ResponseEntity<?> registerPassenger(@RequestBody Passenger passenger){

		ResponseMessage response = new ResponseMessage();
		try {
			busreservationService.savePassengerDetail(passenger);
			response.setMessage("saved successfuly");
			response.setStatus(true);
		}catch(Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(false);
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);

	}

	@PostMapping("/registerBus")
	public ResponseEntity<?> registerBus(@RequestBody Bus bus){

		ResponseMessage response = new ResponseMessage();
		try {
			busreservationService.saveBusDetail(bus);
			response.setMessage("saved successfuly");
			response.setStatus(true);
		}catch(Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(false);
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);

	}

	@PostMapping("/saveResevation")
	public ResponseEntity<?> saveResevation(@RequestBody Reserve reserve){

		ResponseMessage response = new ResponseMessage();
		try {
			busreservationService.saveReservationDetail(reserve);
			response.setMessage("saved successfuly");
			response.setStatus(true);
		}catch(Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(false);
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);

	}
	
	@GetMapping("/getBusDetails")
	public ResponseEntity<?> getBusDetails(){

		ResponseMessage response = new ResponseMessage();
		try {
			response.setData(Constants.registerBusMapCache.entrySet().stream().collect(Collectors.toList()));
			response.setMessage("List of Bus");
			response.setStatus(true);
		}catch(Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(false);
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);

	}
	
	@GetMapping("/getPassengerDetail")
	public ResponseEntity<?> getPassengerDetail(@RequestBody Reserve reserve){

		ResponseMessage response = new ResponseMessage();
		try {
			response.setData(Constants.registerPassengerMapCache.entrySet().stream().collect(Collectors.toList()));
			response.setMessage("List of Passengers");
			response.setStatus(true);
		}catch(Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(false);
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);

	}
	
	@PostConstruct
	public void storeSampleDataInCache() {
		//sample Data
		Bus bus = new Bus();
		bus.setId(1);
		bus.setRouteID(2567);
		bus.setAc(true);
		bus.setArrivalTime("10.00");
		bus.setDepartureTime("11.00");
		bus.setFare(500);
		bus.setAvailablityCount(20);
		Constants.registerBusMapCache.put(bus.getId(), bus);
		
		bus = new Bus();
		bus.setId(2);
		bus.setRouteID(2568);
		bus.setAc(true);
		bus.setArrivalTime("10.30");
		bus.setDepartureTime("11.30");
		bus.setFare(600);
		bus.setAvailablityCount(20);
		Constants.registerBusMapCache.put(bus.getId(), bus);
		
		bus = new Bus();
		bus.setId(3);
		bus.setRouteID(2569);
		bus.setAc(true);
		bus.setArrivalTime("11.00");
		bus.setDepartureTime("12.00");
		bus.setFare(300);
		bus.setAvailablityCount(20);
		Constants.registerBusMapCache.put(bus.getId(), bus);
		
		// sample PassengerData
		Passenger passenger = new Passenger();
		passenger.setId(1);
		passenger.setEmail("abc@xxx.com");
		passenger.setMobile(1234567890);
		passenger.setName("abc");
		passenger.setUsername("abcd");
		passenger.setPassword("abcd");
		Constants.registerPassengerMapCache.put(passenger.getId(), passenger);
		
		passenger = new Passenger();
		passenger.setId(2);
		passenger.setEmail("aefg@xxx.com");
		passenger.setMobile(1234567890);
		passenger.setName("aefg");
		passenger.setUsername("aefg");
		passenger.setPassword("aefg");
		Constants.registerPassengerMapCache.put(passenger.getId(), passenger);
	}
}
