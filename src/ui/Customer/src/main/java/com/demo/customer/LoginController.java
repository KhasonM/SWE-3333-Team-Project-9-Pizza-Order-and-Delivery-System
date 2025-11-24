package com.demo.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.converter.IntegerStringConverter;



public class LoginController {
    @FXML
    private TextField enterPhonenumber;
    @FXML
    private Label errorMessagePhonenumber;
    @FXML
    private PasswordField enterPassword;
    @FXML
    private Button submitLogin;
    @FXML
    private Label errorMessagePasswordCount;

    @FXML
    protected void submitLoginPress(ActionEvent event) {

        if(!enterPhonenumber.getText().isBlank()){
            errorMessagePasswordCount.setVisible(true);
        }
    }



}