/*******************************************************************************
*
* Description - This class represents a single month of data taken from the xml
* files. 
* 
* Author - Alex Herman
*******************************************************************************/
package weatherservice;

import java.util.ArrayList;
import static weatherservice.StatisticsCalculator.MeanTemperature;


public class MyMonth extends org.jfree.data.time.Month {
    public int monthOfYear;
    
    public ArrayList<MyDay> days = new ArrayList<MyDay>();
    
    MyMonth(int monthNumber, int yearNumber)
    {
        super(monthNumber, yearNumber);
        monthOfYear = monthNumber;
    }
}
