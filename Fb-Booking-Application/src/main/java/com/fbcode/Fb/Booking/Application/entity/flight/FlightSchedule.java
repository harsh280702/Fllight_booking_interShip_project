package com.fbcode.Fb.Booking.Application.entity.flight;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="flight_schedule")
public class FlightSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many schedules can belong to one flight
    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private FlightEntity flight;

    @ManyToOne
    @JoinColumn(name = "origin_airport_id", nullable = false)
    private AirportEntity origin;

    @ManyToOne
    @JoinColumn(name = "destination_airport_id", nullable = false)
    private AirportEntity destination;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name = "base_price", nullable = false)
    private BigDecimal basePrice;

    private String status;

}
