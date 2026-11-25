package lw06.unguided;

public class BinarySearchTree {
  Node root;

  public BinarySearchTree() {
    root = null;
  }

  // Insert a new value into the BST
  public void insert(int data) {
    root = insertHelper(root, data);
  }

  private Node insertHelper(Node root, int data) {
    // If the current node is empty, create a new node
    if (root == null) {
      return new Node(data);
    }

    // Move to the left subtree
    if (data < root.data) {
      root.left = insertHelper(root.left, data);
    }

    // Move to the right subtree
    else if (data > root.data) {
      root.right = insertHelper(root.right, data);
    }

    // Duplicate values are ignored
    return root;
  }

  // Search for a target value
  public boolean search(int target) {
    return searchHelper(root, target);
  }

  private boolean searchHelper(Node root, int target) {
    // Value not found
    if (root == null) {
      return false;
    }

    // Value found
    if (root.data == target) {
      return true;
    }

    // Search in the left subtree
    if (target < root.data) {
      return searchHelper(root.left, target);
    }

    // Search in the right subtree
    return searchHelper(root.right, target);
  }

  // Preorder traversal: Root -> Left -> Right
  public void preOrder() {
    StringBuilder result = new StringBuilder();
    preOrderHelper(root, result);
    System.out.print(result.toString().trim());
  }

  private void preOrderHelper(Node root, StringBuilder result) {
    if (root == null) {
      return;
    }

    result.append(root.data).append(" ");

    preOrderHelper(root.left, result);
    preOrderHelper(root.right, result);
  }

  // Inorder traversal: Left -> Root -> Right
  public void inOrder() {
    StringBuilder result = new StringBuilder();
    inOrderHelper(root, result);
    System.out.print(result.toString().trim());
  }

  private void inOrderHelper(Node root, StringBuilder result) {
    if (root == null) {
      return;
    }

    inOrderHelper(root.left, result);

    result.append(root.data).append(" ");

    inOrderHelper(root.right, result);
  }

  // Postorder traversal: Left -> Right -> Root
  public void postOrder() {
    StringBuilder result = new StringBuilder();
    postOrderHelper(root, result);
    System.out.print(result.toString().trim());
  }

  private void postOrderHelper(Node root, StringBuilder result) {
    if (root == null) {
      return;
    }

    postOrderHelper(root.left, result);
    postOrderHelper(root.right, result);

    result.append(root.data).append(" ");
  }

  // Find the minimum value
  public int countNodes() {
    return countNodesHelper(root);
  }

  public int countLeaves() {
    return countLeavesHelper(root);
  }

  public int countNodesHelper(Node root) {
    if (root == null) {
      return 0;
    }
    return 1 + countNodesHelper(root.left) + countNodesHelper(root.right);
  }

  public int countLeavesHelper(Node root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    return countLeavesHelper(root.left) + countLeavesHelper(root.right);
  }
}
