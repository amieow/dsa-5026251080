package lw03.unguided;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Map<String, Integer> registeredStudentMap = new LinkedHashMap<>();
    int registeredStudents = 0;
    int successCheckIn = 0;
    int absentStudent = 0;
    int rejectedAttempts = 0;

    Scanner scanner1 = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
    while (scanner1.hasNext()) {
      String studentId = scanner1.next();
      if (!registeredStudentMap.containsKey(studentId)) {
        registeredStudentMap.put(studentId, 0);
        registeredStudents++;
      }
    }
    scanner1.close();

    System.out.println("===== Event Check-In Results =====");
    Scanner scanner2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
    while (scanner2.hasNext()) {
      String studentId = scanner2.next();
      if (!registeredStudentMap.containsKey(studentId)) {
        System.out.println(studentId + ": Rejected (not registered)");
        rejectedAttempts++;
      } else {
        int status = registeredStudentMap.get(studentId);
        if (status == 0) {
          System.out.println(studentId + ": Checked in");
          registeredStudentMap.put(studentId, 1);
          successCheckIn++;
        } else {
          System.out.println(studentId + ": Rejected (already checked in)");
          rejectedAttempts++;
        }
      }
    }
    scanner2.close();

    for (int status : registeredStudentMap.values()) {
      if (status == 0) {
        absentStudent++;
      }
    }
    System.out.println();
    System.out.println("===== Final Event Summary =====");
    System.out.println("Registered students: " + registeredStudents);
    System.out.println("Successful check-ins: " + successCheckIn);
    System.out.println("Absent students: " + absentStudent);
    System.out.println("Rejected attempts: " + rejectedAttempts);
  }
}