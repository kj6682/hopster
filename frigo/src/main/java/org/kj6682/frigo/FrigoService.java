package org.kj6682.frigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by luigi on 29/08/16.
 * <p>
 * This class is responsible for serving the "business" of the Frigo model
 * It must be protocol agnostic and bridge the model stored in a repository to the client interface
 */
@Service
class FrigoService {


    @Autowired
    private FrigoRepository frigoRepository;


    Frigo findById(String id) {
        return frigoRepository.findOne(id);

    }

    List<Frigo> findAll() {
        return frigoRepository.findAll();
    }


    List<Frigo> find(String search4me) {

        return frigoRepository.findAll();

      }

    void insertOne(String name, LocalDate since, LocalDate bestBefore, Integer quantity, String location) {
        Frigo frigo = new Frigo();
        frigo.setName(name);
        frigo.setSince(since);
        frigo.setBestBefore(bestBefore);
        frigo.setQuantity(quantity);
        frigo.setLocation(location);
        frigoRepository.save(frigo);
    }

    void replaceOne(String id, String name, LocalDate since, LocalDate bestBefore, Integer quantity, String location) {
        Frigo frigo = frigoRepository.findOne(id);
        frigo.setName(name);
        frigo.setSince(since);
        frigo.setBestBefore(bestBefore);
        frigo.setQuantity(quantity);
        frigo.setLocation(location);
        frigoRepository.save(frigo);
    }

    void delete(String id) {
        frigoRepository.delete(id);
    }
}//:)

