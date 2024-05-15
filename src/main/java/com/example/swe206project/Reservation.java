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

    @Override
    public String toString() {
        return ("ID: " + reservationID + ", Reserved by: " + username + ", Facility ID: " + facilityID + ", " +
                "Date: " + reservationDate + ", From: " + startingTime + " To: " + endingTime + ", Reason: " + reservationReason);
    }

    public int getReservationID(){return reservationID;}
    public String getUsername(){return username;}
    public int getReservationRoomID(){return facilityID;}
    static public class Event extends Reservation{
    private String eventName;
    private int requiredParticipants;
    private int currentParticipants;
    //private string facilityGender;
    public Event(int reservationID, String username, int facilityID, String reservationDate,
                  String startingTime, String endingTime, String reservationReason,
                  String eventName, int requiredParticipants, int currentParticipants) {
         super(reservationID, username, facilityID, reservationDate, startingTime, endingTime, reservationReason);
         this.eventName = eventName;
         this.requiredParticipants = requiredParticipants;
         this.currentParticipants = currentParticipants;
         //this.facilityGender = facilityGender;


     }
        public boolean JoinEventCheck() {

            if (currentParticipants != requiredParticipants) {

                currentParticipants++;
                return true;
            } else {
                return false;
            }
        }



        public void eventInformation(Event event){
         System.out.println(event + "Event Name: " + eventName + ", Current Members: " +
                 currentParticipants + ", Required Members: " + requiredParticipants);

     }


     public String getEventName(){return eventName;}

     public int getCurrentParticipants(){return currentParticipants;}

     public int getRequiredParticipants(){return requiredParticipants;}


        @Override
        public String toString() {
            return super.toString() + ", Event Name: " + eventName +
                    ", Current Members: " + currentParticipants +
                    ", Required Members: " + requiredParticipants;
        }

        public void openEvent(String eventName){}

 }}