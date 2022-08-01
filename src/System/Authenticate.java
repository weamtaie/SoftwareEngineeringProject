package System;

import Actors.Adminstrator;

public class Authenticate {

    public Adminstrator admin=new Adminstrator("tarek@gmail.com","15112001");

    // login to check the admin email and password
    public boolean Login(Adminstrator a){
//        Scanner s=new Scanner(System.in);

        if(admin.getEmail()==a.getEmail()){
            if(admin.getPassword()==a.getPassword())
                return true;
            else
                return false;
        }
        else {
            return false;
        }
    }

}
