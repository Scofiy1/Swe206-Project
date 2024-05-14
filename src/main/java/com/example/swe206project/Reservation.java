package com.example.swe206project;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private int reservationID;
    private String username;
    private int facilityID;
    private String reservationDate;
    private String startingTime;
    private String endingTime;
    private String reservationReason;

    public Reservation(int reservationID, String username, int facilityID, String reservationDate,
                       String startingTime, String endingTime, String reservationReason) {
        this.reservationID = reservationID;
        this.username = username;
        this.facilityID = facilityID;
        this.reservationDate = reservationDate;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.reservationReason = reservationReason;


    }


    public int getReservationID(){return reservationID;}
    static class Event extends Reservation{
    private String eventName;
    private int requiredParticipants;
    private int currentParticipants;
    public Event(int reservationID, String username, int facilityID, String reservationDate,
                  String startingTime, String endingTime, String reservationReason,
                  String eventName, int requiredParticipants, int currentParticipants) {
         super(reservationID, username, facilityID, reservationDate, startingTime, endingTime, reservationReason);
         this.eventName = eventName;
         this.requiredParticipants = requiredParticipants;
         this.currentParticipants = currentParticipants;


     }
         public void openEvent(String eventName){}

 }}