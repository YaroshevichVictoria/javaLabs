package com.company.albums.elements;

import java.util.Date;

public class Photo {
    private int id;
    private Date date;
    private String name;

    public Photo(int id, Date date, String name) {
        this.id = id;
        this.date = date;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String description) {
        this.name = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return getId() == photo.getId() &&
                getDate().equals(photo.getDate()) &&
                getName().equals(photo.getName());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.id;
        result = 31 * result + this.date.hashCode();
        result = 31 * result + this.name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\nPhoto №" + id +
                "\ndate: " + date +
                "\nname: '" + name;
    }
}
