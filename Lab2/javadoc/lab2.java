import java.io.*;
import java.util.*;


/**
 * Клас lab2 реалізує програму до лабораторної роботи №2
 *
 * @author Stanislav Derevianko
 * @version 1.0
 * @since version 1.0
 */

public class lab2 {
  /**
     * Статичний метод main є точкою входу в програму
     *
     * @param args function parameter
     * @throws FileNotFoundException throw about non-existent file
     */

  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(System.in);
    int nRows;
    String filler;

    System.out.print("Введіть розмір квадратної матриці: ");
    nRows = in.nextInt();
    in.nextLine();
    System.out.print("\nВведіть символ-заповнювач: ");
    filler = in.nextLine();

exit:
        if(filler.length() == 1) {
          printMatrix(nRows, filler);
        }
        else if (filler.length() == 0) {
          System.out.print("\nНе введено символ заповнювач");
          break exit;
        }
        else {
          System.out.print("\nЗабагато символів заповнювачів");
          break exit;
        }
  }

  public static void printMatrix(int size, String filler) throws FileNotFoundException {
        File dataFile = new File("MyFile.txt");

        PrintWriter fout = new PrintWriter(dataFile);
        String newLine = "\n";
        String space = " ";

        char[][] arr = new char[size][];

        int length = size%2 ==0?2:1;
        for (int i = 0; i < size / 2; i++) {
            arr[i] = new char[length];

            for (int j = 0; j < length; j++) {
                arr[i][j] = filler.charAt(0);
            }
            length += 2;
        }

        length = size;
        for (int i = size/2; i < size; i++) {
            arr[i] = new char[length];

            for (int j = 0; j < length; j++) {
                arr[i][j] = filler.charAt(0);
            }
            length -= 2;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size/2 - arr[i].length/2; j++) {
                System.out.print(" ");
                fout.print(" ");
            }

            for (char chars : arr[i]) {
                System.out.print(chars);
                fout.print(chars);
            }
            System.out.println();
            fout.printf("\n");
        }
        fout.flush();
        fout.close();
    }
}
