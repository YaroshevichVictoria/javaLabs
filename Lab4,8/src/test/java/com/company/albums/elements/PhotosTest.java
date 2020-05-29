package com.company.albums.elements;

import com.company.Date.GregorianDate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhotosTest {
    private Photos photos = new Photos(this.createPhotoArray());

    public Photo[] createPhotoArray() {
        Photo photo1 = new Photo(11, new GregorianDate(2019, 1, 13).getDate(), "Photo 11");
        Photo photo2 = new Photo(12, new GregorianDate(2013, 2, 15).getDate(), "Photo 12");
        Photo photo3 = new Photo(13, new GregorianDate(2015, 1, 17).getDate(), "Photo 13");
        Photo photo4 = new Photo(14, new GregorianDate(2014, 1, 19).getDate(), "Photo 14");
        Photo photo5 = new Photo(15, new GregorianDate(2020, 1, 24).getDate(), "Photo 15");

        return new Photo[]{photo1, photo2, photo3, photo4, photo5};
    }

    @Test
    public void addTest() throws Exception {
        int length = photos.getPhotosCount();
        photos.add(new Photo(11, new GregorianDate(2019, 1, 13).getDate(), "Photo 11"));
        int newLength = photos.getPhotosCount();

        Assert.assertEquals(length + 1, newLength);
    }
}
