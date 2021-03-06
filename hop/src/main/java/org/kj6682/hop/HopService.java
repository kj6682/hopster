package org.kj6682.hop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.List;

/**
 * Created by luigi on 29/08/16.
 *
 * This class is responsible for serving the "business" of the Hop model
 * It must be protocol agnostic and bridge the model stored in a repository to the client interface
 *
 */
@Service
class HopService {


    private HopRepository hopRepository;

    @Autowired
    void setHopRepository(HopRepository hopRepository){
        this.hopRepository = hopRepository;
    }
    Hop findById(String id) {
        return hopRepository.findOne(id);

    }

    List<Hop> findAll() {
        return hopRepository.findAll();
    }


    List<Hop> find(String search4me) {

        if (StringUtils.isEmpty(search4me)) {
            return hopRepository.findAll();
        }

        return hopRepository.searchFor(search4me);
    }

    void insertOne(String title, String author, String type, String location) {
        Hop hop = new Hop();
        hop.setTitle(title);
        hop.setAuthor(author);
        hop.setType(type);
        hop.setLocation(location);
        hopRepository.save(hop);
    }

    void replaceOne(String id, String title, String author, String type, String location) {
        Hop hop = hopRepository.findOne(id);
        hop.setTitle(title);
        hop.setAuthor(author);
        hop.setType(type);
        hop.setLocation(location);
        hopRepository.save(hop);
    }

    void delete(String id) {
        hopRepository.delete(id);
    }
}//:)

