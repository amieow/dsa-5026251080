package lw06.unguided;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    BinarySearchTree bst = new BinarySearchTree();

    // Read input from treenumbers.txt
    Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

    // Read the first line containing numbers to insert
    String firstLine = sc.nextLine();

    String[] numbers = firstLine.trim().split("\\s+");

    for (String number : numbers) {
      int data = Integer.parseInt(number);
      bst.insert(data);
    }

    // Read the second line containing the search target
    int target = sc.nextInt();

    sc.close();

    // Display traversal results
    System.out.print("Preorder : ");
    bst.preOrder();
    System.out.println();

    System.out.print("Inorder : ");
    bst.inOrder();
    System.out.println();

    System.out.print("Postorder : ");
    bst.postOrder();
    System.out.println();

    // Display search result
    System.out.println("Search " + target + " : " + bst.search(target));

    // Display minimum and maximum values
    System.out.println("Nodes : " + bst.countNodes());
    System.out.println("Leaves : " + bst.countLeaves());
  }
}
