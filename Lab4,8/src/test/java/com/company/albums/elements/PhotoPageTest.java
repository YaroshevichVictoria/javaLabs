package com.company.albums.elements;

import com.company.Date.GregorianDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class PhotoPageTest {
    private PhotoPage page = new PhotoPage(this.createPhotoArray(),1);
    private PhotoPage page2 = new PhotoPage(this.createPhotoArray(),2);

    public Photo[] createPhotoArray() {
        Photo photo1 = new Photo(11, new GregorianDate(2019, 1, 13).getDate(), "Photo 11");
        Photo photo2 = new Photo(12, new GregorianDate(2013, 2, 15).getDate(), "Photo 12");
        Photo photo3 = new Photo(13, new GregorianDate(2015, 1, 17).getDate(), "Photo 13");
        Photo photo4 = new Photo(14, new GregorianDate(2014, 1, 19).getDate(), "Photo 14");
        Photo photo5 = new Photo(15, new GregorianDate(2020, 1, 24).getDate(), "Photo 15");

        return new Photo[]{photo1, photo2, photo3, photo4, photo5};
    }

    int getHashCode(PhotoPage page) {
        int result = 17;
        result = 31 * result + page.getPhotosCount();
        result = 31 * result + page.getArray().hashCode();
        return result;
    }

    String getString(PhotoPage page) {
        return "PhotoPage:" +
                "photosCount: " + page.getPhotosCount() +
                ", array:" + Arrays.toString(page.getArray());
    }

    @Test
    public void testPhotoPageEquals() throws Exception {
        Assert.assertEquals(true, page.equals(page));
        Assert.assertEquals(true, page.equals(page2));
    }

    @Test
    public void testPhotoPageHashCode() throws Exception {
        Assert.assertEquals(getHashCode(page), page.hashCode());
    }

    @Test
    public void testPhotoToString() throws Exception {
        Assert.assertEquals(getString(page), page.toString());
    }
}
