package org.kj6682.hop;

import org.bson.Document;

import java.util.List;

/**
 * Created by luigi on 29/08/16.
 */
interface HopService {

    //Create
    void insertOne(String title, String author, Hop.Type type, String location);

    //Read
    Hop findById(String id) throws HopsterApplication.HopNotFoundException;
    List<Hop> findAll();
    List<Hop> findByTitle(String title);
    List<Hop> findByAuthor(String author);
    List<Hop> findByLocation(String location);


    //Update
    void replaceOne(String id, String title, String author, Hop.Type type, String location) throws HopsterApplication.HopNotFoundException;

    //Delete
    void delete(String id) throws HopsterApplication.HopNotFoundException;


}
