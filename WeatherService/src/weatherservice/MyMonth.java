/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import java.util.ArrayList;
import static weatherservice.StatisticsCalculator.MeanTemperature;

/**
 *
 * @author Alex
 */
public class MyMonth extends org.jfree.data.time.Month {
    public int monthOfYear;
    
    public ArrayList<MyDay> days = new ArrayList<MyDay>();
    
    MyMonth(int monthNumber, int yearNumber)
    {
        super(monthNumber, yearNumber);
        monthOfYear = monthNumber;
    }
}
