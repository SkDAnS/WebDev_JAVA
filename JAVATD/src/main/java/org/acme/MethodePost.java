package org.acme;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;

import java.io.FileWriter;
import java.io.InputStream;
import java.util.Set;
import java.util.stream.Collectors;

public class MethodePost {

    // Méthode pour ajouter un nouveau ticket
    public JsonObject addTicket(Ticket ticket) {
        try {
            // Charger le fichier JSON
            InputStream jsonFile = getClass().getResourceAsStream("/ticket.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray ticketsArray = jsonObject.getJsonArray("ticket");




            Set<String> existingIds = ticketsArray.stream()
                    .map(JsonValue::asJsonObject)
                    .map(obj -> obj.getString("id"))
                    .collect(Collectors.toSet());

            // Générer un nouvel ID unique
            String newId = generateUniqueId(existingIds);
            ticket.setId(newId); // Assigner l'ID généré






            // Créer un objet JSON pour le nouveau ticket
            JsonObject newTicket = Json.createObjectBuilder()
                    .add("id", ticket.getId())
                    .add("titre", ticket.getTitre()) // Utilise getTitre()
                    .add("description", ticket.getDescription())
                    .add("dateCreation", ticket.getDateCreation())
                    .add("dateMaj", ticket.getDateMaj())
                    .add("impact", ticket.getImpact())
                    .add("etat", ticket.getEtat())
                    .add("createur", ticket.getCreateur())
                    .add("poste", ticket.getPoste())
                    .add("typeDeDemande", ticket.getTypeDeDemande())
                    .build();

            // Ajouter le nouveau ticket à la liste existante
            JsonArray updatedTickets = Json.createArrayBuilder(ticketsArray)
                    .add(newTicket)
                    .build();

            // Construire le nouvel objet JSON
            JsonObject updatedJsonObject = Json.createObjectBuilder()
                    .add("ticket", updatedTickets)
                    .build();

            // Écrire les modifications dans le fichier JSON
            try (FileWriter fileWriter = new FileWriter("src/main/resources/ticket.json")) {
                Json.createWriter(fileWriter).write(updatedJsonObject);
            }

            return newTicket; // Retourner le ticket ajouté
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'ajout du ticket", e);
        }
    }


    public JsonObject addUser(User user) {
        try {
            // Charger le fichier JSON existant
            InputStream jsonFile = getClass().getResourceAsStream("/users.json");
            if (jsonFile == null) {
                throw new RuntimeException("Le fichier users.json n'existe pas dans les ressources.");
            }
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray usersArray = jsonObject.getJsonArray("users");





            Set<String> existingIds = usersArray.stream()
                    .map(JsonValue::asJsonObject)
                    .map(obj -> obj.getString("id"))
                    .collect(Collectors.toSet());

            // Générer un nouvel ID unique
            String newId = generateUniqueId(existingIds);
            user.setId(newId); // Assigner l'ID généré








            // Créer un objet JSON pour le nouvel utilisateur
            JsonObject newUser = Json.createObjectBuilder()
                    .add("id", user.getId())
                    .add("nom", user.getNom())
                    .add("mail", user.getMail())
                    .add("mdp", user.getMdp())
                    .add("date", user.getDate())
                    .add("statut", user.getStatut())
                    .build();

            // Ajouter le nouvel utilisateur à la liste existante
            JsonArray updatedUsers = Json.createArrayBuilder(usersArray)
                    .add(newUser)
                    .build();

            // Construire le nouvel objet JSON
            JsonObject updatedJsonObject = Json.createObjectBuilder()
                    .add("users", updatedUsers)
                    .build();

            // Écrire les modifications dans le fichier JSON
            try (FileWriter fileWriter = new FileWriter("src/main/resources/users.json")) {
                Json.createWriter(fileWriter).write(updatedJsonObject);
            }

            return newUser; // Retourner l'utilisateur ajouté
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage(), e);
        }
    }


    public JsonObject addDevice(Device device) {
        try {
            // Charger le fichier JSON existant
            InputStream jsonFile = getClass().getResourceAsStream("/device.json");
            if (jsonFile == null) {
                throw new RuntimeException("Le fichier devices.json n'existe pas dans les ressources.");
            }
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray devicesArray = jsonObject.getJsonArray("device");




            Set<String> existingIds = devicesArray.stream()
                    .map(JsonValue::asJsonObject)
                    .map(obj -> obj.getString("id"))
                    .collect(Collectors.toSet());

            // Générer un nouvel ID unique
            String newId = generateUniqueId(existingIds);
            device.setId(newId); // Assigner l'ID généré














            // Créer un objet JSON pour le nouvel appareil
            JsonObject newDevice = Json.createObjectBuilder()
                    .add("id", device.getId())
                    .add("user", device.getUser())
                    .add("etat", device.getEtat())
                    .add("config", device.getConfig())
                    .build();

            // Ajouter le nouvel appareil à la liste existante
            JsonArray updatedDevices = Json.createArrayBuilder(devicesArray)
                    .add(newDevice)
                    .build();

            // Construire le nouvel objet JSON
            JsonObject updatedJsonObject = Json.createObjectBuilder()
                    .add("device", updatedDevices)
                    .build();

            // Écrire les modifications dans le fichier JSON
            try (FileWriter fileWriter = new FileWriter("src/main/resources/device.json")) {
                Json.createWriter(fileWriter).write(updatedJsonObject);
            }

            return newDevice; // Retourner l'appareil ajouté
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'ajout de l'appareil : " + e.getMessage(), e);
        }
    }






    // Générer un ID unique qui n'existe pas déjà
    private String generateUniqueId(Set<String> existingIds) {
        int id = 1;
        while (existingIds.contains(String.valueOf(id))) {
            id++;
        }
        return String.valueOf(id);
    }


}













