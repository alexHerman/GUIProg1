/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Alex
 */
public class Month {
    public int monthOfYear;
    
    public ArrayList<Day> days;
    
    Month(int monthNumber)
    {
        monthOfYear = monthNumber;
        
    }
}
