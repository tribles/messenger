package org.koushik.javabrains.messenger.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX ="Basic";
	
	public SecurityFilter(){
		super();
		System.out.println(".. inside ContainerRequestFilter constru...");
	}
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
	    System.out.println("... inside filter method ....");
		List<String> headerlist = requestContext.getHeaders().get(AUTHORIZATION_HEADER);
		
		if(headerlist != null && headerlist.size() >0){
			String authToken = headerlist.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodedString = Base64.decodeAsString(authToken);
			StringTokenizer tokenizer = new StringTokenizer(decodedString,":");
			
			String userName = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			
			
			if("user".equals(userName) && "password".equals(password))	
				return;
			
		}
		
		Response unauthorizedResponse = Response.status(Response.Status.UNAUTHORIZED)
				                        .entity("user is not allowed to acess this resource")
				                        .build();
		
		requestContext.abortWith(unauthorizedResponse);
	}

}
