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

class Classroom {


    private int roomNumber;

    //private String reservationID;

    private int capacity;
    private String genderRestriction;

    public Classroom(int roomNumber, int capacity, String genderRestriction ) {

        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.genderRestriction = genderRestriction;

    }
    public String getGender(){return genderRestriction;}
    public int getRoomNumber(){return roomNumber;}
    @Override
    public String toString() {
        return ("Room Number: " + roomNumber + ", Capacity: " + capacity + ", Gender restriction: " + genderRestriction);
    }
}
class Labs {
    private int LabNumber;

    private int capacity;

    private String genderRestriction;

    public Labs(int LabNumber, int capacity, String genderRestriction) {
        this.LabNumber = LabNumber;
        this.capacity = capacity;
        this.genderRestriction = genderRestriction;

    }
    public String getGender(){return genderRestriction;}
    public int getLabNumber(){return LabNumber;}
    @Override
    public String toString() {
        if(LabNumber<1000){
            if(LabNumber<10){
                return ("Room Number: 000" + LabNumber + ", Capacity: " + capacity + ", Gender restriction: " + genderRestriction);
            }
            else {
                return ("Room Number: 00" + LabNumber + ", Capacity: " + capacity + ", Gender restriction: " + genderRestriction);

            }
        }
        else {
            return ("Room Number: " + LabNumber + ", Capacity: " + capacity + ", Gender restriction: " + genderRestriction);
        }
    }
}
