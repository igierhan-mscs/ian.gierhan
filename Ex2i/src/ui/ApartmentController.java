package ui;

import business.Apartment;
import business.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class ApartmentController {
    private Apartment apartment1 = null;
    private Apartment apartment2 = null;
    private Apartment apartment3 = null;
    private static int nextApartmentId = 100;
    private static int nextPersonId = 100;

    @FXML private TextField apartmentIdTextField;
    @FXML private TextField apartmentNumTextField;
    @FXML private TextField squareFeetTextField;
    @FXML private TextField bathroomsTextField;
    @FXML private Label priceLabel;
    @FXML private Label updatedLabel;
    @FXML private Label errMsgLabel;
    @FXML
    private TextField personIdTextField;
    @FXML
    private TextField updatedTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField userNameTextField;
    @FXML
    private RadioButton apt1RadioButton;
    @FXML
    private RadioButton apt2RadioButton;
    @FXML
    private RadioButton apt3RadioButton;
    @FXML
    private RadioButton adminRadioButton;
    @FXML
    private RadioButton renterRadioButton;

    public static int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }

    @FXML
    private void saveApartmentButtonClicked(ActionEvent actionEvent) {
        Apartment selectedApartment = null;

        if (this.apt1RadioButton.isSelected()) { selectedApartment = this.apartment1; }
        else if (this.apt2RadioButton.isSelected()) { selectedApartment = this.apartment2; }
        else if (this.apt3RadioButton.isSelected()) { selectedApartment = this.apartment3; }

        String errMsg = "";
        if (selectedApartment == null) {
            selectedApartment = new Apartment();
        }

        selectedApartment.setApartmentId(getNextApartmentId());
        this.apartmentIdTextField.setText(Integer.toString(selectedApartment.getApartmentId()));

        // apartmentNum
        if (errMsg.isEmpty()) {
            errMsg = selectedApartment.setApartmentNum(apartmentNumTextField.getText());
            this.errMsgLabel.setText(errMsg);
            if (!errMsg.isEmpty()) {
                this.apartmentNumTextField.requestFocus();
            }
        }

        // squareFeet
        if (errMsg.isEmpty()) {
            int squareFeet = tryParseInt(squareFeetTextField.getText());
            errMsg = selectedApartment.setSquareFeet(squareFeet);
            if (squareFeetTextField.getText().length() == 0) {
                this.errMsgLabel.setText("Square feet is required");
                this.squareFeetTextField.requestFocus();
            } else {
                this.errMsgLabel.setText(errMsg);
                if (!errMsg.isEmpty()) {
                    this.squareFeetTextField.requestFocus();
                }
            }
        }

        // bathrooms
        if (errMsg.isEmpty()) {
            int bathrooms = tryParseInt(bathroomsTextField.getText());
            errMsg = selectedApartment.setBathrooms(bathrooms);
            if (bathroomsTextField.getText().length() == 0) {
                this.errMsgLabel.setText("Bathrooms is required");
                this.bathroomsTextField.requestFocus();
            } else {
                this.errMsgLabel.setText(errMsg);
                if (!errMsg.isEmpty()) {
                    this.bathroomsTextField.requestFocus();
                }
            }
        }

        //price
        if (errMsg.isEmpty()) {
            selectedApartment.setPrice();
            this.priceLabel.setText(Double.toString(selectedApartment.getPrice()));
        }

        //updated date
        this.updatedLabel.setText(selectedApartment.getUpdated().toString());

        // If input errors, delete apartment obj
        if (!this.errMsgLabel.getText().isEmpty())
            selectedApartment = null;

        if (this.apt1RadioButton.isSelected()) { this.apartment1 = selectedApartment; }
        else if (this.apt2RadioButton.isSelected()) { this.apartment2 = selectedApartment; }
        else if (this.apt3RadioButton.isSelected()) { this.apartment3 = selectedApartment; }
    }

    @FXML
    private void apartmentRadioButtonSelected(ActionEvent actionEvent) {
        this.apartmentIdTextField.setText("");
        this.apartmentNumTextField.setText("");
        this.squareFeetTextField.setText("");
        this.bathroomsTextField.setText("");
        this.priceLabel.setText("");
        this.updatedLabel.setText("");
        this.apartmentIdTextField.requestFocus();
        this.personIdTextField.setText("");
        this.firstNameTextField.setText("");
        this.lastNameTextField.setText("");
        this.userNameTextField.setText("");
        this.updatedTextField.setText("");

        Apartment selectedApartment = null;

        if (this.apt1RadioButton.isSelected()) { selectedApartment = this.apartment1; }
        else if (this.apt2RadioButton.isSelected()) { selectedApartment = this.apartment2; }
        else if (this.apt3RadioButton.isSelected()) { selectedApartment = this.apartment3; }

        if (selectedApartment != null) {
            this.apartmentIdTextField.setText(Integer.toString(selectedApartment.getApartmentId()));
            this.apartmentNumTextField.setText(selectedApartment.getApartmentNum());
            this.squareFeetTextField.setText(Integer.toString(selectedApartment.getSquareFeet()));
            this.bathroomsTextField.setText(Integer.toString(selectedApartment.getBathrooms()));
            this.priceLabel.setText(Double.toString(selectedApartment.getPrice()));
            this.updatedLabel.setText(selectedApartment.getUpdated().toString());

            Person selectedPerson = null;
            if (this.adminRadioButton.isSelected())
                selectedPerson = selectedApartment.getAdministrator();
            else
                selectedPerson = selectedApartment.getRenter();
            if (selectedPerson != null) {
                this.personIdTextField.setText(Integer.toString(selectedPerson.getPersonId()));
                this.firstNameTextField.setText(selectedPerson.getFirstName());
                this.lastNameTextField.setText(selectedPerson.getLastName());
                this.userNameTextField.setText(selectedPerson.getUserName());
                this.updatedTextField.setText(selectedPerson.getUpdated().toString());
            }

            this.apartmentIdTextField.requestFocus();
        }
    }

    @FXML
    private void savePersonButtonClicked(ActionEvent actionEvent) {
        Apartment selectedApartment = null;

        if (this.apt1RadioButton.isSelected()) { selectedApartment = this.apartment1; }
        else if (this.apt2RadioButton.isSelected()) { selectedApartment = this.apartment2; }
        else if (this.apt3RadioButton.isSelected()) { selectedApartment = this.apartment3; }

        if (selectedApartment != null) {
            Person selectedPerson = null;
            if (this.adminRadioButton.isSelected())
                selectedPerson = selectedApartment.getAdministrator();
            else
                selectedPerson = selectedApartment.getRenter();

            if (selectedPerson == null) {
                selectedPerson = new Person(getNextPersonId(), firstNameTextField.getText(),
                        lastNameTextField.getText(), userNameTextField.getText());
                if (this.adminRadioButton.isSelected())
                    selectedApartment.setAdministrator(selectedPerson);
                else
                    selectedApartment.setRenter(selectedPerson);
                this.personIdTextField.setText(Integer.toString(selectedPerson.getPersonId()));
            }
            else {
                selectedPerson.setFirstName((this.firstNameTextField.getText()));
                selectedPerson.setLastName((this.lastNameTextField.getText()));
                selectedPerson.setUserName((this.userNameTextField.getText()));
                selectedPerson.setUpdated();
            }
        }
        this.updatedTextField.setText(selectedApartment.getUpdated().toString());
    }

    private static int getNextApartmentId() {
        return  ++nextApartmentId;
    }

    private static int getNextPersonId() {
        return  ++nextPersonId;
    }

    @FXML
    private void personRadioButtonSelected(ActionEvent actionEvent) {
        this.personIdTextField.setText("");
        this.firstNameTextField.setText("");
        this.lastNameTextField.setText("");
        this.userNameTextField.setText("");
        this.updatedTextField.setText("");

        Apartment selectedApartment = null;
        if (this.apt1RadioButton.isSelected()) { selectedApartment = this.apartment1; }
        else if (this.apt2RadioButton.isSelected()) { selectedApartment = this.apartment2; }
        else if (this.apt3RadioButton.isSelected()) { selectedApartment = this.apartment3; }

        if (selectedApartment != null) {
            Person selectedPerson = null;
            if (this.adminRadioButton.isSelected())
                selectedPerson = selectedApartment.getAdministrator();
            else
                selectedPerson = selectedApartment.getRenter();
            if (selectedPerson != null) {
                this.personIdTextField.setText(Integer.toString(selectedPerson.getPersonId()));
                this.firstNameTextField.setText(selectedPerson.getFirstName());
                this.lastNameTextField.setText(selectedPerson.getLastName());
                this.userNameTextField.setText(selectedPerson.getUserName());
                this.updatedTextField.setText(selectedPerson.getUpdated().toString());
            }
            this.apartmentIdTextField.requestFocus();
        }
    }
}
