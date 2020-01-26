package net.ontopsolutions.components;

import lombok.extern.slf4j.Slf4j;
import net.ontopsolutions.annotation.logging.LogExecutionTime;
import net.ontopsolutions.annotation.uuid.UUID;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class ExampleComponent {

    @PostConstruct
    public void setUp() {
        java.util.UUID x =  java.util.UUID.randomUUID();
        logTime(x.toString());

        logTime("ssjjdd-djjjd--ndññ");

    }

    @LogExecutionTime
    public void logTime(@UUID(message = "Pattern is not valid") String value) {
        log.info("LogTimeExecution...");
        log.info(value);
    }
}
