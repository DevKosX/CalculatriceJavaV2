package fr.devavance.calculatrice.controller;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// je remplace le chemin ici
import fr.devavance.calculatrice.modele.Calculator;

import fr.devavance.calculatrice.exceptions.OperatorException;

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


        String op = request.getParameter("operation");
        String operande1 = request.getParameter("operande1");
        String operande2 = request.getParameter("operande2");

        if (op == null
                || op.isEmpty()
                || !this.permittedOperators.contains(op))

            throw new OperatorException();


        int op1 = Integer.parseInt(operande1);
        int op2 = Integer.parseInt(operande2);


        double r;

        if (op.equals("add"))
            r = Calculator.addition(op1, op2);
        else if (op.equals("sub"))
            r = Calculator.soustraction(op1, op2);
        else if (op.equals("div"))
            r = Calculator.division(op1, op2);
        else if (op.equals("mul"))
            r = Calculator.multiplication(op1, op2);
        else throw new ServletException("Opération invalide !");


        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {


            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculator</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div>");
            out.println("<p class=\"operande\">Operande 1 : " + op1 + "</p>");
            out.println("<p class=\"operande\">Operande 2 : " + op2 + "</p>");
            out.println("<p class=\"operation\">Operateur : " + op + "</p>");
            out.println("<p class=\"resultat\">resultat : " + r + "</p>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();


        }

    }
}
     