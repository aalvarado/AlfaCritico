package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Review extends Model {

	public String title;
	public String content;
	public Date postDate; 
	
	@ManyToOne
	public User user;
	
	@ManyToOne
	public Product product;
	
	
	
	public Review(String title) {
		this.title = title;
	}
	
	public String toString() {
		return title;
	}
}