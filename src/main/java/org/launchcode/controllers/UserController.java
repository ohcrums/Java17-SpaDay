package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(@ModelAttribute @Valid User user, Model model, String verify, Errors errors) {
//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());
        model.addAttribute(user);
        System.out.println("POINT ONE:  " + errors);

        if (errors.hasErrors()) {
            System.out.println("POINT TWO:  " + errors);

            model.addAttribute("errorMsg", "big error business");
            return "user/add";
        } else if (user.getPassword().equals(verify)) {
            return "user/index";
        } else {
            model.addAttribute("errorMsg", "Passwords do not match");
            return "user/add";
        }


    }


}