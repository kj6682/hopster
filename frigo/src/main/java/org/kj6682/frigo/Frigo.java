package org.kj6682.frigo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import java.time.LocalDate;

/**
 * Created by luigi on 26/08/16.
 *
 * This model object guarantees the minimal required information per document on the server side.
 *
 * MongoDB stores data in collections.
 * Spring Data MongoDB will map the class Hop into a collection called hop.
 * If you want to change the name of the collection, you can use
 * Spring Data MongoDB’s @Document annotation on the class.
 */

@Document(collection = "frigo")
class Frigo {

    static enum Type {
        DRINK, EDIBLE, USELESS;
    }

    @Id
    private String id;

    @TextIndexed
    private String name;

    @TextIndexed
    private  String location;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate since;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate bestBefore;

    private Integer quantity;

    public void setId(String id) {
        Assert.hasLength(id, "id must not be empty");
        this.id = id;
    }

    public void setLocation(String location) {
        Assert.hasLength(location, "A Hop is needless without a location");
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public LocalDate getSince() {
        return since;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}//:)
