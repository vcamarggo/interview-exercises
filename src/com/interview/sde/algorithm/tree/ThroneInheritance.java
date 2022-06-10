package com.interview.sde.algorithm.tree;

import java.util.*;

//https://leetcode.com/problems/throne-inheritance/
public class ThroneInheritance {

    final Map<String, List<String>> family = new HashMap<>();
    final String king;
    final Set<String> dead = new HashSet<>();

    public ThroneInheritance(String kingName) {
        family.put(kingName, new ArrayList<>());
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        family.get(parentName).add(childName);
        family.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        return getInheritanceOrder(king);
    }

    public List<String> getInheritanceOrder(String current) {
        List<String> inheritanceOrder = new ArrayList<>();
        if (current != null) {
            if (!dead.contains(current)) {
                inheritanceOrder.add(current);
            }
            for (String child : family.get(current)) {
                inheritanceOrder.addAll(getInheritanceOrder(child));
            }
        }
        return inheritanceOrder;
    }

    public static void main(String[] args) {
        ThroneInheritance ti = new ThroneInheritance("king");
        ti.birth("king", "andy");
        ti.birth("king", "bob");
        ti.birth("king", "catherine");
        ti.birth("andy", "matthew");
        ti.birth("bob", "alex");
        ti.birth("bob", "asha");
        System.out.println(ti.getInheritanceOrder());
        ti.death("bob");
        System.out.println(ti.getInheritanceOrder());

    }
}
