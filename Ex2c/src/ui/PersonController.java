package ui;

import business.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PersonController {
    private Person person1 = null;
    private Person person2 = null;
    private Person person3 = null;

    @FXML private TextField personIdTextField;
    @FXML private TextField updatedTextField;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField userNameTextField;

    @FXML
    private void person1ButtonClicked(ActionEvent actionEvent) {
        if (this.person1 == null) {
            this.person1 = new Person(101, firstNameTextField.getText(),
                    lastNameTextField.getText(), userNameTextField.getText());
            this.personIdTextField.setText("");
            this.firstNameTextField.setText("");
            this.lastNameTextField.setText("");
            this.userNameTextField.setText("");
            this.updatedTextField.setText("");

            this.firstNameTextField.requestFocus();
        }
        else {
            this.personIdTextField.setText(Integer.toString(this.person1.getPersonId()));
            this.firstNameTextField.setText(this.person1.getFirstName());
            this.lastNameTextField.setText(this.person1.getLastName());
            this.userNameTextField.setText(this.person1.getUserName());
            this.updatedTextField.setText(this.person1.getUpdated().toString());
        }
    }

    @FXML
    private void person2ButtonClicked(ActionEvent actionEvent) {
        if (this.person2 == null) {
            this.person2 = new Person(102, firstNameTextField.getText(),
                    lastNameTextField.getText(), userNameTextField.getText());
            this.personIdTextField.setText("");
            this.firstNameTextField.setText("");
            this.lastNameTextField.setText("");
            this.userNameTextField.setText("");
            this.updatedTextField.setText("");

            this.firstNameTextField.requestFocus();
        }
        else {
            this.personIdTextField.setText(Integer.toString(this.person2.getPersonId()));
            this.firstNameTextField.setText(this.person2.getFirstName());
            this.lastNameTextField.setText(this.person2.getLastName());
            this.userNameTextField.setText(this.person2.getUserName());
            this.updatedTextField.setText(this.person2.getUpdated().toString());
        }
    }

    @FXML
    private void person3ButtonClicked(ActionEvent actionEvent) {
        if (this.person3 == null) {
            this.person3 = new Person(103, firstNameTextField.getText(),
                    lastNameTextField.getText(), userNameTextField.getText());
            this.personIdTextField.setText("");
            this.firstNameTextField.setText("");
            this.lastNameTextField.setText("");
            this.userNameTextField.setText("");
            this.updatedTextField.setText("");

            this.firstNameTextField.requestFocus();
        }
        else {
            this.personIdTextField.setText(Integer.toString(this.person3.getPersonId()));
            this.firstNameTextField.setText(this.person3.getFirstName());
            this.lastNameTextField.setText(this.person3.getLastName());
            this.userNameTextField.setText(this.person3.getUserName());
            this.updatedTextField.setText(this.person3.getUpdated().toString());
        }
    }
}