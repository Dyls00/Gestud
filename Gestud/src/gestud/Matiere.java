package gestud;

import java.util.ArrayList;

public class Matiere{
    
    private String libelle = null;
    private String identifiant= null;
    private float Htheorique= 0;
    private float Hpratique= 0;
    private float Heval= 0;
    private int credit= 0;
    private float value;
    private int moyenne;
    private double double_m;

    private ArrayList<Note> mes_notes;

    // getter/setter
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    
    public float getHtheorique() {
        return Htheorique;
    }       

    public void setHtheorique(int Htheorique) {
        this.Htheorique = Htheorique;
    }

    public float getHpratique() {
        return Hpratique;
    }

    public void setHpratique(float Hpratique) {
        this.Hpratique = Hpratique;
    }

    public float getHeval() {
        return Heval;
    }

    public void setHeval(float Heval) {
        this.Heval = Heval;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public ArrayList<Note> getMes_notes() {
        return mes_notes;
    }

    public void setMes_note(ArrayList<Note> mes_notes) {
        this.mes_notes = mes_notes;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(int moyenne) {
        this.moyenne = moyenne;
    }

    // constructeur
    public Matiere(String libelle, String identifiant, float Htheorique, float Hpratique, float Heval, int credit) {
        this.libelle = libelle;
        this.identifiant = identifiant;
        this.Htheorique = Htheorique;
        this.Hpratique = Hpratique;
        this.Heval = Heval;
        this.credit = credit;

        this.mes_notes = new ArrayList<Note>();
        this.newListeNote();

    }
    // Fonction pour afficher les matiere
    public void afficherMatiere(int count) {
        System.out.println("*****************************");
        System.out.println("** Matiere " + count + " : " + this.identifiant + " - " + this.libelle);
        System.out.println("Nb heure théorique : " + this.Htheorique + "h");
        System.out.println("Nb heure pratique : " + this.Hpratique + "h");
        System.out.println("Nb heure évaluation : " + this.Heval + "h");
        System.out.println("Crédit : " + this.credit + " " + " crédits ECTS");


        // Afficher les notes selon la matiere
        int new_count = 1;

        for(Note une_note: this.mes_notes) {
            une_note.afficherNote(new_count);
            new_count++;
        }
        // Afficher la moyenne de la matiere
        this.afficherMoyenneMatiere();
    }

    // Fonction pour inserer les notes selon l'identifiant de la matiere
    public void newListeNote(){
        switch(this.identifiant) {
            case "1OOPIOU":
                this.mes_notes.add(new Note(15));
                this.mes_notes.add(new Note(16));
                break;
            case "1MATHS":
                this.mes_notes.add(new Note(10));
                this.mes_notes.add(new Note(18));
                break;
            case "1WINPIOU":
                this.mes_notes.add(new Note(14));
                this.mes_notes.add(new Note(16));
                break;
            case "2MATHS":
                this.mes_notes.add(new Note(19));
                this.mes_notes.add(new Note(20));
                break;
            case "2OOPADV":
                this.mes_notes.add(new Note(15));
                this.mes_notes.add(new Note(16.5));
                break;
            case "2WINSRV":
                this.mes_notes.add(new Note(14));
                this.mes_notes.add(new Note(16));
                break;
            case "3MATHS":
                this.mes_notes.add(new Note(19));
                this.mes_notes.add(new Note(20));
                break;
            case "3OOPADV":
                this.mes_notes.add(new Note(15));
                this.mes_notes.add(new Note(16));
                break;
            case "3WINSRV":
                this.mes_notes.add(new Note(14));
                this.mes_notes.add(new Note(16));
                break;
            case "4MATHS":
                this.mes_notes.add(new Note(19));
                this.mes_notes.add(new Note(0));
                break;
            case "4OOPADV":
                this.mes_notes.add(new Note(15));
                this.mes_notes.add(new Note(16));
                break;
            case "4WINSRV":
                this.mes_notes.add(new Note(14.5));
                this.mes_notes.add(new Note(16));
                break;
            case "5MATHS":
                this.mes_notes.add(new Note(19));
                this.mes_notes.add(new Note(20));
                break;
            case "5OOPADV":
                this.mes_notes.add(new Note(15));
                this.mes_notes.add(new Note(16));
                break;
            case "5WINSRV":
                this.mes_notes.add(new Note(14));
                this.mes_notes.add(new Note(16));
                break;
        }
    }

    // Fonction pour ajouter une note
    public void addNote(float value) {
        this.value = value;
        this.mes_notes.add(new Note (value));
    }

    // Fonction pour calculer une moyenne par matiere
    public int moyenneMatiere() {
        float somme = 0;
        for (Note une_note : this.mes_notes) {
            somme += une_note.getNote();
        }
        double_m = somme / this.mes_notes.size();

        // convertir la moyenne en int
        moyenne = (int) Math.round(double_m);

        return moyenne;
    }

    // fonction pour supprimer une note
    public void deleteNote(int index) {
        if (index >= 0 && index < this.mes_notes.size()) {
            this.mes_notes.remove(index);
        } else {
            System.out.println("Index de note invalide.");
        }
    }

    // fonction pour modifier une note
    public void editNote(int index, int new_note) {
        if (index >= 0 && index < this.mes_notes.size()) {
            this.mes_notes.remove(index);
            addNote(new_note);
        } else {
            System.out.println("Index de note invalide.");
        }
    }

    // Fonction pour afficher la moyenne par matiere et les appreciations
    public void afficherMoyenneMatiere() {
        moyenne = moyenneMatiere();
        if (moyenne < 10) {
            System.out.println("Moyenne de la matière : " + moyenne + " - " + "Insuffisant");
        } else if (moyenne < 12) {
            System.out.println("Moyenne de la matière : " + moyenne + " - " + "Bien");
        } else if (moyenne < 15) {
            System.out.println("Moyenne de la matière : " + moyenne + " - " + "Assez bien");
        } else if (moyenne < 18) {
            System.out.println("Moyenne de la matière : " + moyenne + " - " + "Très bien");
        } else if (moyenne >= 18 && moyenne <= 20) {
            System.out.println("Moyenne de la matière : " + moyenne + " - " + "Excellent");
        } else {
            System.out.println("Moyenne de la matière : " + moyenne);
        }
    }
}
