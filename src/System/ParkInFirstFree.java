package System;

import Actors.Driver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkInFirstFree implements ParkIn {

    @Override
    public void parkInMethod(Slot[] arr, Driver d) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isFree==true) {
                if (arr[i].length >= d.v.length && arr[i].width >= d.v.width) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    d.v.ArrivalTime = dtf.format(now);
                    System.out.println("Slot Number to park is " + (i + 1));
                    System.out.println("Arrival Time: "+d.v.ArrivalTime);
                    d.v.isParked=true;
                    d.v.slotNum=i;
                    arr[i].isFree=false;
                    break;

                }
            }
        }
    }
}
