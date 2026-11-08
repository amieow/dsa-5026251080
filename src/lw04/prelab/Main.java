package lw04.prelab;

import java.util.Scanner;
import java.io.File;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(new File("branches.txt"));

    int n = scanner.nextInt();
    int[] branches = new int[n];
    for (int i = 0; i < n; i++) {
      branches[i] = scanner.nextInt();
    }

    int m = scanner.nextInt();
    int[] targets = new int[m];
    for (int i = 0; i < m; i++) {
      targets[i] = scanner.nextInt();
    }

    insertionSort3Passes(branches);

    for (int i = 0; i < branches.length; i++) {
      System.out.print(branches[i]);
      if (i < branches.length - 1) {
        System.out.print(" ");
      }
    }
    System.out.println();
    for (int target : targets) {
      int index = linearSearch(branches, target);
      if (index != -1) {
        System.out.println(target + ": FOUND at index " + index);
      } else {
        System.out.println(target + ": NOT FOUND");
      }
    }

    scanner.close();
  }

  static void insertionSort3Passes(int[] arr) {
    for (int i = 1; i <= 3 && i < arr.length; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] < key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }
}