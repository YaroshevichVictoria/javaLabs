package com.company.albums;

import com.company.Date.GregorianDate;
import com.company.albums.elements.Photo;
import com.company.albums.elements.PhotoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class PhotoAlbumTest {
    private PhotoAlbum album = new PhotoAlbum(this.createPhotoArray(), "Someone");
    private PhotoAlbum album2 = new PhotoAlbum(this.createPhotoArray(), "No one");

    public Photo[] createPhotoArray() {
        Photo photo1 = new Photo(11, new GregorianDate(2019, 1, 13).getDate(), "Photo 11");
        Photo photo2 = new Photo(12, new GregorianDate(2013, 2, 15).getDate(), "Photo 12");
        Photo photo3 = new Photo(13, new GregorianDate(2015, 1, 17).getDate(), "Photo 13");
        Photo photo4 = new Photo(14, new GregorianDate(2014, 1, 19).getDate(), "Photo 14");
        Photo photo5 = new Photo(15, new GregorianDate(2020, 1, 24).getDate(), "Photo 15");

        return new Photo[]{photo1, photo2, photo3, photo4, photo5};
    }

    int getHashCode(PhotoAlbum album) {
        int result = 17;
        result = 31 * result + album.getPhotosCount();
        result = 31 * result + album.getArray().hashCode();
        return result;
    }

    String getString(PhotoPage album) {
        return "PhotoPage:" +
                "photosCount: " + album.getPhotosCount() +
                ", array:" + Arrays.toString(album.getArray());
    }

    @Test
    public void testPhotoAlbumEquals() throws Exception {
        Assert.assertEquals(true, album.equals(album));
        Assert.assertEquals(true, album.equals(album2));
    }

    @Test
    public void testPhotoPageHashCode() throws Exception {
        Assert.assertEquals(getHashCode(album), album.hashCode());
    }

    @Test
    public void testPhotoToString() throws Exception {
        Assert.assertEquals(getString(album), album.toString());
    }
}
