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
public class Year {
    public int yearNumber;
    
    public ArrayList<Month> months;
    
    Year(int yearNumber)
    {
        months.add(new Month(1));
        months.add(new Month(2));
        months.add(new Month(3);
        months.add(new Month(4));
        months.add(new Month(5));
        months.add(new Month(6));
        months.add(new Month(7));
        months.add(new Month(8));
        months.add(new Month(9));
        months.add(new Month(10));
        months.add(new Month(11));
        months.add(new Month(12));
    }
}
