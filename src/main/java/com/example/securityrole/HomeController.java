package com.example.securityrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/home")
    public String user(Model model) {
        return "user";
    }
    @GetMapping("/kapcsolat")
    public String kapcsolat(Model model) {
        model.addAttribute("uzenet", new Kapcsolat_uzenetek());
        return "kapcsolat";
    }
    @GetMapping("/admin/home")
    public String admin() {
        return "admin";
    }

    @GetMapping("/regisztral")
    public String greetingForm(Model model) {
        model.addAttribute("reg", new User());
        return "regisztral";
    }

    @GetMapping("/error")
    public String error(Model model) {
        model.addAttribute("uzenet", model);
        return "kapcsolathiba";
    }

    @Autowired
    private UserRepository userRepo;
    @PostMapping("/regisztral_feldolgoz")
    public String Regisztráció(@ModelAttribute User user, Model model) {
        for(User felhasznalo2: userRepo.findAll())
            if(felhasznalo2.getEmail().equals(user.getEmail())){
                model.addAttribute("uzenet", "A regisztrációs email már foglalt!");
                return "reghiba";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role();
        // Minden regisztrációkor USER szerepet adunk a felhasználónak:
        role.setId(3); role.setName("ROLE_USER");
        List<Role> rolelist = new ArrayList<Role>();
        rolelist.add(role);
        user.setRoles(rolelist);
        userRepo.save(user);
        model.addAttribute("id", user.getId());
        return "regjo";
    }

    @Autowired
    private KapcsolatRepository kapcsolatRepository;
    @PostMapping("/kapcsolat_feldolgoz")
    public String Kapcsolat(@ModelAttribute Kapcsolat_uzenetek uzenet, Model model) {
        String bekuldo = SecurityContextHolder.getContext().getAuthentication().getName();
        if (bekuldo.equals("anonymousUser"))
            uzenet.setBekuldo("Vendég");
        else
            uzenet.setBekuldo(bekuldo);
        kapcsolatRepository.save(uzenet);
        return "kapcsolatjo";
    }

    @GetMapping("/uzenetek")
    public String getAllUzenetek(Model model) {
        List<Kapcsolat_uzenetek> uzenetek = (List<Kapcsolat_uzenetek>)kapcsolatRepository.findAll();
        model.addAttribute("uzenetek", uzenetek);
        return "uzenetek";
    }

    @Autowired
    private NaploRepository naploRepository;
    @GetMapping("/naplo")
    public String getAllNaploBejegyzes(Model model) {
        List<Naplo> naploBejegyzesek = naploRepository.findAllNaploBejegyzes();
        model.addAttribute("naplobejegyzesek", naploBejegyzesek);
        return "naplo";
    }
}