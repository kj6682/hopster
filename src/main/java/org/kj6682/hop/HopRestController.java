package org.kj6682.hop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by luigi on 29/08/16.
 */
@RestController
//@RequestMapping("/hop")
public class HopRestController {

    @Autowired
    HopService hopService;

    @RequestMapping(value = "/hop/{id}", method = RequestMethod.GET)
    public Hop findById(@PathVariable String id) {
        return hopService.findById(id);

    }


    @RequestMapping(value = "/hop", method = RequestMethod.GET)
    public List<Hop> find(@RequestParam(value = "search4me", required = false) String search4me) {

        if (StringUtils.isEmpty(search4me)) {
            return hopService.findAll();
        }

        List<Hop> results = hopService.findByTitle(search4me);
        results.addAll(hopService.findByAuthor(search4me));
        results.addAll(hopService.findByLocation(search4me));
        return new ArrayList<Hop>(new HashSet<Hop>(results));

    }

    @RequestMapping(value = "/hop", method = RequestMethod.POST)
    public void create(@RequestParam(value = "title") String title,
                       @RequestParam(value = "author") String author,
                       @RequestParam(value = "type") String type,
                       @RequestParam(value = "location") String location) {

        hopService.insertOne(title, author, Hop.Type.valueOf(type), location);

    }

    @RequestMapping(value = "/hop/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable String id,
                       @RequestParam(value = "title", defaultValue = "no title") String title,
                       @RequestParam(value = "author", defaultValue = "no author") String author,
                       @RequestParam(value = "type", defaultValue = "BOOK") String type,
                       @RequestParam(value = "location", defaultValue = "nowhere") String location) {

        hopService.replaceOne(id, title, author, Hop.Type.valueOf(type), location);
    }

    @RequestMapping(value = "/hop/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        hopService.delete(id);
    }


}
