package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CustomerController {

    public TextField fieldName;
    public TextField fieldMail;
    public ChoiceBox<Car> choiceCar;
    private Customer customer;
    private Car car;
    private ObservableList<Car> listCars;

    public CustomerController(Customer customer, ArrayList<Car> cars) {
        this.customer = customer;
        listCars = FXCollections.observableArrayList(cars);
    }

    @FXML
    public void initialize() {
        choiceCar.setItems(listCars);
        if (customer != null) {
            fieldName.setText(customer.getName());
            fieldMail.setText(customer.getEmail());
            choiceCar.getSelectionModel().select(customer.getCar());
        } else {
            choiceCar.getSelectionModel().selectFirst();
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void clickOk(ActionEvent actionEvent) {
        boolean correct = true;

        if (fieldName.getText().trim().isEmpty()) {
            fieldName.getStyleClass().removeAll("correctly");
            fieldName.getStyleClass().add("incorrectly");
            correct = false;
        } else {
            fieldName.getStyleClass().removeAll("correctly");
            fieldName.getStyleClass().add("incorrectly");
        }

        if (fieldMail.getText().trim().isEmpty()) {
            fieldMail.getStyleClass().removeAll("correctly");
            fieldMail.getStyleClass().add("incorrectly");
            correct = false;
        } else {
            fieldMail.getStyleClass().removeAll("correctly");
            fieldMail.getStyleClass().add("incorrectly");
        }

        if (!correct) return;

        if (customer == null) customer = new Customer();
        customer.setName(fieldName.getText());
        customer.setEmail(fieldMail.getText());
        customer.setCar(choiceCar.getSelectionModel().getSelectedItem());
        closeWindow();
    }

    public void clickCancel(ActionEvent actionEvent) {
        customer = null;
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) fieldName.getScene().getWindow();
        stage.close();
    }
}
