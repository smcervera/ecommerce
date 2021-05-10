package com.capitole.ecommerce.entrypoints;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthCheckController {

    private final Map<String, String> RESPONSE = ImmutableMap.of("response", "ok");

    @GetMapping("/")
    public Map<String, String> healthCheck() {
        return RESPONSE;
    }
}
