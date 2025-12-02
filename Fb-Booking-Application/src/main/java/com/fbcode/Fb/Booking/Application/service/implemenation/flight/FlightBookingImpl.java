package com.fbcode.Fb.Booking.Application.service.implemenation.flight;


import com.fbcode.Fb.Booking.Application.dto.flight.FlightEntityDto;
import com.fbcode.Fb.Booking.Application.dto.user.UserResponseDTO;
import com.fbcode.Fb.Booking.Application.entity.flight.AirportEntity;
import com.fbcode.Fb.Booking.Application.entity.flight.FlightEntity;
import com.fbcode.Fb.Booking.Application.entity.flight.FlightSchedule;
import com.fbcode.Fb.Booking.Application.entity.flight.SeatInventory;
import com.fbcode.Fb.Booking.Application.exception.OurException;
import com.fbcode.Fb.Booking.Application.mapper.Utils;
import com.fbcode.Fb.Booking.Application.repositry.flight.FlightRepository;
import com.fbcode.Fb.Booking.Application.repositry.flight.FlightScheduleRepository;
import com.fbcode.Fb.Booking.Application.repositry.flight.SeatInventoryRepository;
import com.fbcode.Fb.Booking.Application.service.InterFace.flight.IFlightServices;
import jdk.jshell.execution.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FlightBookingImpl implements IFlightServices {

    private FlightRepository   flightRepository;
    private FlightScheduleRepository flightScheduleRepository;
    private SeatInventoryRepository seatInventoryRepository;




    @Override
    public Mono<UserResponseDTO> addFlight(FlightEntity flightEntity) {
       UserResponseDTO userResponseDTO = new UserResponseDTO();

        return Mono.fromCallable(()->{

            try
            {
                FlightEntity flightEntity1  = flightRepository.save(flightEntity);
                FlightEntityDto flightEntityDto  = Utils.mappedFlightEntityToFlightEntityDto(flightEntity1);
                userResponseDTO.setFlightEntityDto(flightEntityDto);
                userResponseDTO.setStatusCode(200);
                userResponseDTO.setMessage("added successfully");
            }
            catch(OurException e){
                userResponseDTO.setStatusCode(400);
                userResponseDTO.setMessage(e.getMessage());
            }
            catch(Exception e)
            {
                userResponseDTO.setStatusCode(500);
                userResponseDTO.setMessage(e.getMessage());
            }
            return userResponseDTO;
        }).subscribeOn(Schedulers.boundedElastic())
                .delayElement(Duration.ofSeconds(2));
    }


    @Override
    public Mono<UserResponseDTO> updateFlight(String flightNumber, FlightEntity flightEntity) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        return Mono.fromCallable(()->{

            try
            {
                FlightEntity flightEntity1  = flightRepository.findByFlightNumber(flightNumber).orElseThrow(()->new OurException("flight number not found"));
               flightEntity1.setAircraftType(flightEntity.getAircraftType());
               flightEntity1.setCarrier(flightEntity.getCarrier());
               flightEntity1.setTotalSeats(flightEntity.getTotalSeats());

              FlightEntity flightEntity2= flightRepository.save(flightEntity1);

                FlightEntityDto flightEntityDto  = Utils.mappedFlightEntityToFlightEntityDto(flightEntity);

                userResponseDTO.setFlightEntityDto(flightEntityDto);
                userResponseDTO.setStatusCode(200);
                userResponseDTO.setMessage("added successfully");
            }
            catch(OurException e){
                userResponseDTO.setStatusCode(400);
                userResponseDTO.setMessage(e.getMessage());
            }
            catch(Exception e)
            {
                userResponseDTO.setStatusCode(500);
                userResponseDTO.setMessage(e.getMessage());
            }
            return userResponseDTO;
        }).subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<UserResponseDTO> deleteFlight(String flightNumber) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        return Mono.fromCallable(()->{

            try
            {
                FlightEntity flightEntity = flightRepository.findByFlightNumber(flightNumber).orElseThrow(()->new OurException("flight number not found"));

                    flightRepository.delete(flightEntity);
                    userResponseDTO.setStatusCode(200);
                    userResponseDTO.setMessage("added successfully");


            }
            catch(OurException e){
                userResponseDTO.setStatusCode(400);
                userResponseDTO.setMessage(e.getMessage());
            }
            catch(Exception e)
            {
                userResponseDTO.setStatusCode(500);
                userResponseDTO.setMessage(e.getMessage());
            }
            return userResponseDTO;
        }).subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<UserResponseDTO> findFlightByFlightNumber(Long id) {
        return null;
    }

    @Override
    public Flux<UserResponseDTO> findLargeCapacityFlights(int minSeats) {
        return null;
    }

    @Override
    public Flux<UserResponseDTO> searchFlightsByCarrier(String carrier) {
        return null;
    }

    @Override
    public Mono<FlightSchedule> addFlightSchedule(FlightSchedule flightSchedule) {
        return null;
    }

    @Override
    public Mono<FlightSchedule> updateFlightSchedule(Long id, FlightSchedule flightSchedule) {
        return null;
    }

    @Override
    public Mono<FlightSchedule> findFlightScheduleByFlightNumber(String flightNumber) {
        return null;
    }

    @Override
    public Flux<FlightSchedule> searchFlightScheduleByCarrier(Long originId, Long destId, LocalDate date) {
        return null;
    }

    @Override
    public Flux<FlightSchedule> findFlightScheduleBySeatNumber(String flightNumber) {
        return null;
    }

    @Override
    public Flux<SeatInventory> getAvailableSeats(Long id) {
        return null;
    }

    @Override
    public Mono<Long> countAvailableSeats(Long id) {
        return null;
    }

    @Override
    public Flux<SeatInventory> getSeatInventory(Long id) {
        return null;
    }

    @Override
    public Mono<AirportEntity> findAirportByCode(String code) {
        return null;
    }

    @Override
    public Mono<AirportEntity> findAirportByName(String name) {
        return null;
    }

    @Override
    public Mono<AirportEntity> findAirportByCity(String city) {
        return null;
    }
}
