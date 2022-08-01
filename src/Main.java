import Actors.*;
import System.*;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

//    function to display available configurations and admin can choose from them it returns string with the choice
    public static String setConfigurations(){

        Scanner s=new Scanner(System.in);
        System.out.println("Choose Slot Configuration");
        String conf;
        while(true) {
            System.out.println("1- Pick first free slot");
            System.out.println("2- Pick best slot");
            int choice = s.nextInt();
            if (choice == 1) {
                conf="first free";
                break;
            } else if (choice == 2) {
                conf="best fit";

                break;
            } else {
                System.out.println("Pleas enter Choose from the above menu");
            }
        }
        return conf;
    }



    public static void main(String args[]) throws ParseException {
        Scanner scan=new Scanner(System.in); // scanner for input

        Driver driver=new Driver(); // driver instance
        Garage sys=new Garage(); // garage system instance

        // Admin menu pannel

        System.out.println("---------ADMIN-----------");
        System.out.println("Enter Email and Password To Login: ");
        System.out.println("Email: ");
        String email= new String(scan.next()) ;
        System.out.println("Password: ");
        String pass=new String(scan.next());
        Adminstrator admin=new Adminstrator("tarek@gmail.com","15112001");
        Authenticate auth=new Authenticate(); // authentication instance

        while(true){
            boolean flag;
            flag=auth.Login(admin);
//            System.out.print(flag);
            if(flag==true){
                break;
            }
            else{
                System.out.println("Enter Correct Email and password: ");
                admin.setEmail(scan.next());
                admin.setPassword(scan.next());

            }
        }

        while (true) {


            System.out.println("------------Control Menu------------");
            System.out.println("1- Fill Slots");
            System.out.println("2- Display Empty Slots");
            System.out.println("3- Set Configurations");
            System.out.println("4- See Total Income");
            System.out.println("5- Save Program Setups");
            int choice=scan.nextInt();
            while(true){
                if(choice==1){
                    sys.fillSlots();
                }

                else if (choice==2) {
                    sys.slotsDisplayer.DisplayFreeSlots();
                }

                else if (choice==3) {
                    String tmp=setConfigurations();
                    if(tmp=="first free"){
                        sys.parking.parkInterface=new ParkInFirstFree();
                        System.out.println("Configuration set to First Free");

                    }
                    else if (tmp=="best fit") {
                        sys.parking.parkInterface=new ParkInBestFit();
                        System.out.println("Configuration set to Best Fit");
                    }
                }

                else if(choice==4){
                    System.out.println("Your Total Income is: "+TotalIncome.getIncome());


                }else if(choice==5){
                    System.out.println("Program Setups Saved...");
                    break;
                }

                else {
                    System.out.println("Pleas enter right Choice");
                }

                System.out.println("1- Fill Slots");
                System.out.println("2- Display Empty Slots");
                System.out.println("3- Set Configurations");
                System.out.println("4- See Total Income");
                System.out.println("5- Save Program Setups");
                choice=scan.nextInt();

            }

            System.out.println("\n-----------Driver-----------");


            System.out.println("------------Driver Options------------");
            System.out.println("1- Park In");
            System.out.println("2- Park Out");
            System.out.println("3- Exit");

            choice=scan.nextInt();

            while(true){
                if(choice==1){
                    sys.parking.parkIn(driver,sys.arr);
                }
                else if (choice==2) {
                    sys.parking.parkOut(driver,sys.arr);
                }
                else if (choice==3) {
                    System.out.println("Exit...");
                    break;
                }

                else {
                    System.out.println("Pleas enter right Choice");
                }

                System.out.println("1- Park In");
                System.out.println("2- Park Out");
                System.out.println("3- Exit");
                choice=scan.nextInt();

            }

            System.out.println("1- Login to Administration");
            System.out.println("2- End Program");
            choice=scan.nextInt();
            if(choice==2){
                System.out.println("Program Ended...");
                break;
            }

        }

    }

}
