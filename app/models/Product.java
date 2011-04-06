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
	public Integer rating;
	
	@ManyToOne
	public ProductType productType;
	@ManyToOne
	public Author author;
	
	public Product(String title) {
		this.title = title;
	}
	
	public String toString() {
		return title;
	}
}