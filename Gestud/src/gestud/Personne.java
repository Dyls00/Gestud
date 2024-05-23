package gestud;

public class Personne {
    protected String nom;
    protected String prenom;
    protected int age;


    public Personne(String nom, String prenom, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public void afficher() {
        System.out.println(this.nom + " - " + this.prenom + " - " + this.age + " ans ");
    }
}

