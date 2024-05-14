package com.example.swe206project;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        User user1 = new User("202311110", "test.gmail.com", "Male", "1234", "Student");

        ArrayList<Classroom> building59_Classrooms = new ArrayList<>();
        for(int i = 1; i<=20; i++){
            building59_Classrooms.add(new Classroom(1000+i, 40, "None"));
        }
        for(int i = 1; i<=10; i++){
            building59_Classrooms.add(new Classroom(1020+i, 40, "Male"));
        }
        for(int i = 1; i<=10; i++){
            building59_Classrooms.add(new Classroom(1030+i, 40, "Female"));
        }


        for(int i = 0; i<building59_Classrooms.size(); i++){
            System.out.println(building59_Classrooms.get(i));
        }

        ArrayList<Labs> building59_Labs = new ArrayList<>();

        for(int i = 1; i<=5; i++){
            building59_Labs.add(new Labs(i, 20, "None"));
        }
        for(int i = 1; i<=5; i++){
            building59_Labs.add(new Labs(5+i, 20, "Male"));
        }
        for(int i = 1; i<=5; i++){
            building59_Labs.add(new Labs(10+i, 20, "Female"));
        }

        for (int i=0; i<building59_Labs.size(); i++){
            System.out.println(building59_Labs.get(i));
        }



        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(new Admin("202034780", "s202034780@kfupm.edu.com", "Male", "1234",  "Admin"));
        admins.add(new Admin("202164610", "s202164610@kfupm.edu.com", "Male", "1234",  "Admin"));
        admins.add(new Admin("202253960", "s202253960@kfupm.edu.com", "Male", "1234",  "Admin"));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Application Admins");
        System.out.println("=========================================================================");



        for(int i = 0; i<admins.size(); i++){
            System.out.println(admins.get(i));
        }




    }
}
