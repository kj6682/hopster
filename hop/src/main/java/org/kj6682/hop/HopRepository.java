package org.kj6682.hop;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * This is the JPA repository for managing Hops.
 *
 * The Hopster microservice is bound to MongoDb in order to keep thing as simple as possible.
 * In case a different base should be needed, we will provide a specific version of the service
 *
 */
interface HopRepository extends MongoRepository<Hop, String> {

    @Query("{$and:[ {title:{$exists:true}}, {author:{$exists:true}}, {type:{$exists:true}} ]}")
    List<Hop> findAll();

    @Query("{$and:[ { $text: { $search:  ?0  } }, {title:{$exists:true}}, {author:{$exists:true}}, {type:{$exists:true}} ] }")
    List<Hop> searchFor(String search4me);
}