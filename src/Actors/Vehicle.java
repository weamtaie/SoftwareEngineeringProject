package Actors;

import java.util.Scanner;

public class Vehicle {

    public int length;
    public int width;
    public String model_name;
    public String model_year;

    public String ArrivalTime;
    public String DepartureTime;
    public boolean isParked=false;
    public int slotNum;
    public long fees;


// this class made to take vehicle information from the driver
    public void setViechleInfo(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter your car width ");
        width =s.nextInt();
        System.out.println("Enter your car length ");
        length = s.nextInt();
        System.out.println("Enter your car model year ");
        model_year =s.next();
        System.out.println("Enter your car model name ");
        model_name=s.next();
    }


}
