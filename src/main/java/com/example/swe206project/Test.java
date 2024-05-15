package com.example.swe206project;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        User user1 = new User("202311110", "test.gmail.com", "Male", "1234", "Student");
        ArrayList<Reservation> reservations1 = new ArrayList<>();
        Reservation.Event event1 = new Reservation.Event(1, "1", 1, "1", "1", "1", "1", "1", 1, 1);
        System.out.println(event1.toString());
        reservations1.add(new Reservation(1, "1", 1, "1", "1", "1", "1"));
        reservations1.add(new Reservation(3, "1", 1, "1", "1", "1","1"));
        for (Reservation reservation : reservations1) {
            System.out.println(reservation.toString());
        }
    }
}