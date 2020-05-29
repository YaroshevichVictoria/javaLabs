package com.company.albums;

import com.company.albums.elements.Photo;
import com.company.albums.elements.PhotoPage;

import java.util.Arrays;

public class PhotoAlbum extends PhotoPage {
    private String author;

    public PhotoAlbum(Photo[] photoArray, String author) {
        super(photoArray);
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public int getPhotosCount() {
        return photosCount;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotoAlbum)) return false;
        if (!super.equals(o)) return false;
        PhotoAlbum that = (PhotoAlbum) o;
        return getPhotosCount() == that.getPhotosCount();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.photosCount;
        result = 31 * result + Arrays.hashCode(this.photoArray);
        return result;
    }
}
