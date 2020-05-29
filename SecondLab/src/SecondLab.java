import javax.swing.*;
import java.util.Date;

import java.util.Scanner;

import static java.lang.Math.abs;

class Array {
    Scanner in = new Scanner(System.in);
    double sum=0;
    int n = in.nextInt();
    int[] count = new int[n];
    int[] massiv = new int[n];
    int[] arr = new int[n];

    public  void setArray() {
        System.out.print("Введите массив: ");
        for (int j = 0; j < n; j++) {
            massiv[j] = in.nextInt();

            arr[j] = massiv[j];
        }
    }
    public void length(){
        System.out.print("Длины чисел:");
        for (int j = 0; j < n; j++) {
            while(massiv[j]>10){
                massiv[j]= massiv[j] / 10;
                (count[j])++;
            }
            System.out.print((count[j]+1)+" ");
        }
    }
    public void middle(){
        System.out.print("\nСредняя длина: ");
        for(int k=0;k<n;k++)
            sum=sum+count[k]+1;
        sum=sum/n;
        System.out.print(sum);
    }
    public void func(){
        System.out.print("\n\nЧисла, длина которых меньше средней:\n");
        for(int i=0;i<n;i++)
            if(count[i]+1<sum)
                System.out.println(arr[i]+" Его длина "+(count[i]+1));
        System.out.print("\nЧисла, длина которых больше средней:\n");
        for(int i=0;i<n;i++)
            if(count[i]+1>sum)
                System.out.println(arr[i]+" Его длина "+(count[i]+1));
    }
};
public class SecondLab {
    public static void main(String[] args) {
        System.out.print("Введите длину массива: ");
        Array arr=new Array();
        arr.setArray();
        arr.length();
        arr.middle();
        arr.func();

        System.out.print("\nДата и время сдачи задания:\n");
        Date date = new Date();
        // Вывод текущей даты и времени с использованием toString()
        System.out.println(date.toString());


    }
}

