package ru.netology.ntlg_hw_springboot_conditional.classes;

import ru.netology.ntlg_hw_springboot_conditional.intrfaces.SystemProfile;

public class ProductionProfile implements SystemProfile {

    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
