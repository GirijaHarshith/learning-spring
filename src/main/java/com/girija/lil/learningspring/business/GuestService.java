package com.girija.lil.learningspring.business;

import com.girija.lil.learningspring.data.Guest;
import com.girija.lil.learningspring.data.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

     public List<Guest> getGuests(){
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Guest> res= new ArrayList<>();
        guests.forEach(guest->{
            res.add(guest);
        });
        return res;
     }

     public Guest saveGuest(Guest guest){
        return this.guestRepository.save(guest);
     }
}
