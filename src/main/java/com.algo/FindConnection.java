package main.java.com.algo;

public class FindConnection {

    /**
     * This is implementation of problem discussed here.
     * Tried solving this problem using single Array.
     *
     * Please review and provide your inputs
     */

    private static int [] virtualTree = null;

    public static void main(String[] args) {

        initialize(10);

        union(1, 2);
        union(2, 4);
        union(3, 6);
        union(3, 9);
        union(5, 10);
        union(10, 7);

        if(find(1) == find(4)){
            System.out.println("Yes 1 and 4 and related");
        }

        if(find(7) == find(5)){
            System.out.println("Yes 5 and 7 and related");
        }

        if(find(1) == find(7)){
            System.out.println("Yes 1 and 7 and related");
        }
        else{
            System.out.println("No!! 1 and 7 and not related");
        }

    }

    public static void initialize(int n){
        virtualTree = new int[n + 1]; //To keep it simple (node -1)

        for(int i = 0; i <= n; i++){
            virtualTree[i] = -1;
        }
    }


    public static void union(int first, int second){

        int firstParent = find(first);

        int secondParent = find(second);

        if(firstParent != secondParent){
            int firstRank = virtualTree[firstParent];
            int secondRank = virtualTree[secondParent];

            int weight = firstRank + secondRank; //rank or weight

            if(firstRank <= secondRank){
                virtualTree[secondParent] = firstParent;
                virtualTree[firstParent] = weight;
            }else{
                virtualTree[firstParent]  = secondParent;
                virtualTree[secondParent] = weight;

            }

        }

    }


    /**
     * Used logic of Collapsing Find to maintain the height
     * @param node
     * @return
     */
    public static int find(int node){
        return virtualTree[node] < 0 ? node : find(virtualTree[node]);
    }

}
