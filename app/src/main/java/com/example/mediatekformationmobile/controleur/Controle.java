package com.example.mediatekformationmobile.controleur;

import android.util.Log;
import com.example.mediatekformationmobile.modele.AccesDistant;
import com.example.mediatekformationmobile.modele.Formation;

import java.util.ArrayList;

public class Controle {

    private static Controle instance = null ;
    private ArrayList<Formation> lesFormations = new ArrayList<>();
    private ArrayList<Formation> lesFormationsCopie = new ArrayList<>(); // Nouvelle variable ajoutée
    private Formation formation = null;
    private static AccesDistant accesDistant;

    /**
     * constructeur privé
     */
    private Controle(){
        super();
    }

    /**
     * récupération de l'instance unique de Controle
     * @return instance
     */
    public static final Controle getInstance(){
        if(Controle.instance == null){
            Controle.instance = new Controle();
            accesDistant = AccesDistant.getInstance();
            accesDistant.envoi("tous", null);
        }
        return Controle.instance;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public ArrayList<Formation> getLesFormations() {
        return lesFormations;
    }

    public void setLesFormations(ArrayList<Formation> lesFormations) {
        this.lesFormations = lesFormations;
    }

    public ArrayList<Formation> getLesFormationsCopie() { // Méthode pour obtenir lesFormationsCopie
        return lesFormationsCopie;
    }

    public void setLesFormationsCopie(ArrayList<Formation> lesFormationsCopie) { // Méthode pour définir lesFormationsCopie
        this.lesFormationsCopie = lesFormationsCopie;
    }

    /**
     * retourne les formations dont le titre contient le filtre
     * @param filtre
     * @return
     */
    public ArrayList<Formation> getLesFormationFiltre(String filtre){
        ArrayList<Formation> lesFormationsFiltre = new ArrayList<>();
        for(Formation uneFormation : lesFormations){
            if(uneFormation.getTitle().toUpperCase().contains(filtre.toUpperCase())){
                lesFormationsFiltre.add(uneFormation);
            }
        }
        return lesFormationsFiltre;
    }
}

