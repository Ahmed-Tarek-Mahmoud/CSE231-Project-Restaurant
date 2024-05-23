package Systems;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Kiere
 */

import java.time.LocalDateTime;
import java.util.ArrayList;

import PersonClasses.Customer;

public interface ReservationManager {
    ArrayList<Reservation> Rlist= new ArrayList<>();
    
     default void CreateReservation(Customer customer, int guests, String datetime){
        Reservation reservation = new Reservation(customer, guests, datetime);  
        Rlist.add(reservation);
    }
    
    default void editReservation(Reservation reservation, int guests, String editteddatetime){
        reservation.setGuests(guests);
        reservation.parseDateTime(editteddatetime);  
    }
    
     void removeReservation(Reservation reservation);
    
    
}
