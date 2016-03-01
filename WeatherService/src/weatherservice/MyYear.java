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
public class MyYear extends org.jfree.data.time.Year{
    public int yearNumber;
    
    public ArrayList<MyMonth> months = new ArrayList<MyMonth>();
    
    MyYear(int yearNumber)
    {
        super(yearNumber);
        this.yearNumber = yearNumber;
    }
}
