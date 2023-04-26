package org.example.pong.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.pong.request.PongRequest;
import org.example.pong.response.PongResponse;

@Path("/v1/resource")
public class PongResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIt() {
        return Response.ok(new String("Got it!")).build();
    }

    @POST
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PongRequest pongRequest) {
        PongResponse pongResponse = new PongResponse();
        pongResponse.setMessage(new StringBuilder()
                .append("Receive: ")
                .append(pongRequest.getMessage())
                .toString());
        return Response.ok(pongResponse).build();
    }

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        PongResponse message = new PongResponse();
        message.setMessage("pong");
        return Response.ok(message).build();
    }

}
