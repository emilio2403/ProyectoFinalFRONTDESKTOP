package es.dylanhurtado.projectfrontdesktop.mapper;

import es.dylanhurtado.projectfrontdesktop.dto.AlquilerDTO;
import es.dylanhurtado.projectfrontdesktop.dto.ClienteDTO;
import es.dylanhurtado.projectfrontdesktop.dto.InfraestructuraDTO;
import es.dylanhurtado.projectfrontdesktop.model.Pista;
import es.dylanhurtado.projectfrontdesktop.model.Reserva;
import es.dylanhurtado.projectfrontdesktop.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public Pista toPista(InfraestructuraDTO item) {
        Pista pista = new Pista();
        pista.setId(item.getId());
        pista.setTitle(item.getTipo());
        pista.setDescription(item.getDescripcion());
        pista.setImage(String.valueOf(item.getFoto()));
        pista.setPrice(item.getCoste());
        pista.setApertura(item.getApertura());
        pista.setCierre(item.getCierre());
        return pista;
    }

    public List<Pista> toPista(List<InfraestructuraDTO> items) {
        return items.stream().map(this::toPista).collect(Collectors.toList());
    }

    public User toUser(ClienteDTO item) {
        User user = new User();
        user.setId(item.getId());
        user.setUsername(item.getNombre());
        user.setEmail(item.getCorreo());
        user.setImage(String.valueOf(item.getFoto()));
        return user;
    }

    public List<User> toUser(List<ClienteDTO> items) {
        return items.stream().map(this::toUser).collect(Collectors.toList());
    }
    public List<Reserva> toReserva(List<InfraestructuraDTO> items) {
        List<Reserva> reservas = new ArrayList<>();
        items.forEach(x->{
            x.getAlquileres().forEach(y->{
                reservas.add(toReserva(y));
            });
        });
        return reservas;
    }
    public Reserva toReserva(AlquilerDTO item) {
        Reserva reserva = new Reserva();
        reserva.setId(item.getId());
        reserva.setImage("");
        reserva.setSportType(item.getInfraestructura().getTipo());
        reserva.setPrice(item.getCoste());
        reserva.setDate(LocalDate.of(item.getYear(),item.getMonth(),item.getDay()));
        reserva.setPista(this.toPista(item.getInfraestructura()));
        reserva.setInicio(item.getInicio());
        reserva.setFin(item.getFin());
        return reserva;
    }
}
