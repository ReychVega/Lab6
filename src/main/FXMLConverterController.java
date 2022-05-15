/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import domain.Node;
import domain.StackException;
import domain.linkedStack;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import static util.Utility.isOperator;

/**
 * FXML Controller class
 *
 * @author XPC
 */
public class FXMLConverterController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private TextField e1TextField;
    @FXML
    private TextField e2TextField;
    @FXML
    private TextField e3TextField;
    @FXML
    private TextField e4TextField;
    @FXML
    private TextField e5TextField;
    @FXML
    private Button btnConvert;
    @FXML
    private Button btnClean;
    @FXML
    private Label TextSuccess;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label11;
    @FXML
    private Label label6;
    @FXML
    private Label label8;
    @FXML
    private Label label9;
    @FXML
    private Label label10;
    @FXML
    private Label label7;
    @FXML
    private TextField e1TextField1;
    @FXML
    private TextField e1TextField11;
    @FXML
    private TextField e1TextField111;
    @FXML
    private TextField e1TextField1111;
    @FXML
    private TextField e1TextField11111;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private String infixNotation(String expresion) throws StackException {
        expresion = expresion.replaceAll("\\s", "");
        linkedStack infixPila = new linkedStack();
        String exp = "";
        for (int i = 0; i < expresion.length(); i++) {
            if (util.Utility.isLetter(expresion.charAt(i)) || util.Utility.isNumber(expresion.charAt(i)) && (expresion.charAt(i) != '(') && expresion.charAt(i) != '(') {//Si es una letra o un número
                infixPila.push("" + expresion.charAt(i));
            } else {
                if (util.Utility.isOperator(expresion.charAt(i))) {//Si es un operador
                    //Se extraen dos elementos del tope de la pila
                    String operando1 = (String) infixPila.pop();
                    String operando2 = (String) infixPila.pop();
                    //Seguimos la operacion "operando operador operando"
                    infixPila.push("(" + operando2 + expresion.charAt(i) + operando1 + ")");
                }
            }
        }

        exp = (String) infixPila.top();
        return exp;

    }

    @FXML
    private void btnConvertOnAction(ActionEvent event) throws StackException {

        if (e1TextField.getText().isEmpty() || e2TextField.getText().isEmpty() || e3TextField.getText().isEmpty() || e4TextField.getText().isEmpty() || e5TextField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.NONE);

            alert.setAlertType(Alert.AlertType.ERROR);

            alert.setTitle("Error");

            alert.setHeaderText("Los campos solicitados están vacíos");

            alert.show();
        }

        String e1, e2, e3, e4, e5;

        e1 = e1TextField.getText();
        e2 = e2TextField.getText();
        e3 = e3TextField.getText();
        e4 = e4TextField.getText();
        e5 = e5TextField.getText();

        if (containsLetters(e1)) {

            e1TextField1.setText(infixNotation(e1));
        }else{
        
            e1TextField1.setText(infixNotation(e1) + " = " + resultFix(e1));
        
        }
        if (containsLetters(e2)) {

            e1TextField11.setText(infixNotation(e2));
        }else{
        
            e1TextField11.setText(infixNotation(e2) + " = " + resultFix(e2));
        
        }
        if (containsLetters(e3)) {

            e1TextField111.setText(infixNotation(e3));
        }else{
        
            e1TextField111.setText(infixNotation(e3) + " = " + resultFix(e3));
        
        }
        if (containsLetters(e4)) {

            e1TextField1111.setText(infixNotation(e4));
        }else{
            
            e1TextField1111.setText(infixNotation(e4) + " = " + resultFix(e5));
        
        
        }
        if (containsLetters(e5)) {

            e1TextField11111.setText(infixNotation(e5));
        }else{
        
            e1TextField11111.setText(infixNotation(e5) + " = " + resultFix(e5));
        
        }


    }

    @FXML
    private void bntCleanOnAction(ActionEvent event) {

        e1TextField.setText("");
        e2TextField.setText("");
        e3TextField.setText("");
        e4TextField.setText("");
        e5TextField.setText("");
        label1.setText("");
        label2.setText("");
        label3.setText("");
        label4.setText("");
        label5.setText("");
//         e1TextField1.setText("");
//         e1TextField11.setText("");
//         e1TextField111.setText("");
//         e1TextField1111.setText("");
//         e1TextField11111.setText("");

    }

    private String resultFix(String expression) throws StackException {
        expression = expression.replaceAll("\\s", "");
        linkedStack s = new linkedStack();

        for (int i = 0; i < expression.length(); i++) {
            //getClass().isPrimitive();
            if (Character.isLetter(expression.charAt(i))
                    || (Character.isDigit(expression.charAt(i)))) {
                s.push("" + expression.charAt(i));
            } else {
                if (isOperator(expression.charAt(i))) {
                    double SecondOp = Double.parseDouble(String.valueOf(s.pop()));
                    double firstOp = Double.parseDouble(String.valueOf(s.pop()));
                    //Se satisface: Operando operador operando
                    //El resultado anterior se almacena en el tope de la pila

                    s.push("" + util.Utility.arithmeticResult(expression.charAt(i), firstOp, SecondOp));
                }//ifOperando

            }
        }
        return (String) s.top();
    }

    private boolean containsLetters(String str) {

        for (int i = 0; i < str.length(); i++) {

            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(("" + str.charAt(i)).toUpperCase())) {
                return true;
            }

        }
        return false;
    }

}
