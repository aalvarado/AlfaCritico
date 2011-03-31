package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import org.hsqldb.Database;

import models.*;

public class Application extends Controller {

    public static void index() {
        //String name = "world";
    	
    	List books =  Book.find("order by id desc").fetch(); 
    	
    	//data
    	
    	render(books);
    }
    
    public static void createBook(String title){
    	Book book = new Book(title).save();
    	renderJSON(book);
    	
    }
    
    public static void changeStatus(long id, boolean done){
    	Book book = Book.findById(id);
    	book.done = done;
    	book.save();
    	renderJSON(book);
    	
    }
}