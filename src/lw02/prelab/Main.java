package lw02.prelab;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    List<String[]> transactions = new LinkedList<>();

    Scanner scanner = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
    while (scanner.hasNext()) {
      String name = scanner.next();
      String type = scanner.next();
      String amount = scanner.next();
      transactions.add(new String[] { name, type, amount });
    }
    scanner.close();

    List<String[]> customers = new LinkedList<>();
    for (String[] transaction : transactions) {
      addCustomer(customers, transaction[0]);
    }

    Queue<String[]> transactionQueue = new LinkedList<>(transactions);

    Stack<String[]> failedTransactions = new Stack<>();
    while (!transactionQueue.isEmpty()) {
      String[] transaction = transactionQueue.poll();
      String[] customer = findCustomer(customers, transaction[0]);
      long amount = Long.parseLong(transaction[2]);
      long balance = Long.parseLong(customer[1]);

      if (transaction[1].equals("WITHDRAW") && amount > balance) {
        failedTransactions.push(transaction);
        continue;
      }

      if (transaction[1].equals("DEPOSIT")) {
        customer[1] = String.valueOf(balance + amount);
      } else {
        customer[1] = String.valueOf(balance - amount);
      }
    }

    System.out.println("=== Saldo Akhir ===");
    for (String[] customer : customers) {
      System.out.println(customer[0] + " : " + customer[1]);
    }

    System.out.println("\n=== Failed Transactions ===");
    while (!failedTransactions.isEmpty()) {
      String[] transaction = failedTransactions.pop();
      System.out.println(transaction[0] + " " + transaction[1] + " " + transaction[2]);
    }
  }

  private static void addCustomer(List<String[]> customers, String name) {
    if (findCustomer(customers, name) == null) {
      customers.add(new String[] { name, "0" });
    }
  }

  private static String[] findCustomer(List<String[]> customers, String name) {
    for (String[] customer : customers) {
      if (customer[0].equals(name)) {
        return customer;
      }
    }
    return null;
  }
}
