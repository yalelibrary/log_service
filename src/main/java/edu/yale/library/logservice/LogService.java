package edu.yale.library.logservice;

import org.slf4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

import java.util.Date;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author Osman Din
 */
@Path("/log")
public class LogService {

    private final Logger logger = getLogger(this.getClass());

    private final LoggingEventDAO dao = new LoggingEventDAO();

    @GET
    @Path("/{param}")
    public Response transform(@PathParam("param") String msg) {
        logger.debug("GET request for:{}", msg);
        final String result = "Looked up value for=" + msg;
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/{param}")
    @Consumes("application/x-www-form-urlencoded")
    public Response store(@FormParam("param") String msg) {
        logger.debug("POST request for:{}", msg);

        final LoggingEvent event = new LoggingEventBuilder().createLoggingEvent();
        event.setFormattedMessage(msg);
        event.setTimestmp(new Date());
        try {
            dao.persist(event);
        } catch (RuntimeException e) {
            logger.error("Error persisting log", e);
            return Response.status(500).build();
        }

        final String result = "Saved text=" + msg;
        return Response.status(200).entity(result).build();
    }

}


