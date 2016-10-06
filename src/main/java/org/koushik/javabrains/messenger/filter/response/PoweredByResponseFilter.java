package org.koushik.javabrains.messenger.filter.response;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {
	
	public PoweredByResponseFilter(){
		super();
		System.out.println(".. inside PoweredByResponseFilter ..");
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("..inside response filter adding header");
		responseContext.getHeaders().add("X-Powered-By", "Tribles");
		
	}


}
