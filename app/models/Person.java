package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Person extends Model {

	public String name;
	
	@ManyToOne
	public Product product;
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(String name, Product product) {
		this.name = name;
	}
	
	public String toString(String name){
		return this.name;
	}
}

