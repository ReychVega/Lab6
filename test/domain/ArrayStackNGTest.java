/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.annotations.Test;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 * Grupo 4.
 */
public class ArrayStackNGTest {
    
    public ArrayStackNGTest() {
    }

    @Test
    public void test() {
        try {
            ArrayStack s = new ArrayStack(10);
            s.push(10); s.push(3); s.push(5);
            s.push(20); s.push(30); s.push(40);
            System.out.println(s.toString());
            System.out.println(s.pop());
             System.out.println(s.toString());
             System.out.println(s.size());
             
             
             ArrayStack stack=new ArrayStack(10);
             stack.push(new Animal("Nemo", "pez", 2));
             stack.push(new Animal("Dorado", "pez", 1));
             stack.push(new Animal("Rufo", "perro", 1));
             stack.push(new Animal("Pintado", "gato", 4));
             stack.push(new Animal("Miau", "gato", 3));
             stack.push(new Animal("Bolita", "perro", 2));
             stack.push(new Animal("Sky", "perro", 1));
             stack.push(new Animal("Celeste", "ave", 3));
            stack.push(new Animal("Pricesa", "gato", 1));
            stack.push(new Animal("Chester", "perro", 2));

            System.out.println("ArrayStack, animal content:" + "\n");
            System.out.println(stack.toString());
            System.out.println("----------------------------------------------------------------");

          //  System.out.println("Last " + stack.peek());

            System.out.println("Desapila la especie de perro con un año de edad." + "\n");
            System.out.println(desapilarObjetos(stack, new Animal("", "perro", 1)));//especie=perro, edad=1

            System.out.println("----------------------------------------------------------------");
            System.out.println("Desapila la especie de gatos con tres años de edad." + "\n");
            System.out.println(desapilarObjetos(stack, new Animal("", "gato", 3)));//especie=perro, edad=1
            
//especie=gato, edad=3*
//                 
        } catch (StackException ex) {
            Logger.getLogger(ArrayStackNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String desapilarObjetos(ArrayStack list, Object element) throws StackException {
        ArrayStack auxStack = new ArrayStack(list.size());

        while (!list.isEmpty()) {
            //  list.peek();
            auxStack.push(list.pop());//agrega todos los elementos a lista auxiliar y vacía la otra
        }

        //  System.out.println(list.size());
        while (!auxStack.isEmpty()) {
            if (!util.Utility.containsObject(auxStack.peek(), element)) {//
                list.push(auxStack.pop());//agrega a la lista principal solo los elementos diferentes a element y con pop lo elimina de la otra lista
            } else {
                auxStack.pop();//si son elemento iguales, necesitamos eliminarlos para seguir añadiendo los demás
            }

        }
        // System.out.println(auxStack.size());
        return list.toString();
    }
    
}
