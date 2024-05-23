package gestud;

import java.util.ArrayList;

public class Etudiant extends Personne{

    private String niveau;
    private ArrayList<Matiere> mes_matieres;


    // getter/setter

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public ArrayList<Matiere> getMes_matieres() {
        return mes_matieres;
    }

    public void setMes_matieres(ArrayList<Matiere> mes_matieres) {
        this.mes_matieres = mes_matieres;
    }

    // constructeur
    public Etudiant(String nom, String prenom, int age, String niveau) {

        super(nom, prenom, age);
        this.niveau = niveau;
        this.mes_matieres = new ArrayList<Matiere>();
        this.newListMatiere();
    }

    // Fonction d'ajout de matiere selon les niveau
    private void newListMatiere() {
        switch(this.niveau) {
            case "E1" :
                this.mes_matieres.add(new Matiere("Java Pioupiou", "1OOPIOU", 20, 2, 18, 3));
                this.mes_matieres.add(new Matiere("Mathematiques Pioupiou", "1MATHS", 12, 4, 6, 1));
                this.mes_matieres.add(new Matiere("Windows Server Pioupiou", "1WINPIOU", 2, 30, 6, 3));
                break;
            case "E2" :
                this.mes_matieres.add(new Matiere("Java Programming", "2OOPADV", 6, 10, 6, 3));
                this.mes_matieres.add(new Matiere("Mathematiques", "2MATHS", 12, 4, 6, 1));
                this.mes_matieres.add(new Matiere("Windows Server Administration", "2WINSRV", 6, 18, 6, 3));
                break;
            case "E3" :
                this.mes_matieres.add(new Matiere("Java Programming", "3OOPADV", 6, 10, 6, 3));
                this.mes_matieres.add(new Matiere("Mathematiques", "3MATHS", 12, 4, 6, 1));
                this.mes_matieres.add(new Matiere("Windows Server Administration", "3WINSRV", 6, 18, 6, 3));
                break;
            case "E4" :
                this.mes_matieres.add(new Matiere("Java Programming", "4OOPADV", 6, 10, 6, 3));
                this.mes_matieres.add(new Matiere("Mathematiques", "4MATHS", 12, 4, 6, 1));
                this.mes_matieres.add(new Matiere("Windows Server Administration", "4WINSRV", 6, 18, 6, 3));
                break;
            case "E5" :
                this.mes_matieres.add(new Matiere("Java Programming", "5OOPADV", 6, 10, 6, 3));
                this.mes_matieres.add(new Matiere("Mathematiques", "5MATHS", 12, 4, 6, 1));
                this.mes_matieres.add(new Matiere("Windows Server Administration", "5WINSRV", 6, 18, 6, 3));
                break;
        }

    }

    // Fonction afficher un etudiant
    public void afficherEtudiant() {

        super.afficher();
        System.out.println("Niveau : " + this.niveau);

        int count = 1;

        for(Matiere une_matiere:this.mes_matieres) {
            une_matiere.afficherMatiere(count);
            count++;
        }

        // afficher la moyenne générale
        afficherMoyenneGenerale();
        System.out.println("*****************************\n");

    }

    // Fonction pour calculer la moyenne générale
    public int moyenneGenerale() {
        int moyenne = 0;
        int count = 0;

        for(Matiere une_matiere:this.mes_matieres) {
            moyenne += une_matiere.getMoyenne();
            count++;
        }

        moyenne = moyenne / count;

        return moyenne;
    }

    // fonction pour ajouter une matiere
    public void addMatiere(String libelle, String identifiant, float Htheorique, float Hpratique, float Heval, int credit) {
        this.mes_matieres.add(new Matiere(libelle, identifiant, Htheorique, Hpratique, Heval, credit));
    }

    // fonction pour supprimer une matiere
    public void deleteMatiere(int index) {
        if (index >= 0 && index < this.mes_matieres.size()) {
            this.mes_matieres.remove(index);
        } else {
            System.out.println("Index de matière invalide.");
        }
    }

    // fonction pour modifier une matiere
    public void editMatiere(int index, String libelle, String identifiant, float Htheorique, float Hpratique, float Heval, int credit) {
        if (index >= 0 && index < this.mes_matieres.size()) {
            this.mes_matieres.remove(index);
            addMatiere(libelle, identifiant, Htheorique, Hpratique, Heval, credit);
        } else {
            System.out.println("Index de note invalide.");
        }
    }

    // Fonction pour afficher la moyenne générale et les appreciations
    public void afficherMoyenneGenerale() {
        System.out.println("*****************************");
        if (moyenneGenerale() < 10) {
            System.out.println("Moyenne générale : " + moyenneGenerale() + " - " + "Insuffisant");
        } else if (moyenneGenerale() < 12 ) {
            System.out.println("Moyenne générale : " + moyenneGenerale() + " - " + "Moyen");
        } else if (moyenneGenerale() < 15) {
            System.out.println("Moyenne générale : " + moyenneGenerale() + " - " + "Assez bien");
        } else if (moyenneGenerale() < 18) {
            System.out.println("Moyenne générale : " + moyenneGenerale() + " - " + "Très bien");
        } else if (moyenneGenerale() >=18  && moyenneGenerale() <= 20) {
            System.out.println("Moyenne générale : " + moyenneGenerale() + " - " + "Excellent");
        }else {
            System.out.println("Moyenne générale : " + moyenneGenerale());
        }
    }
}
