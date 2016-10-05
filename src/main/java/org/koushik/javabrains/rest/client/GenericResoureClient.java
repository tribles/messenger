package org.koushik.javabrains.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Message;

public class GenericResoureClient {
	static final String BASE_URL ="http://localhost:8080/messenger/webapi";
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		 List<Message> list = client.target(BASE_URL)  .path("messages")
                .queryParam("year", 2016)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Message>>(){});
		 
		 System.out.println(list);
	
	}
	
	
	private static void prepareRequest(int year){
		

}
}



