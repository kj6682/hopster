package org.kj6682.frigo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by luigi on 07/10/2016.
 */
@RestController
public class DeprecatedFrigoRestController {
    @GetMapping(value = "/frigo", headers = "frigo.version=v0")
    ResponseEntity<List<Frigo>> findVeryOldVersion(@RequestParam(value = "search4me", required = false) String search4me) {

        throw new UnsupportedOperationException("sorry mate, this operation is no more supported.");
    }

}
