package com.example.swe206project;

public class Facilities {

    private int facilityID;
    private boolean isAvailable;

    private String gender;
    private int capacity;

    public Facilities(int facilityID, String gender, int capacity) {
        this.facilityID = facilityID;
        this.gender = gender;
        isAvailable = true;
        this.capacity = capacity;
    }

    public int getFacilityID() {return facilityID;}
    public int getCapacity(){return capacity;}
    public String getGender(){return gender;}

    public boolean checkAvailability() {
        return isAvailable;
    }

    public void setUnAvailable(){ isAvailable = false;}
    public void setAvailable(){ isAvailable = true;}
}
class Gym extends Facilities {


    public Gym(int facilityID, String gender, int capacity) {
        super(facilityID, gender, capacity);
    }}
class SportCourt extends Facilities {


    public SportCourt(int facilityID, String gender, int capacity) {
        super(facilityID, gender, capacity);
    }}
class SwimmingPool extends Facilities {
    public SwimmingPool(int facilityID, String gender, int capacity) {
        super(facilityID, gender, capacity);
    }}

class Classroom extends Facilities{

    public Classroom(int facilityID, String gender, int capacity) {
        super(facilityID, gender, capacity);
    }}
}
class Labs extends Facilities{
    public Labs(int facilityID, String gender, int capacity) {
        super(facilityID, gender, capacity);
    }}

}
