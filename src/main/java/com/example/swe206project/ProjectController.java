package com.example.swe206project;

import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.control.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import javafx.event.ActionEvent;

public class  ProjectController {
    ArrayList<Reservation> Reservations = new ArrayList<>();
    private boolean reservationEventClicked = false;
    private boolean isAdmin = false;
    @FXML
    private RadioButton rMail;
    @FXML
    private RadioButton rMale, rFemale;
    @FXML
    private RadioButton rStudent, rFaculty, rStaff, rClubPresident;
    @FXML
    private ImageView AccountIcon;

    @FXML
    private TextField CurrentParticipantsInput;
    @FXML
    private TextField RequiredParticipantsInput;
    @FXML
    private Label CurrentParticipantsLabel;
    @FXML
    private Label RequiredParticipantsLabel;
    @FXML
    private Label EventNameLabel;
    @FXML
    private TextField EventNameInput;
    @FXML
    private HBox AdminButtonsHbox;

    @FXML
    private Label AlreadyRegisteredLabel;
    @FXML
    private Label UsernameLabel;
    @FXML
    private HBox ButtonsHbox;

    @FXML
    private HBox EmailBar;

    @FXML
    private TextField EmailInput;

    @FXML
    private HBox GenderBar;

    @FXML
    private Button HomeButton;

    @FXML
    private ImageView HomeIcon;

    @FXML
    private HBox ImagesHbox;

    @FXML
    private Button KfupmButton;

    @FXML
    private ImageView KfupmIcon;

    @FXML
    private ImageView SportCourt;

    @FXML
    private Label LiketodoLabel;

    @FXML
    private Button LoginButton;

    @FXML
    private Label LoginLabel;

    @FXML
    private HBox MenuBar;

    @FXML
    private PasswordField PasswordInput;

    @FXML
    private VBox RegisterBar;

    @FXML
    private Button RegisterButton;

    @FXML
    private Button JoinButton;

    @FXML
    private Label RegisterErrorLabel;

    @FXML
    private Label RegisterLabel;

    @FXML
    private TextField SearchBar;

    @FXML
    private HBox TypeBar;
    @FXML
    private AnchorPane ReservationInfoPage;

    @FXML
    private AnchorPane ChoicePage;
    @FXML
    private AnchorPane JoinEventPage;

    @FXML
    private Label RoomIDLabel;

    @FXML
    private Label ReservationErrorInfoLabel;

    @FXML
    private Label RequiredParticipants;


    @FXML
    private TextField RoomIDInput;

    @FXML
    private TextField DateInput;
    @FXML
    private TextField StartTimeInput;
    @FXML
    private TextField EndTimeInput;
    @FXML
    private TextField ReservationReasonInput;
    @FXML
    private Label SuccessLabel;

    @FXML
    private TextField UsernameInput;
    @FXML
    private Label EnterEventLabel;

    @FXML
    private Label WelcomeLabel;

    @FXML
    private ImageView ClassroomImage;
    @FXML

    private ImageView GymImage;
    @FXML
    private Button CancelButton;
    @FXML

    private ImageView LabImage;
    @FXML
    private ImageView SwimImage;
    @FXML
    private AnchorPane ViewEventsPage;

    @FXML
    private TextField JoinEventInput;
    @FXML
    private Label EventLabel;
    @FXML
    private Label AllEventLabel;

