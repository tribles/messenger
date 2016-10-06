package org.koushik.javabrains.messenger.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class LogHeadersFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("response>>");
     System.out.println(responseContext.getHeaders());
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("request>>");
		 System.out.println(requestContext.getHeaders());

	}

}
