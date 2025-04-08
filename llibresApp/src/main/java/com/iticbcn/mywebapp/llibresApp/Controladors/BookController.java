package com.iticbcn.mywebapp.llibresApp.Controladors;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.iticbcn.mywebapp.llibresApp.DomainModel.Llibre;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Usuaris;
import com.iticbcn.mywebapp.llibresApp.Serveis.ProductService;

import java.util.Optional;
import java.util.Set;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
 
import com.iticbcn.mywebapp.llibresApp.DTO.LlibreDTO;
 
@Controller
@SessionAttributes("users")
public class BookController {

    @Autowired
    private ProductService llibreService; 
 
    @GetMapping("/")
    public String iniciar(Model model) {
        return "login";
    }
 
    @PostMapping("/index")
    public String login(@ModelAttribute("users") Usuaris users, Model model) {
 
        model.addAttribute("users", users);
 
        if (users.getUsuari().equals("toni") 
        && users.getPassword().equals("h3ll0!!")) {
            return "index";
        } else {
            return "login";
        }        
    }
 
    @GetMapping("/index")
    public String index(@ModelAttribute("users") Usuaris users, Model model) {
 
            return "index";
 
    }
 
    @GetMapping("/consulta") 
    public String consulta(@ModelAttribute("users") Usuaris users,Model model) {
 
        // ArrayList<Llibre> llibres = repoll.getAllLlibres();
        //Set<Llibre> llibres = llibreService.findAll();
        Set<LlibreDTO> llibreDTOs = llibreService.findAll();
 
        model.addAttribute("llibreDTOs", llibreDTOs);
 
        return "consulta";
    }
 
    @GetMapping("/inserir") 
    public String inputInserir(@ModelAttribute("users") Usuaris users,Model model) {
 
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        return "inserir";
    }
 
    @GetMapping("/cercaid")
    public String inputCerca(@ModelAttribute("users") Usuaris users, Model model) {
 
        LlibreDTO llibreDTO = new LlibreDTO();
        model.addAttribute("llibreErr", true);
        model.addAttribute("message", "");
        //model.addAttribute("llibre", llibre);
        model.addAttribute("llibreDTO", llibreDTO);
 
        return "cercaid";
 
    }
 
    @PostMapping("/inserir")
    public String inserir(@ModelAttribute("users") Usuaris users, 
                          @ModelAttribute LlibreDTO llibreDTO,
                          Model model) {
 
        llibreService.save(llibreDTO);    
 
        Set<LlibreDTO> llibreDTOs = llibreService.findAll();
 
        model.addAttribute("llibreDTOs", llibreDTOs);
        return "consulta";  
 
    }
 
    @PostMapping("/cercaid")
    public String cercaId(@ModelAttribute("users") Usuaris users,
                          @RequestParam(name = "idLlibre", required = false) String idLlibre, 
                          Model model) {
 
        String message = "";
        boolean llibreErr = false;
 
        try {
            Long idLl = Long.parseLong(idLlibre);
 
            Optional<LlibreDTO> llibreDTO = llibreService.findByIdLlibre(idLl);
 
            if (llibreDTO.isPresent()) {
                model.addAttribute("llibreDTO", llibreDTO);
            } else {
                message = "No hi ha cap llibre amb aquesta id";
                llibreErr = true;
            }
 
        } catch (Exception e) {
            message = "La id de llibre ha de ser un nombre enter";
            llibreErr = true;
        } 
 
        model.addAttribute("message", message);
        model.addAttribute("llibreErr",llibreErr);
 
        return "cercaid";
 
    }
 
    @PostMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/";
    }
 
 
    @ModelAttribute("users")
    public Usuaris getDefaultUser() {
        return new Usuaris(); 
    }
 
}
 