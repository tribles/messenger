package org.koushik.javabrains.messenger.resources;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.MyDate;

@Path("date")
public class DateResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{dateString}")
	public String getRequestedDate(@PathParam("dateString") MyDate mydate ){//String dateStr
		return "date:"+mydate.toString();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)  // custom message body writer that converts date object to text
	public Date returnDate(){
		return Calendar.getInstance().getTime();
	}
	
	@GET
	@Produces("text/shortDate") // Custom Media Type
	public Date returnShortDate(){
		return Calendar.getInstance().getTime();
	}
	

}
