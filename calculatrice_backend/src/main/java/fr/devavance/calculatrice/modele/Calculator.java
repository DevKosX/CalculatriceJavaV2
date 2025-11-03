package fr.devavance.calculatrice.modele;

/**
 *
 * @author blemaire
 */
public class Calculator implements CalculatorInterface {
// rajout du implement du contrat pour respecter ce que la calculatrice doit avoir comme responsabilité    
    /**
     * Addition
     * @param s_operande_1 : première opérande
     * @param s_operande_2 : seconde opérande
     * @return somme des deux opérances
     */
    
    @Override
    public Double addition(Integer s_operande_1, Integer s_operande_2)  {
        
        return Double.valueOf(s_operande_1 + s_operande_2);
       
    }
	
    /**
     * Soustraction
     * @param s_operande_1 : première opérande
     * @param s_operande_2 : seconde opérande
     * @return somme des deux opérances
     */
    
    @Override
    public Double soustraction(Integer s_operande_1, Integer s_operande_2) {
            
        return Double.valueOf(s_operande_1 - s_operande_2);
       
    }
    
     /**
     * Division
     * @param s_operande_1 : première opérande
     * @param s_operande_2 : seconde opérande
     * @return somme des deux opérances
     * @throws ArithmeticException 
     */
    
    @Override
    public Double division(Integer s_operande_1, 
                                  Integer s_operande_2) {
        
        if (s_operande_2.intValue()==0) throw new ArithmeticException();
        
        return Double.valueOf(s_operande_1 / (float) s_operande_2);
       
    }
    
     /**
     * Multiplication
     * @param s_operande_1 : première opérande
     * @param s_operande_2 : seconde opérande
     * @return somme des deux opérances
     * @throws NumberFormatException 
     */
    
    @Override
    public Double multiplication(Integer s_operande_1, 
                                        Integer s_operande_2)  {
        return Double.valueOf(s_operande_1 * s_operande_2);
       
    }
        
    
}
