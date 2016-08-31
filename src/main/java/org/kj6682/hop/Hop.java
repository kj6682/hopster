package org.kj6682.hop;

/**
 * Created by luigi on 26/08/16.
 *
 * This model object guarantees the minimal required information per document on the server side.
 *
 *
 */
class Hop {

    static enum Type {
        AUDIO, BOOK, MOVIE;
    }

    private final String _id;

    private final String title;

    private final String author;

    private final Type type;

    private final String location;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hop)) return false;

        Hop hop = (Hop) o;

        if (get_id() != null ? !get_id().equals(hop.get_id()) : hop.get_id() != null) return false;
        if (getTitle() != null ? !getTitle().equals(hop.getTitle()) : hop.getTitle() != null) return false;
        if (getAuthor() != null ? !getAuthor().equals(hop.getAuthor()) : hop.getAuthor() != null) return false;
        if (getType() != hop.getType()) return false;
        return getLocation() != null ? getLocation().equals(hop.getLocation()) : hop.getLocation() == null;

    }

    @Override
    public int hashCode() {
        int result = get_id() != null ? get_id().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        return result;
    }

    public Hop(String _id, String title, String author, Type type, String location) {
        this._id = _id;
        this.title = title;
        this.author = author;
        this.type = type;

        this.location = location;
    }

    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Type getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }
}
