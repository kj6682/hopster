package org.kj6682.hop;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by luigi on 29/08/16.
 *
 * As its names states clearly, this class is the RestController for the Hop application.
 * In case the hopster microservice should provide also other interfaces, by mvc and templates for instance,
 * we will provide the appropriated controller.
 *
 * This class wraps the service and exposes it in a defined protocol to clients.
 *
 * No business logic must be implemented in this class.
 *
 * It is not necessary to expose this class as public, so keep it package private.
 */
@RestController
class HopRestController {

    private HopService hopService;

    HopRestController(HopService hopService) {
        this.hopService = hopService;
    }

    @GetMapping(value = "/hop/{id}")
    Hop findById(@PathVariable String id) {
        return hopService.findById(id);

    }


    @GetMapping(value = "/hop")
    List<Hop> find(@RequestParam(value = "search4me", required = false) String search4me) {

        return hopService.find(search4me);

    }

    @PostMapping(value = "/hop")
    void create(@RequestParam(value = "title") String title,
                       @RequestParam(value = "author") String author,
                       @RequestParam(value = "type") String type,
                       @RequestParam(value = "location") String location) {

        hopService.insertOne(title, author, type, location);

    }

    @PutMapping(value = "/hop/{id}")
    void update(@PathVariable String id,
                       @RequestParam(value = "title", defaultValue = "no title") String title,
                       @RequestParam(value = "author", defaultValue = "no author") String author,
                       @RequestParam(value = "type", defaultValue = "BOOK") String type,
                       @RequestParam(value = "location", defaultValue = "nowhere") String location) {

        hopService.replaceOne(id, title, author, type, location);
    }

    @DeleteMapping(value = "/hop/{id}")
    void delete(@PathVariable String id) {
        hopService.delete(id);
    }

}
