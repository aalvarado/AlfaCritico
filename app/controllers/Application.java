package controllers;

import play.*;
import play.data.validation.Required;
import play.mvc.*;
import play.mvc.Scope.Flash;
import play.mvc.results.Error;

import java.util.*;

import org.hsqldb.Database;

import models.*;

public class Application extends Controller {
	
    @Before(unless="login")
    static void checkAuthentification() {
    	if(session.get("userId") != null){
    		Long userId = Long.parseLong(session.get("userId")); 
    		User user = User.find("byId",userId).first();
    		renderArgs.put("user", user);
    	}
        	
    }

    
    public static void logout(){
    	session.clear();
    	index();
    }

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
    
    public static void products(Integer start,String type) {
    	int max = 10;
    	if(start == null){
    		start = 0;
    	}
    	ProductType productType = ProductType.find("byName", type).first();
    	List<Products> products = Product.find("productType=? order by dateAdded desc",productType).from(start).fetch(max);
		render(products);
	}
    public static void review(Long id){
    	Review review = Review.findById(id);
    	Product product = review.product;
    	List<Review> reviews = Review.find("byProduct", product).fetch(10);
    	reviews.remove(review);
    	render(review,reviews,product);
    }
    public static void login(){
    	if(session.get("userId") != null){
    		index();
    	}else{
    		render();
    	}
    	
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
    public static void addReview(){
    	
    	render();
    }
    public static void profile(){
    	
    	render();
    }
    public static void verifyLogin(String email, String password){
    	validation.required(email).message("* email es requerido");
    	validation.required(password).message("* contraseña es requerida");
		if(validation.hasErrors()){
    		params.flash();
    		validation.keep();
    		login();
    	}else{
    		User user = User.connect(email, password);
    		if(user != null){
    			//notFoundIfNull(user);
    			session.put("userId", user.id);
    			profile();
    		}else{
    			validation.addError("email", "correo o contraseña invalida");
    			params.flash();
        		validation.keep();
    			login();
    		}
    	}
    }
    public static void addUser(String email, String name, String password, String confirm_password ){
    	validation.email(email).message("* email invalido");
    	validation.required(email).message("* Requerido");
    	validation.required(name).message("* Requerido");
    	validation.required(password).message("* Requerido");
    	validation.required(confirm_password).message("* Requerido");
    	validation.equals(password, confirm_password).message("* Las contraseñas no coinciden");
    	
    	if(validation.hasErrors()){
    		
    		params.flash();
    		validation.keep();
    		register();
    	}else{
    		try {
    			User user = new User(email,name,password);
        		user.save();
        		flash.success("Su usuario se ha guardado exitosamente");
        		register();
			} catch (Exception e) {
				validation.addError("name", "el usuario o el correo ya existe");
				params.flash();
				validation.keep();
				register();
			}
    	}
    	
    }
}