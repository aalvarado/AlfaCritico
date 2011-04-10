package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Review extends Model {

	public String title;
	
	@Lob
	public String content;
	public Date reviewDateCreated;
	public Date reviewDateModified;
	@ManyToOne
	public User user;
	
	@ManyToOne
	public Product product;
	
	@OneToMany
	public List<Rating> ratings;
	
	public Review(String title) {
		this.title = title;
	}
	
	public String toString() {
		return title;
	}
	public Review(User user, String title, String content, Product product){
		this.user =user;
		this.title = title;
		this.content = content;
		this.product = product;
		this.reviewDateCreated = new Date();
	}
	
}