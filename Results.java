import java.io.IOException;
import java.util.Arrays;
/**
 * Write a description of class Results here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Results
{
    // instance variables - replace the example below with your own
    Retrieve r;
    private String stops;
    private String[] stopArr;
    /**
     * Constructor for objects of class Results
     */
    public Results(String dept, String dest, String stations, int deptIndex, int destIndex, String time, int sor, int soa, double howMuch, int discount)
    {
        r = new Retrieve(deptIndex, destIndex);
        System.out.println(stations);
        System.out.println(time);
        switch(sor) 
        {
            case 0: System.out.println("Single");
                    break;
            case 1: System.out.println("Return");
                    break;
        }
        switch(discount)
        {
           case 0: System.out.println("Cost: £" + howMuch);
                   break;
           case 1: howMuch = howMuch*0.9;
                   System.out.println("Cost: £" + howMuch);
                   System.out.println("(Last day of the Month: 10% Discount Applied.)");
                   break;
        }
        
        
        stops = Retrieve.textFieldString();
        if (stops == null)
        {
            System.out.println("There aren't any stops between "+dept+" and "+dest+".");
        }
        else if(stops.length() == 1)
        {
            System.out.println("There aren't any stops between "+dept+" and "+dest+".");
        }
        else
        {
            System.out.println("Stops between "+dept+" and "+dest+":");
            stopArr = stops.split(",");
            if (soa == 1)
            {
                Arrays.sort(stopArr);
                System.out.println("(Sorted Alphabetically)");
                for (int s=0;s<stopArr.length;s++){
                    System.out.println(stopArr[s]);
                }
            }
            else
            {
                System.out.println("(Sorted in Order of Appearance)");
                for (int s=0;s<stopArr.length;s++){
                    System.out.println(stopArr[s]);
                }
            }
        }
        

    }
}
