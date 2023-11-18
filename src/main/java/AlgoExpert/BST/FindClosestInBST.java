package AlgoExpert.BST;

import geeksforgeeks.BST.BST;

import java.util.*;

class FindClosestInBST {
    public static int findClosestValueInBst(BST tree, int target) {
        int closestValue = -1, diff = 999999;
        return helper(tree, target, closestValue, diff);
    }

    public static int helper(BST tree, int target, int closestValue, int diff) {
        if (tree == null) {
            return closestValue;
        }
        if (Math.abs(target - tree.value) < diff) {
            diff = Math.abs(target - tree.value);
            closestValue = tree.value;
        }
        if (target - tree.value > 0){
            return helper(tree.right, target, closestValue, diff);
        }
        else if (target - tree.value < 0) {
            return helper(tree.left, target, closestValue, diff);
        }
        else {
            return tree.value;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    static BST insert(BST node, int key) {
        if (node == null) {
            return new BST(key);
        }
        if (key < node.value) {
            node.left = insert(node.left, key);
        }
        else if (key > node.value) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    public static void main(String[] args) {
        BST root = new BST(10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 2);
        insert(root, 5);
        insert(root, 13);
        insert(root, 22);
        insert(root, 1);
        insert(root, 14);



    }
}