    @FXML
    void JoinButtonClick(ActionEvent event) {

        try {

            int inputReservationID = Integer.parseInt(JoinEventInput.getText());
            boolean eventFound = false;
            for (Reservation.Event event2 : events) {
                if (event2.getReservationID() == inputReservationID) {
                    eventFound = true;
                    if (getRoomGenderUsingReservationID()){
                        if(getUserNameUsingReservationID()){

                            if (event2.JoinEventCheck()) {

                                SuccessLabel.setText("You have registered in an event!");



                                if (isAdmin) {
                                    AdminHomepage();
                                    SuccessLabel.setVisible(true);
                        }
                                else {
                                    Homepage();
                                    SuccessLabel.setVisible(true);
                        }}
                        else{
                                SuccessLabel.setText("The event you tried to join is full");


                            if (isAdmin) {
                                AdminHomepage();
                                SuccessLabel.setVisible(true);
                            } else {
                                Homepage();
                                SuccessLabel.setVisible(true);
                            }


                            }


                    } else {
                            SuccessLabel.setText("You cannot Join your own event");



                        if (isAdmin) {
                            AdminHomepage();
                            SuccessLabel.setVisible(true);
                        } else {
                            Homepage();
                            SuccessLabel.setVisible(true);
                        }
                    }

                    break;
                }
            }

            if (!eventFound) {
                SuccessLabel.setText("No Event exists with this ID");


                if (isAdmin) {
                    AdminHomepage();
                    SuccessLabel.setVisible(true);
                } else {
                    Homepage();
                    SuccessLabel.setVisible(true);
                }
            }
            else {SuccessLabel.setText("Error! Gender Conflict");}



                if (isAdmin) {
                    AdminHomepage();
                    SuccessLabel.setVisible(true);
                } else {
                    Homepage();
                    SuccessLabel.setVisible(true);
                }}

        } catch (NumberFormatException e) {
            SuccessLabel.setText("Please enter a valid event ID.");


            if (isAdmin) {
                AdminHomepage();
                SuccessLabel.setVisible(true);
            } else {
                Homepage();
                SuccessLabel.setVisible(true);
            }
        }
    }
    String text = "";
    @FXML
    void CancelButtonClick(ActionEvent event) {

        try {
            int reservationId = Integer.parseInt(JoinEventInput.getText());
            String Email = getEmail();
            if (removeReservationById(reservationId)) {
                if(rMail.isSelected()) {
                    openEmailClient(Email, "Facility Reservation Cancellation", "Dear user,\n\nYour reservation for the facility has been canceled.\n\nBest regards,\nKFUPM Reservation Admins Team");
                    text = "You have Cancelled a Reservation";
                }
                else text = "You have Cancelled a Reservation";
            } else {
               text ="No reservation exists with that ID";
            }

                if (isAdmin) {
                    AdminHomepage();
                } else {
                    Homepage();

                }
                SuccessLabel.setText(text);
                SuccessLabel.setVisible(true);
                JoinEventInput.setText("");

        }catch (NumberFormatException e) {

            if (isAdmin) {
                AdminHomepage();
            } else {
                Homepage();
            }
            SuccessLabel.setText("Please enter a valid reservation ID");
            SuccessLabel.setVisible(true);
            JoinEventInput.setText("");

        }}
    public String getEmail(){

        int reservationId = Integer.parseInt(JoinEventInput.getText());
        for(Reservation reservation: reservations){
            if(reservation.getReservationID()==reservationId){
                for(User user:users1){
                    if(reservation.getUsername().equals(user.getUserName())){
                        return user.getEmail();
                    }
                }
                for(Admin admin : admins){

                    if(reservation.getUsername().equals(admin.getUserName())){

                        return admin.getEmail();}}
            }
        }
        for(Reservation.Event event: events){

            if(event.getReservationID()==reservationId){

                for(User user:users1){

                    if(event.getUsername().equals(user.getUserName())){

                        return user.getEmail();
                    }
                }
                for(Admin admin : admins){

                    if(event.getUsername().equals(admin.getUserName())){

                        return admin.getEmail();}}
            }
        }

        return "";

    }
    public boolean getRoomGenderUsingReservationID(){
        int reservationId = Integer.parseInt(JoinEventInput.getText());

        for(Reservation.Event reservation: events){
            if(reservation.getReservationID()==reservationId){

                for(Facilities facility: roomsIDs){
                    if(facility.getFacilityID()==reservation.getReservationRoomID()){

                        if((facility.getGender().equals(getUserGender(UsernameLabel.getText())))||facility.getGender().equals("None")){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean getUserNameUsingReservationID(){
        int reservationId = Integer.parseInt(JoinEventInput.getText());
        for(Reservation.Event reservation: events){
            if(reservation.getReservationID()==reservationId){
                if(reservation.getUsername().equals(UsernameLabel.getText())){
                    return false;
                        }
                    }
                }

        return true;
    }
    private void openEmailClient(String email, String subject, String body) {
        try {
            String encodedSubject = URLEncoder.encode(subject, "UTF-8");
            String encodedBody = URLEncoder.encode(body, "UTF-8");
            String uriString = String.format("mailto:%s?subject=%s&body=%s", email, encodedSubject, encodedBody);
            URI mailto = new URI(uriString);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().mail(mailto);
            } else {
                System.out.println("Desktop is not supported. Please open the following URL manually: " + uriString);
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void MakeReservationButtonClick(ActionEvent event) {
        ChoicePage.setVisible(true);
        HideHomepage();
        ImagesHbox.setVisible(true);
        SuccessLabel.setVisible(false);
        SuccessLabel.setText("You have Successfully made a Reservation");
        reservationEventClicked = true;
    }

    @FXML
    void OpenReservationEventButtonClick(ActionEvent event) {

        ChoicePage.setVisible(true);
        HideHomepage();
        ImagesHbox.setVisible(true);
        SuccessLabel.setVisible(false);
        SuccessLabel.setText("You have Successfully Opened a Reservation Event");
        reservationEventClicked = false;

    }

    @FXML
    void JoinReservationEventButtonClick(ActionEvent event) {
        HideHomepage();
        rMail.setVisible(false);
        JoinEventPage.setVisible(true);
        CancelButton.setVisible(false);
        JoinButton.setVisible(true);
        JoinButton.setText("Join Event");
        EnterEventLabel.setText("Enter the ID of the Event you Would like to Join");


    }

    @FXML
    void ViewAllReservationsButtonClick(ActionEvent event) {
        HideHomepage();
        ViewEventsPage.setVisible(true);
        AllEventLabel.setVisible(true);
        EventLabel.setVisible(false);
        addTextEvent(events);
        addTextReservation(reservations);
    }
    @FXML
    void SearchButtonClick(ActionEvent event) {
        HideHomepage();
        ViewEventsPage.setVisible(true);
        AllEventLabel.setVisible(false);
        EventLabel.setVisible(true);
        addTextEvent(events);
    }
    @FXML
    void CancelReservationButtonClick(ActionEvent event) {
        rMail.setVisible(true);
        JoinEventPage.setVisible(true);
        HideHomepage();
        JoinButton.setText("Cancel Reservation");
        EnterEventLabel.setText("Enter the ID of the Reservation you Would like to Remove");
        CancelButton.setVisible(true);
        JoinButton.setVisible(false);
        }



    @FXML
    void HomeButtonClick(ActionEvent event) {
        if (isAdmin){
            AdminHomepage();
            clearInputs();
            ReservationErrorInfoLabel.setText("");
        }
        else {
        Homepage();
        clearInputs();
        ReservationErrorInfoLabel.setText("");
    }}

    @FXML
    void AccountButtonClick(ActionEvent event) {
        Login();
        ChoicePage.setVisible(false);
        ReservationInfoPage.setVisible(false);
        ViewEventsPage.setVisible(false);
        JoinEventPage.setVisible(false);
    }

    @FXML
    void KfupmButtonClick(ActionEvent event) {

    }
    @FXML
    void RegisterButtonClick(ActionEvent event) {
        if (LoginLabel.getText().equals("Login!")){
            if(checkRegisterInfo()){
                addUser();
                UsernameLabel.setText(UsernameInput.getText());
                Homepage();
                isAdmin=false;}
            else
                RegisterErrorLabel.setText("Error Please fill all requested information");
        }
        else
        if (checkForLogin(UsernameInput.getText(),PasswordInput.getText())) {
            UsernameLabel.setText(UsernameInput.getText());
            Homepage();
            isAdmin= false;
        }else if (checkForAdmin(UsernameInput.getText(),PasswordInput.getText())){
                AdminHomepage();
                isAdmin = true;
                UsernameLabel.setText(UsernameInput.getText());
            }

        else
            RegisterErrorLabel.setText("Error Username and Password dont match");

    }

    @FXML
    void LoginButtonClick(ActionEvent event) {
        if (LoginLabel.getText().equals("Login!")) {
            Login();
        } else {
            Register();
        }
    }

    @FXML
    void ConfirmButtonClick(ActionEvent event) {
        if (reservationEventClicked) {
            if (checkReservationInfo()) {
                if(addReservation()) {

                    clearInputs();
                    if (isAdmin) {
                        AdminHomepage();
                    } else {
                        Homepage();
                    }
                    SuccessLabel.setVisible(true);
                    ReservationErrorInfoLabel.setText("");
                }
                else{
                    ReservationErrorInfoLabel.setText("Error! Gender Conflict");
                }
            } else {
                ReservationErrorInfoLabel.setText("Error Please fill all information");
            }
        } else {

                if (checkEventInfo()) {
                    try {
                        if(checkRoomCapacity()){
                            int currentParticipants = Integer.parseInt(CurrentParticipantsInput.getText());
                            int requiredParticipants = Integer.parseInt(RequiredParticipantsInput.getText());
                            if(checkEventCapacity(currentParticipants,requiredParticipants)){

                                boolean checkGender = getRoomGenderUsingRoomID();
                                if(checkGender) {
                                    if (addEvent()) {
                                        if (isAdmin) {
                                            AdminHomepage();
                                        } else {
                                            Homepage();
                                        }
                                        SuccessLabel.setVisible(true);
                                        ReservationErrorInfoLabel.setText("");
                                        clearInputs();
                                    } else ReservationErrorInfoLabel.setText("Error! Time Conflict");
                                }
                                else ReservationErrorInfoLabel.setText("Error! Gender Conflict");

                                }
                            else {
                                ReservationErrorInfoLabel.setText("Required Participants cant be lower or equal to Current Participants");

                            }
                    }
                        else{
                            ReservationErrorInfoLabel.setText("Required or Current Participants cannot be higher than room capacity");
                        }
                    }

                    catch(NumberFormatException e){
                        ReservationErrorInfoLabel.setText("Please enter integers for current and required participants");

                    }

                } else {
                    ReservationErrorInfoLabel.setText("Error Please fill all information");

                }
            }
        }







    boolean t;
    @FXML
    void ClassroomButtonClick(ActionEvent event) {
        try{
        t = getUserType(UsernameLabel.getText()).equals("Student");}
        catch(Exception e){
            t = false;
        }
        if (t)
        {SuccessLabel.setText("You are not Allowed to Open a Reservation Even for Classrooms or Labs");
            SuccessLabel.setVisible(true);}
        else{
        ReservationInfoPage.setVisible(true);
        ChoicePage.setVisible(false);
        ImagesHbox.setVisible(false);
            if (reservationEventClicked){
        hide();
        }
        else{
        unhide();
        }
    }}

    @FXML
    void ComputerLabButtonClick(ActionEvent event) {
        try{
            t = getUserType(UsernameLabel.getText()).equals("Student");}
        catch(Exception e){
            t = false;
        }
        if (t)
        {SuccessLabel.setText("You are not Allowed to Open a Reservation Even for Classrooms or Labs");
            SuccessLabel.setVisible(true);}
        else{
        ReservationInfoPage.setVisible(true);
        ChoicePage.setVisible(false);
        ImagesHbox.setVisible(false);
            if (reservationEventClicked){
            hide();
        }
        else{
            unhide();
        }}
    }

    @FXML
    void SportCourtButtonClick(ActionEvent event) {
        ReservationInfoPage.setVisible(true);
        ChoicePage.setVisible(false);
        ImagesHbox.setVisible(false);
        if (reservationEventClicked){
            hide();
        }
        else{
            unhide();
        }
    }

    @FXML
    void GymButtonClick(ActionEvent event) {
        ReservationInfoPage.setVisible(true);
        ChoicePage.setVisible(false);
        ImagesHbox.setVisible(false);
        if (reservationEventClicked){
            hide();
        }
        else{
            unhide();
        }
    }

    @FXML
    void SwimmingPoolButtonClick(ActionEvent event) {
        ReservationInfoPage.setVisible(true);
        ChoicePage.setVisible(false);
        ImagesHbox.setVisible(false);
        if (reservationEventClicked){
            hide();
        }
        else{
            unhide();
        }

    }


    @FXML
    public String getGender() {
        if (rMale.isSelected()) {
            return "Male";
        } else if (rFemale.isSelected()) {
            return "Female";
        } else {
            return null;
        }
    }

    public String getType() {
        if (rStudent.isSelected()) {
            return "Student";
        } else if (rFaculty.isSelected()) {
            return "Faculty";
        } else if (rStaff.isSelected()) {
            return "Staff";
        } else {
            return null;
        }
    }
    ArrayList<Admin> admins = new ArrayList<>();
    ArrayList<Classroom> building59_Classrooms = new ArrayList<>();
    ArrayList<Labs> building59_Labs = new ArrayList<>();
    ArrayList<SwimmingPool> swimmingPools = new ArrayList<>();
    ArrayList<Gym> gyms = new ArrayList<>();
    ArrayList<SportCourt> sportCourts = new ArrayList<>();
    ArrayList<Facilities> roomsIDs = new ArrayList<>();

    public void initialize() {

        try {
            initializeImages();
            admins.add(new Admin("202034780", "s202034780@kfupm.edu.com", "Male", "1234",  "Admin"));
            admins.add(new Admin("202164610", "s202164610@kfupm.edu.com", "Male", "1234",  "Admin"));
            admins.add(new Admin("202253960", "s202253960@kfupm.edu.com", "Male", "1234",  "Admin"));
            admins.add(new Admin("admin", "admin@kfupm.edu.com", "Female", "1234",  "Admin"));

            //classrooms//
            for(int i = 1; i<=20; i++){
                building59_Classrooms.add(new Classroom(1000+i, "None", 40));
                roomsIDs.add(new Facilities(1000+i, "None", 40));
            }
            for(int i = 1; i<=10; i++){
                building59_Classrooms.add(new Classroom(1020+i, "Male", 40));
                roomsIDs.add(new Facilities(1020+i, "Male", 40));
            }
            for(int i = 1; i<=10; i++){
                building59_Classrooms.add(new Classroom(1030+i,  "Female",40));
                roomsIDs.add(new Facilities(1030+i,  "Female",40));
            }
            //labs//
            for(int i = 1; i<=5; i++){
                building59_Labs.add(new Labs(100+i, "None", 20));
                roomsIDs.add(new Facilities(100+i, "None", 20));
            }
            for(int i = 1; i<=5; i++){
                building59_Labs.add(new Labs(200+i, "Male", 20));
                roomsIDs.add(new Facilities(200+i, "Male", 20));
            }
            for(int i = 1; i<=5; i++){
                building59_Labs.add(new Labs(300+i, "Female", 20));
                roomsIDs.add(new Facilities(300+i, "Female", 20));
            }
            //swimming pools//
            swimmingPools.add(new SwimmingPool(1, "Male", 40));
            roomsIDs.add(new Facilities(1, "Male", 40));
            swimmingPools.add(new SwimmingPool(2, "Female",30 ));
            roomsIDs.add(new Facilities(2, "Female",30));

            //gyms//
            gyms.add(new Gym(3,"Male", 20));
            roomsIDs.add(new Facilities(3,"Male", 20));
            gyms.add(new Gym(4,"Female", 20));
            roomsIDs.add(new Facilities(4,"Female", 20));

            //Sport courts//
            sportCourts.add(new SportCourt(5,"Male", 50));
            roomsIDs.add(new Facilities(5,"Male", 50));
            sportCourts.add(new SportCourt(6,"Female", 33));
            roomsIDs.add(new Facilities(6,"Female", 33));


            Reservation.Event ev1 = new Reservation.Event(100,"202253960",1,"2024-02-11","12:00","15:00","Practice","Football",3,1);
            Reservation res1 = new Reservation(10,"202253960",2,"2024-06-02","04:00","08:00","Playing");
            reservations.add(res1);
            events.add(ev1);
            addTextEvent(events);
            addTextReservation(reservations);

            ChoicePage.setVisible(false);
            ViewEventsPage.setVisible(false);
            ReservationInfoPage.setVisible(false);
            JoinEventPage.setVisible(false);

        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
        Register();
    }

    void Register() {
        MenuBar.setVisible(false);
        RegisterBar.setVisible(true);
        EmailBar.setVisible(true);
        TypeBar.setVisible(true);
        GenderBar.setVisible(true);
        HideHomepage();
        RegisterLabel.setText("Register");
        RegisterButton.setText("Register");
        LoginLabel.setText("Login!");
        UsernameInput.clear();
        PasswordInput.clear();
        EmailInput.clear();
        AlreadyRegisteredLabel.setText("Already Registered?");
        clearRadioButtons();
        RegisterErrorLabel.setText("");
    }

    void Login() {
        MenuBar.setVisible(false);
        RegisterBar.setVisible(true);
        EmailBar.setVisible(false);
        TypeBar.setVisible(false);
        GenderBar.setVisible(false);
        HideHomepage();
        RegisterLabel.setText("Login");
        RegisterButton.setText("Login");
        LoginLabel.setText("Register!");
        AlreadyRegisteredLabel.setText("Dont have an account?");
        UsernameInput.clear();
        PasswordInput.clear();
        EmailInput.clear();
        RegisterErrorLabel.setText("");
        clearRadioButtons();
    }
    boolean checkEventCapacity(int currentMembers, int neededMembers){
        if (currentMembers < neededMembers)
        return true;
        else{ReservationErrorInfoLabel.setText("Required Participants cant be lower or equal than current members");
        return false;}
    }

    void Homepage() {
        MenuBar.setVisible(true);
        RegisterBar.setVisible(false);
        ImagesHbox.setVisible(true);
        ButtonsHbox.setVisible(true);
        LiketodoLabel.setVisible(true);
        WelcomeLabel.setVisible(true);
        ChoicePage.setVisible(false);
        ReservationInfoPage.setVisible(false);
        SuccessLabel.setVisible(false);
        JoinEventPage.setVisible(false);
        ViewEventsPage.setVisible(false);
    }
    void AdminHomepage(){
        Homepage();
        AdminButtonsHbox.setVisible(true);
    }

    void HideHomepage() {
        ImagesHbox.setVisible(false);
        ButtonsHbox.setVisible(false);
        LiketodoLabel.setVisible(false);
        WelcomeLabel.setVisible(false);
        AdminButtonsHbox.setVisible(false);
    }

    public void clearRadioButtons() {
        rMale.setSelected(false);
        rFemale.setSelected(false);
        rStudent.setSelected(false);
        rFaculty.setSelected(false);
        rStaff.setSelected(false);
        rClubPresident.setSelected(false);
    }
    public void hide(){
        CurrentParticipantsInput.setVisible(false);
        CurrentParticipantsLabel.setVisible(false);
        RequiredParticipantsInput.setVisible(false);
        RequiredParticipantsLabel.setVisible(false);
        EventNameInput.setVisible(false);
        EventNameLabel.setVisible(false);}
    public void unhide(){
        CurrentParticipantsInput.setVisible(true);
        CurrentParticipantsLabel.setVisible(true);
        RequiredParticipantsInput.setVisible(true);
        RequiredParticipantsLabel.setVisible(true);
        EventNameInput.setVisible(true);
        EventNameLabel.setVisible(true);}
    public void clearInputs() {
        ReservationReasonInput.clear();
        DateInput.clear();
        StartTimeInput.clear();
        EndTimeInput.clear();
        CurrentParticipantsInput.clear();
        RoomIDInput.clear();
        RequiredParticipantsInput.clear();
        EventNameInput.clear();
    }

    public void addTextReservation(List<Reservation> reservations) {

        for (Reservation reservation : reservations) {
            AllEventLabel.setText(AllEventLabel.getText() +"\n"+ reservation.toString());
        }
    }
    public void addTextEvent(List<Reservation.Event> Events) {
        AllEventLabel.setText("");
        EventLabel.setText("");
        for (Reservation.Event event : Events) {
            AllEventLabel.setText(AllEventLabel.getText() + "\n"+ event.toString() );
            EventLabel.setText(EventLabel.getText() + "\n"+ event.toString() );
        }
    }


    public boolean findReservation(Reservation Res) {
        for (Reservation reservation : Reservations) {

            if (reservation.getReservationID() == (Res.getReservationID())) {
                return true;
            }
        }
        return false;
    }

    void initializeImages() {
        Image image = new Image(getClass().getResource("/com/example/swe206project/Home.png").toString());
        HomeIcon.setImage(image);
        Image image2 = new Image(getClass().getResource("/com/example/swe206project/Account.png").toString());
        AccountIcon.setImage(image2);
        Image image3 = new Image(getClass().getResource("/com/example/swe206project/Kfupm.png").toString());
        KfupmIcon.setImage(image3);
        Image image4 = new Image(getClass().getResource("/com/example/swe206project/Lab.jpg").toString());
        LabImage.setImage(image4);
        Image image5 = new Image(getClass().getResource("/com/example/swe206project/Classroom.Jpg").toString());
        ClassroomImage.setImage(image5);
        Image image6 = new Image(getClass().getResource("/com/example/swe206project/Gym.jpg").toString());
        GymImage.setImage(image6);
        Image image7 = new Image(getClass().getResource("/com/example/swe206project/Swim.jpg").toString());
        SwimImage.setImage(image7);
        Image image8 = new Image(getClass().getResource("/com/example/swe206project/SportCourt.jpg").toString());
        SportCourt.setImage(image8);


    }
    public boolean checkEventInfo() {
        if (isEmpty(RequiredParticipantsInput) || isEmpty(CurrentParticipantsInput) || isEmpty(ReservationReasonInput)
                || isEmpty(DateInput) || isEmpty(StartTimeInput) || isEmpty(EndTimeInput) || isEmpty(EventNameInput) || isEmpty(RoomIDInput)) {
            return false;}
            return true;}
    public boolean checkReservationInfo() {
        if (isEmpty(ReservationReasonInput)  || isEmpty(DateInput) || isEmpty(StartTimeInput) || isEmpty(EndTimeInput)
                || isEmpty(RoomIDInput)) {
            return false;}
        return true;}
    public boolean checkRegisterInfo() {
        if (isEmpty(UsernameInput) || isEmpty(EmailInput) || isEmpty(PasswordInput)) {
            return false;
        }
        if (!rMale.isSelected() && !rFemale.isSelected()) {
            return false;
        }
        if (!rFaculty.isSelected() && !rStaff.isSelected() && !rStudent.isSelected() && !rClubPresident.isSelected()) {
            return false;}
        return true;
    }
        private boolean isEmpty(TextField textField) {
            return textField.getText() == null || textField.getText().trim().isEmpty();
        }
    public boolean isAdmin(User user) {
        return user instanceof Admin;
    }


    ArrayList<User> users1 = new ArrayList<>();

    public void addUser() {
        users1.add(new User(UsernameInput.getText(), EmailInput.getText(), getGender(), PasswordInput.getText(), getType()));
    }

    public boolean checkForLogin(String username, String password) {
        for (User user : users1) {
            if (user.getUserName().equals(username)) {
                return user.getPassword().equals(password);
            }
        }
        return false;}
    public boolean checkForAdmin(String username, String password) {
        for(Admin admin:admins){
            if(admin.getUserName().equals(username)){
                return admin.getPassword().equals(password);
            }
        }
        return false;
    }
    public boolean removeReservationById(int id) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReservationID() == id) {
                reservations.remove(i);
                return true;
            }
        }
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getReservationID() == id) {
                events.remove(i);
                return true;
            }
        }
        return false;
    }
    public String getUserType(String username) {
        for (User user : users1) {
            if (user.getUserName().equals(username)) {
                return user.getType();}}
        return null;
    }
    public String getUserGender(String username) {
        for (User user : users1) {
            if (user.getUserName().equals(username)) {
                return user.getGender();}}
        for (Admin admin : admins)
            if (admin.getUserName().equals(username)) {
                return admin.getGender();}
        return null;
    }
    public boolean getRoomGenderUsingRoomID(){
        for(Facilities Facility:roomsIDs){
            if (Facility.getFacilityID()==Integer.parseInt(RoomIDInput.getText())){
                if((getUserGender(UsernameLabel.getText()).equals(Facility.getGender())||Facility.getGender().equals("None"))){
                    return true;
                }
                else return false;
            }
        }
        return false;
    }
    ArrayList<Reservation> reservations = new ArrayList<>();
    int i = 1;

    public boolean addReservation() {
        boolean checkGender = getRoomGenderUsingRoomID();
        if (checkGender){
            Reservation newReservation = new Reservation(i, UsernameLabel.getText(), Integer.parseInt(RoomIDInput.getText()), DateInput.getText(), StartTimeInput.getText(), EndTimeInput.getText(), ReservationReasonInput.getText());
            reservations.add(newReservation);
            i++;
            return true;
        }
        else return false;
    }
    public boolean checkRoomCapacity(){
        for(Facilities facilities: roomsIDs){
            if(facilities.getFacilityID()==Integer.parseInt(RoomIDInput.getText())){
                if((facilities.getCapacity()>=Integer.parseInt(RequiredParticipantsInput.getText()))||facilities.getCapacity()>=Integer.parseInt(CurrentParticipantsInput.getText())){
                    return true;
                }
            }
        }
        return false;
    }
    ArrayList<Reservation.Event> events = new ArrayList<>();
    public boolean addEvent() {
        Reservation.Event newEvent = new Reservation.Event(i, UsernameLabel.getText(),
                Integer.parseInt(RoomIDInput.getText()), DateInput.getText(), StartTimeInput.getText(),
                EndTimeInput.getText(), ReservationReasonInput.getText(),EventNameInput.getText(),
                Integer.parseInt(RequiredParticipantsInput.getText()),
                Integer.parseInt(CurrentParticipantsInput.getText()));
            if(!isTimeConflict(Integer.parseInt(RoomIDInput.getText()))){
                events.add(newEvent);
                i++;
                return true;
            }
            else return false;


    }

    public LocalDate getDateInput() {
        return LocalDate.parse(DateInput.getText());
    }

    public LocalTime getStartTimeInput() {
        return LocalTime.parse(StartTimeInput.getText());
    }

    public LocalTime getEndTimeInput() {
        return LocalTime.parse(EndTimeInput.getText());
    }

    public boolean isTimeConflict(int roomID){
        for(Reservation.Event event:events){
            if(roomID==event.getReservationRoomID()) {
                if (getDateInput().equals(event.getDate()) && getStartTimeInput().isBefore(event.getEndTime()) && getEndTimeInput().isAfter(event.getStartTime())) {
                    ReservationErrorInfoLabel.setText("Error! Time Conflict");
                    return true;
                }
            }
        }
        return false;
    }

}

