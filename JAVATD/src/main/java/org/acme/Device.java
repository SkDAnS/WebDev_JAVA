package org.acme;

public class Device {

    private String id;
    private String user;
    private String etat;
    private String config;

    // Getter et Setter pour chaque attribut
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }


    @Override
    public String toString() {
        return "Device : \n" +
                "\n   id='" + id + '\'' +
                "\n   user='" + user + '\'' +
                "\n   etat='" + etat + '\'' +
                "\n   config='" + config + '\'';
    }
}
