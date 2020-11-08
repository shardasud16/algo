package main.java.com.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * For a given set of an array we want to get
 * all the subsets of array for which if we consider the value
 * should equal to a sum.
 *
 * Example: {5,10,12,13,15,18}
 *
 * Sum total needed: 30
 *
 * Ops {1,1,0,0,1,0} 5 + 10 + 15 = 30
 *     {0,0,1,1,1,0} 12 + 13 + 15 = 30 ...
 *
 *  To solve this problem, we will use backtracking.
 */


public class SumOfSubSets {

    private static List<int[]> output = new ArrayList<>();
    private static final int VALUE = 40;


    public static void main(String[] args) {

        int [] numbers = new int [] {15, 10, 12, 13, 5, 18};

        getAllSubSets(numbers, 0, 73, new int [6], 0);

        System.out.println(output.size());

    }


    public static void getAllSubSets(int [] numbers, int sum, int balance, int [] solution, int index){

        if(index > numbers.length -1)
            return;

        int number = numbers[index];

        if(checkSumAndBalance(number, sum, balance)) {
            solution[index] = 1;
            if(sum + number == VALUE){
                output.add(solution.clone());
            }
            getAllSubSets(numbers, sum + number, balance - number, solution, index + 1);

        }

        solution[index] = 0;
        getAllSubSets(numbers, sum, balance - number, solution, index + 1);

    }

    public static boolean checkSumAndBalance(int number, int sum, int balance){

        if(number + sum <= VALUE && sum + (balance - number) >= 0)
            return true;
        return false;

    }
}
