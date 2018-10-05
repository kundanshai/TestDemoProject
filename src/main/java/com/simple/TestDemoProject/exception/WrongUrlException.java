package com.simple.TestDemoProject.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WrongUrlException implements ExceptionMapper<Throwable> {
	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage=new ErrorMessage(exception.getMessage(),404,"http://localhost:8080/alertId");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}
}
