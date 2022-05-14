/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


/**
 * FXML Controller class
 *
 * @author XPC
 */
public class FXMLCheckController implements Initializable {

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
    private Button btnCheck;
    @FXML
    private Label TextSuccess;
    @FXML
    private ImageView Image1;
    @FXML
    private Button btnClean;
    @FXML
    private ImageView Image2;
    @FXML
    private ImageView Image3;
    @FXML
    private ImageView Image4;
    @FXML
    private ImageView Image5;
    @FXML
    private ImageView Image1_1;
    @FXML
    private ImageView Image2_1;
    @FXML
    private ImageView Image3_1;
    @FXML
    private ImageView Image4_1;
    @FXML
    private ImageView Image5_1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
     private boolean checkParenthesis(String expresion) throws StackException {
        boolean res = false;
        expresion = expresion.replaceAll("\\s", "");//sustituyo cada caracter raro y la limpio
        //validamos si ya empieza con un parentesis cerrado se acabó
        if (expresion.charAt(0) == ')') {
            res = false;
        }
        //valdamos si el parentesis final es abierto se acabó 
        if (expresion.charAt(expresion.length() - 1) == '(') {
            res = false;
        }
        linkedStack pilaParentesis = new linkedStack();
        for (int i = 0; i < expresion.length(); i++) {
            if (expresion.charAt(i) == '(') {
                pilaParentesis.push(expresion.charAt(i));//Si es abierto entonces apilelo en la pila
            }
            if (expresion.charAt(i) == ')') {
                if (pilaParentesis.isEmpty()) {
                    return false;//Se termina
                }
                pilaParentesis.pop();
            }
        }
        //Una posible opción
        if (pilaParentesis.size() == 0) {//pila vacía
            res = true;
        } else {
            res = false;
        }

        return res;
    }
    
    
    private boolean checkExpressions(String expression) throws StackException {
        expression = expression.replaceAll("\\s", "");
        boolean res = false;
        linkedStack pila = new linkedStack();
        //primero valido que los parentesis que contiene la expresión estén correctos
        if (checkParenthesis(expression) == true) {//si los parentesis están bien, ahora valido lo demás

            for (int i = 0; i < expression.length()-1; i++) {
                //si es una letra o un numero
                if (util.Utility.isLetter(expression.charAt(i)) || util.Utility.isNumber(expression.charAt(i)) && (expression.charAt(i) != '(') && expression.charAt(i) != '(') {

                    if (pila.isEmpty()) {//Si la pila está vacía entonces agregue el numero o la letra a la pila
                        pila.push(expression.charAt(i));
                    }

                }
                if (util.Utility.isOperator(expression.charAt(i))) {//Si es un operador 
                    if (pila.isEmpty()) {
                        return false;
                    } else {

                        pila.pop();

                    }

                }

            }

            if (pila.size() != 0) {//la pila no quedó vacía al terminar de recorrer toda la expresión 

                res = true;

            } else { //La pila no está vacía, por lo que quiere decir que sobró un elemento o un operador

                res = false;

            }

        } else { //no cumple con la caracteristica de que todos sus parentesis están bien 
            res = false;

        }

        return res;

    } 
    
    

    @FXML
    private void btnCheckOnAction(ActionEvent event) throws StackException {
        
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
        
        if(checkExpressions(e1)== true){
            Image1.setOpacity(1);
        }else{
            Image1_1.setOpacity(1);
        }
         if(checkExpressions(e2)== true){
            Image2.setOpacity(1);
        }else{
            Image2_1.setOpacity(1);
        }
         if(checkExpressions(e3)== true){
            Image3.setOpacity(1);
        }else{
            Image3_1.setOpacity(1);
        } 
         if(checkExpressions(e4)== true){
            Image4.setOpacity(1);
        }else{
            Image4_1.setOpacity(1);
        }
          if(checkExpressions(e5)== true){
            Image5.setOpacity(1);
        }else{
            Image5_1.setOpacity(1);
        }
        
        
    }

    @FXML
    private void bntCleanOnAction(ActionEvent event) {
        
         e1TextField.setText("");
         e2TextField.setText("");
         e3TextField.setText("");
         e4TextField.setText("");
         e5TextField.setText("");
         Image1.setOpacity(0);
         Image2.setOpacity(0);
         Image3.setOpacity(0);
         Image4.setOpacity(0);
         Image5.setOpacity(0);
         Image1_1.setOpacity(0);
         Image2_1.setOpacity(0);
         Image3_1.setOpacity(0);
         Image4_1.setOpacity(0);
         Image5_1.setOpacity(0);
        
    }
    
}
