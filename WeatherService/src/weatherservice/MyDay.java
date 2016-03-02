/*******************************************************************************
*
* Description - This class represents the data for a single day of data. 
* 
* Author - Alex Herman
*******************************************************************************/
package weatherservice;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Alex
 */
public class MyDay extends org.jfree.data.time.Day {
    public int dayOfMonth;
    
    public ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();
    
    MyDay (int dayOfMonth, int monthNumber, int yearNumber)
    {
        super(dayOfMonth, monthNumber, yearNumber);
        this.dayOfMonth = dayOfMonth;
    }
}
