/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author Alex
 */
public class DataPoint {
    public LocalDate date;
    
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
}
