import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {
	
	@Before
    public void setup() {
        Fixtures.deleteAll();
    }

	@Test
	public void createAndRetrieveUser() {
	    // Create a new user and save it
	    new User("bob@gmail.com","bob", "secret").save();
	    
	    // Retrieve the user with e-mail address bob@gmail.com
	    User bob = User.find("byEmail", "bob@gmail.com").first();
	    
	    // Test 
	    assertNotNull(bob);
	    assertEquals("bob@gmail.com", bob.email);
	}
	
	@Test
	public void tryConnectAsUser() {
	    // Create a new user and save it
		new User("bob@gmail.com","bob","secret").save();
	    
	    // Test 
	    assertNotNull(User.connect("bob@gmail.com", "secret"));
	    assertNull(User.connect("bob@gmail.com", "badpassword"));
	    assertNull(User.connect("tom@gmail.com", "secret"));
	}
	
	@Test
	public void createReview(){
		User bob = new User("bob@gmail.com","bob", "password").save();
		Product p = new Product("some title","some url",new Person("test person"),new ProductType("product type")).save();
		
		new Review(bob,"test title","test content looooong content maybe some html? <aaa>",p).save();
		
		// test post created
		assertEquals(1,Product.count());
		
		List<Review> reviews = Review.find("byUser", bob).fetch();
		
		assertEquals(1,reviews.size());
		Review r = reviews.get(0);
		assertNotNull(r);
		assertEquals(bob,r.user);
		assertEquals("test title",r.title);
		assertNotNull(r.reviewDateCreated);
	}
}
