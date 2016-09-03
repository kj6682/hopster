package org.kj6682.hop;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by luigi on 29/08/16.
 */
@Service
class HopService {

    @Autowired
    private HopRepository hopRepository;
    @Autowired
    MongoOperations operations;

    public Hop findById(String id) {
        return hopRepository.findOne(id);
    }

    public List<Hop> findAll() {
        //return hopRepository.findAll();
        List<Hop> hops = new LinkedList<>();
        DBCursor cursor = operations.getCollection("hop")
                .find(new BasicDBObject());

        try {
            while (cursor.hasNext()) {

                DBObject dbo = cursor.next();
                try {
                    Hop hop = new Hop();
                    hop.setId(dbo.get("_id").toString());
                    hop.setTitle(dbo.get("title").toString());
                    hop.setAuthor(dbo.get("author").toString());
                    hop.setType(dbo.get("type").toString());
                    hop.setLocation(dbo.get("location").toString());
                    hops.add(hop);
                } catch (Throwable t) {
                    //just skip this element
                    System.out.println(t);
                }

            }
        } finally {
            cursor.close();
        }
        return hops;

    }


    public List<Hop> find(String search4me) {
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(search4me);
        return hopRepository.findAllBy(criteria);
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

