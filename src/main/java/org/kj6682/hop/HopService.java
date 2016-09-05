package org.kj6682.hop;

import org.springframework.beans.factory.annotation.Autowired;
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

