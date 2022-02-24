package es.dylanhurtado.projectfrontdesktop.rest;

public class Config {
    private static final String url = "https://randomuser.me";

    private Config() {
    }

    public static RestOperations getService() {
        return Client.getClient(url).create(RestOperations.class);
    }
}