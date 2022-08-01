package System;

//this class is for displaying the slots to the Admin
public class SlotsDisplayer {

    Slot[] arr;
    public SlotsDisplayer(Slot[] s){arr=s;}

    public void DisplayFreeSlots(){
        if (arr==null){
            System.out.println("You didnt fill slots please fill slots");
        }
        else{
            // loop to fill the Slots
            for(int i=0;i<arr.length;i++){
                //display the free slot
                if(arr[i].isFree){
                    System.out.println("Slot "+(i+1)+" is free");
                }
            }
        }

    }


}
