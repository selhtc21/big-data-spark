package fr.htc.todo;

public class User {
	
	private int id;
	private String login;
	private String pwd;
	
	
	
	public User(int id, String login, String pwd) {
		super();
		this.id = id;
		this.login = login;
		this.pwd = pwd;
	}
	
	
	public int getId() {
		System.out.println("done");
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		System.out.println("done");
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		System.out.println("done");
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", pwd=" + pwd + "]";
	}


	public void printObject() {
		System.out.println(toString());
	}
	
	public void printObject2() {
		System.out.println("Pour vider mon compte voici les coordonnées : login" + this.login + ", pwd "+ this.pwd );
	}
	
	
	

}
