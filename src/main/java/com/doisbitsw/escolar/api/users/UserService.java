package com.doisbitsw.escolar.api.users;


import com.doisbitsw.escolar.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository rep;

    public List<UserDTO> getUsers() {
        return rep.findAll().stream().map(UserDTO::create).collect(Collectors.toList());
    }


    public UserDTO insert(User user) {
        Assert.isNull(user.getId(),"Não foi possível inserir o registro");
        return UserDTO.create(rep.save(user));
    }

    public UserDTO getUserById(Long id) {
        Optional<User> carro = rep.findById(id);
        return carro.map(UserDTO::create).orElseThrow(() -> new ObjectNotFoundException("Rotas não encontrado"));
    }
}
