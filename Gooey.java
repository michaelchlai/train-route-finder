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
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


/**
 * Write a description of class Gooey here.
 * 
 * @author Michael Lai
 * @version 1.4 (15/5/2017)
 */
public class Gooey extends JPanel
{
    // instance variables - replace the example below with your own
    Journey j;
    JTextField textField;
    Save s;
    Retrieve r;
    Results res;
    
    private String file_name;
    private String deptSta;
    private String destSta;
    private int deptIndex;
    private int destIndex;
    private String adminDeptSta;
    private String adminDestSta;
    private String textInput;
    private int adminDeptIndex;
    private int adminDestIndex;
    private int tabIndex;
    private int numberOfDays;
    private int sor;
    private int soa;
    private int discount;
    private int monthsIndex;
    private int yearsIndex;
    private int daysIndex;
    private String[] stationNames = {"Leicester","Loughborough","Nottingham","Derby","York"};
    public static void main(String[] args)
    {
        GUI();
    }

    
    /*
    private void results()
    {
        System.out.println("Your departing station is " + deptSta + " and your destination station is " + destSta + ".");
        System.out.println("Station index: " + deptIndex + "," + destIndex);
        
    }
    */
   
    private static void GUI() {
        //Create and set up the window.
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle ("I like trains LLC");
        frame.setSize( 800, 600 );
        frame.setResizable ( true );

        frame.add(new Gooey());
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
    
    /**
     * Constructor for objects of class Gooey
     */
    private Gooey()
    /* we get 6 inputs from the customer
         * Departing Station
         * Destination Station
         * Single or Return
         * Date
         * Sort (either in order of appearance or alphabetically)
         * End
         */
    {
        // initialise instance variables
        JTabbedPane tabs = new JTabbedPane();

        
        
        
        JComponent p2 = new JPanel(false);
        p2.setLayout(new FlowLayout());

        
        JComboBox<String> departingStation = new JComboBox<> (stationNames);
        p2.add(departingStation);
        
        JComboBox<String> destinationStation = new JComboBox<> (stationNames);
        p2.add(destinationStation);
        
        JTextField textField= new JTextField(10);
        p2.add(textField);
        textField.setVisible(false);
        JButton saveroutebutton = new JButton("Save Route");        
        saveroutebutton.setVisible(false);
        JButton retrievebutton = new JButton("Retrieve Route");
        retrievebutton.setVisible(false);
        class ComboBoxHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                adminDeptIndex = (int) departingStation.getSelectedIndex();
                adminDestIndex = (int) destinationStation.getSelectedIndex();
                if (adminDeptIndex == adminDestIndex)
                {
                    textField.setVisible(false);
                    saveroutebutton.setVisible(false);
                    retrievebutton.setVisible(false);
                }
                else
                {
                    textField.setVisible(true);
                    saveroutebutton.setVisible(true);
                    retrievebutton.setVisible(true);
                }
            }
        }
        
