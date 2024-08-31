package com.example.TechPlay.Controller;

import com.example.TechPlay.Model.Users;
import com.example.TechPlay.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        userDetailsService.saveUser(user);
        return ResponseEntity.ok("User registered Successfully");
    }

//    @GetMapping("/home")
//    public ModelAndView accessHomePage(@RequestParam String username, @RequestParam String password, Model model) {
//        Optional<Users> user = userDetailsService.findyByUsername(username);
//        if (user.isPresent() && user.get().getPassword().equals(password)) {
//            ModelAndView modelAndView = new ModelAndView("HomePage");
//            modelAndView.addObject("username", username);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("error");
//            modelAndView.addObject("message", "Invalid credentials");
//            return modelAndView;
//        }
//}
    @GetMapping("/home")
    public String home() {
    return "HomePage";
}
}
