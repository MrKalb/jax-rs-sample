package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET()
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post() {

        EntityManager entityManager =
                Persistence.createEntityManagerFactory("jax-rs-sample").createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            PersonEntity personEntity = new PersonEntity();
            personEntity.setId(1L);
            personEntity.setName("Igor");
            entityManager.persist(personEntity);
            transaction.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.clear();
            entityManager.close();
        }

        return Response.status(Response.Status.fromStatusCode(200)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id,Object object) {
        return Response.status(Response.Status.fromStatusCode(200)).entity(object).build();
    }

}
