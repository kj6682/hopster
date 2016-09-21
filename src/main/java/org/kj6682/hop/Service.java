package org.kj6682.hop;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * Created by luigi on 29/08/16.
 */
@org.springframework.stereotype.Service
class Service {

    static interface AbstractRepository {
        public Hop findOne(String id);
        public List<Hop> searchFor(String text);
        public List<Hop> findAll();
        public Hop save(Hop hop);
        public void delete(String id);

    }

    @Autowired
    private AbstractRepository hopRepository;

    public Hop findById(String id) {
        return hopRepository.findOne(id);

    }

    public List<Hop> findAll() {
        return hopRepository.findAll();
    }


    public List<Hop> find(String search4me) {
       return hopRepository.searchFor(search4me);
    }

    public void insertOne(String title, String author, String type, String location) {
        Hop hop = new Hop();
        hop.setTitle(title);
        hop.setAuthor(author);
        hop.setType(type);
        hop.setLocation(location);
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

