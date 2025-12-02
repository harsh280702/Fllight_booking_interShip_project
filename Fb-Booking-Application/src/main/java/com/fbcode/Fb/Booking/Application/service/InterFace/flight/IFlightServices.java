package com.fbcode.Fb.Booking.Application.service.InterFace.flight;

import com.fbcode.Fb.Booking.Application.dto.user.UserResponseDTO;
import com.fbcode.Fb.Booking.Application.entity.flight.AirportEntity;
import com.fbcode.Fb.Booking.Application.entity.flight.FlightEntity;
import com.fbcode.Fb.Booking.Application.entity.flight.FlightSchedule;
import com.fbcode.Fb.Booking.Application.entity.flight.SeatInventory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface IFlightServices {


    //------------------------------------------------
    // these functioon is for  use in the Flight Entity
    //-------------------------------------------------
    Mono<UserResponseDTO> addFlight(FlightEntity flightEntity);
    Mono<UserResponseDTO> updateFlight(String  flightNumber,FlightEntity flightEntity);
    Mono<UserResponseDTO> deleteFlight(String  flightNumber);

    Mono<UserResponseDTO> findFlightByFlightNumber(Long id);
    Flux<UserResponseDTO> findLargeCapacityFlights(int minSeats);
    Flux<UserResponseDTO> searchFlightsByCarrier( String carrier);
    //------------------------------------------------
    // these functioon is for  use in the Flight Entity
    //-------------------------------------------------

    Mono<FlightSchedule> addFlightSchedule(FlightSchedule flightSchedule);
    Mono<FlightSchedule> updateFlightSchedule(Long id ,FlightSchedule flightSchedule);
    Mono<FlightSchedule> findFlightScheduleByFlightNumber(String flightNumber);
    Flux<FlightSchedule> searchFlightScheduleByCarrier(Long originId, Long destId, LocalDate date);
    Flux<FlightSchedule> findFlightScheduleBySeatNumber(String flightNumber);


    //----------------------------------------------------
    // these function use  is for  use the Flight Schedule
    //----------------------------------------------------
    Flux <SeatInventory> getAvailableSeats(Long id);
    Mono<Long> countAvailableSeats(Long id);
    Flux<SeatInventory> getSeatInventory(Long id);



    //------------------------------------------------------
    //these Function use is  for the use the  Airport Entity
    //------------------------------------------------------

    Mono<AirportEntity> findAirportByCode(String code);
    Mono<AirportEntity> findAirportByName(String name);
    Mono<AirportEntity> findAirportByCity(String city);

}



