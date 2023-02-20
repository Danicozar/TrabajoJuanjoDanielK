package com.danielK.mientrashagolimonadadef.controladores;

import com.danielK.mientrashagolimonadadef.modelo.admin.Admin;
import com.danielK.mientrashagolimonadadef.modelo.user.User;
import com.danielK.mientrashagolimonadadef.servicios.AdminService;
import com.danielK.mientrashagolimonadadef.servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiControlador {
    @Autowired
    private AdminService adminService;


    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/admin")
    public void registrarAdmin(@RequestBody Admin admin){

        adminService.registrar(admin);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public User registrarUser(@RequestBody User usuario){
        return this.userService.registrar(usuario);
    }

    @Autowired
    private UserService servicioUser;


    @GetMapping()
    public List<User> obtenerUsuarios(){

        return servicioUser.listarUser();
    }

}
