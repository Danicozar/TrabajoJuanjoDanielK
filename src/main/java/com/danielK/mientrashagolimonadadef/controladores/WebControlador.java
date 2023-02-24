package com.danielK.mientrashagolimonadadef.controladores;

import com.danielK.mientrashagolimonadadef.modelo.user.User;
import com.danielK.mientrashagolimonadadef.servicios.UserService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebControlador {

    @Autowired
    private UserService servicioUser;

    @GetMapping ("/")
    public String index(Model modelo){

        return "index";
    }

    @GetMapping ("/info")
    public String info(Model modelo){

        return "/html/info";
    }

    @GetMapping ("/perfil")
    public String perfil(Model modelo){

        return "/html/perfil";
    }

    @GetMapping ("/blogs")
    public String inicio(Model modelo){

        return "/html/blogs";
    }

    @GetMapping ("/Entrada_BYogurt")
    public String entrada1(Model modelo){

        return "/html/Entrada_BYogurt";
    }

    @GetMapping ("/Entrada_Gachamiga")
    public String entrada2(Model modelo){

        return "/html/Entrada_Gachamiga";
    }

    @GetMapping ("/Entrada_Lasagna")
    public String entrada3(Model modelo){

        return "/html/Entrada_Lasagna";
    }

    @GetMapping ("/Entrada_Pasta_Alfredo")
    public String entrada4(Model modelo){

        return "/html/Entrada_Pasta_Alfredo";
    }

    @GetMapping ("/Entrada_Raffaello")
    public String entrada5(Model modelo){

        return "/html/Entrada_Raffaello";
    }

    @GetMapping ("/Entrada_Tarta_Queso")
    public String entrada6(Model modelo){

        return "/html/Entrada_Lasagna";
    }

    @GetMapping ("/listado")
    public String listarUser(Model modelo){
        modelo.addAttribute("user",servicioUser.listarUser());
        return "usuarios";
    }

    @GetMapping ("/nuevo")
    public String nuevoUser(Model modelo){
        User usuario = new User();
        modelo.addAttribute("user",usuario);
        return "nuevo_usuario";
    }
    @PostMapping("/guardar")
    public String guardarUser (@ModelAttribute("user") User usuario) {
        servicioUser.registrar(usuario);
        return "redirect:/";
    }

    @RequestMapping ("/editar/{num}")
    public String editarUser(@PathVariable int num, Model modelo){

      modelo.addAttribute("user",
                servicioUser.buscarId(num).get());
        return "editar_usuario";
    }

    @PostMapping ("/actualizar")
    public String actualizaUser(@ModelAttribute("user") User usuario){
        servicioUser.actualizaId(usuario);
        return "redirect:/";
    }

    @GetMapping ("/borrar/{num}")
    public String borrarUser(@PathVariable int num){
        servicioUser.deleteId(num);
        return "redirect:/";
    }

    @GetMapping ("/buscar")
    public String buscar(){
        return "buscar";
    }

    @RequestMapping("parametros/{a}/{b}/{c}")
    public String parametros( @PathVariable int a,
                              @PathVariable int b,
                              @PathVariable int c,
                              Model model) {
        model.addAttribute("a",a);
        model.addAttribute("b",b);
        model.addAttribute("c",c);
        return "parametros";
    }
    @RequestMapping({"opcionales/{a}/{b}/{c}",
            "opcionales/{a}/{b}",
               "opcionales/{a}",
    "opcionales"})
    public String opcionales(
            @PathVariable (name = "a", required = false) String a,
            @PathVariable (name = "b", required = false) String b,
            @PathVariable (name = "c", required = false) String c,
            Model model) {
        if (StringUtils.isEmpty(a)) {
            a = "0";
        }
        if (StringUtils.isEmpty(b)) {
            b = "0";
        }
        if (StringUtils.isEmpty(c)) {
            c = "0";
        }
        model.addAttribute("a",a);
        model.addAttribute("b",b);
        model.addAttribute("c",c);
        return "opcionales";
    }


}
