
/**
 * Write a description of class Journey here.
 * 
 * @author Michael Lai
 * @version 1.2 (28/3/2017)
 * To Fix: round cost to 2 decimal places.
 */
public class Journey 
{
    /* Journey HAS A 1 way cost
     * Journey HAS A return cost
     * Journey HAS A departing station
     * Journey HAS A destination station
     * Journey HAS A departure date
     * Journey HAS A journey time
     */
    Results r;
    protected double howMuch;
    private String roundedHowMuch;
    protected String stations;
    protected String time;
    protected String deptSta;
    protected String destSta;
    protected int discount;
    public Journey(String deptSta, String destSta, int sor, int soa, int deptIndex, int destIndex, int discount) 
    {
       
       switch(deptIndex)
       {
           case 0: switch(destIndex)
                   {
                        case 1:LeicesterToLoughborough(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 2:LeicesterToNottingham(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 3:LeicesterToDerby(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 4:LeicesterToYork(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;        
                   }
                   break;
           case 1: switch(destIndex)
                   {
                        case 0:LoughboroughToLeicester(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 2:LoughboroughToNottingham(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 3:LoughboroughToDerby(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 4:LoughboroughToYork(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;        
                   }
                   break;
           case 2:switch(destIndex)
                  {
                        case 0:NottinghamToLeicester(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 1:NottinghamToLoughborough(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 3:NottinghamToDerby(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 4:NottinghamToYork(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;        
                  }
                  break;
           case 3:switch(destIndex)
                  {
                        case 0:DerbyToLeicester(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 1:DerbyToLoughborough(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 2:DerbyToNottingham(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 4:DerbyToYork(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;        
                  }
                  break;
           case 4:switch(destIndex)
                  {
                        case 0:YorkToLeicester(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 1:YorkToLoughborough(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 2:YorkToNottingham(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;
                        case 3:YorkToDerby(deptSta, destSta, deptIndex, destIndex, sor, soa, discount);
                               break;        
                  }
                  break;
       }
       
       
    }
    
    
    private void LeicesterToLoughborough(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Leicester to Loughborough");
        time = ("Journey Time: 10 Minutes");
        switch(sor) {
            case 0: howMuch = 2.50;
                    break;
            case 1: howMuch = 4.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void LeicesterToNottingham(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Leicester to Nottingham");
        time = ("Journey Time: 30 Minutes");
        switch(sor) {
            case 0: howMuch = 3.50;
                    break;
            case 1: howMuch = 6.20;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void LeicesterToDerby(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Leicester to Derby");
        time = ("Journey Time: 48 Minutes");
        switch(sor) {
            case 0: howMuch = 3.70;
                    break;
            case 1: howMuch = 7.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void LeicesterToYork(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Leicester to York");
        time = ("Journey Time: 1 Hour, 5 Minutes");
        switch(sor) {
            case 0: howMuch = 23.50;
                    break;
            case 1: howMuch = 25.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void LoughboroughToLeicester(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Loughborough to Leicester");
        time = ("Journey Time: 10 Minutes");
        switch(sor) {
            case 0: howMuch = 2.50;
                    break;
            case 1: howMuch = 4.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void LoughboroughToNottingham(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Loughborough to Nottingham");
        time = ("Journey Time: 15 Minutes");
        switch(sor) {
            case 0: howMuch = 1.50;
                    break;
            case 1: howMuch = 2.50;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void LoughboroughToDerby(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Loughborough to Derby");
        time = ("Journey Time: 23 Minutes");
        switch(sor) {
            case 0: howMuch = 1.25;
                    break;
            case 1: howMuch = 2.50;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void LoughboroughToYork(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Loughborough to York");
        time = ("Journey Time: 1 Hour");
        switch(sor) {
            case 0: howMuch = 11.50;
                    break;
            case 1: howMuch = 20.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void NottinghamToLeicester(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Nottingham to Leicester");
        time = ("Journey Time: 30 Minutes");
        switch(sor) {
            case 0: howMuch = 3.50;
                    break;
            case 1: howMuch = 6.20;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void NottinghamToLoughborough(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Nottingham to Loughborough");
        time = ("Journey Time: 15 Minutes");
        switch(sor) {
            case 0: howMuch = 1.50;
                    break;
            case 1: howMuch = 2.50;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void NottinghamToDerby(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Nottingham to Derby");
        time = ("Journey Time: 12 Minutes");
        switch(sor) {
            case 0: howMuch = 2.50;
                    break;
            case 1: howMuch = 3.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void NottinghamToYork(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Nottingham to York");
        time = ("Journey Time: 40 Minutes");
        switch(sor) {
            case 0: howMuch = 11.50;
                    break;
            case 1: howMuch = 16.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void DerbyToLeicester(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Derby to Leicester");
        time = ("Journey Time: 48 Minutes");
        switch(sor) {
            case 0: howMuch = 3.70;
                    break;
            case 1: howMuch = 7.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void DerbyToLoughborough(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Derby to Loughborough");
        time = ("Journey Time: 25 Minutes");
        switch(sor) {
            case 0: howMuch = 2.00;
                    break;
            case 1: howMuch = 2.50;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void DerbyToNottingham(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Derby to Nottingham");
        time = ("Journey Time: 10 Minutes");
        switch(sor) {
            case 0: howMuch = 1.50;
                    break;
            case 1: howMuch = 3.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void DerbyToYork(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("Derby to York");
        time = ("Journey Time: 1 Hour 25 Minutes");
        switch(sor) {
            case 0: howMuch = 7.20;
                    break;
            case 1: howMuch = 16.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void YorkToLeicester(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("York to Leicester");
        time = ("Journey Time: 1 Hour 10 Minutes");
        switch(sor) {
            case 0: howMuch = 12.20;
                    break;
            case 1: howMuch = 25.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void YorkToLoughborough(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("York to Loughborough");
        time = ("Journey Time: 1 Hour");
        switch(sor) {
            case 0: howMuch = 12.00;
                    break;
            case 1: howMuch = 20.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void YorkToNottingham(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("York to Nottingham");
        time = ("Journey Time: 40 Minutes");
        switch(sor) {
            case 0: howMuch = 8.20;
                    break;
            case 1: howMuch = 16.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
    public void YorkToDerby(String deptSta, String destSta, int deptIndex, int destIndex, int sor, int soa, int discount)
    {
        stations = ("York to Derby");
        time = ("Journey Time: 1 Hour 15 Minutes");
        switch(sor) {
            case 0: howMuch = 11.20;
                    break;
            case 1: howMuch = 16.00;
                    break;
        }
        r = new Results(deptSta, destSta, stations, deptIndex, destIndex, time, sor, soa, howMuch, discount);
    }
    
}
