package org.acme;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MethodeGet {

    // Méthode pour obtenir tous les tickets
    public List<Ticket> getTickets() {
        try {
            InputStream jsonFile = getClass().getResourceAsStream("/ticket.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray ticketsArray = jsonObject.getJsonArray("ticket");
            List<Ticket> tickets = new ArrayList<>();

            for (int i = 0; i < ticketsArray.size(); i++) {
                JsonObject ticketJson = ticketsArray.getJsonObject(i);
                Ticket ticket = new Ticket();
                ticket.setId(ticketJson.getString("id"));
                ticket.setTitre(ticketJson.getString("titre"));
                ticket.setDescription(ticketJson.getString("description"));
                ticket.setDateCreation(ticketJson.getString("date_creation"));
                ticket.setDateMaj(ticketJson.getString("date_maj"));
                ticket.setImpact(ticketJson.getString("impact"));
                ticket.setEtat(ticketJson.getString("etat"));
                ticket.setCreateur(ticketJson.getString("createur"));
                ticket.setPoste(ticketJson.getString("poste"));
                ticket.setTypeDeDemande(ticketJson.getString("type_de_demande"));
                tickets.add(ticket);
            }

            return tickets;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la lecture des tickets", e);
        }
    }

    // Méthode pour obtenir un ticket par ID
    public Ticket getTicketById(String id) {
        try {
            InputStream jsonFile = getClass().getResourceAsStream("/ticket.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray ticketsArray = jsonObject.getJsonArray("ticket");

            for (int i = 0; i < ticketsArray.size(); i++) {
                JsonObject ticketJson = ticketsArray.getJsonObject(i);
                if (ticketJson.getString("id").equals(id)) {
                    Ticket ticket = new Ticket();
                    ticket.setId(ticketJson.getString("id"));
                    ticket.setTitre(ticketJson.getString("titre"));
                    ticket.setDescription(ticketJson.getString("description"));
                    ticket.setDateCreation(ticketJson.getString("date_creation"));
                    ticket.setDateMaj(ticketJson.getString("date_maj"));
                    ticket.setImpact(ticketJson.getString("impact"));
                    ticket.setEtat(ticketJson.getString("etat"));
                    ticket.setCreateur(ticketJson.getString("createur"));
                    ticket.setPoste(ticketJson.getString("poste"));
                    ticket.setTypeDeDemande(ticketJson.getString("type_de_demande"));
                    return ticket;
                }
            }

            return null;  // Retourne null si le ticket avec l'ID donné n'est pas trouvé
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la lecture du ticket", e);
        }
    }

    // Méthode pour obtenir un utilisateur par ID
    public User getUserById(String id) {
        try {
            InputStream jsonFile = getClass().getResourceAsStream("/users.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray usersArray = jsonObject.getJsonArray("users");

            for (int i = 0; i < usersArray.size(); i++) {
                JsonObject userJson = usersArray.getJsonObject(i);
                if (userJson.getString("id").equals(id)) {
                    User user = new User();
                    user.setId(userJson.getString("id"));
                    user.setNom(userJson.getString("nom"));
                    user.setMail(userJson.getString("mail"));
                    user.setMdp(userJson.getString("mdp"));
                    user.setDate(userJson.getString("date"));
                    user.setStatut(userJson.getString("statut"));
                    return user;
                }
            }

            return null;  // Retourne null si l'utilisateur avec l'ID donné n'est pas trouvé
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la lecture de l'utilisateur", e);
        }
    }

    // Méthode pour obtenir un dispositif par ID
    public Device getDeviceById(String id) {
        try {
            InputStream jsonFile = getClass().getResourceAsStream("/device.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray devicesArray = jsonObject.getJsonArray("device");

            for (int i = 0; i < devicesArray.size(); i++) {
                JsonObject deviceJson = devicesArray.getJsonObject(i);
                if (deviceJson.getString("id").equals(id)) {
                    Device device = new Device();
                    device.setId(deviceJson.getString("id"));
                    device.setUser(deviceJson.getString("user"));
                    device.setEtat(deviceJson.getString("etat"));
                    device.setConfig(deviceJson.getString("config"));
                    return device;
                }
            }

            return null;  // Retourne null si le dispositif avec l'ID donné n'est pas trouvé
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la lecture du dispositif", e);
        }
    }

    // Méthodes pour obtenir les utilisateurs et les dispositifs
    public List<User> getUsers() {
        try {
            InputStream jsonFile = getClass().getResourceAsStream("/users.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray usersArray = jsonObject.getJsonArray("users");
            List<User> users = new ArrayList<>();

            for (int i = 0; i < usersArray.size(); i++) {
                JsonObject userJson = usersArray.getJsonObject(i);
                User user = new User();
                user.setId(userJson.getString("id"));
                user.setNom(userJson.getString("nom"));
                user.setMail(userJson.getString("mail"));
                user.setMdp(userJson.getString("mdp"));
                user.setDate(userJson.getString("date"));
                user.setStatut(userJson.getString("statut"));
                users.add(user);
            }

            return users;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la lecture des utilisateurs", e);
        }
    }

    public List<Device> getDevices() {
        try {
            InputStream jsonFile = getClass().getResourceAsStream("/device.json");
            JsonObject jsonObject = Json.createReader(jsonFile).readObject();
            JsonArray devicesArray = jsonObject.getJsonArray("device");
            List<Device> devices = new ArrayList<>();

            for (int i = 0; i < devicesArray.size(); i++) {
                JsonObject deviceJson = devicesArray.getJsonObject(i);
                Device device = new Device();
                device.setId(deviceJson.getString("id"));
                device.setUser(deviceJson.getString("user"));
                device.setEtat(deviceJson.getString("etat"));
                device.setConfig(deviceJson.getString("config"));
                devices.add(device);
            }

            return devices;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la lecture des informations des postes", e);
        }
    }
}
