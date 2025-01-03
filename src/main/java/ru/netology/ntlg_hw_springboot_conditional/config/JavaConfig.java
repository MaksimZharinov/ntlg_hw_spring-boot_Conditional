package ru.netology.ntlg_hw_springboot_conditional.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.ntlg_hw_springboot_conditional.classes.DevProfile;
import ru.netology.ntlg_hw_springboot_conditional.classes.ProductionProfile;
import ru.netology.ntlg_hw_springboot_conditional.intrfaces.SystemProfile;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
