package com.milkyway.dreamform.controller;

import com.milkyway.dreamform.dto.ProfileDto;
import com.milkyway.dreamform.security.UserDetailsImpl;
import com.milkyway.dreamform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProfileController {
    @Autowired UserService userService;

    @GetMapping("/profile")
        public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("password", userDetails.getPassword());
        model.addAttribute("email", userDetails.getEmial());
        return "profile";
        }
    @PostMapping("/profile/pwupdate")
        public String pwupdate(ProfileDto pw){

            userService.pwupdate(pw);
        return "/user/logout";
        }
}
