/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Jos
 */
public class Animal {
    
    private String name;
    private String specie;
    private int age;

    public Animal(String name, String specie, int age) {
        this.name = name;
        this.specie = specie;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSpecie() {
        return specie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return " Animal{ " + " name = " + name + " , specie = " + specie + ", age = " + age + '}';
    }
    
}
