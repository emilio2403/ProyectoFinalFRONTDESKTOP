package es.dylanhurtado.projectfrontdesktop.rest;

import es.dylanhurtado.projectfrontdesktop.dto.ClienteDTO;
import es.dylanhurtado.projectfrontdesktop.dto.InfraestructuraDTO;
import es.dylanhurtado.projectfrontdesktop.mapper.Mapper;
import es.dylanhurtado.projectfrontdesktop.model.Pista;
import es.dylanhurtado.projectfrontdesktop.model.User;
import retrofit2.Response;

import java.util.List;

public class RestToModel {
    private final Mapper mapper = new Mapper();
    private final RestOperations restOperations = Config.getService();

    public List<Pista> getAllPistas() throws Exception {
        List<Pista> pistas = null;
        Response<List<InfraestructuraDTO>> res = restOperations.getInfrastructuras().execute();
        if (res.body() != null && res.isSuccessful()) {
            pistas = mapper.toPista(res.body());
        } else {
            throw new NullPointerException("Error al recuperar getAllPistas de la API");
        }
        return pistas;
    }

    public List<User> getAllUsers() throws Exception {
        List<User> users = null;
        Response<List<ClienteDTO>> res = restOperations.getClientes().execute();
        if (res.body() != null && res.isSuccessful()) {
            users = mapper.toUser(res.body());
        } else {
            throw new NullPointerException("Error al recuperar getAllUsers de la API");
        }
        return users;
    }
}
