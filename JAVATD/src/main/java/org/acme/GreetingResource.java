package org.acme;

import jakarta.json.JsonObject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("")
public class GreetingResource {

    private MethodeGet methodeGet = new MethodeGet();
    private MethodePut methodePut = new MethodePut();
    private MethodePost methodePost = new MethodePost();
    private MethodeDelete methodeDelete = new MethodeDelete();

    // Endpoint pour obtenir tous les tickets
    @GET
    @Path("/ticket")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> getTickets() {
        return methodeGet.getTickets();
    }

    // Endpoint pour obtenir un ticket par ID
    @GET
    @Path("/ticket/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ticket getTicketById(@PathParam("id") String id) {
        return methodeGet.getTicketById(id);
    }

    // Endpoint pour obtenir un dispositif par ID
    @GET
    @Path("/device/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Device getDeviceById(@PathParam("id") String id) {
        return methodeGet.getDeviceById(id);
    }

    // Endpoint pour obtenir un utilisateur par ID
    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") String id) {
        return methodeGet.getUserById(id);
    }

    // Endpoint pour obtenir tous les utilisateurs
    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return methodeGet.getUsers();
    }

    // Endpoint pour obtenir tous les dispositifs
    @GET
    @Path("/device")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> getDevices() {
        return methodeGet.getDevices();
    }

    // Endpoint pour ajouter un nouveau ticket (POST)
    @POST
    @Path("/ticket")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTicket(Ticket ticket) {
        try {
            JsonObject newTicket = methodePost.addTicket(ticket);
            return Response.status(Response.Status.CREATED).entity(newTicket).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur lors de la création du ticket : " + e.getMessage())
                    .build();
        }
    }




    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        try {
            JsonObject newUser = methodePost.addUser(user);
            return Response.status(Response.Status.CREATED).entity(newUser).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur lors de la création du user : " + e.getMessage())
                    .build();
        }
    }







    @POST
    @Path("/device")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDevice(Device device) {
        try {
            JsonObject newDevice = methodePost.addDevice(device);
            return Response.status(Response.Status.CREATED).entity(newDevice).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur lors de la création du device : " + e.getMessage())
                    .build();
        }
    }









    // Endpoint pour mettre à jour un ticket (PUT)
    @PUT
    @Path("/ticket/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTicket(@PathParam("id") String id, Ticket ticket) {
        try {
            JsonObject updatedTicket = methodePut.updateTicket(id, ticket);
            return Response.status(Response.Status.OK).entity(updatedTicket).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur lors de la mise à jour du ticket : " + e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/user/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") String id, User user) {
        try {
            JsonObject updatedUser = methodePut.updateUser(id, user);
            return Response.status(Response.Status.OK).entity(updatedUser).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage())
                    .build();
        }
    }


    // Endpoint pour mettre à jour un dispositif (PUT)
    @PUT
    @Path("/device/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDevice(@PathParam("id") String id, Device device) {
        try {
            JsonObject updatedDevice = methodePut.updateDevice(id, device);
            return Response.status(Response.Status.OK).entity(updatedDevice).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur lors de la mise à jour du dispositif : " + e.getMessage())
                    .build();
        }
    }

    // Endpoint pour supprimer un ticket (DELETE)
    @DELETE
    @Path("/ticket/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTicket(@PathParam("id") String id) {
        return methodeDelete.deleteTicket(id);
    }

    // Endpoint pour supprimer un utilisateur (DELETE)
    @DELETE
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") String id) {
        return methodeDelete.deleteUser(id);
    }

    // Endpoint pour supprimer un dispositif (DELETE)
    @DELETE
    @Path("/device/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDevice(@PathParam("id") String id) {
        return methodeDelete.deleteDevice(id);
    }
}

