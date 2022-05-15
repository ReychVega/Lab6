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
            linkedStack p = new linkedStack();
            p.push("Hello world");
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
            System.out.println("pop: " + s.pop());
            System.out.println(s.toString());
            s.push(p);
            System.out.println(p.toString());
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
            
            System.out.println(" Prueba metodo checkParenthesis ");
          //  System.out.println(hilera4.replaceAll("\\s", ""));
            System.out.println(checkParenthesis(hilera));
            System.out.println(checkParenthesis(hilera2));
            System.out.println(checkParenthesis(hilera3));
            System.out.println(checkParenthesis(hilera4));
        } catch (StackException ex) {
            Logger.getLogger(ArrayStackNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testSomeMethod3() {
        try {
            ArrayStack anim = new ArrayStack(10);
            linkedStack pil = new linkedStack();

            for (int i = 0; i < 10; i++) {

                pil.push(util.Utility.random(99999));

            }

            Animal a = new Animal("Pep", "Perro", 4);
            anim.push(a);
            Animal a1 = new Animal("Sizy", "Gata", 4);
            anim.push(a1);
            Animal a2 = new Animal("Ror", "Hamster", 2);
            anim.push(a2);
            Animal a3 = new Animal("Aly", "Conejo", 1);
            anim.push(a3);
            Animal a4 = new Animal("Ub", "Perro", 6);
            anim.push(a4);
            Animal a5 = new Animal("Son Goku", "Tortuga", 8);
            anim.push(a5);
            Animal a6 = new Animal("Silizor", "Gato", 9);
            anim.push(a6);
            Animal a7 = new Animal("Kira", "Perro", 6);
            anim.push(a7);
            Animal a8 = new Animal("Umtii", "Pez", 1);
            anim.push(a8);
            Animal a9 = new Animal("Alizon", "Loro", 3);
            anim.push(a9);

            pil.push(anim); //Agregamos el objeto arrayStack tipo animal que ocntiene 10 animalees

            pil.push("Croacia");
            pil.push("Suiza");
            pil.push("Costa Rica");
            pil.push("Holanda");
            pil.push("Noruega");

            //Indique la cantidad de elementos apilados 
            System.out.println("     ");
            System.out.println("------");
            System.out.println("Cantidad de elementos apilados en la pila enlazada: ");
            System.out.println("     ");
            System.out.println(pil.size());
            System.out.println("     ");
            System.out.println("------");
            System.out.println("     ");

            //Indique el contenido de la pila
            System.out.println("     ");
            System.out.println(pil.toString());
            System.out.println("     ");
            System.out.println("------");

            //Desapila 15 elementos y muestrelos por consola
            System.out.println("     ");
            System.out.println(" Elements of likedStack pop ");
            for (int i = 0; i < 15; i++) {
                System.out.println(pil.pop() + "\n");
            }
            System.out.println("     ");
            System.out.println("------");

            //Muestre el elemento del tope de la pila
            System.out.println("     ");
            System.out.println("Element of top of the linked Stack");
            System.out.println("     ");
            System.out.println(pil.top());
            System.out.println("     ");
            System.out.println("------");

            //Indique la cantidad de elementos apilados
            System.out.println("     ");
            System.out.println(" total elements ");
            System.out.println("     ");
            System.out.println(pil.size());
            System.out.println("     ");
            System.out.println("------");

            //Muestre el contenido de la pila por consola
            System.out.println("     ");
            System.out.println(pil.toString());
            System.out.println("     ");
            System.out.println("------");

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
    
    @Test
    public void testSomeMethod4() {
        try {

            String hilera = "2-(3-5)*(10/2)";//correcta
            String hilera2 = "2-(3-5)*(10/2-)";//incorrecta
            String hilera3 = "((a * b) / (a + c))";//correcta
            String hilera4 = "2-(3-5)*(10/2)";//correcta
            String hilera5 = "((2-10*5)-3";//incorrecta

            System.out.println(" Prueba metodo CheckExpressions");
            System.out.println(checkExpressions(hilera));
            System.out.println(checkExpressions(hilera2));
            System.out.println(checkExpressions(hilera3));
            System.out.println(checkExpressions(hilera4));
            System.out.println(checkExpressions(hilera5));
            System.out.println("  ");
            System.out.println(" Method infixNotation ");
            //AB*AC+/ =  ((A * B) / (A + C))
            String hilera7 = "AB*AC+/";
            System.out.println("Formula sin el infix: " + hilera7);
            System.out.println("Formula con infix: " + infixNotation(hilera7));

              //25*73+/ = ((2 * 5) / (7 + 3)) = 1
            String hilera8 = "25*73+/";
            System.out.println("Formula sin el infix: " + hilera8);
            System.out.println("Formula con infix: " + infixNotation(hilera8));
            
                //59 + 2*65* + = (((5 + 9) * 2) + (6 * 5)) = 58

            String hilera9 = "59 + 2*65* +"; 
            System.out.println("Formula sin el infix: " + hilera9);
            System.out.println("Formula con infix: " + infixNotation(hilera9));
            
        
        } catch (StackException ex) {
            Logger.getLogger(ArrayStackNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean checkExpressions(String expression) throws StackException {
        expression = expression.replaceAll("\\s", "");
        boolean res = false;
        int result=0;
        linkedStack pila = new linkedStack();
        //primero valido que los parentesis que contiene la expresión estén correctos
        if (checkParenthesis(expression) == true) {//si los parentesis están bien, ahora valido lo demás

            for (int i = 0; i < expression.length() - 1; i++) {
                //si es una letra o un numero
                if (util.Utility.isLetter(expression.charAt(i)) || util.Utility.isNumber(expression.charAt(i))
                        && (expression.charAt(i) != '(') && expression.charAt(i) != '(') {

                    
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


    
    

    private String infixNotation(String expresion) throws StackException {
        expresion = expresion.replaceAll("\\s", "");
        linkedStack infixPila = new linkedStack();
        
        String exp = "";
        
        for (int i = 0; i < expresion.length(); i++) {
            
            if (util.Utility.isLetter(expresion.charAt(i)) 
                    || (util.Utility.isNumber(expresion.charAt(i)) && (expresion.charAt(i) != '(')) 
                    && (expresion.charAt(i) != '(')) {//Si es una letra o un número
                
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

    //falta el metodo que retorne el resultado
    private double resultInfixNotation(String s) throws StackException{
      linkedStack infixPila = new linkedStack();
      int result=0;
      String aux="";  
        for (int i = 0; i < s.length(); i++) {
            if (util.Utility.isLetter(s.charAt(i))) {//si es letra,, result es cero
                return result;
            }
        }
        
        String[] parts=aux.split("*");
        
                //orden de parentesis.
                //orden de signos
        
        return result;
    }
}
/* infixPila.push("" + expresion.charAt(i));
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
        exp = (String) infixPila.top();*/