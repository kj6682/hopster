package org.kj6682.hop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by luigi on 29/08/16.
 */
@Service
class HopService {

    @Autowired
    private HopRepository hopRepository;

    public Hop findById(String id) {
        return hopRepository.findOne(id);
    }

    public List<Hop> findAll() {
        return hopRepository.findAll();
    }


    public List<Hop> find(String search4me) {
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(search4me);
        return hopRepository.findAllBy(criteria);
    }

    public void insertOne(Hop hop) {
        hopRepository.save(hop);
    }

    public void replaceOne(String id, String title, String author, String type, String location) {
        Hop hop = hopRepository.findOne(id);
        hop.setTitle(title);
        hop.setAuthor(author);
        hop.setType(type);
        hop.setLocation(location);
        hopRepository.save(hop);
    }

    public void delete(String id) {
        hopRepository.delete(id);
    }
}//:) JPA

