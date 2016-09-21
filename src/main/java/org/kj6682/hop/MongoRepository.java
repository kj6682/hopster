package org.kj6682.hop;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.Query;

@Profile("mongo")
interface MongoRepository extends org.springframework.data.mongodb.repository.MongoRepository<Hop, String>,
                                  Service.AbstractRepository {

    @Query("{$and:[ {title:{$exists:true}}, {author:{$exists:true}}, {type:{$exists:true}} ]}")
    List<Hop> findAll();

    @Query("{$and:[ { $text: { $search:  ?0  } }, {title:{$exists:true}}, {author:{$exists:true}}, {type:{$exists:true}} ] }")
    List<Hop> searchFor(String search4me);
}