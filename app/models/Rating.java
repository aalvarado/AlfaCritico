package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class Rating extends Model {

	public int rate;

	public Rating(int rate) {
		this.rate = rate;
	}
}