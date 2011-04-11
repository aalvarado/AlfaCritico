package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import org.hsqldb.Database;

import models.*;

public class Application extends Controller {

    public static void index() {
        //String name = "world";
    	
    	ProductType ptMovie = ProductType.find("byName", "movie").first();
    	ProductType ptBook = ProductType.find("byName", "book").first();
    	
    	List<Product> books =  Product.find("productType=? order by dateAdded desc", ptBook).fetch(3);
    	List<Product> movies =  Product.find("productType=? order by dateAdded desc", ptMovie).fetch(3);
    	
    	List<Review> latest_reviews = Review.find("order by reviewDateCreated desc").fetch(10);
    	
    	render(books, movies,latest_reviews);
    }
     
    public static void product(Long id){
    	if(id != null){
    		Product product = Product.findById(id);
    		if(product != null){
    			List<Review> reviews = Review.find("byProduct",product).fetch(10);
    			if(reviews.size() > 0){
    				render(product,reviews);
    			}else{
    				render(product);
    			}
    			
    		}else{
    			render();
    		}
    	}
    	else{
    		render();
    	}
    	
    }
    
    public static void products() {
    	
		render();
	}
    public static void login(){
    	render();
    }
    public static void register(){
    	render();
    }
    public static void results(){
    	render();
    }
    public static void addProduct(){
    	render();
    }
}