/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Jos
 */
public class linkedStackNGTest {

    public linkedStackNGTest() {

    }

    @Test
    public void testSomeMethod() {
        try {
            linkedStack s = new linkedStack();
            s.push(10);
            s.push(3);
            s.push(5);
            s.push(20);
            s.push(30);
            s.push(40);
            System.out.println(s.toString());
            System.out.println("Linked stack top: " + s.top());
            System.out.println("pop: " + s.pop());
            System.out.println(s.toString());
            System.out.println("Linked stack top: " + s.top());
            System.out.println(s.toString());
            System.out.println(s.toString());
            System.out.println(s.toString());
            linkedStack p = new linkedStack();
            p.push("Hello world");
            s.push(p);
            System.out.println(s.toString());

        } catch (StackException ex) {
            Logger.getLogger(ArrayStackNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testSomeMethod2() {
        try {
            String hilera = "(()(()())())";//correcta
            String hilera2 = "(()(()())()))";//incorrecta
            String hilera3 = "((2-10*5)-3";//incorrecta
            String hilera4 = "(2-2)*4/5())";//incorrecta

            System.out.println(checkParenthesis(hilera));
            System.out.println(checkParenthesis(hilera2));
            System.out.println(checkParenthesis(hilera3));
            System.out.println(checkParenthesis(hilera4));
        } catch (StackException ex) {
            Logger.getLogger(ArrayStackNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //funcional
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

    private String infixNotation(String expresion) throws StackException {
        expresion = expresion.replaceAll("\\s", "");
        linkedStack infixPila = new linkedStack();
        String exp = "";
        for (int i = 0; i < expresion.length() - 1; i++) {
            if (util.Utility.isLetter(expresion.charAt(i)) || util.Utility.isNumber(expresion.charAt(i)) && (expresion.charAt(i) != '(') && expresion.charAt(i) != '(') {//Si es una letra o un número
                infixPila.push("" + expresion.charAt(i));
            } else {
                if (util.Utility.isOperator(expresion.charAt(i))) {//Si es un operador
                    //Se extraen dos elementos del tope de la pila
                    String operando1 = (String) infixPila.pop();
                    String operando2 = (String) infixPila.pop();
                    //Seguimos la operacion "operando operador operando"
                    infixPila.push("("+operando1+expresion.charAt(i)+operando2+")");
                }
            }
        }
        
        exp = (String)infixPila.top();//Devuelve el top, que equivale a la expresion infija
        
        return exp;

    }
    
    //falta el metodo que retorne el resultado

}
