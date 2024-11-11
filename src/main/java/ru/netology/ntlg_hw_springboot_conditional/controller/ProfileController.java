package ru.netology.ntlg_hw_springboot_conditional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.ntlg_hw_springboot_conditional.intrfaces.SystemProfile;

@RestController
@RequestMapping("/")
public class ProfileController {

    private SystemProfile profile;

    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("profile")
    public String getProfile() {
        return profile.getProfile();
    }
}
