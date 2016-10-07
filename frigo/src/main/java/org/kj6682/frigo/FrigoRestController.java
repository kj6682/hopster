package org.kj6682.frigo;

import io.swagger.annotations.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by luigi on 29/08/16.
 * <p>
 * As its names states clearly, this class is the RestController for the Katering application.
 * In case the Frigo microservice should provide also other interfaces, by mvc and templates for instance,
 * we will provide the appropriated controller.
 * <p>
 * This class wraps the service and exposes it in a defined protocol to clients.
 * <p>
 * No business logic must be implemented in this class.
 * <p>
 * It is not necessary to expose this class as public, so keep it package private.
 */
@RestController
class FrigoRestController {

    @Autowired
    private FrigoService frigoService;


    @GetMapping(value = "/frigo/{id}")
    Frigo findById(@PathVariable String id) {
        return frigoService.findById(id);

    }


    @GetMapping(value = "/frigo")
    List<Frigo> find(@RequestParam(value = "search4me", required = false) String search4me) {

        return frigoService.find(search4me);

    }


    @PostMapping(value = "/frigo")
    void create(@RequestParam(value = "name") String title,
                @RequestParam(value = "since") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate since,
                @RequestParam(value = "bestBefore") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bestBefore,
                @RequestParam(value = "quantity", defaultValue = "1") Integer quantity,
                @RequestParam(value = "location") String location) {

        frigoService.insertOne(title, since, bestBefore, quantity, location);

    }

    @PutMapping(value = "/frigo/{id}")
    void update(@PathVariable String id,
                @RequestParam(value = "name", defaultValue = "no name") String name,
                @RequestParam(value = "since") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate since,
                @RequestParam(value = "bestBefore") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bestBefore,
                @RequestParam(value = "quantity", defaultValue = "1") Integer quantity,
                @RequestParam(value = "location", defaultValue = "nowhere") String location) {

        frigoService.replaceOne(id, name, since, bestBefore, quantity, location);
    }

    @DeleteMapping(value = "/frigo/{id}")
    void delete(@PathVariable String id) {
        frigoService.delete(id);
    }

}
