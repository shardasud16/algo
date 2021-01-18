package com.algo.optimization.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


/**
 * Given a array of Job and their respective deadlines, get the maximum profit that can
 * be achieved.
 */
public class JobSequencing {

    public static void main(String[] args) {


        int [] profit = new int[]{10,5,20,20,1};
        int [] deadlines = new int[]{1,3,2,2,3};

        JobSequencing jobSequencing = new JobSequencing();
        System.out.println("Max Profit: " + jobSequencing.calculateMaxProfit(profit, deadlines));

    }


    public int calculateMaxProfit(int [] profit, int [] deadlines){

        int maxProfit = 0;
        TreeSet<ProfitToDeadline> profitToDeadlineSet = new TreeSet<>(Comparator.comparing(ProfitToDeadline::getProfit).thenComparing(ProfitToDeadline::getJobId));

        int maxDeadline = 0;
        for(int i = 0; i < profit.length; i++){
            ProfitToDeadline pToD = new ProfitToDeadline();
            pToD.setDeadline(deadlines[i]);
            pToD.setProfit(profit[i]);

            pToD.setJobId(i + 1);

            profitToDeadlineSet.add(pToD);

            if(deadlines[i] > maxDeadline)
                maxDeadline = deadlines[i];
        }// nlog(n) -> N is the size of the list and to add a node to a tree set it is log n so total nlogn

        int [] jobTaken = new int [maxDeadline];

        for(int j = profitToDeadlineSet.size(); j > 0; j--){// N
            ProfitToDeadline pToD = profitToDeadlineSet.pollLast();  //O(1)
            int index = pToD.getDeadline() - 1;
            boolean isDone = false;
            while(index >=0 && !isDone){ //? ??? O (?)

                if(jobTaken[index] == 0) {
                    jobTaken[index] = pToD.getJobId();
                    isDone = true;
                    maxProfit += pToD.getProfit();
                }

                index--;

            }

        }

        Arrays.stream(jobTaken).forEach(jobId -> System.out.println("Job Id taken: " + jobId));


        return maxProfit;
    }


    static class ProfitToDeadline{

        int profit;
        int deadline;

        int jobId;

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        public int getDeadline() {
            return deadline;
        }

        public void setDeadline(int deadline) {
            this.deadline = deadline;
        }

        public int getJobId() {
            return jobId;
        }

        public void setJobId(int jobId) {
            this.jobId = jobId;
        }




    }
}
