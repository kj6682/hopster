package org.kj6682.hop;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.text;

/**
 * Created by luigi on 29/08/16.
 */
class HopServiceMongoImpl implements HopService {

    @Autowired
    private final MongoCollection<Document> hopCollection;


    public HopServiceMongoImpl(MongoCollection hopCollection) {
        this.hopCollection = hopCollection;
    }

    @Override
    public void insertOne(String title, String author, Hop.Type type, String location) {
        Document hop = new Document();

        hop.append("author", author)
                .append("title", title)
                .append("type", type.toString())
                .append("location", location);

        hopCollection.insertOne(hop);

    }

    @Override
    public Hop findById(String id) throws HopsterApplication.HopNotFoundException {
        try {
            Document document = hopCollection.find(eq("_id", new ObjectId(id))).first();
            Hop hop = new Hop(document.get("_id").toString(),
                    document.get("title").toString(),
                    document.get("author").toString(),
                    Hop.Type.valueOf(document.get("type").toString()),
                    document.get("location").toString());

            return hop;
        } catch (Throwable Th) {
            throw new HopsterApplication.HopNotFoundException(id);
        }
    }

    @Override
    public List<Hop> findAll() {

        return getHops(null);
    }

    private void makeHop(Document document, List<Hop> result) {
        try {
            Hop hop = new Hop(document.get("_id").toString(),
                    document.get("title").toString(),
                    document.get("author").toString(),
                    Hop.Type.valueOf(document.get("type").toString()),
                    document.get("location").toString());
            result.add(hop);
        } catch (NullPointerException np) {
            System.out.println(String.format("Problems with mandatory attributes for document : %s", document.toString()));
        }
    }

    @Override
    public List<Hop> findByTitle(String title) {
        return getHops(text(title));
    }

    private List<Hop> getHops(Bson query) {
        List<Hop> result = new LinkedList<>();
        FindIterable<Document> iterable;
        if(query == null){

            iterable = hopCollection.find();

        }else{

            iterable = hopCollection.find(query);
        }
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                makeHop(document, result);
            }
        });
        return result;
    }

    @Override
    public List<Hop> findByAuthor(String author) {
        return getHops(text(author));
    }

    @Override
    public List<Hop> findByLocation(String location) {
        return getHops(text(location));
    }


    @Override
    public void replaceOne(String id, String title, String author, Hop.Type type, String location) throws HopsterApplication.HopNotFoundException {
        Document hop = new Document();

        hop.append("author", author)
                .append("title", title)
                .append("type", type.toString())
                .append("location", location);

        UpdateResult updateResult = hopCollection.replaceOne(eq("_id", new ObjectId(id)), hop);

        if (updateResult.getModifiedCount() == 0) {

            throw new HopsterApplication.HopNotFoundException(id);
        }
    }

    @Override
    public void delete(String id) throws HopsterApplication.HopNotFoundException {
        DeleteResult deleteResult = hopCollection.deleteOne(eq("_id", new ObjectId(id)));

        if (deleteResult.getDeletedCount() == 0) {

            throw new HopsterApplication.HopNotFoundException(id);
        }
    }


}
