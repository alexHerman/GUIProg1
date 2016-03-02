/*******************************************************************************
*
* Description - This class represents a single year of data taken from the xml
* files. 
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
public class MyYear extends org.jfree.data.time.Year{
    public int yearNumber;
    
    public ArrayList<MyMonth> months = new ArrayList<MyMonth>();
    
    MyYear(int yearNumber)
    {
        super(yearNumber);
        this.yearNumber = yearNumber;
    }
}
