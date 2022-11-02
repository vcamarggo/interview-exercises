package com.interview.sde.java.stack;

import java.util.*;

//https://leetcode.com/problems/exclusive-time-of-functions/
public class ExclusiveTimeOfFunctions {
    public static void main(String[] args) {
        ExclusiveTimeOfFunctions main = new ExclusiveTimeOfFunctions();
        System.out.println(Arrays.toString(main.exclusiveTime(2, List.of("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"))));
        System.out.println(Arrays.toString(main.exclusiveTime(1, List.of("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"))));
        System.out.println(Arrays.toString(main.exclusiveTime(2, List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));
    }

    int[] exclusiveTime(int n, List<String> logs) {
        Deque<Execution> callStack = new ArrayDeque<>();
        for (String log : logs) {
            callStack.push(new Execution(log));
        }

        int[] solution = new int[n];

        Stack<Execution> backgroundExecution = new Stack<>();

        while (!callStack.isEmpty()) {
            Execution executing = callStack.pop();
            if (callStack.peek().isEnd) {
                //send the current execution to background because something executed between its start and end
                backgroundExecution.push(executing);
            } else {
                //execution Stack will be a start, so we calculate how long it took
                int executionTime = 1 + (executing.time - callStack.pop().time);
                //update solution after processing
                solution[executing.id] += executionTime;
                //clean the background and update the time removing the subprocess execution time
                while (!backgroundExecution.isEmpty()) {
                    Execution toExecute = backgroundExecution.pop();
                    toExecute.time -= executionTime;
                    callStack.push(toExecute);
                }
            }
        }

        return solution;
    }

    static class Execution {
        int id;
        boolean isEnd;
        int time;

        public Execution(String log) {
            String[] execution = log.split(":");
            this.id = Integer.parseInt(execution[0]);
            this.isEnd = execution[1].equals("end");
            this.time = Integer.parseInt(execution[2]);
        }

    }
}
