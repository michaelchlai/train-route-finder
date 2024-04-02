
 
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Write a description of class File here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Retrieve 
{
    // instance variables - replace the example below with your own
    private String path;
    protected String aryLines;
    protected static String hehe;
    /**
     * Constructor for objects of class File
     */
    protected Retrieve(int adminDeptIndex, int adminDestIndex)
    {
        path = "../OOPCW/textfiles/"+adminDeptIndex + "to" +adminDestIndex+".txt";
        try
        {
            String aryLines = OpenFile();
            SendBack(aryLines);
        }
        catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
    }
    
    public String OpenFile() throws IOException
    {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        String textData=textReader.readLine();
        textReader.close();
        return textData;
    }
    protected String SendBack(String aryLines)
    {
        hehe = aryLines;
        return hehe;
    }
    public static String textFieldString()
    {
        return hehe;
    }
}
