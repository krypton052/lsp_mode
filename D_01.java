package com.hit.kp;

public class D_01 {
    private int numOfItems;
    private int capacityOfKnapsack;
    private int[][] knapsackTable;
    private int totalBenefit;
    private int[] weights;
    private int[] values;



    public D_01(int numOfItems, int capacityOfKnapsack, int[] weights, int[] values) {
        super();
        this.numOfItems = numOfItems;
        this.capacityOfKnapsack = capacityOfKnapsack;
        this.weights = weights;
        this.values = values;
        this.knapsackTable = new int[numOfItems+1][capacityOfKnapsack+1];
    }



    public void solve() {
        for(int i=1;i<numOfItems+1;i++) {
            for(int w=1;w<capacityOfKnapsack+1;w++) {
                int notTakingItem = knapsackTable[i-1][w];		// not taking item i
                int takingItem = 0;
                if(weights[i]<=w) {
                    takingItem = values[i]+knapsackTable[i-1][w-weights[i]];
                }

                knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
            }
        }
        totalBenefit = knapsackTable[numOfItems][capacityOfKnapsack];
    }



    public void showResults() {
        System.out.println("Total benefit: "+ totalBenefit);
        for(int n=numOfItems,w=capacityOfKnapsack;n>0;n--) {
            if(knapsackTable[n][w]!=0 && knapsackTable[n][w] != knapsackTable[n-1][w]) {
                System.out.println("We take item: "+n);
                w=w-weights[n];
            }
        }

    }



    public static void main(String[] args) {
        int numOfItems = 3;
        int capacityOfKnapsack = 5;

        int[] weightOfItems = new int[numOfItems+1];
        weightOfItems[1] = 4;
        weightOfItems[2] = 2;
        weightOfItems[3] = 3;

        int[] profitOfItems = new int[numOfItems+1];;
        profitOfItems[1] = 10;
        profitOfItems[2] = 4;
        profitOfItems[3] = 7;

        D_01 D_01 = new D_01(numOfItems, capacityOfKnapsack, weightOfItems, profitOfItems);
        D_01.solve();
        D_01.showResults();

    }
}
