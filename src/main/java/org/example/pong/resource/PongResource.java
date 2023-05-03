package org.example.pong.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.pong.request.PongRequest;
import org.example.pong.response.PongResponse;
import org.example.pong.service.PongService;

@Path("/v1/resource")
public class PongResource {

    private PongService pongService = new PongService();

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
        String pongResponse = pongService.returnPong(pongRequest.getMessage());
        return Response.ok(pongResponse).build();
    }

    @POST
    @Path("/ping/message")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postMessage(PongRequest pongRequest) {
        pongService.postMessage(pongRequest);
        return Response.ok().build();
    }

    @GET
    @Path("/ping/message")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMessage() {
        return Response.ok(pongService.getMessage()).build();
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
