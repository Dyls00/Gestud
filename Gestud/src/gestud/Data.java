package gestud;

import java.sql.*;

public class Data {

    public Connection connectBDD(){

        Connection co = null;
        System.out.println("Connexion à la base de données...");
        String dbname = "gestud";
        String url = "jdbc:postgresql://localhost:5432/";
        String username = "postgres";
        String password = "root";

        try {
            co = DriverManager.getConnection(url+dbname, username, password) ;
            System.out.println("Etat de la connexion :");
            System.out.println(co.isClosed() ?"fermée":"ouverte") ;
        } catch(SQLException e){
            System.out.println(" Une erreur est survenue lors de la connexion à la base de données");
            e.printStackTrace();
        }
        return co;
    }

    public void insert_matiere(Connection co, String table_name,int id_matiere, String libelle, String identifiant, float htheorique, float hpratique, float heval, int credits){
        PreparedStatement statement;
        try{
            String query = String.format("insert into %s(id_matiere, libelle, identifiant, htheorique, hpratique, heval, credits) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s');", table_name,id_matiere, libelle, identifiant, htheorique, hpratique, heval, credits);
            statement = co.prepareStatement(query);
            statement.executeUpdate();
            System.out.println("Matiere insérée");
        } catch ( Exception e){
            System.out.println(e);
        }
    }

    public void insert_user(Connection co, String table_name, int id_humain, String nom, String prenom, int age, String niveau, String fonction, int salaire, int id_role){
        PreparedStatement statement;
        try{
            String query = String.format("insert into %s(id_humain, nom, prenom, age, niveau, fonction, salaire, id_role) values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');", table_name,id_humain, nom, prenom, age, niveau, fonction, salaire, id_role);
            statement = co.prepareStatement(query);
            statement.executeUpdate();
            System.out.println("Utilisateur inséré");
        } catch ( Exception e){
            System.out.println(e);
        }
    }

    public void insert_note(Connection co, String table_name, int id_note, float value,String appreciation, int id_matiere){
        PreparedStatement statement;
        try{
            String query = String.format("insert into %s(id_note, value, appreciation, id_matiere) values ('%s', '%s', '%s', '%s');", table_name,id_note, value, appreciation, id_matiere);
            statement = co.prepareStatement(query);
            statement.executeUpdate();
            System.out.println("Note insérée");
        } catch ( Exception e){
            System.out.println(e);
        }
    }
}
