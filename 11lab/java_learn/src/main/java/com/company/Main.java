package com.company;
/*
import com.company.Date.GregorianDate;
import com.company.utils.albums.PhotoAlbum;
import com.company.utils.albums.elements.Photo;
import com.company.utils.albums.elements.PhotoPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    static Logger logger = LogManager.getLogger();

    public static Photo createPhoto() throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите год");
        int year = in.nextInt();
        try {
            if (year < 0 || year > 2020) throw new Exception("Год неверно введен");
        } catch (Exception ex){
            logger.error(ex.getMessage());
            System.exit(1);
        } finally {
            logger.info(year);
        }

        System.out.println("Введите месяц");
        int month = in.nextInt();
        try {
            if (month < 0 || month > 11) throw new Exception("Месяц неверно введен");
        } catch (Exception ex){
            logger.error(ex.getMessage());
            System.exit(1);
        } finally {
            logger.info(month);
        }

        System.out.println("Введите день");
        int day = in.nextInt();
        try {
            if (day < 0 || day > 30) throw new Exception("День неверно введен");
        } catch (Exception ex){
            logger.error(ex.getMessage());
            System.exit(1);
        } finally {
            logger.info(day);
        }

        return new Photo(16, new GregorianDate(year, month, day).getDate(), "Photo " + 16);
    }

    public static Photo[] createPhotoArray() throws Exception {
        Photo photo1 = new Photo(11, new GregorianDate(2019, 1, 13).getDate(), "Photo 11");
        Photo photo2 = new Photo(12, new GregorianDate(2013, 2, 15).getDate(), "Photo 12");
        Photo photo3 = new Photo(13, new GregorianDate(2015, 1, 17).getDate(), "Photo 13");
        Photo photo4 = new Photo(14, new GregorianDate(2014, 1, 19).getDate(), "Photo 14");
        Photo photo5 = new Photo(15, new GregorianDate(2020, 1, 24).getDate(), "Photo 15");
        Photo newPhoto = createPhoto();

        return new Photo[]{photo1, photo2, photo3, photo4, photo5, newPhoto};
    }

    public static void checkPhotoClass() {
        Photo photo = new Photo(11, new GregorianDate(2019, 1, 13).getDate(), "Photo 11");
        logger.info(photo.toString());
    }

    public static void checkPhotoPageClass() throws Exception {
        PhotoPage page = new PhotoPage(createPhotoArray(), 1);
        logger.info(page.toString());
    }

    public static void checkPhotoAlbumClass() throws Exception {
        PhotoAlbum album = new PhotoAlbum(createPhotoArray(), "Someone");
        logger.info(album.toString());
    }

    public static void main(String[] args) throws Exception {
        checkPhotoClass();
        checkPhotoPageClass();
        checkPhotoAlbumClass();
    }
}*/


import com.company.exception.MenuException;
import com.company.menu.Menu;
import com.company.utils.flowers.Bouquet;
import com.company.utils.flowers.Flower;
import com.company.utils.flowers.subtropical.bougainvillea.BougainvilleaFlower;
import com.company.utils.flowers.temperate.peonies.Peony;
import com.company.utils.flowers.temperate.roses.Rose;
import com.company.utils.flowers.temperate.roses.YellowRose;

public class Main {
    public static Flower[] getFlowersArr() {
        BougainvilleaFlower bougainvilleaFlower = new BougainvilleaFlower("Bougainvillea glabra", 10, (float) 5.50, false);
        Rose rose = new Rose("Red rose", 7, 2, "red");
        YellowRose yellowRose = new YellowRose("Yellow rose", 6, (float) 3.25);
        Peony peony = new Peony("Paeonia Sarah Bernhardt", 6, (float) 10.15, "pink");
        return new Flower[]{bougainvilleaFlower, rose, yellowRose, peony};
    }

    public static void main(String[] args) throws MenuException {
        Bouquet bouquet = new Bouquet(getFlowersArr());
        Menu menu = new Menu(bouquet);
    }
}
