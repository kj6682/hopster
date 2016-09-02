package org.kj6682.hop;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HopRepository extends MongoRepository<Hop, String> {

    List<Hop> findAllBy(TextCriteria criteria);

}