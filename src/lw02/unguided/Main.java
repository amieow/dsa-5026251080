package lw02.unguided;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    List<String[]> orders = new LinkedList<>();

    Scanner Sc = new Scanner(Main.class.getResourceAsStream("orders.txt"));
    while (Sc.hasNext()) {
      String name = Sc.next();
      String food = Sc.next();
      String drink = Sc.next();
      String tableNum = Sc.next();
      orders.add(new String[] { name, food, drink, tableNum} );
    }
    Sc.close();

    List<String[]> foods = new LinkedList<>();
    foods.add(new String[] { "Bakso", "2" });
    foods.add(new String[] { "Sate", "1" });
    foods.add(new String[] { "Soto", "2" });

    List<String[]> drinks = new LinkedList<>();
    drinks.add(new String[] { "EsTeh", "4" });
    drinks.add(new String[] { "EsJeruk", "2" });

    Queue<String[]> orderQueue = new LinkedList<>();
    orderQueue.addAll(orders);

    Stack<String[]> failedOrders = new Stack<>();
    List<String[]> successfulOrders = new LinkedList<>();
    while (!orderQueue.isEmpty()) {
      String[] order = orderQueue.poll();
      int foodIndex = findStock(foods, order[1]);
      int drinkIndex = findStock(drinks, order[2]);

      boolean foodReady = order[1].equals("-") || (foodIndex != -1 && Integer.parseInt(foods.get(foodIndex)[1]) > 0);
      boolean drinkReady = order[2].equals("-")
          || (drinkIndex != -1 && Integer.parseInt(drinks.get(drinkIndex)[1]) > 0);

      if (foodReady && drinkReady) {
        reduceStock(foods, foodIndex);
        reduceStock(drinks, drinkIndex);
        successfulOrders.add(order);
      } else {
        failedOrders.push(order);
      }
    }

    System.out.println("=== Successfully Processed Orders ===");
    for (String[] order : successfulOrders) {
      System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
    }

    System.out.println("\n=== Remaining Food Stock ===");
    for (String[] food : foods) {
      System.out.println(food[0] + " : " + food[1]);
    }

    System.out.println("\n=== Remaining Drink Stock ===");
    for (String[] drink : drinks) {
      System.out.println(drink[0] + " : " + drink[1]);
    }

    System.out.println("\n=== Failed Orders ===");
    while (!failedOrders.isEmpty()) {
      String[] order = failedOrders.pop();
      System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
    }
  }

  private static void reduceStock(List<String[]> items, int index) {
    if (index != -1) {
      items.get(index)[1] = String.valueOf(Integer.parseInt(items.get(index)[1]) - 1);
    }
  }

  private static int findStock(List<String[]> items, String name) {
    for (int i = 0; i < items.size(); i++) {
      if (items.get(i)[0].equals(name)) {
        return i;
      }
    }
    return -1;
  }
}