        class SaveButtonHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                adminDeptSta = (String) departingStation.getSelectedItem();
                adminDestSta = (String) destinationStation.getSelectedItem();
                adminDeptIndex = (int) departingStation.getSelectedIndex();
                adminDestIndex = (int) destinationStation.getSelectedIndex();
                textInput = (String) textField.getText();
                s = new Save(adminDeptIndex, adminDestIndex, adminDeptSta, adminDestSta, textInput);
            }
        }
    
        
        class RetrieveButtonHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                adminDeptIndex = (int) departingStation.getSelectedIndex();
                adminDestIndex = (int) destinationStation.getSelectedIndex();
                r = new Retrieve(adminDeptIndex, adminDestIndex);
                textField.setText(Retrieve.textFieldString());
                textField.validate();
            }
        }    
        SaveButtonHandler savebuttonhandler = new SaveButtonHandler();
        saveroutebutton.addActionListener(savebuttonhandler);
        p2.add(saveroutebutton);
        
        RetrieveButtonHandler retrievebuttonhandler = new RetrieveButtonHandler();
        retrievebutton.addActionListener(retrievebuttonhandler);
        p2.add(retrievebutton);
        
        ComboBoxHandler comboboxhandler = new ComboBoxHandler();
        departingStation.addActionListener(comboboxhandler);
        destinationStation.addActionListener(comboboxhandler);
        
        JComponent p1 = instantiateUserMenu();
        tabs.addTab("User", null, p1, "User Menu");
        tabs.addTab("Admin", null, p2, "Admin Menu");
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        add(tabs);
        
    }
    
    
    protected JComponent instantiateUserMenu()
    {
        JPanel p1 = new JPanel(false);
        p1.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.ipadx = 10;
        c.ipady = 20;
        c.insets = new Insets(0,0,0,0);

        //ComboBoxes for departing and destination stations
        JComboBox<String> departingStation = new JComboBox<> (stationNames);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,100,10,0);
        p1.add(departingStation, c);
        
        JComboBox<String> destinationStation = new JComboBox<> (stationNames);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(10,10,10,100);
        p1.add(destinationStation, c);
        
        //RadioButtons to select single or return journey
        //and
        //RadioButtons to select the order of stops
        
        JRadioButton oneWay = new JRadioButton ("Single");
        JRadioButton twoWay = new JRadioButton ("Return");
        JRadioButton sequential = new JRadioButton ("Sequential");
        JRadioButton alphabetical = new JRadioButton ("Alphabetical");
        ButtonGroup singleOrReturn = new ButtonGroup();
        ButtonGroup seqOrAlph = new ButtonGroup();
        singleOrReturn.add(oneWay);
        singleOrReturn.add(twoWay);
        seqOrAlph.add(sequential);
        seqOrAlph.add(alphabetical);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(10,10,10,10);
        p1.add(oneWay, c);
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(10,10,10,10);
        p1.add(sequential, c);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(10,10,10,10);
        p1.add(twoWay, c);
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(10,10,10,10);
        p1.add(alphabetical, c);
        oneWay.setSelected(true);//sets default button selected as "Single"
        sequential.setSelected(true);
        //Date and Discount
        
        JComboBox<String> yearList = new JComboBox<> (Date.getYears());
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.insets = new Insets(0,10,0,10);
        c.anchor = GridBagConstraints.CENTER;
        p1.add(yearList, c);
        
        JComboBox<String> monthList = new JComboBox<> (Date.getMonths());
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER; 
        p1.add(monthList, c);

        JComboBox<Integer> dayList = new JComboBox<> (Date.days);
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        p1.add(dayList, c);
        dayList.setVisible(false);
        daysIndex = 1;
        
        class ComboBoxHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                
                yearsIndex = (int) yearList.getSelectedIndex();
                monthsIndex = (int) monthList.getSelectedIndex();
                daysIndex = (int) dayList.getSelectedIndex();
                new Date(yearsIndex, monthsIndex);
                
                dayList.removeAllItems();
                numberOfDays = Date.getNumberOfDays();
                for(int i=0; i<numberOfDays;i++)
                {
                    dayList.addItem(i+1);
                }
                if (daysIndex>=numberOfDays){
                    dayList.setSelectedIndex(0);
                }
                else{
                    dayList.setSelectedIndex(daysIndex);
                }
                dayList.setVisible(true);
            }   
        }
        
        
        //Submit button to submit query
        JButton submitbutton = new JButton("Submit");

        
        class ButtonHandler implements ActionListener
        //when the "Submit" button is pressed
        {
            public void actionPerformed(ActionEvent e)
            {
                //assigns deptSta and destSta to the selected departing and destination stations
                deptSta = (String) departingStation.getSelectedItem();
                destSta = (String) destinationStation.getSelectedItem();
                deptIndex = (int) departingStation.getSelectedIndex();
                destIndex = (int) destinationStation.getSelectedIndex();
                daysIndex = (int) dayList.getSelectedIndex();
                if (deptIndex == destIndex)
                {
                    System.out.println("Error: Please Select 2 Different Stations");
                }
                else 
                {
                    if (oneWay.isSelected()) 
                    {
                        sor = 0;
                    }
                    else
                    {
                        sor = 1;
                    }
                    
                    if (sequential.isSelected()) 
                    {
                        soa = 0;
                    }
                    else
                    {
                        soa = 1;
                    }
                    
                    if(daysIndex == (numberOfDays-1)){
                        discount = 1;
                    }
                    else{
                        discount = 0;
                    }
                    
                    j = new Journey(deptSta, destSta, sor, soa, deptIndex, destIndex, discount);
                        /* Journey class also needs a revamp, think the other stuff should be subclassses of it
                         * Journey should have many parameters, like: (deptsta, deststa, singleOrReturn, date, sort)
                         * then through Journey split into subclasses - all should be HAS-A relationship
                         */
                    
                    
                }
            }
        }
       
        //Handlers
        ComboBoxHandler comboboxhandler = new ComboBoxHandler();
        monthList.addActionListener(comboboxhandler);
        yearList.addActionListener(comboboxhandler);
        departingStation.addActionListener(comboboxhandler);
        destinationStation.addActionListener(comboboxhandler);
        
        ButtonHandler buttonhandler = new ButtonHandler();
        submitbutton.addActionListener(buttonhandler);
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(0,0,0,0);
        p1.add(submitbutton, c);
        
        DefaultListCellRenderer renderer = new DefaultListCellRenderer(); 
        renderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
        yearList.setRenderer(renderer);
        monthList.setRenderer(renderer);
        dayList.setRenderer(renderer);
        
        return p1;
    }
    
    
}
