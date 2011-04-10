package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import org.hsqldb.Database;

import models.*;

public class Application extends Controller {

    public static void index() {
        //String name = "world";
    	List books =  Product.find("order by id desc").fetch();
    	List movies =  Product.find("order by id desc").fetch();
    	render(books);
    }
    
    public static void createBook(String title){
    	Product book = new Product(title).save();
    	renderJSON(book);
    }
    
    public static void changeStatus(long id, boolean done){
    	Product book = Product.findById(id);
    	book.save();
    	renderJSON(book);
    	
    }
}