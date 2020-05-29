package com.company;
/*
import com.company.Date.GregorianDate;
import com.company.albums.PhotoAlbum;
import com.company.albums.elements.Photo;
import com.company.albums.elements.PhotoPage;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public Main() throws IOException {
    }

    public static Photo createPhoto() throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите год");
        int year = in.nextInt();
        try {
            if (year < 1000 || year > 2020) throw new Exception("Год неверно введен");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());

        } finally {
            System.out.println(year);
        }

        System.out.println("Введите месяц");
        int month = in.nextInt();
        try {
            if (month < 1 || month > 11) throw new Exception("Месяц неверно введен");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        } finally {
            System.out.println(month);
        }

        System.out.println("Введите день");
        int day = in.nextInt();
        try {
            if (day < 1 || day > 30) throw new Exception("День неверно введен");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        } finally {
            System.out.println(day);
        }

        return new Photo(16, new GregorianDate(year, month, day).getDate(), "Photo " + 6);

        // ЗАПИСЬ И СЧИТЫВАНИЕ ИЗ ФАЙЛА
        try (
                FileWriter writer = new FileWriter("notes3.txt", false)) {
            String text = "40";
            writer.write(text);
        } catch (
                IOException ex) {

            System.out.println(ex.getMessage() + "Файла нет");
        }

        int a = 0;
        try (
                FileReader reader = new FileReader("notes3.txt")) {
            a = reader.read();
        } catch (IOException ex) {

            System.out.println(ex.getMessage() + "Файла нет");
        }
    }



    public static Photo[] createPhotoArray() throws Exception {
        Photo photo1 = new Photo(1, new GregorianDate(2019, 1, 13).getDate(), "Photo 1");
        Photo photo2 = new Photo(2, new GregorianDate(2013, 2, 15).getDate(), "Photo 2");
        Photo photo3 = new Photo(3, new GregorianDate(2015, 1, 17).getDate(), "Photo 3");
        Photo photo4 = new Photo(4, new GregorianDate(2014, 1, 19).getDate(), "Photo 4");
        Photo photo5 = new Photo(5, new GregorianDate(2020, 1, 24).getDate(), "Photo 5");
        Photo newPhoto = createPhoto();

        return new Photo[]{photo1, photo2, photo3, photo4, photo5, newPhoto};
    }

    public static void checkPhotoClass() {
        Photo photo = new Photo(1, new GregorianDate(2019, 1, 13).getDate(), "Photo 1");
        System.out.println(photo.toString());
    }

    public static void checkPhotoPageClass() throws Exception {
        PhotoPage page = new PhotoPage(createPhotoArray(), 1);
        System.out.println(page.toString());
    }

    public static void checkPhotoAlbumClass() throws Exception {
        PhotoAlbum album = new PhotoAlbum(createPhotoArray(), "Someone");
        System.out.println(album.toString());
    }

    public static void main(String[] args) throws Exception {
        checkPhotoClass();
        checkPhotoPageClass();
        checkPhotoAlbumClass();
    }
}
*/
import com.company.exceptions.MenuException;
import com.company.flowers.Bouquet;
import com.company.flowers.Flower;
import com.company.flowers.subtropical.bougainvillea.BougainvilleaFlower;
import com.company.flowers.temperate.peonies.Peony;
import com.company.flowers.temperate.roses.Rose;
import com.company.flowers.temperate.roses.YellowRose;

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
