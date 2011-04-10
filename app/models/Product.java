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
	
	@Lob 
	public String shortDescription;
	
	@ManyToOne
	public ProductType productType;
	
	@ManyToOne
	public Person person;
	
	@OneToMany
	public List<Rating> ratings;
	
	
	public String toString() {
		return title;
	}
	
	public Product(String title,String shortDescription, String image_url,Person person,ProductType product_type){
		this.title = title;
		this.image_url = image_url;
		this.person = person;
		this.productType = product_type;
	}
}