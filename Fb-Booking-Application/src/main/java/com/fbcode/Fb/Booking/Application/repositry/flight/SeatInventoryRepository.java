package com.fbcode.Fb.Booking.Application.repositry.flight;

import com.fbcode.Fb.Booking.Application.entity.flight.SeatInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Repository
public interface SeatInventoryRepository extends JpaRepository<SeatInventory, Long> {
    @Query("SELECT * FROM seat_inventory s WHERE s.schedule_id = :scheduleId AND s.is_reserved = false")
    List<SeatInventory> findAvailableSeatsByScheduleId(Long scheduleId);

    List<SeatInventory> findByScheduleId(Long scheduleId);

    @Query("SELECT * FROM seat_inventory s WHERE s.schedule_id = :scheduleId AND s.seat_class = :seatClass AND s.is_reserved = false")
    List<SeatInventory> findAvailableSeatsByScheduleIdAndClass(Long scheduleId, String seatClass);

    Long     countByScheduleIdAndIsReservedFalse(Long scheduleId);
}
