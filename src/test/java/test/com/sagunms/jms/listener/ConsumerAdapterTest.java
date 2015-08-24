package test.com.sagunms.jms.listener;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sagunms.jms.adapter.ConsumerAdapter;

public class ConsumerAdapterTest {
	
	private String json = "{vendorName:\"Googletest\",firstName:\"Saguntest\",lastName:\"MStest\",address:\"123 Planet Earth test\",city:\"Pangeatest\",state:\"PangeaCitytest\",zip:\"2343\",email:\"email@test.com\",phoneNumber:\"83483934839\"}";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSendToMongo() throws UnknownHostException {
		ConsumerAdapter adapter = new ConsumerAdapter();
		adapter.sendToMongo(json);
		assertNotNull(json);
		// After running JUnit test, go to mongo shell, try the following queries:
			// use vendor
			// db.getCollections("contact").find()
			// db.contact.find().limit(100)
	}

}
