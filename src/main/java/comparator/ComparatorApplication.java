package comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.invoke.MethodHandles;

@SpringBootApplication
public class ComparatorApplication {
    private static final Logger log = LogManager.getLogger(MethodHandles.Lookup.class);

    public static void main(String[] args) {
        SpringApplication.run(ComparatorApplication.class, args);
        log.info("Testing log which informs that Comparator Application has started successfully.");
    }
}