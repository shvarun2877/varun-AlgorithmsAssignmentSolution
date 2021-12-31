import java.util.Arrays;
import java.util.Scanner;

public class Ass2 {
    public static Scanner sc=new Scanner(System.in);
    public static int option=0;
    public  static int rose = 0, fall = 0;
    public static double[] stock_prices;
    public static void main(String...args){
        Method();
options();
    }

    public static void Method() {

        System.out.println("Enter the no of companies");
        int no_of_companies = sc.nextInt();
         stock_prices = new double[no_of_companies];
        boolean price_rose_status = false;
        for (int i = 0; i < no_of_companies; i++) {
            System.out.println("Enter current stock price of the company " + (i + 1));
            stock_prices[i] = sc.nextDouble();
          System.out.println("Whether company's stock price rose today compare to yesterday?");
            price_rose_status = sc.nextBoolean();
            if (price_rose_status == true) {
                rose++;
            }
            if (price_rose_status == false) {
                fall++;
            }
        }
    }
    public static void options(){
            System.out.println("Enter the operation that you want to perform\n" +
                    "1. Display the companies stock prices in ascending order\n" +
                    "2. Display the companies stock prices in descending order\n" +
                    "3. Display the total no of companies for which stock prices rose today\n" +
                    "4. Display the total no of companies for which stock prices declined today\n" +
                    "5. Search a specific stock price\n" +
                    "6. press 0 to exit");


         option=sc.nextInt();
         if(option==0){

             System.out.println("Exited Successfully");
         }
        if(option==1 )
            {
               System.out.println("Stock prices in ascending order are :");
                int array_length1=stock_prices.length;
                if(array_length1==1){
                    System.out.println(stock_prices[0]);
                }
                else {
                    divide(stock_prices);
                    System.out.println(Arrays.toString(stock_prices));
                }
                options();
            }
        if(option==2 )
        {
           System.out.println("Stock prices in descending order are :");
            int array_length1=stock_prices.length;
            if(array_length1==1){
                System.out.println(stock_prices[0]);
            }
            else {
                divide(stock_prices);
                System.out.println(Arrays.toString(stock_prices));
            }
            options();
        }
        if(option==3){
            System.out.println("Total no of companies whose stock price rose today :");
            System.out.println(rose);
            options();
        }
        if(option==4){
            System.out.println("Total no of companies whose stock price declined today :");
            System.out.println(fall);
            options();
        }
        if(option==5){
            boolean status=false;
            System.out.println("enter the key value");
            double key=sc.nextDouble();
            for(int i=0;i<stock_prices.length;i++){
                if(stock_prices[i]==key){
                   status=true;
                }
            }
            if(status==false)
            System.out.println("Value not found");
            else
                System.out.println("Stock of value "+ key+" is present");
            options();
        }

    }
    public static void divide(double [] stock_prices1){
        int array_length=stock_prices1.length;

        if (array_length < 2)
            return;
        int mid_index = array_length / 2;
        double[] leftArray = new double[mid_index];
        double[] rightArray = new double[array_length - mid_index];
        for(int i=0;i<mid_index;i++){
            leftArray[i]=stock_prices1[i];
        }
        for(int i=mid_index;i<array_length;i++){
            rightArray[i-mid_index]=stock_prices1[i];
        }
        divide(leftArray);
        divide(rightArray);
        if(option==1){
           // System.out.println("Stock prices in ascending order are :");
            Ascending_merge(stock_prices1,leftArray,rightArray);
           // System.out.println(Arrays.toString(stock_prices));
        }
        if(option==2){
           // System.out.println("Stock prices in descending order are :");
            Descending_merge(stock_prices1,leftArray,rightArray);
          //System.out.println(Arrays.toString(stock_prices));
        }
    }
    public static void Ascending_merge(double [] stock_prices,double [] leftArray,double [] rightArray){
        int i=0,j=0,k=0;
        while (i< leftArray.length && j<rightArray.length) {
            if (leftArray[i]<rightArray[j]) {
                stock_prices[k] = leftArray[i];
                i++;
            }
            else {
                stock_prices[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i< leftArray.length){
            stock_prices[k]=leftArray[i];
            i++;
            k++;
        }
        while(j< rightArray.length){
            stock_prices[k]=rightArray[j];
            j++;
            k++;
        }


    }
    public static void Descending_merge(double [] stock_prices,double [] leftArray,double [] rightArray){
        int i=0,j=0,k=0;
        while (i< leftArray.length && j<rightArray.length ) {
            if (leftArray[i]>rightArray[j]) {
                stock_prices[k] = leftArray[i];
                i++;
            }
            else {
                stock_prices[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i< leftArray.length){
            stock_prices[k]=leftArray[i];
            i++;
            k++;
        }
        while(j< leftArray.length){
            stock_prices[k]=rightArray[j];
            j++;
            k++;
        }

    }


}

