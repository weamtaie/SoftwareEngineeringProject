package System;

//this class used to calculate the income according to ""Singelton Pattern""
public class TotalIncome {

    private static long income=0;
    private TotalIncome(int n){income+=n;}
    public static void incIncome(long n){income+=n;}
    public static long getIncome(){return income;}


}
