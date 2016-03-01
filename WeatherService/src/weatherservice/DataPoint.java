/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alex
 */
public class DataPoint extends org.jfree.data.time.Day {
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
        super(Date.from(date.atZone(ZoneId.systemDefault()).toInstant()));
        this.date = date;
    }

    DataPoint() {
        
    }
}
