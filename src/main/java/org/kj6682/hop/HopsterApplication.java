package org.kj6682.hop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HopsterApplication {

    public static void main(String[] args) {
		SpringApplication.run(HopsterApplication.class, args);
	}

    static class HopNotFoundException extends RuntimeException {
        HopNotFoundException(String id) {
            super("could not find documents for '" + id + "'.");
        }

    }//:)

}
