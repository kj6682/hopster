package org.kj6682.frigo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by luigi on 07/10/2016.
 */
@ApiV2
@RestController
public class FrigoRestControllerV2 {

    @Autowired
    private FrigoService frigoService;

    /**
     * In order to use this demo method for vesioning with custom headers, try :
     *
     * curl --header "frigo.version:v2" "http://localhost:8081/frigo
     *
     *
     * @param search4me
     * @return
     */
    @ApiImplicitParams({@ApiImplicitParam(name = "frigo.version", required = true, dataType = "string", paramType = "header")})
    @GetMapping(value = "/frigo", headers = "frigo.version=v2")
    ResponseEntity<List<Frigo>> findWithHeaders(@RequestParam(value = "search4me", required = false) String search4me) {

        HttpHeaders headers = new HttpHeaders();
        List<MediaType> l = new LinkedList<MediaType>();

        headers.set("frigo.version","v2");

        Frigo dummyFrigo = new Frigo();
        dummyFrigo.setId("*** dummy frigo idem ***");
        dummyFrigo.setName("This instance is accessible only in version 2");
        dummyFrigo.setQuantity(0);
        dummyFrigo.setBestBefore(LocalDate.MAX);
        dummyFrigo.setSince(LocalDate.now());
        List<Frigo> frigos = frigoService.find(search4me);
        frigos.add(dummyFrigo);

        return new ResponseEntity<List<Frigo>>(frigos, headers, HttpStatus.OK);

    }
}
