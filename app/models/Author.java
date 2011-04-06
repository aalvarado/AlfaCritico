package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Author extends Model {

	public String name;
	
	public Author(String name) {
		this.name = name;
	}
	
	
}

