package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Comment extends Model {

	@Lob
	public String content;

	
	@ManyToMany(cascade=CascadeType.PERSIST)
	public List<Comment> parentComment = new ArrayList<Comment>();
	
	public Comment(String content) {
		this.content = content;
		
	}
}