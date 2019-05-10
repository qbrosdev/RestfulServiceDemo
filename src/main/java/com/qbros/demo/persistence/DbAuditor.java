package com.qbros.demo.persistence;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public class DbAuditor  implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Default Auditor");
    }
}
