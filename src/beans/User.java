package beans;

public class User {
private int id;
private String prenom, nom , login, password;
public User() {
	
}
public User(int id,String prenom,String nom,String login,String password) {
	this.id = id;
	this.prenom = prenom;
	this.nom = nom;
	this.login = login;
	this.password = password;
	
}
public User(String prenom,String nom,String login,String password) {
	this.prenom = prenom;
	this.nom = nom;
	this.login = login;
	this.password = password;
	
}
public int getId() {
	return this.id;
}
public String getPrenom() {
	return this.prenom;
}
public String getNom() {
	return this.nom;
}
public String getLogin() {
	return this.login;
}
public String getPassword() {
	return this.password;
}

public void setId(int id) {
	this.id = id;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public void setLogin(String login) {
	this.login = login;
}
public void setPassword(String password) {
	this.password = password;
}
}
