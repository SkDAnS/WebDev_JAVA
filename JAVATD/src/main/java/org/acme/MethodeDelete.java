package org.acme;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.ws.rs.core.Response;

import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MethodeDelete {

    // Méthode pour supprimer un ticket
    public Response deleteTicket(String id) {
        try {
            // Charger le fichier JSON
            InputStream jsonFile = getClass().getResourceAsStream("/ticket.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray ticketsArray = jsonObject.getJsonArray("ticket");

            // Filtrer les tickets et créer une nouvelle liste sans le ticket à supprimer
            List<JsonValue> updatedTickets = new ArrayList<>();
            boolean ticketFound = false;

            for (JsonValue ticket : ticketsArray) {
                JsonObject ticketObj = ticket.asJsonObject();
                if (!ticketObj.getString("id").equals(id)) {
                    updatedTickets.add(ticketObj);
                } else {
                    ticketFound = true;
                }
            }

            // Si le ticket n'existe pas, retourner NOT_FOUND
            if (!ticketFound) {
                return Response.status(Response.Status.NOT_FOUND).entity("Ticket non trouvé").build();
            }

            // Construire le nouvel objet JSON
            JsonObject updatedJsonObject = Json.createObjectBuilder()
                    .add("ticket", Json.createArrayBuilder(updatedTickets))
                    .build();

            // Écrire les modifications dans le fichier JSON
            try (FileWriter fileWriter = new FileWriter("src/main/resources/ticket.json")) {
                Json.createWriter(fileWriter).write(updatedJsonObject);
            }

            return Response.ok().entity("Ticket supprimé avec succès").build();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la suppression du ticket", e);
        }
    }

    // Méthode pour supprimer un utilisateur
    public Response deleteUser(String id) {
        try {
            // Charger le fichier JSON
            InputStream jsonFile = getClass().getResourceAsStream("/users.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray usersArray = jsonObject.getJsonArray("users");

            // Filtrer les utilisateurs et créer une nouvelle liste sans l'utilisateur à supprimer
            List<JsonValue> updatedUsers = new ArrayList<>();
            boolean userFound = false;

            for (JsonValue user : usersArray) {
                JsonObject userObj = user.asJsonObject();
                if (!userObj.getString("id").equals(id)) {
                    updatedUsers.add(userObj);
                } else {
                    userFound = true;
                }
            }

            // Si l'utilisateur n'existe pas, retourner NOT_FOUND
            if (!userFound) {
                return Response.status(Response.Status.NOT_FOUND).entity("Utilisateur non trouvé").build();
            }

            // Construire le nouvel objet JSON
            JsonObject updatedJsonObject = Json.createObjectBuilder()
                    .add("users", Json.createArrayBuilder(updatedUsers))
                    .build();

            // Écrire les modifications dans le fichier JSON
            try (FileWriter fileWriter = new FileWriter("src/main/resources/users.json")) {
                Json.createWriter(fileWriter).write(updatedJsonObject);
            }

            return Response.ok().entity("Utilisateur supprimé avec succès").build();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la suppression de l'utilisateur", e);
        }
    }






    // Méthode pour supprimer un dispositif
    public Response deleteDevice(String id) {
        try {
            // Charger le fichier JSON
            InputStream jsonFile = getClass().getResourceAsStream("/device.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray devicesArray = jsonObject.getJsonArray("device");

            // Filtrer les dispositifs et créer une nouvelle liste sans le dispositif à supprimer
            List<JsonValue> updatedDevices = new ArrayList<>();
            boolean deviceFound = false;

            for (JsonValue device : devicesArray) {
                JsonObject deviceObj = device.asJsonObject();
                if (!deviceObj.getString("id").equals(id)) {
                    updatedDevices.add(deviceObj);
                } else {
                    deviceFound = true;
                }
            }

            // Si le dispositif n'existe pas, retourner NOT_FOUND
            if (!deviceFound) {
                return Response.status(Response.Status.NOT_FOUND).entity("Dispositif non trouvé").build();
            }

            // Construire le nouvel objet JSON
            JsonObject updatedJsonObject = Json.createObjectBuilder()
                    .add("device", Json.createArrayBuilder(updatedDevices))
                    .build();

            // Écrire les modifications dans le fichier JSON
            try (FileWriter fileWriter = new FileWriter("src/main/resources/device.json")) {
                Json.createWriter(fileWriter).write(updatedJsonObject);
            }

            return Response.ok().entity("Dispositif supprimé avec succès").build();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la suppression du dispositif", e);
        }
    }
}


