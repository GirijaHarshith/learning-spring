package com.girija.lil.learningspring.webservice;

import com.girija.lil.learningspring.business.GuestService;
import com.girija.lil.learningspring.business.ReservationService;
import com.girija.lil.learningspring.business.RoomReservation;
import com.girija.lil.learningspring.data.Guest;
import com.girija.lil.learningspring.data.GuestRepository;
import com.girija.lil.learningspring.data.Room;
import com.girija.lil.learningspring.util.DateUtils;
import net.bytebuddy.build.RepeatedAnnotationPlugin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final DateUtils dateUtils;
    private  final ReservationService reservationService;
    private final GuestService guestService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService, GuestService guestService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
        this.guestService = guestService;
    }

    @RequestMapping(path = "/reservations",method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date",required = false) String dateSring){
        Date date= this.dateUtils.createDateFromDateString(dateSring);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @RequestMapping(path="/guests",method = RequestMethod.GET)
    public List<Guest> getGuests(){
//        List<Guest> guestL = this.guestService.getGuests();
        return this.guestService.getGuests();
    }

    @PostMapping(path = "/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public Guest addGuest(@RequestBody Guest newGuest){
        return this.guestService.saveGuest(newGuest);
    }

    @RequestMapping(path="/rooms", method = RequestMethod.GET)
    public List<Room> getRooms(){
        return this.reservationService.getRooms();
    }
}
