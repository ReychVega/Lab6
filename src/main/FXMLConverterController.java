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
        
        if(e1TextField.getText().isEmpty() || e2TextField.getText().isEmpty() || e3TextField.getText().isEmpty() || e4TextField.getText().isEmpty() || e5TextField.getText().isEmpty()){      
             
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
     
        label1.setText(infixNotation(e1));
        label2.setText(infixNotation(e2));
        label3.setText(infixNotation(e3));
        label4.setText(infixNotation(e4));
        label5.setText(infixNotation(e5));
        
        
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
        
    }
    
}
