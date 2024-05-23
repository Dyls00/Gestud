package gestud;

public class Note {

    private double value;
    private float moyenne;
    private String[] appreciation = {"Insuffisant", "Bien", "Assez bien", "Très bien", "Excellent"};


    // getter et setter

    public double getNote(){

        return value;
    }

    public void setNote(float value) {

        this.value = value;
    }

    public float getMoyenne() {

        return moyenne;
    }

    public void setMoyenne(float moyenne) {

        this.moyenne = moyenne;
    }

    public String[] getAppreciation() {

        return appreciation;
    }

    public void setAppreciation(String[] appreciation) {

        this.appreciation = appreciation;
    }


    // constructeur
    public Note(double value) {

        this.value = value;

    }
    // methode surcharge
    public Note() {

    }

    // fonction pour afficher les notes et les appreciations
    public void afficherNote(int new_count){
        if (this.value < 10) {
            System.out.println("Note " + new_count + " : " + this.value + " - " + this.appreciation[0]);
        } else if (this.value < 12) {
            System.out.println("Note " + new_count + " : " + this.value + " - " + this.appreciation[1]);
        } else if (this.value < 15) {
            System.out.println("Note " + new_count + " : " + this.value + " - " + this.appreciation[2]);
        } else if (this.value < 18) {
            System.out.println("Note " + new_count + " : " + this.value + " - " + this.appreciation[3]);
        }
        else if (this.value >= 18 && this.value <= 20) {
            System.out.println("Note " + new_count + " : " + this.value + " - " + this.appreciation[4]);
        } else {
        System.out.println("Note " + new_count + " : " + this.value);
        }
    }
}
