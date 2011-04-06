package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class ProductType extends Model {

	public String name;

	public ProductType(String name) {
		this.name = name;
	}
}