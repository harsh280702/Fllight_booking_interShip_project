package com.fbcode.Fb.Booking.Application.repositry.flight;

import com.fbcode.Fb.Booking.Application.entity.flight.FlightSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Long> {

    @Query("SELECT * FROM flight_schedule fs " +
                  "WHERE fs.origin_airport_id = :originId " +
                  "AND fs.destination_airport_id = :destId " +
                  "AND DATE(fs.departure_time) = :date")
    List<FlightSchedule> findByRouteAndDate(Long originId, Long destId, LocalDate date);

    List<FlightSchedule> findByFlightId(Long flightId);

    List<FlightSchedule> findByStatus(String status);
}
