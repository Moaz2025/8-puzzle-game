package com.company;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Astar parameter:
        // (0) for Manhattan Hearistic
        // (any other integer) for Euclidean Hearistic
        AStar a = new AStar(0);
        Node finalNode = a.AStarSearch("768243105");
        System.out.println();
        System.out.println(finalNode.depth);
        System.out.println(a.path);
    }
    public static double manhattanHeuristic(String state){
        double heuristic = 0;
        for(int i = 0; i < 9; ++i){
            if(state.charAt(i) - '0' == 0) continue;
            heuristic += manhattan(getPos(i), getPos(state.charAt(i) - '0'));
        }
        return heuristic;
    }
    public static int manhattan(Point current, Point goal){
        return Math.abs(current.x - goal.x) + Math.abs(current.y - goal.y);
    }
    private static Point getPos(int i) {
        return new Point(i / 3, i % 3);
    }

    public static List<String> getNeighbors(String puzzle){
        List<String> neighbors = new ArrayList<>();
        if(puzzle.charAt(0) == '0'){
            neighbors.add(swapChars(puzzle, 0, 1));
            neighbors.add(swapChars(puzzle, 0, 3));
        }else if(puzzle.charAt(1) == '0'){
            neighbors.add(swapChars(puzzle, 1, 0));
            neighbors.add(swapChars(puzzle, 1, 2));
            neighbors.add(swapChars(puzzle, 1, 4));
        }else if(puzzle.charAt(2) == '0'){
            neighbors.add(swapChars(puzzle, 2, 1));
            neighbors.add(swapChars(puzzle, 2, 5));
        }else if(puzzle.charAt(3) == '0'){
            neighbors.add(swapChars(puzzle, 3, 0));
            neighbors.add(swapChars(puzzle, 3, 4));
            neighbors.add(swapChars(puzzle, 3, 6));
        }else if(puzzle.charAt(4) == '0'){
            neighbors.add(swapChars(puzzle, 4, 1));
            neighbors.add(swapChars(puzzle, 4, 5));
            neighbors.add(swapChars(puzzle, 4, 7));
            neighbors.add(swapChars(puzzle, 4, 3));
        }else if(puzzle.charAt(5) == '0'){
            neighbors.add(swapChars(puzzle, 5, 2));
            neighbors.add(swapChars(puzzle, 5, 8));
            neighbors.add(swapChars(puzzle, 5, 4));
        }else if(puzzle.charAt(6) == '0'){
            neighbors.add(swapChars(puzzle, 6, 3));
            neighbors.add(swapChars(puzzle, 6, 7));
        }else if(puzzle.charAt(7) == '0'){
            neighbors.add(swapChars(puzzle, 7, 6));
            neighbors.add(swapChars(puzzle, 7, 4));
            neighbors.add(swapChars(puzzle, 7, 8));
        }else if(puzzle.charAt(8) == '0'){
            neighbors.add(swapChars(puzzle, 8, 5));
            neighbors.add(swapChars(puzzle, 8, 7));
        }

        return neighbors;
    }
    public static String swapChars(String word, int index1, int index2){
        char[] c = word.toCharArray();
        char temp = c[index1];
        c[index1] = c[index2];
        c[index2] = temp;
        return new String(c);
    }
}
