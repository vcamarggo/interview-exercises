package com.interview.sde.algorithm.tree;

import java.util.*;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class AllNodesKDistance {
    static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<TreeNode>> graph = new HashMap<>();
        constructGraphPreOrder(graph, root);

        List<Integer> solution = new ArrayList<>();

        Queue<TreeNode> toProcess = new LinkedList<>();
        Set<TreeNode> processed = new HashSet<>();

        toProcess.offer(target);

        int currentLevel = 0;

        while (!toProcess.isEmpty() && currentLevel <= k) {
            int elements = toProcess.size();
            while (elements-- > 0) {
                TreeNode node = toProcess.poll();
                processed.add(node);
                if (currentLevel == k) {
                    solution.add(node.val);
                }
                for (TreeNode neighbor : graph.getOrDefault(node.val, Collections.emptyList())) {
                    if (!processed.contains(neighbor)) {
                        toProcess.offer(neighbor);
                    }
                }
            }
            currentLevel++;
        }

        return solution;
    }

    static void constructGraphPreOrder(Map<Integer, List<TreeNode>> graph, TreeNode root) {
        if (root.left != null) {
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left);
            graph.computeIfAbsent(root.left.val, k -> new ArrayList<>()).add(root);

            constructGraphPreOrder(graph, root.left);
        }
        if (root.right != null) {
            graph.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right);
            graph.computeIfAbsent(root.right.val, k -> new ArrayList<>()).add(root);

            constructGraphPreOrder(graph, root.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
