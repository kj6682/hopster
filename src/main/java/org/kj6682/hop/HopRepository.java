package org.kj6682.hop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface HopRepository extends MongoRepository<Hop, String> {

    @Query("{$and:[ {title:{$exists:true}}, {author:{$exists:true}}, {type:{$exists:true}} ]}")
    List<Hop> findAll();

    @Query("{$and:[ { $text: { $search:  ?0  } }, {title:{$exists:true}}, {author:{$exists:true}}, {type:{$exists:true}} ] }")
    List<Hop> searchFor(String search4me);
}