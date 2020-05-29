/*  Phone: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Дебет, Кредит, Время городских и междугородных разговоров.
Создать массив объектов. Вывести:
 a) сведения об абонентах, у которых время внутригородских разговоров превышает заданное;
 b) сведения об абонентах, которые пользовались междугородной связью;
 c) сведения об абонентах в алфавитном порядке.*/

import java.util.*;
import java.util.Scanner;
public class ThirdLab {
    public static void main(String[] args) {
        Data phonebook = new Data("PhoneBook");
        phonebook.addPhoneToPhoneList(new Phone("Николай", "Николаевич", "Николаев", "Москва", 12_34_56_78, 20000, 30000, 300, 400));
        phonebook.addPhoneToPhoneList(new Phone("Петр", "Петрович", "Петров", "Алтай", 22_33_44_55, 5, 150000, 789, 546));
        phonebook.addPhoneToPhoneList(new Phone("Иван", "Иванович", "Иванов", "Крым", 66_77_88_99, 70000, 30000, 1234, 0));
        System.out.print("Введите,чтобы получить:\n 1 -  сведения об абонентах, у которых время внутригородских разговоров превышает заданное\n 2 - сведения об абонентах, которые пользовались междугородной связью\n 3 - сведения об абонентах в алфавитном порядке\n");
        while(true){
            Scanner in = new Scanner(System.in);
           int  type = in.nextInt();
            switch (type) {
                case 1:
                    System.out.println("\nСведения об абонентах, у которых время внутригородских разговоров превышает лимит:");
                    List<Phone> listSortByLimit = phonebook.getListByLimit();
                    for (Phone a : listSortByLimit) {
                        System.out.println(a);
                    }
                    break;
                case 2:
                    System.out.println("\nСведения об абонентах, которые пользовались междугородной связью:");
                    List<Phone> listSortByOutCityTime = phonebook.getListByOutCityTime();
                    for (Phone b : listSortByOutCityTime) {
                        System.out.println(b);
                    }
                    break;
                case 3:
                    System.out.println("\nСведения об абонентах в алфавитном порядке:");
                    List<Phone> listSortBySurname = phonebook.getListBySurname();
                    for (Phone c : listSortBySurname) {
                        System.out.println(c);
                    }
                    break;
            }
        }

    }
}
class Phone {
    {
        client++;
    }

    private static int client = 0;
    private int id = client;
    private String name;
    private String patronymic;
    private String surname;
    private String address;
    private int creditNumber;
    private int debit;
    private int credit;
    private int inCityTime;
    private int outCityTime;
    //заполнение
    Phone(String name, String patronymic, String surname, String address, int creditNumber, int debit, int credit, int inCityTime, int outCityTime) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.address = address;
        this.creditNumber = creditNumber;
        this.debit = debit;
        this.credit = credit;
        this.inCityTime = inCityTime;
        this.outCityTime = outCityTime;
    }

    public int setInCityTime(int a) {
        return a;
    }
    public String getSurname() {
        return surname;
    }
    public int getInCityTime() {
        return inCityTime;
    }
    public int getOutCityTime() {
        return outCityTime;
    }
    //вернуть строку вывода
    public String toString() {
        return String.format("ID: %d\t Имя: %s\t Отчество: %s\t Фамилия: %s\t Адрес: %s\t Номер кредитки: %d\t Дебет: %d\t Кредит: %d\t Внутригородское время звонков: %d\t Межгородское время звонков: %d",
                id, name, patronymic, surname, address, creditNumber, debit, credit, inCityTime, outCityTime);
    }
}
class Data {

    //ArrayList
    private ArrayList<Phone> phoneList = new ArrayList<>();
    Data(String dataName) {
    }
    //добавить запись
    void addPhoneToPhoneList(Phone phone) {
        phoneList.add(phone);
    }

    //сортировка по лимиту
    List<Phone> getListByLimit() {
        List<Phone> list = new ArrayList<>();
        for (Phone a : phoneList) {
            if (a.getInCityTime() > a.setInCityTime(500)) {
                list.add(a);
            }
        }
        return list;
    }

    //сортировка по межгородскому времени
    List<Phone> getListByOutCityTime() {
        List<Phone> list = new ArrayList<>();
        for (Phone b : phoneList) {
            if (b.getOutCityTime() != 0) {
                list.add(b);
            }
        }
        return list;
    }

    //сортировка  по фамилии
    List<Phone> getListBySurname() {
        List<Phone> list = new ArrayList<>(phoneList);
        Collections.sort(list, new Comparator<Phone>() {
            public int compare(Phone c1, Phone c2) {
                return c1.getSurname().compareToIgnoreCase(c2.getSurname());
            }
        });
        return list;
    }
}