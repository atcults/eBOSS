package org.sanelib.eboss.api.errorhandling;

import org.sanelib.eboss.core.exceptions.ResponseError;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	public Response toResponse(NotFoundException ex) {

        ResponseError responseError = new ResponseError();
        responseError.addError("resource.not.found", "form", ex.getMessage());

		return Response.status(ex.getResponse().getStatus())
				.entity(responseError)
				.type(MediaType.APPLICATION_JSON) //this has to be set to get the generated JSON
				.build();
	}

}
