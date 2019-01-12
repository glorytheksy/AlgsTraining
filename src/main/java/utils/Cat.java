package utils;

import java.util.Calendar;
import java.util.Date;

public class Cat extends Pet{
    
    public static int test(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        return (int) (calendar.getTimeInMillis() / 1000);
    }
    
        
    public Cat() {
        super("cat");
    }
    
    public Cat(String name){
        super("cat");
        this.name = name;
    }
    
    public static void main(String[] args) {
        System.out.println(test(new Date()));
    }

}
