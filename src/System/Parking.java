package System;

import Actors.Driver;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parking {

    public ParkIn parkInterface;



    public void parkIn(Driver d,Slot[] arr){

        if(d.v.isParked==true)
        {
            System.out.println("You already parked in");

        }
        else{

            parkInterface.parkInMethod(arr,d);

        }

    }


    public void parkOut(Driver d,Slot arr[]) throws ParseException {
        //Next condition check if the driver is already parked his car or not
        if(d.v.isParked==false){
            System.out.println("You Didnt park in ");
        }
        else{

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            //Next line is for record the departure time
            d.v.DepartureTime = dtf.format(now);
            d.v.isParked=false;
            arr[d.v.slotNum].isFree=true;
            System.out.println("Parking Out");
            System.out.println("Departure Time: "+d.v.DepartureTime);

            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date date1 = format.parse(d.v.ArrivalTime);
            Date date2 = format.parse(d.v.DepartureTime);
            //the next lines is used to calculate the Duration
            long differenceHours = (date2.getTime() - date1.getTime())/ (60 * 60 * 1000) % 24;
            long differenceMin = (date2.getTime() - date1.getTime())/  (60 * 1000) % 60;
            long differencesec = (date2.getTime() - date1.getTime())/ 1000 % 60;
            if(differencesec>0){
                differenceMin+=1;
            }
            if(differenceMin>0){
                differenceHours+=1;
            }

            System.out.println(differenceHours);
            //next line to display the duration after parking out
            long fee=differenceHours*5;
            d.v.fees=fee;
            //total
            TotalIncome.incIncome(fee);


            System.out.println("Time Taken: "+differenceHours+" Hour");



        }
    }
}
