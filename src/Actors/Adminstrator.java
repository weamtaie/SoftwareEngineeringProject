package Actors;

public class Adminstrator {
    public String email=new String();
    public String password=new String();

    public Adminstrator() {
        email="";
        password="";

    }

    public Adminstrator(String e,String p) {
        email=e;
        password=p;

    }

    public void setEmail(String e){
        email=e;
    }

    public void setPassword(String p){
        password=p;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }


}
