package com.danielK.mientrashagolimonadadef.servicios;

import com.danielK.mientrashagolimonadadef.modelo.user.User;
import com.danielK.mientrashagolimonadadef.repo.user.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepo repo;

    public User registrar(User t){
        repo.save(t);
        return t;
    }

    public List<User> listarUser(){

        return repo.findAll();
    }


    public Optional<User> buscarId(Integer id){

        return Optional.of(repo.findById(id).get());
    }


    public void guardarId(User t) {
        int i = repo.actualizaId(t.getIdUsuario(), t.getNombres());
    }

    public void deleteId(int id) {
        repo.deleteById(id);
    }

    public void actualizaId(User t) {
        repo.save(t);
    }
}