package com.company.albums.elements;

import java.util.Arrays;

public class PhotoPage extends Photos {
    private int id;

    public PhotoPage(Photo[] photoArray, int id) {
        super(photoArray);
        this.id = id;
    }

    public PhotoPage(Photo[] photoArray) {
        super(photoArray);
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void add(Photo photoToAdd) {
        super.add(photoToAdd);
    }

    @Override
    public int getPhotosCount() {
        return photosCount;
    }

    @Override
    public Photo[] getArray() {
        return super.getArray();
    }

    @Override
    public String toString() {
        return "PhotoPage:" +
                "photosCount: " + photosCount +
                ", array:" + Arrays.toString(photoArray);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhotoPage)) return false;
        PhotoPage photoPage = (PhotoPage) o;
        return getPhotosCount() == photoPage.getPhotosCount() &&
                Arrays.equals(photoArray, photoPage.photoArray);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.photosCount;
        result = 31 * result + this.photoArray.hashCode();
        return result;
    }
}
