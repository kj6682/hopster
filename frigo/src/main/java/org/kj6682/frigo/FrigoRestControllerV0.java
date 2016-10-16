package org.kj6682.frigo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by luigi on 07/10/2016.
 */
@ApiV0
@RestController
public class FrigoRestControllerV0 {
    @ApiParam()
    @ApiImplicitParams({@ApiImplicitParam(name = "frigo.version", required = true, dataType = "string", paramType = "header")})
    @GetMapping(value = "/frigo", headers = "frigo.version=v0")
    ResponseEntity<List<Frigo>> findVeryOldVersion(@RequestParam(value = "search4me", required = false) String search4me) {

        throw new UnsupportedOperationException("sorry mate, this operation is no more supported.");
    }

}
