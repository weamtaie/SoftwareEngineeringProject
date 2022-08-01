package System;


public class Slot {
    public int width;
    public int length;

    public boolean isFree;

    public Slot(){
        isFree=true;
        width=0;
        length=0;
    }

    public void setWidth(int w){
        width=w;
    }

    public int getWidth(){
        return width;
    }

    public void setLength(int l){
        length=l;
    }

    public int getLength(){
        return length;
    }

}
