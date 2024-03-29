package com.interview.sde.java.tree;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
public class BSTLowestCommonAncestor {

    public static TreeNode lca(TreeNode temp, int v1, int v2) {
        while (true) {
            if (temp.data > v1 && temp.data > v2) {
                temp = temp.left;
            } else if (temp.data < v1 && temp.data < v2) {
                temp = temp.right;
            } else {
                return temp;
            }
        }
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        TreeNode ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }

}
