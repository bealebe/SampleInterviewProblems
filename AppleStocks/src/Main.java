/**
 * Created by bryanbeale on 10/12/17.
 */
public class Main {
    public static void main(String[] args){

        int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};

        System.out.println(getMaxProfit(stockPricesYesterday));

    }

    public static int getMaxProfit(int[] pStockPricesYesterday){
        int maxPrice = 0;

        for(int i : pStockPricesYesterday){
            if (i > maxPrice){
                maxPrice = i;
            }
        }

        return maxPrice;
    }


}
