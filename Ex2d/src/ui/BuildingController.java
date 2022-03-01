package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import business.Building;

public class BuildingController {

    private Building building1 = null;
    private Building building2 = null;
    private Building building3 = null;
    
    @FXML private TextField buildingIdTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField cityTextField;
    @FXML private TextField stateTextField;
    @FXML private TextField zipTextField;
    @FXML private TextField unitsTextField;
    @FXML private TextField updatedTextField;

    @FXML
    private void building1ButtonClicked(ActionEvent actionEvent) {
        if (this.building1 == null) {
            this.building1 = new Building(101, addressTextField.getText(),
                    cityTextField.getText(), stateTextField.getText(),
                    zipTextField.getText(), unitsTextField.getText());
            this.buildingIdTextField.setText("");
            this.addressTextField.setText("");
            this.cityTextField.setText("");
            this.stateTextField.setText("");
            this.zipTextField.setText("");
            this.unitsTextField.setText("");
            this.updatedTextField.setText("");

            this.addressTextField.requestFocus();
        }
        else {
            this.buildingIdTextField.setText(Integer.toString(this.building1.getBuildingId()));
            this.addressTextField.setText(this.building1.getAddress());
            this.cityTextField.setText(this.building1.getCity());
            this.stateTextField.setText(this.building1.getState());
            this.zipTextField.setText(this.building1.getZip());
            this.unitsTextField.setText(this.building1.getUnits());
            this.updatedTextField.setText(this.building1.getUpdated().toString());
        }
    }

    @FXML
    private void building2ButtonClicked(ActionEvent actionEvent) {
        if (this.building2 == null) {
            this.building2 = new Building(102, addressTextField.getText(),
                    cityTextField.getText(), stateTextField.getText(),
                    zipTextField.getText(), unitsTextField.getText());
            this.buildingIdTextField.setText("");
            this.addressTextField.setText("");
            this.cityTextField.setText("");
            this.stateTextField.setText("");
            this.zipTextField.setText("");
            this.unitsTextField.setText("");
            this.updatedTextField.setText("");

            this.addressTextField.requestFocus();
        }
        else {
            this.buildingIdTextField.setText(Integer.toString(this.building2.getBuildingId()));
            this.addressTextField.setText(this.building2.getAddress());
            this.cityTextField.setText(this.building2.getCity());
            this.stateTextField.setText(this.building2.getState());
            this.zipTextField.setText(this.building2.getZip());
            this.unitsTextField.setText(this.building2.getUnits());
            this.updatedTextField.setText(this.building2.getUpdated().toString());
        }
    }

    @FXML
    private void building3ButtonClicked(ActionEvent actionEvent) {
        if (this.building3 == null) {
            this.building3 = new Building(103, addressTextField.getText(),
                    cityTextField.getText(), stateTextField.getText(),
                    zipTextField.getText(), unitsTextField.getText());
            this.buildingIdTextField.setText("");
            this.addressTextField.setText("");
            this.cityTextField.setText("");
            this.stateTextField.setText("");
            this.zipTextField.setText("");
            this.unitsTextField.setText("");
            this.updatedTextField.setText("");

            this.addressTextField.requestFocus();
        }
        else {
            this.buildingIdTextField.setText(Integer.toString(this.building3.getBuildingId()));
            this.addressTextField.setText(this.building3.getAddress());
            this.cityTextField.setText(this.building3.getCity());
            this.stateTextField.setText(this.building3.getState());
            this.zipTextField.setText(this.building3.getZip());
            this.unitsTextField.setText(this.building3.getUnits());
            this.updatedTextField.setText(this.building3.getUpdated().toString());
        }
    }
}
