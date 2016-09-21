package org.kj6682.hop;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by luigi on 29/08/16.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private Service hopService;

    public RestController(Service hopService) {
        this.hopService = hopService;
    }

    @GetMapping(value = "/hop/{id}")
    public Hop findById(@PathVariable String id) {
        return hopService.findById(id);

    }


    @GetMapping(value = "/hop")
    public List<Hop> find(@RequestParam(value = "search4me", required = false) String search4me) {

        if (StringUtils.isEmpty(search4me)) {
            return hopService.findAll();
        }

        return hopService.find(search4me);

    }

    @PostMapping(value = "/hop")
    public void create(@RequestParam(value = "title") String title,
                       @RequestParam(value = "author") String author,
                       @RequestParam(value = "type") String type,
                       @RequestParam(value = "location") String location) {

        hopService.insertOne(title, author, type, location);

    }

    @PutMapping(value = "/hop/{id}")
    public void update(@PathVariable String id,
                       @RequestParam(value = "title", defaultValue = "no title") String title,
                       @RequestParam(value = "author", defaultValue = "no author") String author,
                       @RequestParam(value = "type", defaultValue = "BOOK") String type,
                       @RequestParam(value = "location", defaultValue = "nowhere") String location) {

        hopService.replaceOne(id, title, author, type, location);
    }

    @DeleteMapping(value = "/hop/{id}")
    public void delete(@PathVariable String id) {
        hopService.delete(id);
    }


}
