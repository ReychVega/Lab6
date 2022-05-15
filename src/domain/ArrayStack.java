/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class ArrayStack implements Stack
{
    private int n; //el tam max de la pila
    private int top; //para llevar el control del tope de la pila, apunta al ultimo campo del arreglo
    private Object stack[];

    //Constructor
    public ArrayStack(int n){
        if(n<=0) System.exit(1); //se sale
        this.n = n;
        this.top = -1; //indica q la pila esta vacia
        this.stack = new Object[n];//inicializa un arreglo de clase
    }
    
    @Override
    public int size() {//preguntar
        return top+1;
    }

    @Override
    public void clear() {
        this.top = -1;
        this.stack = new Object[n];
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    @Override
    public Object peek() throws StackException {//tope de la pila
        if(isEmpty())
            throw new StackException("Array Stack is empty");
        return this.stack[top];
    }

    @Override
    public Object top() throws StackException {//el top 
        if(isEmpty())
            throw new StackException("Array Stack is empty");
        return this.stack[top];
    }

    @Override
    public void push(Object element) throws StackException {//agrega un elemento
        //if(top==n-1)
        if(top==stack.length-1)
            throw new StackException("Array Stack is full");
        stack[++top] = element;
    }

    @Override
    public Object pop() throws StackException {//elimina el último
        if(isEmpty())
            throw new StackException("Array Stack is empty");
        return stack[top--];
    }

    @Override
    public String toString() {
        String result = "Array Stack content: \n";
        try {
            ArrayStack auxStack = new ArrayStack(size());
            while(!isEmpty()){
                    result+=peek()+"\n";
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
