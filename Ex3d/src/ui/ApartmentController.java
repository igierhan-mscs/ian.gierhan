package ui;

import business.Apartment;
import db.ApartmentTextFile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;

public class ApartmentController {
//    ObservableList<String> apartmentOptions =
//            FXCollections.observableArrayList(
//                    "101, 400sqft, $400",
//                    "102, 600sqft, $600",
//                    "103, 900sqft, $900"
//            );
    private static int nextApartmentId = 100;

    ObservableList<Apartment> apartmentOptions =
        FXCollections.observableArrayList(
                new Apartment(++nextApartmentId, "101", 400, 1, 400.0, LocalDateTime.now()),
                new Apartment(++nextApartmentId, "102", 600, 1, 600.0, LocalDateTime.now()),
                new Apartment(++nextApartmentId, "103", 800, 1, 800.0, LocalDateTime.now()),
                new Apartment(++nextApartmentId, "104", 1000, 2, 1100.0, LocalDateTime.now())
                );

    @FXML
    private TextField apartmentIdTextField;
    @FXML
    private TextField apartmentNumTextField;
    @FXML
    private TextField squareFeetTextField;
    @FXML
    private TextField bathroomsTextField;
    @FXML
    private Label priceLabel;
    @FXML
    private Label updatedLabel;
    @FXML
    private Label errMsgLabel;
    @FXML
    private ComboBox apartmentsComboBox;

    public static int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }

    @FXML
    private void generateTestDataClicked(ActionEvent actionEvent) {
        this.apartmentsComboBox.setItems(apartmentOptions);
        if (this.apartmentsComboBox.getItems().size() > 0)
            this.apartmentsComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void selectedApartmentChanged(ActionEvent actionEvent) {
        this.apartmentIdTextField.setText("");
        this.apartmentNumTextField.setText("");
        this.squareFeetTextField.setText("");
        this.bathroomsTextField.setText("");
        this.priceLabel.setText("");
        this.updatedLabel.setText("");

        Apartment selectedApartment = (Apartment) this.apartmentsComboBox.getValue();

        if (selectedApartment != null) {
            this.apartmentIdTextField.setText(Integer.toString(selectedApartment.getApartmentId()));
            this.apartmentNumTextField.setText(selectedApartment.getApartmentNum());
            this.squareFeetTextField.setText(Integer.toString(selectedApartment.getSquareFeet()));
            this.bathroomsTextField.setText(Integer.toString(selectedApartment.getBathrooms()));
            this.priceLabel.setText(Double.toString(selectedApartment.getPrice()));
            this.updatedLabel.setText(selectedApartment.getUpdated().toString());

            this.apartmentNumTextField.requestFocus();
        }
    }

    @FXML
    private void newApartmentButtonClicked(ActionEvent actionEvent) {
        Apartment newApartment = new Apartment(++nextApartmentId, "", 0, 0, 0.0, LocalDateTime.now());
        this.apartmentOptions.add(newApartment);
        this.apartmentsComboBox.setValue(newApartment);
    }

    @FXML
    private void saveApartmentButtonClicked(ActionEvent actionEvent) {
        Apartment selectedApartment = (Apartment) this.apartmentsComboBox.getValue();

        String errMsg = "";

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
            selectedApartment.setUpdated(LocalDateTime.now());
            this.updatedLabel.setText(selectedApartment.getUpdated().toString());
            this.apartmentsComboBox.setItems(this.apartmentOptions);

//            ApartmentTextFile apartmentTextFile = new ApartmentTextFile();
            ApartmentTextFile.saveAll(apartmentOptions);
        }
    }

    @FXML
    private void clearApartmentsButtonClicked(ActionEvent actionEvent) {
        this.apartmentOptions.clear();
    }

    @FXML
    private void getApartmentsButtonClicked(ActionEvent actionEvent) {
        this. apartmentOptions.clear();
//        ApartmentTextFile apartmentTextFile = new ApartmentTextFile();
        ApartmentTextFile.getAll(this.apartmentOptions);
        this.apartmentsComboBox.setItems(apartmentOptions);
        if (this.apartmentsComboBox.getItems().size() > 0)
            this.apartmentsComboBox.getSelectionModel().selectFirst();
    }
}
