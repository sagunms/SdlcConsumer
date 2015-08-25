package test.com.sagunms.jms.listener;

import static org.junit.Assert.assertNull;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sagunms.jms.listener.ConsumerListener;

public class ConsumerListenerTest {
	
	private TextMessage message;
	private ApplicationContext context;
	private ConsumerListener listener;
	private String json = "{vendorName:\"SpaceXtest\",firstName:\"Sagun\",lastName:\"MShrestha\",address:\"234 Andromeda Galaxy test\",city:\"Alpha Centauri\",state:\"Cthulu Dawn\",zip:\"4030\",email:\"intestellar@andromeda.spx\",phoneNumber:\"AE0F-FF1D-B3B9-CCBA\"}";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("/spring/application-config.xml");
		listener = (ConsumerListener) context.getBean("consumerListener");
	}

	@After
	public void tearDown() throws Exception {
		((ConfigurableApplicationContext) context).close();
	}
	
	@Test
	public void testOnMessage() throws JMSException {
		expect(message.getText()).andReturn(json);
		replay(message);
		listener.onMessage(message);
		verify(message);
	}

	/*
	@Test
	public void testOnMessage() {
		ConsumerListener listener = new ConsumerListener();
		listener.onMessage(message);
		assertNull(message);
	}
	*/

}
