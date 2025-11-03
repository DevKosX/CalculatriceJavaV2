package fr.devavance.calculatrice.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// je remplace le chemin ici
import fr.devavance.calculatrice.modele.Calculator;
import fr.devavance.calculatrice.exceptions.OperatorException;
import fr.devavance.calculatrice.modele.CalculatorInterface;
import java.util.ArrayList;



/**
 *
 * @author B. LEMAIRE
 * Controller pour la calculatrice
 * <p>
 * Ce code utilise volontairement des anti-patterns, il n'a pas un
 * bon "good smell"
 * Ce code doit être refactorisé  pour respecter les
 * principes du "good smell code"
 */


@WebServlet(urlPatterns = {"/calculate/*"})
public class CalculatorController extends HttpServlet {

    private static ArrayList<String> permittedOperators = null;


    @Override
    public void init() throws ServletException {
        super.init();
        this.permittedOperators = new ArrayList<>();

        this.permittedOperators.add("add");
        this.permittedOperators.add("sub");
        this.permittedOperators.add("mul");
        this.permittedOperators.add("div");
    }

    //<editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

                //Déclaration des variables ici    
        
        double op1 = 0, op2 = 0; 
        double r = 0;
        String op = null;
        String messageErreur = null;
        CalculatorInterface modele;
        modele = new Calculator();
        
        try{
        
            op = request.getParameter("operation");
            String operande1 = request.getParameter("operande1");
            String operande2 = request.getParameter("operande2");

            if (op == null
                    || op.isEmpty()
                    || !this.permittedOperators.contains(op))

                throw new OperatorException();

           //on va traiter et gérer nos erreur
            try{
                // je transforme le texte en chiffres ici
                op1 = Integer.parseInt(operande1);
                op2 = Integer.parseInt(operande2);
            } catch(NumberFormatException e){
                throw new IllegalArgumentException("Les opérandes doivent être des nombres.");
            }
           
            r = executionDuCalcul(modele, op, (int)op1, (int)op2);
        } catch (OperatorException | IllegalArgumentException | ArithmeticException e) {
            // j'attrape les ereurs possible
            messageErreur = e.getMessage(); // je stocke le message d'erreur
            if (e instanceof ArithmeticException) {
                messageErreur = "Erreur : Division par zéro impossible.";
            }
        }    
        //nous allons modifier nos variables pour que dans la jsp ils pourront etre utilisé
            
        request.setAttribute("operande1", op1);
        request.setAttribute("operande2", op2);
        request.setAttribute("operation", op);
        request.setAttribute("resultat", r);
        request.setAttribute("messageErreur", messageErreur); 

        // on utilise requestdispatcher pour envoyer la jsp au lieu d'utiliser printwriter
        //je passe la main à la vue
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vue.jsp");
        dispatcher.forward(request, response);
    }
        
        private Double executionDuCalcul(CalculatorInterface modele, String op, int op1, int op2)
            throws OperatorException, ServletException {
        
            double r;
            if (op.equals("add"))
                r = modele.addition((int)op1, (int)op2);
            else if (op.equals("sub"))
                r = modele.soustraction((int)op1, (int)op2);
            else if (op.equals("div"))
                r = modele.division((int)op1, (int)op2);
            else if (op.equals("mul"))
                r = modele.multiplication((int)op1, (int)op2);
            else throw new OperatorException("Opération invalide !");
   
            return r; //retourne mon réuslta à doget
        }

} 