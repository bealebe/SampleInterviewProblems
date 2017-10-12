/**
 * Created by bryanbeale on 10/12/17.
 */
public class Main {
    public static void main(String[] args){

        int[] stockPricesYesterday = new int[] {-1, -2};

        System.out.println(getMaxProfit(stockPricesYesterday));

    }

    public static int getMaxProfit(int[] pStockPricesYesterday){
        if( pStockPricesYesterday.length <2){
            throw new IllegalArgumentException("Getting a max profit requires two numbers at least...");
        }
        int maxProfit = pStockPricesYesterday[1] - pStockPricesYesterday[0];
        int minPrice = pStockPricesYesterday[0];

        for(int i = 1; i <  pStockPricesYesterday.length; i++){

            int current =  pStockPricesYesterday[i];

            int potentialProfit = current - minPrice;

            maxProfit = Math.max(potentialProfit, maxProfit);

            minPrice = Math.min(current, minPrice);
        }

        return maxProfit;
    }


}
