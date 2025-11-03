/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.devavance.calculatrice.constants;

/**
 *
 * @author narz
 */
public final class VueConstants {
    // je mets un constructeur privécomme ça, personne ne peut faire "new VueConstants()"
    private VueConstants() {
    }

    //les clés seront rangés ici quand l'utilisateur voudront setter ils viendront cici 
    public static final String VUE_OPERANDE_UN = "operande1";
    public static final String VUE_OPERANDE_DEUX = "operande2";
    public static final String VUE_OPERATION_CHOISIE = "operation";
    public static final String VUE_RESULTAT_CALCUL = "resultat";
    public static final String VUE_MESSAGE_ERREUR = "messageErreur";
    
}