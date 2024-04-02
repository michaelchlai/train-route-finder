import java.io.BufferedWriter;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.time.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.MutableComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.DefaultListCellRenderer; 
import java.io.IOException;
import java.io.FileWriter;

/**
 * Write a description of class Admin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Save 
{
    // instance variables - replace the example below with your own
    private String path;
    private boolean append_to_file = false;
    private String[] splitInput;
    private int splitIndex;
    private boolean empty;
    /**
     * Constructor for objects of class Admin
     */
    protected Save(int adminDeptIndex, int adminDestIndex, String adminDeptSta, String adminDestSta, String textInput)
    {
        String[] splitInput = textInput.split(",");
        splitIndex = (int) splitInput.length;
        path = "../OOPCW/textfiles/"+adminDeptIndex + "to" +adminDestIndex+".txt";
        boolean empty = false;
        for (int i=0; i<splitIndex;i++)
        {
            if(splitInput[i].length() ==0)
            {
                System.out.println("please fill all array elements.");
                empty = true;
                break;
            }
        }
        if(empty == false){
            try{writeToFile(path, splitInput);}
            
            catch(IOException e) {System.out.println(e.getMessage());}
        }
    }
    
    public void writeToFile(String path, String[]splitInput ) throws IOException
    {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(path));
        for (int i=0; i<splitIndex; i++) 
        {
            outputWriter.write(splitInput[i]+",");
        }
        outputWriter.flush();  
        outputWriter.close();
    }
}
