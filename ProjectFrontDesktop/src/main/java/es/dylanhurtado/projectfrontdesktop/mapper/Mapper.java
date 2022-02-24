package es.dylanhurtado.projectfrontdesktop.mapper;

import es.dylanhurtado.projectfrontdesktop.dto.ClienteDTO;
import es.dylanhurtado.projectfrontdesktop.dto.InfraestructuraDTO;
import es.dylanhurtado.projectfrontdesktop.model.Pista;
import es.dylanhurtado.projectfrontdesktop.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public Pista toPista(InfraestructuraDTO item) {
        Pista pista = new Pista();
        pista.setId(item.getId());
        pista.setTitle(item.getTipo());
        pista.setDescription(item.getDescripcion());
        pista.setImage(String.valueOf(item.getFoto()));
        pista.setPrice(item.getPrice());
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
}
