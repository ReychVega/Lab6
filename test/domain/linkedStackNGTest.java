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
    
    
        
        @Test
    public void testSomeMethod3() {
        try {
            ArrayStack anim = new ArrayStack(10);
            linkedStack pil = new linkedStack();
            
            for (int i = 0; i < 10; i++) {
                
                pil.push(util.Utility.random(99999));
                
            }
            
            Animal a =new Animal("Pep","Perro",4);
            anim.push(a);
            Animal a1 =new Animal("Sizy","Gata",4);
            anim.push(a1);
            Animal a2 =new Animal("Ror","Hamster",2);
            anim.push(a2);
            Animal a3 =new Animal("Aly","Conejo",1);
            anim.push(a3);
            Animal a4 =new Animal("Ub","Perro",6);
            anim.push(a4);
            Animal a5 =new Animal("Son Goku","Tortuga",8);
            anim.push(a5);
            Animal a6 =new Animal("Silizor","Gato",9);
            anim.push(a6);
            Animal a7 =new Animal("Kira","Perro",6);
            anim.push(a7);
            Animal a8 =new Animal("Umtii","Pez",1);
            anim.push(a8);
            Animal a9 =new Animal("Alizon","Loro",3);
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
                System.out.println(pil.pop()+"\n"); 
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
