package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.User;
import database.Connexion;

public class UserDao {
	public static int lastId = 0;
	static Connexion connexion = new Connexion();
	private static ArrayList<User> users =  new ArrayList<User>();
	
	static {
		lister();
	}
	public static void ajouter(User user) {
		try {
			String sql = "INSERT INTO users (prenom, nom, login, password) VALUES (?, ?, ?, ?) ";
		    PreparedStatement ps = connexion.getConn().prepareStatement(sql);
		    ps.setString(1,user.getPrenom());
		    ps.setString(2,user.getNom());
		    ps.setString(3,user.getLogin());
		    ps.setString(4,user.getPassword());
		    int rowsInserted = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<User> lister(){
		ArrayList<User> utilisateurs=new ArrayList<User>();
			try {	
			    String sql = "SELECT * FROM users";
			    Statement statement = Connexion.getConn().createStatement();
			    ResultSet result = statement.executeQuery(sql);
			    while (result.next()){
			        int id = result.getInt("id");
			        String prenom = result.getString("prenom");
			        String nom = result.getString("nom");
			        String login = result.getString("login");
			        String passwd = result.getString("password");
			        utilisateurs.add(new User(id,prenom,nom,login,passwd));
			    }
			    	
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			users = utilisateurs;
			return users;
			
	}
	
	public static boolean supprimer(int id) {
		boolean response = false;
		try {
			String sql = "delete from users where id=?";
			PreparedStatement ps=connexion.getConn().prepareStatement(sql);
			ps.setInt(1, id);
			int rowsInserted = ps.executeUpdate();
			
			if (rowsInserted >0){
				response= true;
				}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		 return response;
	}
	
    
	public static void modifier(int id,String prenom,String nom,String login,String password){
		
		try {
			String sql = "update users set prenom=?,nom=?,login=?,password=? where id=?";
			PreparedStatement ps=connexion.getConn().prepareStatement(sql);
			ps.setString(1,prenom);
			ps.setString(2,nom);
			ps.setString(3,login);
			ps.setString(4,password);
			ps.setInt(5,id);
			int rowsInserted = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static User get(int id){
		for(User user:users) {
			 if(user.getId() == id) {
				 return user;
			 }
		 }
		return null;
	}
	public static User getLogin(String login){
		for(User user:users) {
			 if(user.getLogin().equals(login)) {
				 return user;
			 }
		 }
		return null;
	}
	
	public static boolean aut(String login,String password) {
		for(User user:users) {
			 if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
				 return true;
			 }
		 }
		return false;
	}
}

