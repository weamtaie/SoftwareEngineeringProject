package System;

import Actors.Driver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// class for BestFit method which implements ParkIn interface
public class ParkInBestFit implements ParkIn{
    @Override
    public void parkInMethod(Slot[] arr, Driver d) {
        int bestslotIndex=0;
        int tmp=10000000;
        //next loop check the slot according to best fit slot for the car
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isFree) {
                if (arr[i].length >= d.v.length && arr[i].width >= d.v.width) {
                    if(arr[i].length*arr[i].width<tmp){
                        tmp=arr[i].length*arr[i].width;
                        bestslotIndex=i;
                    }

                }

            }

        }
        //Display the slot for the driver
        System.out.println("Slot Number to park is " + (bestslotIndex + 1));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        //the next line save the arrival time for the driver
        d.v.ArrivalTime = dtf.format(now);
        d.v.isParked=true;
        d.v.slotNum=bestslotIndex;
        arr[bestslotIndex].isFree=false;


    }

}
