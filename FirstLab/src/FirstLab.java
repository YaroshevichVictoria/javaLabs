import java.util.Scanner;
  class Array {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

     public  void setArray() {
           System.out.print("\nВведите массив:");
           for (int i = 0; i < arr.length; i++) {
               arr[i] = in.nextInt();
           }
       }
       void getArray () {
           System.out.println("\nМассив элементов:");
           for (int i = 0; i < arr.length; i++) {
               System.out.print(arr[i] + " ");
           }
       }
       void Find () {
         System.out.println("\n\nЧисла, которые делятся на 3 или 9:");
         for (int i = 0; i < arr.length; i++) {
             if (arr[i] % 9 == 0 || arr[i] % 3 == 0)
                 System.out.print(arr[i] + " ");
         }
     }

    };
public class FirstLab {
    public static void main(String[] args) {
        System.out.println("Введите количество массивов:");
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println("Введите размерность массива");
            Array arr1 = new Array();
            arr1.setArray();
            arr1.getArray();
            arr1.Find();
        }
    }
}