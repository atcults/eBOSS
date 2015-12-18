package org.sanelib.eboss.api.errorhandling;

import org.sanelib.eboss.core.exceptions.ResponseError;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
 

	
	public Response toResponse(Throwable ex) {

        ResponseError responseError = new ResponseError();
        responseError.addError("resource.not.found", "form", ex.getMessage());

		return Response.status(500)
				.entity(responseError)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}

