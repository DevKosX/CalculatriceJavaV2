/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.calculatrice.modele;

/**
 * cette classe va servir à définir le contrat correctement 
 * @author narz 
 */
public interface CalculatorInterface {
    
    Double addition(Integer a, Integer b);
    
    Double soustraction(Integer a, Integer b);
    
    Double division(Integer a, Integer b);
    
    Double multiplication(Integer a, Integer b);
    
}
