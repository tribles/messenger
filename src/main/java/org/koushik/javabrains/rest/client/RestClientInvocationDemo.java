package org.koushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class RestClientInvocationDemo {
	static final String BASE_URL ="http://localhost:8080/messenger/webapi";
	public static void main(String[] args) {
		Invocation invocation = prepareRequest(2015);
		Response response = invocation.invoke();
		System.out.println(response.getStatus());
	}
	
	
	private static Invocation prepareRequest(int year){
		Client client = ClientBuilder.newClient();
		return client.target(BASE_URL)
				                 .path("messages")
				                 .queryParam("year", year)
				                 .request(MediaType.APPLICATION_JSON)
				                 .buildGet();
				 
	}
}
