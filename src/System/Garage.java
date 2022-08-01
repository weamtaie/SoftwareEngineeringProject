package System;
import java.util.Scanner;
import Actors.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.*;
import java.time.temporal.*;

public class Garage {
    public Slot[] arr;
    public int arrSize;
    public Parking parking=new Parking();// parkin class instance
    public SlotsDisplayer slotsDisplayer=new SlotsDisplayer(this.arr); // slots displayer instance which takes slots array


    public void setArrSize(int s){
        arrSize=s;
    }

    // function to fill the garage slots
    public void fillSlots(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Number of Garage Slots");
        arrSize= s.nextInt();

        arr=new Slot[arrSize];
        for(int i=0;i<arrSize;i++){
            this.arr[i]=new Slot();
        }
// the next loop used to set Dimensions of each slot
        for(int i=0;i<arrSize;i++){
            System.out.println("Enter Slot "+(i+1)+" Width and length");
            this.arr[i].width=s.nextInt();
            this.arr[i].length=s.nextInt();
        }

        System.out.println("Slots are filled");
        slotsDisplayer=new SlotsDisplayer(this.arr);
    }


}
