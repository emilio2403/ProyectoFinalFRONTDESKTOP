package es.dylanhurtado.projectfrontdesktop.rest;

import es.dylanhurtado.projectfrontdesktop.dto.ClienteDTO;
import es.dylanhurtado.projectfrontdesktop.dto.InfraestructuraDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface RestOperations {
    @GET("infraestructura")
    Call<List<InfraestructuraDTO>> getInfrastructuras();

    @GET("clientes")
    Call<List<ClienteDTO>> getClientes();
}
