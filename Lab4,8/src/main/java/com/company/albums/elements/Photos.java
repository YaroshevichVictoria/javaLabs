package com.company.albums.elements;

import java.util.ArrayList;
import java.util.List;

public class Photos {
    protected int photosCount;
    protected Photo[] photoArray;

    public Photos(Photo[] photoArray) {
        this.photoArray = photoArray;
        this.photosCount = photoArray.length;
    }

    public void add(Photo photoToAdd) {
        this.photosCount += 1;

        List<Photo> photoList = new ArrayList<Photo>();
        photoList.add(photoToAdd);

        photoList.toArray(this.photoArray);
    }

    public int getPhotosCount() {
        return this.photosCount;
    }

    public Photo[] getArray() {
        return this.photoArray;
    }
}
