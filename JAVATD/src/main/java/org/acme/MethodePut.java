package org.acme;

import jakarta.json.*;

import java.io.FileWriter;
import java.io.InputStream;

public class MethodePut {

    // Méthode pour mettre à jour un ticket
    public JsonObject updateTicket(String id, Ticket ticket) {
        try {
            // Charger le fichier JSON
            InputStream jsonFile = getClass().getResourceAsStream("/ticket.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray ticketsArray = jsonObject.getJsonArray("ticket");

            // Créer un tableau de tickets mis à jour
            JsonArray ticketsArrayUpdated = Json.createArrayBuilder().build();
            boolean isUpdated = false;

            // Parcourir les tickets existants
            for (int i = 0; i < ticketsArray.size(); i++) {
                JsonObject ticketJson = ticketsArray.getJsonObject(i);
                if (ticketJson.getString("id").equals(id)) {
                    // Mettre à jour le ticket
                    JsonObject updatedTicket = Json.createObjectBuilder()
                            .add("id", id)
                            .add("titre", ticket.getTitre())
                            .add("description", ticket.getDescription())
                            .add("dateCreation", ticket.getDateCreation())
                            .add("dateMaj", ticket.getDateMaj())
                            .add("impact", ticket.getImpact())
                            .add("etat", ticket.getEtat())
                            .add("createur", ticket.getCreateur())
                            .add("poste", ticket.getPoste())
                            .add("typeDeDemande", ticket.getTypeDeDemande())
                            .build();
                    ticketsArrayUpdated = Json.createArrayBuilder(ticketsArrayUpdated)
                            .add(updatedTicket)
                            .build();
                    isUpdated = true;
                } else {
                    ticketsArrayUpdated = Json.createArrayBuilder(ticketsArrayUpdated)
                            .add(ticketJson)
                            .build();
                }
            }

            if (!isUpdated) {
                throw new RuntimeException("Ticket avec l'ID " + id + " non trouvé");
            }

            // Construire l'objet JSON mis à jour
            JsonObject updatedJsonObject = Json.createObjectBuilder()
                    .add("ticket", ticketsArrayUpdated)
                    .build();

            // Écrire les modifications dans le fichier JSON
            try (FileWriter fileWriter = new FileWriter("src/main/resources/ticket.json")) {
                Json.createWriter(fileWriter).write(updatedJsonObject);
            }

            // Retourner le ticket mis à jour
            return updatedJsonObject;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la mise à jour du ticket", e);
        }
    }






    public JsonObject updateUser(String id, User user) {
        try {
            // Charger le fichier JSON
            InputStream jsonFile = getClass().getResourceAsStream("/users.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray usersArray = jsonObject.getJsonArray("users");

            // Créer un tableau d'utilisateurs mis à jour
            JsonArray usersArrayUpdated = Json.createArrayBuilder().build();
            boolean isUpdated = false;

            // Parcourir les utilisateurs existants
            for (int i = 0; i < usersArray.size(); i++) {
                JsonObject userJson = usersArray.getJsonObject(i);
                if (userJson.getString("id").equals(id)) {
                    // Mettre à jour l'utilisateur
                    JsonObject updatedUser = Json.createObjectBuilder()
                            .add("id", id)
                            .add("nom", user.getNom())
                            .add("mail", user.getMail())
                            .add("mdp", user.getMdp())
                            .add("date", user.getDate())
                            .add("statut", user.getStatut())
                            .build();
                    usersArrayUpdated = Json.createArrayBuilder(usersArrayUpdated)
                            .add(updatedUser)
                            .build();
                    isUpdated = true;
                } else {
                    usersArrayUpdated = Json.createArrayBuilder(usersArrayUpdated)
                            .add(userJson)
                            .build();
                }
            }

            if (!isUpdated) {
                throw new RuntimeException("Utilisateur avec l'ID " + id + " non trouvé");
            }

            // Construire l'objet JSON mis à jour
            JsonObject updatedJsonObject = Json.createObjectBuilder()
                    .add("users", usersArrayUpdated)
                    .build();

            // Écrire les modifications dans le fichier JSON
            try (FileWriter fileWriter = new FileWriter("src/main/resources/users.json")) {
                Json.createWriter(fileWriter).write(updatedJsonObject);
            }

            // Retourner l'utilisateur mis à jour
            return updatedJsonObject;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la mise à jour de l'utilisateur", e);
        }
    }









    // Méthode pour mettre à jour un dispositif
    public JsonObject updateDevice(String id, Device device) {
        try {
            // Charger le fichier JSON
            InputStream jsonFile = getClass().getResourceAsStream("/device.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray devicesArray = jsonObject.getJsonArray("device");

            // Créer un tableau de dispositifs mis à jour
            JsonArray devicesArrayUpdated = Json.createArrayBuilder().build();
            boolean isUpdated = false;

            // Parcourir les dispositifs existants
            for (int i = 0; i < devicesArray.size(); i++) {
                JsonObject deviceJson = devicesArray.getJsonObject(i);
                if (deviceJson.getString("id").equals(id)) {
                    // Mettre à jour le dispositif
                    JsonObject updatedDevice = Json.createObjectBuilder()
                            .add("id", id)
                            .add("user", device.getUser())
                            .add("etat", device.getEtat())
                            .add("config", device.getConfig())
                            .build();
                    devicesArrayUpdated = Json.createArrayBuilder(devicesArrayUpdated)
                            .add(updatedDevice)
                            .build();
                    isUpdated = true;
                } else {
                    devicesArrayUpdated = Json.createArrayBuilder(devicesArrayUpdated)
                            .add(deviceJson)
                            .build();
                }
            }

            if (!isUpdated) {
                throw new RuntimeException("Dispositif avec l'ID " + id + " non trouvé");
            }

            // Construire l'objet JSON mis à jour
            JsonObject updatedJsonObject = Json.createObjectBuilder()
                    .add("device", devicesArrayUpdated)
                    .build();

            // Écrire les modifications dans le fichier JSON
            try (FileWriter fileWriter = new FileWriter("src/main/resources/device.json")) {
                Json.createWriter(fileWriter).write(updatedJsonObject);
            }

            // Retourner le dispositif mis à jour
            return updatedJsonObject;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la mise à jour du dispositif", e);
        }
    }
}
