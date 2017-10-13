/**
 * Created by bryanbeale on 10/12/17.
 */
public class Main {

    public static void main(String[] args){

        int[] values = getProductsOfAllIntsExceptAtIndex();

        System.out.print("[");
        for(int val : values){
            System.out.print(" " + val + " ");
        }
        System.out.print("]");

    }

    private static int[] getProductsOfAllIntsExceptAtIndex() {
        int[] array = { 1, 7, 3, 4 };
        int[] products = new int[array.length];


        for (int i = 0; i < products.length; i++) {
            products[i] = 1;
            for (int j = 0; j < products.length; j++){
                if (j == i){
                    continue;
                }else{
                    products[i] *= array[j];
                }
            }
        }

        return  products;

    }


}
