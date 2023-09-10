package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.text.NumberFormat;


public class loanCalculatorController {
    @FXML
    TextField interestRateTextField;
    @FXML
    TextField numberOfYearsTextField;
    @FXML
    TextField loanAmountTextField;
    @FXML
    TextField monthlyPaymentTextField;
    @FXML
    TextField totalPaymentTextField;
    private float interestRate;
    private int numberOfYears;
    private double loanAmount;
    private double monthlyPayment;
    private double totalPayment;
    private int numberOfMonths;
    private float monthlyInterestRate;

    public void calculateBtnOnAction(ActionEvent actionEvent) {
try{
    clearAllFields();
    interestRate = Float.parseFloat(interestRateTextField.getText())/100;
    monthlyInterestRate = (interestRate/12);
    numberOfYears = Integer.parseInt(numberOfYearsTextField.getText());
    numberOfMonths = numberOfYears * 12;
    loanAmount = Double.parseDouble(loanAmountTextField.getText());
    monthlyPayment = loanAmount * ((monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfMonths))) / ((Math.pow(1 + monthlyInterestRate, numberOfMonths))-1));
    totalPayment = monthlyPayment * numberOfMonths;
    monthlyPaymentTextField.appendText(NumberFormat.getCurrencyInstance().format(monthlyPayment));
    totalPaymentTextField.appendText(NumberFormat.getCurrencyInstance().format(totalPayment));
} catch (Exception e) {
    e.printStackTrace();
}
    }

    private void clearAllFields() {
        monthlyPaymentTextField.clear();
        totalPaymentTextField.clear();
    }

}
