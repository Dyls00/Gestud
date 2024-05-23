package gestud;

public class Formateur extends Personne{
    private String fonction;
    private int salaire;

    // getter/setter

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getFonction() {
        return fonction;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public int getSalaire() {
        return salaire;
    }

    public Formateur(String nom, String prenom, int age, String fonction, int salaire){

        super(nom, prenom, age);
        this.fonction = fonction;
        this.salaire = salaire;
    }

    public void afficherFormateur() {

        super.afficher();
        System.out.println("Fonction : " + this.fonction);
        System.out.println("Salaire : " + this.salaire + " " + "euros");
        System.out.println("*****************************\n");
    }
}
