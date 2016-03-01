/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class myMonth {
    public int monthOfYear;
    
    public ArrayList<Day> days = new ArrayList<Day>();
    
    myMonth(int monthNumber)
    {
        monthOfYear = monthNumber;
    }
}
