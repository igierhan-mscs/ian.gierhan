package ui;

import business.Apartment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ApartmentController {
    private Apartment apartment1 = null;
    private Apartment apartment2 = null;
    private Apartment apartment3 = null;

    @FXML private TextField apartmentIdTextField;
    @FXML private TextField apartmentNumTextField;
    @FXML private TextField squareFeetTextField;
    @FXML private TextField bathroomsTextField;
    @FXML private Label priceLabel;
    @FXML private Label updatedLabel;
    @FXML private Label errMsgLabel;
    @FXML private Button saveApartment1Button;
    @FXML private Button saveApartment2Button;
    @FXML private Button saveApartment3Button;
    @FXML private Button displayApartment1Button;
    @FXML private Button displayApartment2Button;
    @FXML private Button displayApartment3Button;

    public static int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }

    @FXML
    private void saveApartment1ButtonClicked(ActionEvent actionEvent) {
        String errMsg = "";
        if (this.apartment1 == null) {
            this.apartment1 = new Apartment();
        }

        // apartmentID
        int aptId = tryParseInt(this.apartmentIdTextField.getText());
        if (aptId == 0)
            errMsg = "Apartment Id is required";
        else
            errMsg = this.apartment1.setApartmentId(aptId);
        this.errMsgLabel.setText(errMsg);
        if (!errMsg.isEmpty()) {
            this.apartmentIdTextField.requestFocus();
        }

        // apartmentNum
        if (errMsg.isEmpty()) {
            errMsg = apartment1.setApartmentNum(apartmentNumTextField.getText());
            this.errMsgLabel.setText(errMsg);
            if (!errMsg.isEmpty()) {
                this.apartmentNumTextField.requestFocus();
            }
        }

        // squareFeet
        if (errMsg.isEmpty()) {
            int squareFeet = tryParseInt(squareFeetTextField.getText());
            errMsg = apartment1.setSquareFeet(squareFeet);
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
            errMsg = apartment1.setBathrooms(bathrooms);
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
            apartment1.setPrice();
            this.priceLabel.setText(Double.toString(this.apartment1.getPrice()));
        }

        //updated date
        this.updatedLabel.setText(this.apartment1.getUpdated().toString());

        // If input errors, delete apartment obj
        if (!this.errMsgLabel.getText().isEmpty())
            this.apartment1 = null;
        else {
            this.apartmentIdTextField.setText("");
            this.apartmentNumTextField.setText("");
            this.squareFeetTextField.setText("");
            this.bathroomsTextField.setText("");
            this.priceLabel.setText("");
            this.updatedLabel.setText("");
            this.saveApartment1Button.setDisable(true);
            this.displayApartment1Button.setDisable(false);
            this.apartmentIdTextField.requestFocus();
        }
    }

    @FXML
    private void saveApartment2ButtonClicked(ActionEvent actionEvent) {
        String errMsg = "";
        if (this.apartment2 == null) {
            this.apartment2 = new Apartment();
        }

        // apartmentID
        int aptId = tryParseInt(this.apartmentIdTextField.getText());
        if (aptId == 0)
            errMsg = "Apartment Id is required";
        else
            errMsg = this.apartment2.setApartmentId(aptId);
        this.errMsgLabel.setText(errMsg);
        if (!errMsg.isEmpty()) {
            this.apartmentIdTextField.requestFocus();
        }

        // apartmentNum
        if (errMsg.isEmpty()) {
            errMsg = apartment2.setApartmentNum(apartmentNumTextField.getText());
            this.errMsgLabel.setText(errMsg);
            if (!errMsg.isEmpty()) {
                this.apartmentNumTextField.requestFocus();
            }
        }

        // squareFeet
        if (errMsg.isEmpty()) {
            int squareFeet = tryParseInt(squareFeetTextField.getText());
            errMsg = apartment2.setSquareFeet(squareFeet);
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
            errMsg = apartment2.setBathrooms(bathrooms);
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
            apartment2.setPrice();
            this.priceLabel.setText(Double.toString(this.apartment2.getPrice()));
        }

        //updated date
        this.updatedLabel.setText(this.apartment2.getUpdated().toString());

        // If input errors, delete apartment obj
        if (!this.errMsgLabel.getText().isEmpty())
            this.apartment2 = null;
        else {
            this.apartmentIdTextField.setText("");
            this.apartmentNumTextField.setText("");
            this.squareFeetTextField.setText("");
            this.bathroomsTextField.setText("");
            this.priceLabel.setText("");
            this.updatedLabel.setText("");
            this.saveApartment2Button.setDisable(true);
            this.displayApartment2Button.setDisable(false);
            this.apartmentIdTextField.requestFocus();
        }
    }

    @FXML
    private void saveApartment3ButtonClicked(ActionEvent actionEvent) {
        String errMsg = "";
        if (this.apartment3 == null) {
            this.apartment3 = new Apartment();
        }

        // apartmentID
        int aptId = tryParseInt(this.apartmentIdTextField.getText());
        if (aptId == 0)
            errMsg = "Apartment Id is required";
        else
            errMsg = this.apartment3.setApartmentId(aptId);
        this.errMsgLabel.setText(errMsg);
        if (!errMsg.isEmpty()) {
            this.apartmentIdTextField.requestFocus();
        }

        // apartmentNum
        if (errMsg.isEmpty()) {
            errMsg = apartment3.setApartmentNum(apartmentNumTextField.getText());
            this.errMsgLabel.setText(errMsg);
            if (!errMsg.isEmpty()) {
                this.apartmentNumTextField.requestFocus();
            }
        }

        // squareFeet
        if (errMsg.isEmpty()) {
            int squareFeet = tryParseInt(squareFeetTextField.getText());
            errMsg = apartment3.setSquareFeet(squareFeet);
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
            errMsg = apartment3.setBathrooms(bathrooms);
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
            apartment3.setPrice();
        this.priceLabel.setText(Double.toString(this.apartment3.getPrice()));
        }

        //updated date
        this.updatedLabel.setText(this.apartment3.getUpdated().toString());

        // If input errors, delete apartment obj
        if (!this.errMsgLabel.getText().isEmpty())
            this.apartment3 = null;
        else {
            this.apartmentIdTextField.setText("");
            this.apartmentNumTextField.setText("");
            this.squareFeetTextField.setText("");
            this.bathroomsTextField.setText("");
            this.priceLabel.setText("");
            this.updatedLabel.setText("");
            this.saveApartment3Button.setDisable(true);
            this.displayApartment3Button.setDisable(false);
            this.apartmentIdTextField.requestFocus();
        }
    }

    @FXML
    private void displayApartment1ButtonClicked(ActionEvent actionEvent) {
        if (this.apartment1 != null) {
            this.apartmentIdTextField.setText(Integer.toString(this.apartment1.getApartmentId()));
            this.apartmentNumTextField.setText(this.apartment1.getApartmentNum());
            this.squareFeetTextField.setText(Integer.toString(this.apartment1.getSquareFeet()));
            this.bathroomsTextField.setText(Integer.toString(this.apartment1.getBathrooms()));
            this.priceLabel.setText(Double.toString(this.apartment1.getPrice()));
            this.updatedLabel.setText(this.apartment1.getUpdated().toString());
            this.saveApartment1Button.setDisable(true);
            this.displayApartment1Button.setDisable(false);
            this.apartmentIdTextField.requestFocus();
        }
    }

    @FXML
    private void displayApartment2ButtonClicked(ActionEvent actionEvent) {
        if (this.apartment2 != null) {
            this.apartmentIdTextField.setText(Integer.toString(this.apartment2.getApartmentId()));
            this.apartmentNumTextField.setText(this.apartment2.getApartmentNum());
            this.squareFeetTextField.setText(Integer.toString(this.apartment2.getSquareFeet()));
            this.bathroomsTextField.setText(Integer.toString(this.apartment2.getBathrooms()));
            this.priceLabel.setText(Double.toString(this.apartment2.getPrice()));
            this.updatedLabel.setText(this.apartment2.getUpdated().toString());
            this.saveApartment2Button.setDisable(true);
            this.displayApartment2Button.setDisable(false);
            this.apartmentIdTextField.requestFocus();
        }
    }

    @FXML
    private void displayApartment3ButtonClicked(ActionEvent actionEvent) {
        if (this.apartment3 != null) {
            this.apartmentIdTextField.setText(Integer.toString(this.apartment3.getApartmentId()));
            this.apartmentNumTextField.setText(this.apartment3.getApartmentNum());
            this.squareFeetTextField.setText(Integer.toString(this.apartment3.getSquareFeet()));
            this.bathroomsTextField.setText(Integer.toString(this.apartment3.getBathrooms()));
            this.priceLabel.setText(Double.toString(this.apartment3.getPrice()));
            this.updatedLabel.setText(this.apartment3.getUpdated().toString());
            this.saveApartment3Button.setDisable(true);
            this.displayApartment3Button.setDisable(false);
            this.apartmentIdTextField.requestFocus();
        }
    }
}
