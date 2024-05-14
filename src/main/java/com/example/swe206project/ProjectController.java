package com.example.swe206project;

import javafx.scene.layout.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.control.*;

import java.util.*;

import javafx.event.ActionEvent;

public class  ProjectController {
    ArrayList<Reservation> Reservations = new ArrayList<>();
    private boolean reservationEventClicked = false;
    private boolean isAdmin = false;
    private String Building = "";
    @FXML
    private Button AccountButton;
    @FXML
    private RadioButton rMale, rFemale;
    @FXML
    private RadioButton rStudent, rFaculty, rStaff;
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

    private ImageView LabImage;
    @FXML
    private ImageView SwimImage;
    @FXML
    private AnchorPane ViewEventsPage;

    @FXML
    private TextField JoinEventInput;

    @FXML
    void JoinButtonClick(ActionEvent event) {
        SuccessLabel.setText("You have registered in an event!");
        JoinEventPage.setVisible(false);
        if (isAdmin){
            AdminHomepage();
        }
        else
        Homepage();

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
        JoinEventPage.setVisible(true);
        JoinButton.setText("Join Event");
        EnterEventLabel.setText("Enter the Name of the Event you Would like to Join");
        SuccessLabel.setText("You have Successfully Joined an Event");
    }

    @FXML
    void ViewAllReservationsButtonClick(ActionEvent event) {
        HideHomepage();
        ViewEventsPage.setVisible(true);
    }

    @FXML
    void CancelReservationButtonClick(ActionEvent event) {
        JoinEventPage.setVisible(true);
        HideHomepage();
        JoinButton.setText("Cancel Reservation");
        EnterEventLabel.setText("Enter the Name of the Event you Would like to Remove");
        SuccessLabel.setText("You have Cancelled a Reservation");


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
                Homepage();}
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
        if (reservationEventClicked){
            if(checkReservationInfo()){
                if (isAdmin){
                    AdminHomepage();
                }
                else
                { Homepage();}
                SuccessLabel.setVisible(true);
                clearInputs();
                ReservationErrorInfoLabel.setText("");
            }
            else {ReservationErrorInfoLabel.setText("Error Please fill all information");}
        }
        else {if(checkEventInfo())
            {if (isAdmin){
                AdminHomepage();
            }
            else
            { Homepage();}
                SuccessLabel.setVisible(true);
                clearInputs();
                ReservationErrorInfoLabel.setText("");}
         else {ReservationErrorInfoLabel.setText("Error Please fill all information");}
        }



    }

    @FXML
    void ClassroomButtonClick(ActionEvent event) {
        ReservationInfoPage.setVisible(true);
        ChoicePage.setVisible(false);
        ImagesHbox.setVisible(false);
        Building = "Classroom";
        if (reservationEventClicked){
        hide();
        }
        else{
        unhide();
        }
    }

    @FXML
    void ComputerLabButtonClick(ActionEvent event) {
        ReservationInfoPage.setVisible(true);
        ChoicePage.setVisible(false);
        ImagesHbox.setVisible(false);
        Building = "ComputerLab";
        if (reservationEventClicked){
            hide();
        }
        else{
            unhide();
        }
    }

    @FXML
    void SportCourtButtonClick(ActionEvent event) {
        ReservationInfoPage.setVisible(true);
        ChoicePage.setVisible(false);
        ImagesHbox.setVisible(false);
        Building = "SportCourt";
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
        Building = "Gym";
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
        Building = "SwimmingPool";
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
            return "Student selected";
        } else if (rFaculty.isSelected()) {
            return "Faculty selected";
        } else if (rStaff.isSelected()) {
            return "Staff selected";
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

    public void initialize() {

        try {
            initializeImages();
            admins.add(new Admin("202034780", "s202034780@kfupm.edu.com", "Male", "1234",  "Admin"));
            admins.add(new Admin("202164610", "s202164610@kfupm.edu.com", "Male", "1234",  "Admin"));
            admins.add(new Admin("202253960", "s202253960@kfupm.edu.com", "Male", "1234",  "Admin"));

            //classrooms//
            for(int i = 1; i<=20; i++){
                building59_Classrooms.add(new Classroom(1000+i, 40, "None"));
            }
            for(int i = 1; i<=10; i++){
                building59_Classrooms.add(new Classroom(1020+i, 40, "Male"));
            }
            for(int i = 1; i<=10; i++){
                building59_Classrooms.add(new Classroom(1030+i, 40, "Female"));
            }
            //labs//
            for(int i = 1; i<=5; i++){
                building59_Labs.add(new Labs(i, 20, "None"));
            }
            for(int i = 1; i<=5; i++){
                building59_Labs.add(new Labs(5+i, 20, "Male"));
            }
            for(int i = 1; i<=5; i++){
                building59_Labs.add(new Labs(10+i, 20, "Female"));
            }
            //swimming pools//
            swimmingPools.add(new SwimmingPool(1, "Male", 40));
            swimmingPools.add(new SwimmingPool(2, "Female",30 ));

            //gyms//
            gyms.add(new Gym(3,"Male", 20));
            gyms.add(new Gym(4,"Female", 20));

            //Sport courts//
            sportCourts.add(new SportCourt(5,"Male", 50));
            sportCourts.add(new SportCourt(6,"Female", 33));

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
        if (!rFaculty.isSelected() && !rStaff.isSelected() && !rStudent.isSelected()) {
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
    public String getUserType(String username) {
        for (User user : users1) {
            if (user.getUserName().equals(username)) {
                return user.getType();}}
        return null;
    }

    ArrayList<Reservation> reservations = new ArrayList<>();
    int i = 1;

    public void addReservation() {
        Reservation newReservation = new Reservation(i, UsernameLabel.getText(), Integer.parseInt(RoomIDInput.getText()), DateInput.getText(), StartTimeInput.getText(), EndTimeInput.getText(), ReservationReasonInput.getText());
        reservations.add(newReservation);
        i++;
    }
    ArrayList<Reservation.Event> events = new ArrayList<>();
    public void addEvent() {
        Reservation.Event newEvent = new Reservation.Event(i, UsernameLabel.getText(),
                Integer.parseInt(RoomIDInput.getText()), DateInput.getText(), StartTimeInput.getText(),
                EndTimeInput.getText(), ReservationReasonInput.getText(),EventNameInput.getText(),
                Integer.parseInt(RequiredParticipantsInput.getText()),
                Integer.parseInt(CurrentParticipantsInput.getText()));
        events.add(newEvent);
        i++;
    }
}

