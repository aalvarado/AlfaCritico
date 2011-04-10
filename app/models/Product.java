package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Product extends Model {
	public String title;
	public String image_url;
	public Date dateAdded;
	
	@ManyToOne
	public ProductType productType;
	@ManyToOne
	public Author author;
	
	@OneToMany
	public List<Rating> ratings;
	
	public Product(String title) {
		this.title = title;
	}
	
	public String toString() {
		return title;
	}
	
	public Product(String title, String image_url,Author author){
		
	}
}