package es.dylanhurtado.projectfrontdesktop.rest;

import es.dylanhurtado.projectfrontdesktop.dto.AdminDTO;
import es.dylanhurtado.projectfrontdesktop.dto.AlquilerDTO;
import es.dylanhurtado.projectfrontdesktop.dto.ClienteDTO;
import es.dylanhurtado.projectfrontdesktop.dto.InfraestructuraDTO;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.UUID;

public interface RestOperations {
    @GET("/cliente/all")
    Call<List<ClienteDTO>> getClientes();

    @GET("/admin/login")
    Call<AdminDTO> adminLogin(@Query(value = "mail") String mail,
                              @Query(value = "password") String password);

    @GET("/infraestructura/tipo")
    Call<List<InfraestructuraDTO>> infraestructuraByTipo(@Query(value = "tipo") String tipo);

    @DELETE("/infraestructura/delete")
    Call<InfraestructuraDTO> infraestructuraDelete(@Query(value = "id") UUID id);

    @PUT("/infraestructura/update")
    Call<InfraestructuraDTO> infraestructuraUpdate(@Body InfraestructuraDTO infraestructura);

    @POST("/infraestructura/post")
    Call<InfraestructuraDTO> infraestructuraPost(@Body InfraestructuraDTO infraestructura);

    @DELETE("/cliente/delete")
    Call<ClienteDTO> clienteDelete(@Query(value = "id") UUID id);

    @PUT("/cliente/put")
    Call<ClienteDTO> clienteUpdate(@Body ClienteDTO cliente);

    @POST("/cliente/post")
    Call<ClienteDTO> clientePost(@Body ClienteDTO cliente);

    @DELETE("/alquiler/delete")
    Call<AlquilerDTO> alquilerDelete(@Query(value = "id") UUID id);

    @PUT("/alquiler/update")
    Call<AlquilerDTO> alquilerUpdate(@Body AlquilerDTO alquiler);

    @POST("/alquiler/post")
    Call<AlquilerDTO> alquilerPost(@Body AlquilerDTO alquiler);
}
