package org.koushik.javabrains.messenger.model.converter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import org.koushik.javabrains.messenger.model.MyDate;

@Provider
public class MyDateParamConverterProvider implements ParamConverterProvider{

	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
		
		if(rawType.getName().equals(MyDate.class.getName())){
			return new ParamConverter<T>(){
               
				@Override
				public T fromString(String arg0) {
				     Calendar requestedDate = Calendar.getInstance();
				     if("tomorrow".equals(arg0))
				    	 requestedDate.add(Calendar.DATE, 1);
				     else if("tomorrow".equals(arg0))
				    	 requestedDate.add(Calendar.DATE, -1);
				     
				     MyDate mydate = new MyDate();
				     mydate.setDate(requestedDate.get(Calendar.DATE));   
				     mydate.setMonth(requestedDate.get(Calendar.MONTH));
				     mydate.setYear(requestedDate.get(Calendar.YEAR));
				     
					return rawType.cast(mydate);
				}

				@Override
				public String toString(T arg0) {
					return arg0 == null ? null : arg0.toString();
				}
			};
		}
		else
			return null;
	}
}