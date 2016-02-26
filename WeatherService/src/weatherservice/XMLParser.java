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
    
    public void ParseFile(String fileName)
    {
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
                
                newData = CreateDataPoint(dataPoint);
                InsertDataPoint(newData);
            }
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void ParseDirectory(String directoryPath)
    {
        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles)
        {
            ParseFile(file.getPath());
        }
    }
    
    private DataPoint CreateDataPoint(Element dataPoint)
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(" MM/dd/yy ");
        DataPoint newData = new DataPoint();
        NodeList x;
        
        x = dataPoint.getElementsByTagName("date");
        if (x.getLength() > 0){
            newData.date = LocalDate.parse(x.item(0).getTextContent(), dateFormat);
        }
        x = dataPoint.getElementsByTagName("barometer");
        if (x.getLength() > 0){
            newData.barometer = tryParseFloat(x.item(0).getTextContent());
        }
        x = dataPoint.getElementsByTagName("heatindex");
        if (x.getLength() > 0){
            newData.heatindex = tryParseFloat(x.item(0).getTextContent());
        }
        x = dataPoint.getElementsByTagName("humidity");
        if (x.getLength() > 0){
            newData.humidity = tryParseFloat(x.item(0).getTextContent());
        }
        x = dataPoint.getElementsByTagName("rainfall");
        if (x.getLength() > 0){
            newData.rainfall = tryParseFloat(x.item(0).getTextContent());
        }
        x = dataPoint.getElementsByTagName("temperature");
        if (x.getLength() > 0){
            newData.temperature = tryParseFloat(x.item(0).getTextContent());
        }
        x = dataPoint.getElementsByTagName("uvindex");
        if (x.getLength() > 0){
            newData.uvindex = tryParseFloat(x.item(0).getTextContent());
        }
        x = dataPoint.getElementsByTagName("windchill");
        if (x.getLength() > 0){
            newData.windchill = tryParseFloat(x.item(0).getTextContent());
        }
        x = dataPoint.getElementsByTagName("windgust");
        if (x.getLength() > 0){
            newData.windgust = tryParseFloat(x.item(0).getTextContent());
        }
        x = dataPoint.getElementsByTagName("windspeed");
        if (x.getLength() > 0){
            newData.windspeed = tryParseFloat(x.item(0).getTextContent());
        }
        
        x = dataPoint.getElementsByTagName("winddirection");
        if (x.getLength() > 0){
            newData.winddirection = getDirection(x.item(0).getTextContent());
        }
        
        
        return newData;
    }
    
    private float tryParseFloat(String num)
    {
        if (num.isEmpty())
            return 0;
        else
            return Float.parseFloat(num);
    }
    
    private WindDirection getDirection(String direction)
    {
        if (direction.equals(" E "))
            return WindDirection.EAST;
        else if (direction.equals(" W "))
            return WindDirection.WEST;
        else if (direction.equals(" N "))
            return WindDirection.NORTH;
        else
            return WindDirection.SOUTH;
    }
    
    private void InsertDataPoint(DataPoint newData)
    {
        Year foundYear = null;
        Month foundMonth = null;
        Day foundDay = null;
        for (Year year : years)
        {
            if (year.yearNumber == newData.date.getYear())
            {
                foundYear = year;
                for (Month month : year.months)
                {
                    if (month.monthOfYear == newData.date.getMonthValue())
                    {
                        foundMonth = month;
                        for (Day day : month.days)
                        {
                            if (day.dayOfMonth == newData.date.getDayOfMonth())
                            {
                                foundDay = day;
                            }
                        }
                    }
                }
            }
        }
        
        if (foundYear == null)
        {
            foundYear = new Year(newData.date.getYear());
            years.add(foundYear);
        }
        
        if (foundMonth == null)
        {
            foundMonth = new Month(newData.date.getMonthValue());
            foundYear.months.add(foundMonth);
        }
        
        if (foundDay == null)
        {
            foundDay = new Day(newData.date.getDayOfMonth());
            foundMonth.days.add(foundDay);
        }
        
        foundDay.dataPoints.add(newData);
    }
}
