package lw01.unguided;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    List<WashService> jobs = new ArrayList<>();
    int i = 0;
    int[] jobsUnits;
    try (Scanner scanner = new Scanner(new File("washes.txt"))) {
      int total = scanner.nextInt();
      jobsUnits = new int[total];
      while (scanner.hasNext()) {
        String type = scanner.next();
        String id = scanner.next();
        int days = scanner.nextInt();
        int units = scanner.nextInt();
        jobsUnits[i] = units;
        if (type.equals("MOTORCYCLE")) {
          jobs.add(new MotorcycleWash(id, days));
        } else if (type.equals("CAR")) {
          jobs.add(new CarWash(id, days));
        }
        i+=1;
      }
    } catch (FileNotFoundException e) {
      System.out.println("washes.txt tidak ditemukan");
      return;
    }
    i = 0;
    for (WashService job : jobs) {
      System.out.println(job.getId() + " | " + job.label() + " | " + job.calculateCharge(jobsUnits[i]));
      i++;
    }
  }
}
