import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JRadioButton;
/**
 * Write a description of class Date here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Date extends JFrame
{
    // instance variables - replace the example below with your own
    private static String[] years = {"2017", "2018", "2019", "2020", "2021", "2022"};
    private static String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    protected static Integer[] days = {1};
    private static int numberOfDays;
    private static JComboBox dayList;
    
    protected Date (int yearsIndex, int monthsIndex)
    {
        switch (monthsIndex) {
            case 0: case 2: case 4: case 6: case 7: case 9: case 11:
                numberOfDays = 31;
                break;
            case 3: case 5: case 8: case 10:
                numberOfDays = 30;
                break;
            case 1:
                if (yearsIndex == 3)
                    numberOfDays = 29;
                else
                    numberOfDays = 28;
                break;
        }
        
        Integer[] days = new Integer[numberOfDays];
        
        for(int i=0;i>numberOfDays;i++)
        {
            days[i] = i+1;
        }
    }
    
    protected static int getNumberOfDays(){return numberOfDays;}
    protected static String[] getYears(){return years;}
    protected static String[] getMonths(){return months;}

}
