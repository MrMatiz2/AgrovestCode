package com.Agrovest.controller;

import com.Agrovest.domain.Asesoria;
import com.Agrovest.domain.User;
import com.Agrovest.repository.AsesoriaRepository;
import com.Agrovest.repository.UserRepository;
import com.Agrovest.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    private UserRepository userMongo;

    @Autowired
    private AsesoriaRepository asesoriaRepository;


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("backButton", false);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("backButton", true);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.addObject("backButton", true);
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/signup?errorDup=true");

        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.addObject("backButton", true);
            modelAndView.addObject("userCreation", true);
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/sobrenosotros", method = RequestMethod.GET)
    public ModelAndView sobrenosotros() {
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("backButton", true);
        modelAndView.setViewName("sobrenosotros");
        return modelAndView;
    }

    @RequestMapping(value = "/plannegocio", method = RequestMethod.GET)
    public ModelAndView plannegocio() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userService.findUserByEmail(auth.getName());

        modelAndView.addObject("all", true);
        modelAndView.addObject("user", true);
        modelAndView.addObject("backButton", true);

        if (user.getId().equals("5f88e9ad32a4e46604768ae9")) {
            modelAndView.addObject("planNegocio", false);
        } else{
            modelAndView.addObject("planNegocio", true);
        }

        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fullName", "Bienvenido " + user.getFullname());

        modelAndView.setViewName("plannegocio");
        return modelAndView;
    }

    @RequestMapping(value = "/requisitos", method = RequestMethod.GET)
    public ModelAndView requisitos() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());


        modelAndView.addObject("all", true);
        modelAndView.addObject("user", true);
        modelAndView.addObject("backButton", true);
        modelAndView.addObject("planNegocio", true);
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fullName", "Bienvenido " + user.getFullname());

        modelAndView.setViewName("requisitos");
        return modelAndView;
    }

    @RequestMapping(value = "/tierra", method = RequestMethod.GET)
    public ModelAndView tierra() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());


        modelAndView.addObject("all", true);
        modelAndView.addObject("user", true);
        modelAndView.addObject("backButton", true);
        modelAndView.addObject("planNegocio", true);
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fullName", "Bienvenido " + user.getFullname());

        modelAndView.setViewName("tierra");
        return modelAndView;
    }

    @RequestMapping(value = "/panel", method = RequestMethod.GET)
    public ModelAndView panel() {

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        modelAndView.addObject("all", true);
        modelAndView.addObject("admin", true);
        modelAndView.addObject("backButton", true);
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fullName", "Bienvenido " + user.getFullname());

        modelAndView.setViewName("panel");
        return modelAndView;
    }

    @RequestMapping(value = "/inversionistas", method = RequestMethod.GET)
    public ModelAndView inversionistas(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        modelAndView.addObject("admin", true);
        modelAndView.addObject("all", true);
        modelAndView.addObject("backButton", true);
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("fullName", "Bienvenido " + user.getFullname());

        model.addAttribute("users", userMongo.findAll());

        modelAndView.setViewName("inversionistas");
        return modelAndView;
    }

    @RequestMapping(value = "/asesoria", method = RequestMethod.GET)
    public ModelAndView asesoria(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        if (user.getId().equals("5f88e9ad32a4e46604768ae9")) {
            modelAndView.addObject("adminRole", true);
            modelAndView.addObject("user", false);
            modelAndView.addObject("planNegocio", false);
        } else {
            modelAndView.addObject("userId", user.getId());
            modelAndView.addObject("user", true);
            modelAndView.addObject("planNegocio", true);
        }


        modelAndView.addObject("all", true);
        modelAndView.addObject("currentUser", user);
        modelAndView.addObject("backButton", true);

        model.addAttribute("asesorias", asesoriaRepository.findAll());
        modelAndView.setViewName("asesoria");
        return modelAndView;
    }

    @RequestMapping(value = "/crear")
    public ModelAndView crear() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        if (user.getId().equals("5f88e9ad32a4e46604768ae9")) {
            modelAndView.addObject("adminRole", true);
            modelAndView.addObject("planNegocio", false);
        } else {
            modelAndView.addObject("userRole", true);
            modelAndView.addObject("planNegocio", true);
        }

        modelAndView.addObject("all", true);
        modelAndView.addObject("user", true);

        modelAndView.addObject("backButton", true);
        modelAndView.addObject("currentUser", user);

        modelAndView.setViewName("crear");
        return modelAndView;
    }

    @RequestMapping("/guardar")
    public ModelAndView save(@RequestParam String asunto, @RequestParam String descripcion, @RequestParam String respuesta) {

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        Asesoria asesoria = new Asesoria();
        asesoria.setAsunto(asunto);
        asesoria.setDescripcion(descripcion);
        asesoria.setRespuesta(respuesta);
        asesoria.setUserId(user.getId());
        asesoria.setUserName(user.getFullname());
        asesoriaRepository.save(asesoria);

        if (user.getId().equals("5f88e9ad32a4e46604768ae9")) {
            modelAndView.addObject("planNegocio", false);
        } else{
            modelAndView.addObject("planNegocio", true);
        }

        modelAndView.addObject("all", true);
        modelAndView.addObject("user", true);
        modelAndView.addObject("backButton", true);
        modelAndView.addObject("currentUser", user);


        modelAndView.setViewName("redirect:/asesoria/");
        return modelAndView;

    }

    @RequestMapping("/mostrar/{id}")
    public ModelAndView mostrar(@PathVariable String id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        if (user.getId().equals("5f88e9ad32a4e46604768ae9")) {
            modelAndView.addObject("adminRole", true);
            modelAndView.addObject("planNegocio", false);
        } else {
            modelAndView.addObject("userRole", true);
            modelAndView.addObject("planNegocio", true);
        }

        modelAndView.addObject("all", true);
        modelAndView.addObject("user", true);
        modelAndView.addObject("backButton", true);
        modelAndView.addObject("currentUser", user);

        model.addAttribute("asesoria", asesoriaRepository.findById(id).get());
        modelAndView.setViewName("mostrar");
        return modelAndView;
    }

    @RequestMapping("/eliminar")
    public ModelAndView eliminar(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        Optional<Asesoria> asesoria = asesoriaRepository.findById(id);
        asesoriaRepository.delete(asesoria.get());

        if (user.getId().equals("5f88e9ad32a4e46604768ae9")) {
            modelAndView.addObject("planNegocio", false);
        } else{
            modelAndView.addObject("planNegocio", true);
        }

        modelAndView.addObject("all", true);
        modelAndView.addObject("user", true);
        modelAndView.addObject("backButton", true);
        modelAndView.addObject("currentUser", user);

        modelAndView.setViewName("redirect:/asesoria");
        return modelAndView;
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable String id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        if (user.getId().equals("5f88e9ad32a4e46604768ae9")) {
            modelAndView.addObject("adminRole", true);
            modelAndView.addObject("planNegocio", false);
        } else {
            modelAndView.addObject("userRole", true);
            modelAndView.addObject("planNegocio", true);
        }

        modelAndView.addObject("all", true);
        modelAndView.addObject("user", true);
        modelAndView.addObject("backButton", true);
        modelAndView.addObject("currentUser", user);

        model.addAttribute("asesoria", asesoriaRepository.findById(id).get());
        modelAndView.setViewName("editar");
        return modelAndView;
    }

    @RequestMapping("/actualizar")
    public ModelAndView actualizar(@RequestParam String id, @RequestParam String asunto, @RequestParam String descripcion, @RequestParam String respuesta) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        Optional<Asesoria> asesoria = asesoriaRepository.findById(id);
        asesoria.get().setAsunto(asunto);
        asesoria.get().setDescripcion(descripcion);
        asesoria.get().setRespuesta(respuesta);

        if (user.getId().equals("5f88e9ad32a4e46604768ae9")) {
            modelAndView.addObject("planNegocio", false);
        } else {
            modelAndView.addObject("planNegocio", true);
        }

        modelAndView.addObject("all", true);
        modelAndView.addObject("user", true);
        modelAndView.addObject("backButton", true);
        modelAndView.addObject("currentUser", user);

        asesoriaRepository.save(asesoria.get());
        modelAndView.setViewName("redirect:/asesoria/");

        return modelAndView;
    }

    public boolean createNewUsers(@Valid User user) {

        try {
            User userExists = userService.findUserByEmail(user.getEmail());
            userService.saveUser(user);
            return true;
        }catch (Exception e){
            System.out.println("Error! No se pudo crear al usuario \n"+ e);
            return false;
        }

    }

    public boolean saveAsesoria(@Valid Asesoria asesoria) {

        try {
            asesoriaRepository.save(asesoria);
            return true;
        }catch (Exception e) {
            System.out.println("Error! No se pudo crear la asesoría \n"+ e);
            return false;
        }

    }


}
