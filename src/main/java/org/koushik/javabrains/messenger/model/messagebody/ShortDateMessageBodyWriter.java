package org.koushik.javabrains.messenger.model.messagebody;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces("text/shortDate")
public class ShortDateMessageBodyWriter<Date> implements MessageBodyWriter<Date> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return java.util.Date.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(Date t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public void writeTo(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String,Object> httpHeaders, 
			OutputStream entityStream) throws IOException{
		
		String shortDate = "My short Date is:"+date;
		entityStream.write(shortDate.toString().getBytes());
	}

}
