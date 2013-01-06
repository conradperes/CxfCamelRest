package br.com.devmedia.helloworldservice;

import junit.framework.Assert;

import org.apache.camel.CamelContext;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldServiceTest {

	@Autowired
	CamelContext context;
	
	@DirtiesContext
	@Test
	public void requestResponseTest() throws Exception {
		WebClient client = WebClient.create("http://localhost:8090/hello/helloworldservice");
		client.accept("application/json").type("application/json").path("/hello").query("nome", "John");
		String result = client.get(String.class);
		Assert.assertEquals("Hello John", result);
	}

	@DirtiesContext
	@Test
	public void requestResponseErrorTest() throws Exception {
		WebClient client = WebClient.create("http://localhost:8090/hello/helloworldservice");
		client.accept("application/json").type("application/json").path("/hello");
		javax.ws.rs.core.Response r = client.get();
		Assert.assertEquals(404, r.getStatus());
	}

}
