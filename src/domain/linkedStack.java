/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jos
 */
public class linkedStack implements Stack {

    private Node top; //apuntador al tope de la pila, apunta a primer nodo
    private int count;//cuenta los elementos apilados

    public linkedStack() {
        this.top = null;
        this.count = 0;
    }

    @Override
    public int size() {
        return count;

    }

    @Override
    public void clear() {
        this.top = null;

    }

    @Override
    public boolean isEmpty() {

        return top == null;
    }

    @Override
    public Object peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Linked Stack is empty");
        }
        return top.data;

    }

    @Override
    public Object top() throws StackException {
        if (isEmpty()) {
            throw new StackException("Linked Stack is empty");
        }
        return top.data;

    }

    @Override
    public void push(Object element) throws StackException {
        Node nuevoNodo = new Node(element);
        if (isEmpty()) {
            this.top = nuevoNodo;
        } else {
            nuevoNodo.next = top;//Enlace entre nodos
            top = nuevoNodo;//Le decimos a top que apunte a nuevoNodo
        }
        this.count++;//incremento el contador cada vez que agrego un elemento al primer nodo de la pila enlazada

    }

    @Override
    public Object pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Linked Stack is empty");
        }
        Object element = top.data;//Elememto del tope de la pila
        top = top.next;//Movemos top al siguiente elemento
        this.count--;//cuando desapilamos entonces disminuimos contador
        return element;

    }
    
        @Override
    public String toString() {
        String result = " Linked Stack content: \n";
        try {
            linkedStack auxStack = new linkedStack();
            while(!isEmpty()){
                    result+=peek()+" \n ";
                    auxStack.push(pop());
            }
            //ahora debemos dejar la pila como al inicio
            while(!auxStack.isEmpty()){
                push(auxStack.pop());
            }
        } catch (StackException ex) {
                Logger.getLogger(ArrayStack.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return result;
    }
    

}
