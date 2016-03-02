/*
 * This class represents the measurements taken from a single reading of the 
 * measurement device. It also extends a class so that it can be used by 
 * JFreeChart.
 *
 * Author: Alex Herman
 */
package weatherservice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DataPoint extends org.jfree.data.time.Minute {
    public LocalDateTime date;
    
    public float temperature;
    
    public float humidity;
   
    public float barometer;
    
    public float windspeed;
    
    public WindDirection winddirection;
    
    public float windgust;
    
    public float windchill;
    
    public float heatindex;
    
    public float uvindex;
    
    public float rainfall;
    
    DataPoint(LocalDateTime date){
        super(date.getMinute(), date.getHour(), date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        this.date = date;
    }
    
    DataPoint()
    {
    }
}
