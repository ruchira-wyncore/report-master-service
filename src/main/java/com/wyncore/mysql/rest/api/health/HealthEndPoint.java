package com.wyncore.mysql.rest.api.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * This class creates a custom health check end point for springboot application.
 *
 */
@Component
public class HealthEndPoint implements org.springframework.boot.actuate.health.HealthIndicator {


    /**
     * Overriding the constructor of HealthIndicator to return health status.
     * Currently if end point is up, it will simply return status up.Going forward
     * when the complexity of application increases the health will be dependent on health of
     * all its associated databases which are connected to it.
     * @return Health: status of the application.Currently always return healthy if application is up.
     */
    @Override
    public Health health() {
        return Health.status("Healthy.").build();
    }

}
