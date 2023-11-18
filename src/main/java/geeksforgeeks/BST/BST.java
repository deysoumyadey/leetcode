package geeksforgeeks.BST;

public class BST {
    static class node {
        int key;
        node left, right;
    }

    static node newNode(int item) {
        node temp = new node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }

    static node insert(node node, int key) {
        if (node == null) {
            return newNode(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        }
        else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        return node;
    }
    static void preorder(node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    static void inorder(node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    static void postorder(node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    static int getTreeHeight(node root) {
        if (root == null) {
            return 0;
        }
        int lheight = getTreeHeight(root.left);
        int rheight = getTreeHeight(root.right);
        if (lheight > rheight) {
            return lheight + 1;
        }
        else {
            return rheight + 1;
        }
    }

    static void printGivenLevel(node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.key + " ");
        }
        else if (level > 1) {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    static void printLevelOrder(node root) {
        int height = getTreeHeight(root);
        for (int i=1; i<=height; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        /* Let us create following BST
                50
             /     \
            30      70
           /  \    /  \
         20   40  60   80
     */
        node root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 70);
        insert(root, 20);
        insert(root, 40);
        insert(root, 60);
        insert(root, 80);
        System.out.println("Preorder: ");
        preorder(root);
        System.out.println("\nInorder: ");
        inorder(root);
        System.out.println("\nPostorder: ");
        postorder(root);
        System.out.println("\nLevel print");
        printLevelOrder(root);
    }
}
