package org.koushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.koushik.javabrains.messenger.model.Message;

public class RestApiClient {
	static final String BASE_URL ="http://localhost:8080/messenger/webapi";
	public static void main(String[] args) {
		
		
		
        Client client = ClientBuilder.newClient();
        WebTarget baseTarget = client.target(BASE_URL);
        WebTarget messagesTarget =  baseTarget.path("messages");
        WebTarget singleMessagesTarget =  messagesTarget.path("{messageId}");
        
       /*// Buildeing requests
        Builder requestBuilder = target.request(); 
        
        Response response = requestBuilder.get();
        Message message = response.readEntity(Message.class);
        System.out.println(message.getMessage());
        
        Message message =singleMessagesTarget.resolveTemplate("messageId", "2").request().get(Message.class);
     
        System.out.println(message.getMessage());*/
        
        
        Message newMessage = new Message(10,"Good Luck","tribles");
        Response response = messagesTarget.request().post(Entity.json(newMessage));
        System.out.println(response);
	}

}
