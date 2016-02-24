/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.w3c.dom.*;
import static weatherservice.XmlUtil.asList;

/**
 *
 * @author Alex
 */
public class XMLParser {
    
    ArrayList<Year> years = new ArrayList<Year>();
    
    public void Parse(String fileName)
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/yy/yy");
        File dataFile = new File(fileName);
        DataPoint newData = new DataPoint();
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(dataFile);
            doc.getDocumentElement().normalize();
            
            NodeList dataPoints = doc.getElementsByTagName("weather");
            for (Node point : asList(dataPoints)){
                Element dataPoint = (Element)point;
                
                newData.date = LocalDate.parse(dataPoint.getElementsByTagName("date").item(0).getTextContent(), dateFormat);
                newData.barometer = Integer.parseInt(dataPoint.getElementsByTagName("date").item(0).getTextContent());
                newData.heatindex = Integer.parseInt(dataPoint.getElementsByTagName("date").item(0).getTextContent());
                newData.humidity = Integer.parseInt(dataPoint.getElementsByTagName("date").item(0).getTextContent());
                newData.rainfall = Integer.parseInt(dataPoint.getElementsByTagName("date").item(0).getTextContent());
                newData.temperature = Integer.parseInt(dataPoint.getElementsByTagName("date").item(0).getTextContent());
                newData.uvindex = Integer.parseInt(dataPoint.getElementsByTagName("date").item(0).getTextContent());
                newData.windchill = Integer.parseInt(dataPoint.getElementsByTagName("date").item(0).getTextContent());
                newData.windgust = Integer.parseInt(dataPoint.getElementsByTagName("date").item(0).getTextContent());
                newData.windspeed = Integer.parseInt(dataPoint.getElementsByTagName("date").item(0).getTextContent());
                newData.winddirection = getDirection(dataPoint.getElementsByTagName("date").item(0).getTextContent());
            }
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private WindDirection getDirection(String direction)
    {
        if (direction == "E")
            return WindDirection.EAST;
        else if (direction == "W")
            return WindDirection.WEST;
        else if (direction == "N")
            return WindDirection.NORTH;
        else
            return WindDirection.SOUTH;
    }
    
    private void InsertDataPoint(DataPoint newData)
    {
        for (Year year : years)
        {
            if (year.yearNumber == newData.date.getYear())
            {
                
            }
        }
    }
}
