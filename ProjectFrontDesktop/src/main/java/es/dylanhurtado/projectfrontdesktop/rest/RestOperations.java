package es.dylanhurtado.projectfrontdesktop.rest;

import es.dylanhurtado.projectfrontdesktop.dto.AdminDTO;
import es.dylanhurtado.projectfrontdesktop.dto.ClienteDTO;
import es.dylanhurtado.projectfrontdesktop.dto.InfraestructuraDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface RestOperations {
    @GET("infraestructura/all")
    Call<List<InfraestructuraDTO>> getInfrastructuras();

    @GET("/cliente/all")
    Call<List<ClienteDTO>> getClientes();

    @GET("/admin/login")
    Call<AdminDTO> adminLogin(@Query(value = "mail") String mail,
                              @Query(value = "password") String password);
    @GET("/infraestructura/tipo")
    Call<List<InfraestructuraDTO>> infraestructuraByTipo(@Query(value = "tipo") String tipo);
}
