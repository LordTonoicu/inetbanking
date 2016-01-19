package inetbanking.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	private static Logger log = LoggerFactory.getLogger(GenericExceptionMapper.class);
	@Override
	public Response toResponse(Throwable ex) {
		log.error(ex.getMessage(),ex);
		return Response.status(500)
				.entity(ex.getMessage())
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
