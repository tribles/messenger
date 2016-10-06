package org.koushik.javabrains.messenger.filters.server;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;

@PreMatching
public class PreMatchingFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("before matching..");
		 if (requestContext.getMethod().equals("PUT")) {
	            requestContext.setMethod("POST");
	        }
	}

}
