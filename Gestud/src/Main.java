import gestud.Data;
import gestud.Etudiant;
import gestud.Formateur;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Etudiant> mes_etudiants = new ArrayList<Etudiant>();
    private static ArrayList<Formateur> mes_formateurs = new ArrayList<Formateur>();
    private static Data data = new Data();


    public static void main(String[] args) {

        // Se connecter a la base de donnees
        Connection co = data.connectBDD();
        data.insert_user(co,"gestud.humain",1, "johane", "dyls", 26, "E2", null,0,2);
        //data.insert_matiere(co, "gestud.matiere", 1, "Java", "POOJAVA", 10, 15,12,6);
        //data.insert_note(co, "gestud.note", 1, 15, "Assez bien", 1);

        // Creer un etudiant
        Etudiant etudiant1 = new Etudiant("Dyls", "Johane", 26, "E4");
        Etudiant etudiant2 = new Etudiant("jojo", "Johane", 26, "E2");

        // creer un formateur
        Formateur formateur1 = new Formateur("Quentin", "georges", 36, "Dev python", 15000);
        Formateur formateur2 = new Formateur("Gregoire", "patin", 30, "Campus manager", 25000);

        // Ajouter les étudiant dans une liste
        mes_etudiants.add(etudiant1);
        mes_etudiants.add(etudiant2);

        // Ajouter les formateur dans une liste
        mes_formateurs.add(formateur1);
        mes_formateurs.add(formateur2);

        // Methode pour supprimer, ajouter, modifier ( les matieres, les note, les etudiants)
        //mes_etudiants.get(0).getMes_matieres().get(0).deleteNote(0);
        //mes_etudiants.get(1).getMes_matieres().get(1).editNote(0,6);
        mes_etudiants.get(1).editMatiere(2,"Python","2PY",15,10,12,6);
        mes_etudiants.get(1).getMes_matieres().get(2).addNote(17);
        mes_etudiants.get(1).getMes_matieres().get(2).addNote(10);
        mes_etudiants.get(1).getMes_matieres().get(2).addNote(12);
        editEtudiant(0,"simon","pacot",23,"E4");
        mes_etudiants.get(0).deleteMatiere(1);
        //deleteEtudiant(0); 

        // Afficher le tableau des etudiants 
        for (Etudiant un_etudiant : mes_etudiants) {
            un_etudiant.afficherEtudiant();
        }

        // Afficher le tableau des formateurs
        for (Formateur un_formateur : mes_formateurs) {
            un_formateur.afficherFormateur();
        }
    }

    // fonction ajouter un etudiant
    public static void addEtudiant(String nom, String prenom, int age, String niveau) {
        mes_etudiants.add( new Etudiant(nom, prenom, age, niveau));
    }

    // fonction pour supprimer un etudiant
    public static void deleteEtudiant(int index) {
        if (index >= 0 && index < mes_etudiants.size()) {
            mes_etudiants.remove(index);
        } else {
            System.out.println("Index invalide. Echec de la suppression d'un etudiant.");
        }
    }

    // fonction pour modifier un etudiant
    public static void editEtudiant(int index, String nom, String prenom, int age, String niveau) {
        if (index >= 0 && index < mes_etudiants.size()) {
            mes_etudiants.remove(index);
            addEtudiant(nom, prenom, age, niveau);
        } else {
            System.out.println("Index invalide. Echec de la modification d'un etudiant.");
        }
    }

    // fonction ajouter un formateur
    public static void addFormateur(String nom, String prenom, int age, String fonction, int salaire) {
        mes_formateurs.add( new Formateur(nom, prenom, age, fonction, salaire));
    }

    // fonction pour supprimer un formateur
    public static void deleteFormateur(int index) {
        if (index >= 0 && index < mes_formateurs.size()) {
            mes_formateurs.remove(index);
        } else {
            System.out.println("Index invalide. Echec de la suppression d'un formateur.");
        }
    }

    // fonction pour modifier un formateur
    public static void editFormateur(int index, String nom, String prenom, int age, String fonction, int salaire) {
        if (index >= 0 && index < mes_formateurs.size()) {
            mes_formateurs.remove(index);
            addFormateur(nom, prenom, age, fonction, salaire);
        } else {
            System.out.println("Index invalide. Echec de la modification d'un formateur.");
        }
    }
}


