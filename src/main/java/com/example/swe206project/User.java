package com.example.swe206project;

public class User {


    private String userName;
    private int userID;
    private String email;
    private String gender;
    private String password;
    private String type;

    public User(String userName, int userID, String email, String gender, String password, String type) {
        this.userName = userName;
        this.userID = userID;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.type = type;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userID;
    }

    public void setUserId(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPassword() {return password;}
    public void setPassword(String password){this.password = password;}
    public String getType(){return type;}
    public void setType(String type){this.type = type;}

    public void joinEvent(String eventName){}

    @Override
    public String toString() {
        return ("UserName:" + userName + ", UserID:" + userID + ", User Email:" + email + ", User Gender:" + gender + ", User Type:" + type);
    }
}
class Admin extends User{
    public Admin(String userName, int userID, String email, String gender, String password, String type) {
        super(userName, userID, email, gender, password, type);
    }
    void viewAllReservations(){}
    void cancelReservation(String reservationID){}
    void sendCancelEmail(){}
}
class Faculty extends User{
    public Faculty(String userName, int userID, String email, String gender, String password, String type) {
        super(userName, userID, email, gender, password, type);
    }
}
class Staff extends User{
    public Staff(String userName, int userID, String email, String gender, String password, String type) {
        super(userName, userID, email, gender, password, type);
    }
}

class Student extends User{

    boolean inClub;
    boolean clubPresident;

    public Student(String userName, int userID, String email, String gender,String password, String type, boolean inClub, boolean clubPresident) {
        super(userName, userID, email, gender, password, type);
        this.inClub = inClub;
        this.clubPresident = clubPresident;

    }
}
