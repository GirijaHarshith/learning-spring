package com.girija.lil.learningspring.util;

import com.girija.lil.learningspring.business.ReservationService;
import com.girija.lil.learningspring.business.RoomReservation;
import com.girija.lil.learningspring.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
public class AppStartupEvent{ //implements ApplicationListener<ApplicationReadyEvent> {

//    private final RoomRepository roomRepository;
//    private final GuestRepository guestRepository;
//    private final ReservationRepository reservationRepository;

    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository, ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
//        this.roomRepository = roomRepository;
//        this.guestRepository = guestRepository;
//        this.reservationRepository = reservationRepository;
    }

    @EventListener
//    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) throws Exception{
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        reservations.forEach(System.out::println);
//        Iterable<Room> rooms =this.roomRepository.findAll();
//        rooms.forEach(System.out::println);
//        Iterable<Guest> guests =this.guestRepository.findAll();
//        guests.forEach(System.out::println);
//        //LocalDate date = LocalDate.parse("2022-01-01");
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//        Date date = formatter.parse("01-Jan-2022");
//        Iterable<Reservation> reservations = this.reservationRepository.findByReservationDate(date);
//        reservations.forEach(System.out::println);
//

    }

}
