package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Book extends Model{

	public String title;
	public boolean done;
	
	public Book(String title){
		this.title = title;
	}
}
