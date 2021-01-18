package com.algo.optimization.greedy;

import java.util.*;

public class KnapSack {

    public static void main(String[] args) {

        int [] objectWeights = new int [] {2, 3, 5, 7, 1, 4, 1};
        int [] objetsProfits = new int [] {10, 5, 15, 7, 6, 18, 3};

        System.out.println(getMaximumProfit(objectWeights, objetsProfits));



    }

    public static float getMaximumProfit(int [] objectWeights, int [] objetsProfits){

        List<Details> itemDetails = greedyApproach(objectWeights, objetsProfits);

        //itemDetails.forEach( details -> System.out.println("Weight: " + details.getWeight() + " Profit/Weight : " + details.getWeightToProfit()));
        int totalWeight = 0;
        float totalProfit = 0.0f;

        for(Details details : itemDetails){
            if(totalWeight + details.getWeight() <= 15){
                totalProfit += details.getProfit();
                totalWeight += details.getWeight();
            }else{

                float fractProfit = ((float)(15 - totalWeight)/details.getWeight()) * details.getProfit();
                System.out.println(fractProfit);
                totalProfit += fractProfit;
                totalWeight += 15 - totalWeight;
                break;


            }
        }

        System.out.println("Total Weight: " + totalWeight + " total profit: " + totalProfit);

        return totalProfit;

    }
    //Exception in thread "main" java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.util.Map$Entry
        //(java.lang.Integer and java.util.Map$Entry are in module java.base of loader 'bootstrap')

    public static List<Details>  greedyApproach(int [] objectWeights, int [] objetsProfits){

        List<Details> itemDetails = new ArrayList<>(objectWeights.length);

        String str = "";

        for(int i=0; i < objectWeights.length; i++){
           Details details = new Details();
           details.setProfit(objetsProfits[i]);
           details.setWeight(objectWeights[i]);
           float weightToProfit = (float) objetsProfits[i]/objectWeights[i];
           details.setWeightToProfit(weightToProfit);
           itemDetails.add(details);
        }

        itemDetails.sort((Details d1, Details d2) -> Float.compare(d2.getWeightToProfit(), d1.getWeightToProfit()));

        return itemDetails;

    }

    static class Details{

        private int weight;
        private int profit;
        private float weightToProfit;


        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        public float getWeightToProfit() {
            return weightToProfit;
        }

        public void setWeightToProfit(float weightToProfit) {
            this.weightToProfit = weightToProfit;
        }
    }


}
