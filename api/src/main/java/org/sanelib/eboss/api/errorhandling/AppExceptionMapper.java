package org.sanelib.eboss.api.errorhandling;

import org.sanelib.eboss.core.exceptions.AppException;
import org.sanelib.eboss.core.exceptions.ResponseError;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class AppExceptionMapper implements ExceptionMapper<AppException> {

	public Response toResponse(AppException ex) {

        ResponseError responseError = new ResponseError();

        responseError.addError("application.exception", "form", ex.getMessage());

        return Response.status(ex.getStatus())
				.entity(responseError)
				.type(MediaType.APPLICATION_JSON).
				build();
	}

}
