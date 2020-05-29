package com.company.albums.elements;

import com.company.Date.GregorianDate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhotoTest {
    private Photo photo = new Photo(1, new GregorianDate(2018, 0, 20).getDate(), "First photo");
    private Photo photo2 = new Photo(2, new GregorianDate(2019, 3, 23).getDate(), "Second photo");

    int getHashCode(Photo photo) {
        int result = 17;
        result = 31 * result + photo.getId();
        result = 31 * result + photo.getDate().hashCode();
        result = 31 * result + photo.getName().hashCode();
        return result;
    }

    String getString(Photo photo) {
        return "\nPhoto №" + photo.getId() +
                "\ndate: " + photo.getDate() +
                "\nname: '" + photo.getName();
    }

    @Test
    public void testGetName() throws Exception {
        String name = "First photo";
        Assert.assertEquals(name, photo.getName());
    }

    @Test
    public void testPhotoEquals() throws Exception {
        Assert.assertEquals(true, photo.equals(photo));
        Assert.assertEquals(false, photo.equals(photo2));
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(getHashCode(photo), photo.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertEquals(getString(photo), photo.toString());
    }
}

