package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class User extends Model {
	
	@Column(unique=true)
	public String email;
	@Column(unique=true)
	public String name;
	public String hash;
	public Boolean isAdmin;
	
	@OneToMany
	public List<Rating> ratings;
	
	public User(String name){
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public User(String email,String name, String hash){
		this.email = email;
		this.name = name;
		this.hash = hash;
	}

	public static User connect(String email, String hash) {
		// TODO Auto-generated method stub
		return find("byEmailAndHash", email, hash).first();
	}
	
}
