package br.com.devmedia.helloworldservice.camel;

import javax.servlet.ServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;

/**
 * Simple routebuilder implementation for HelloWorldService
 * 
 * @author leogsilva at gmail dot com
 * 
 */
public class HelloWorldServiceRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("cxfrs:bean:server")
		.process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
		        Message inMessage = exchange.getIn();                        
		        String operationName = inMessage.getHeader(CxfConstants.OPERATION_NAME, String.class);
		        MessageContentsList list = exchange.getIn().getBody(org.apache.cxf.message.MessageContentsList.class);
		        org.apache.cxf.message.Message cxfMessage = inMessage.getHeader(CxfConstants.CAMEL_CXF_MESSAGE, org.apache.cxf.message.Message.class);
		        ServletRequest request = (ServletRequest) cxfMessage.get("HTTP.REQUEST");
		        String path = inMessage.getHeader(Exchange.HTTP_PATH, String.class);
		        if ("hello".equals(operationName)) {
		        	String nome = request.getParameter("nome");
		        	if (nome == null) {
                        Response r = Response.status(404).entity("Nome nao pode ser nulo " + path).build();
                        throw new WebApplicationException(r);
		        	} else {
			        	exchange.getOut().setBody("Hello " + nome);
		        	}
		        }
			}
			
	});
	}
}
