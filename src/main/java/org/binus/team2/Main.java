package org.binus.team2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
  private static final int DIVIDER_LENGTH = 50;
  private static final String[] MENU = {
      "1. Random Data",
      "2. Simulasi Bubble Sort - Ascending",
      "3. Simulasi Selection Sort - Ascending",
      "4. Simulasi Bubble Sort - Descending",
      "5. Simulasi Selection Sort - Descending",
      "6. Exit"
  };
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean exit = false;
    int[] randomNumbers = {0, 0, 0, 0, 0};
    do {
      renderHeader();
      renderMenu();
      int menuSelected = readIntegerWithRangeValidation(1, MENU.length, String.format("Masukkan pilihan anda [%d..%d] : ", 1, MENU.length));
      switch (menuSelected) {
        case 1:
          randomNumbers = generateRandomData();
          break;
        case 2:
          simulateBubbleSortAscending(randomNumbers);
          break;
        case 3:
          simulateSelectionSortAscending(randomNumbers);
          break;
        case 4:
          simulateBubbleSortDescending(randomNumbers);
          break;
        case 5:
          simulateSelectionSortDescending(randomNumbers);
          break;
        case 6:
          exit = true;
          System.out.println("Terima kasih!");
          break;
      }

      scanner.nextLine();
      System.out.println();
      // add this comment
    } while (!exit);
  }

  /* ==== START APPLICATION MENU METHODS ==== */
  private static int[] generateRandomData() {
    int lowerBound = readIntegerWithRangeValidation(0, Integer.MAX_VALUE, "Batas Bawah = ");
    int upperBound = readIntegerWithRangeValidation(lowerBound, Integer.MAX_VALUE, "Batas Atas = ");
    int[] randomNumbers = new int[5];
    for (int i = 0; i < randomNumbers.length; i++) {
      Random random = new Random();
      randomNumbers[i] = lowerBound + random.nextInt(upperBound - lowerBound);
      System.out.print(randomNumbers[i] + " ");
    }
    return randomNumbers;
  }

  private static void simulateBubbleSortAscending(int[] randomNumbers) {
    // TODO: implement
  }

  private static void simulateSelectionSortAscending(int[] randomNumbers) {
    // TODO: implement
  }

  private static void simulateBubbleSortDescending(int[] randomNumbers) {
    // TODO: implement
  }

  private static void simulateSelectionSortDescending(int[] randomNumbers) {
    // TODO: implement
  }
  /* ==== END APPLICATION MENU METHODS ==== */

  /* ==== START RENDERING METHODS ==== */
  private static void renderHeader() {
    System.out.println("Selamat datang di Program Simulasi Sorting");
    renderDivider("=");
  }

  private static void renderDivider(String dividerChar) {
    for (int i = 0; i < DIVIDER_LENGTH; i++) {
      System.out.print(dividerChar);
    }
    System.out.println();
  }

  private static void renderMenu() {
    System.out.println("Menu");
    for (String menuOption : MENU) {
      System.out.println(menuOption);
    }
  }
  /* ==== END RENDERING METHODS ==== */

  /* ==== START READ INPUT METHODS ==== */
  private static int readIntegerWithRangeValidation(int min, int max, String message) {
    while (true) {
      try {
        System.out.println(message);
        int n = scanner.nextInt();
        if (n < min || n > max) {
          throw new Exception("Nilai harus berada di antara " + min + " dan " + max + ".");
        }

        return n;
      } catch (InputMismatchException e) {
        System.out.println("Terdapat kesalahan tipe data pada input. Mohon input data berupa angka.");
        scanner.nextLine();
      } catch (Exception e) {
        System.out.println(e.getMessage());
        scanner.nextLine();
      }
    }
  }
  /* ==== END READ INPUT METHODS ==== */
}