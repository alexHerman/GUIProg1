/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static weatherservice.XmlUtil.asList;

/**
 *
 * @author Alex
 */
public class XMLParser {
    static ArrayList<MyYear> years = new ArrayList<MyYear>();
    
    public void ParseFiles(String[] fileNames)
    {
        for (String fileName : fileNames)
        {
            ParseFile(fileName);
        }
    }
    
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
        NodeList currentData;
        LocalDateTime newDate;
        DataPoint newData;
        
        currentData = dataPoint.getElementsByTagName("date");
        if (currentData.getLength() > 0){
            newDate = LocalDate.parse(currentData.item(0).getTextContent(), dateFormat).atTime(parseTime(
                dataPoint.getElementsByTagName("time").item(0).getTextContent()));
            
            newData = new DataPoint(newDate);
        }
        else{
            newData = new DataPoint();
        }
        
        currentData = dataPoint.getElementsByTagName("barometer");
        if (currentData.getLength() > 0){
            newData.barometer = tryParseFloat(currentData.item(0).getTextContent());
        }
        currentData = dataPoint.getElementsByTagName("heatindex");
        if (currentData.getLength() > 0){
            newData.heatindex = tryParseFloat(currentData.item(0).getTextContent());
        }
        currentData = dataPoint.getElementsByTagName("humidity");
        if (currentData.getLength() > 0){
            newData.humidity = tryParseFloat(currentData.item(0).getTextContent());
        }
        currentData = dataPoint.getElementsByTagName("rainfall");
        if (currentData.getLength() > 0){
            newData.rainfall = tryParseFloat(currentData.item(0).getTextContent());
        }
        currentData = dataPoint.getElementsByTagName("temperature");
        if (currentData.getLength() > 0){
            newData.temperature = tryParseFloat(currentData.item(0).getTextContent());
        }
        currentData = dataPoint.getElementsByTagName("uvindex");
        if (currentData.getLength() > 0){
            newData.uvindex = tryParseFloat(currentData.item(0).getTextContent());
        }
        currentData = dataPoint.getElementsByTagName("windchill");
        if (currentData.getLength() > 0){
            newData.windchill = tryParseFloat(currentData.item(0).getTextContent());
        }
        currentData = dataPoint.getElementsByTagName("windgust");
        if (currentData.getLength() > 0){
            newData.windgust = tryParseFloat(currentData.item(0).getTextContent());
        }
        currentData = dataPoint.getElementsByTagName("windspeed");
        if (currentData.getLength() > 0){
            newData.windspeed = tryParseFloat(currentData.item(0).getTextContent());
        }
        
        currentData = dataPoint.getElementsByTagName("winddirection");
        if (currentData.getLength() > 0){
            newData.winddirection = getDirection(currentData.item(0).getTextContent());
        }
        
        
        return newData;
    }
    
    private float tryParseFloat(String num)
    {
        try 
        {
            return Float.parseFloat(num);
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    
    private WindDirection getDirection(String direction)
    {
        if (direction.equals(" N "))
            return WindDirection.N;
        else if (direction.equals(" NNE "))
            return WindDirection.NNE;
        else if (direction.equals(" NE "))
            return WindDirection.NE;
        else if (direction.equals(" ENE "))
            return WindDirection.ENE;
        else if (direction.equals(" E "))
            return WindDirection.E;
        else if (direction.equals(" ESE "))
            return WindDirection.ESE;
        else if (direction.equals(" SE "))
            return WindDirection.SE;
        else if (direction.equals(" SSE "))
            return WindDirection.SSE;
        else if (direction.equals(" S "))
            return WindDirection.S;
        else if (direction.equals(" SSW "))
            return WindDirection.SSW;
        else if (direction.equals(" SW "))
            return WindDirection.SW;
        else if (direction.equals(" WSW "))
            return WindDirection.WSW;
        else if (direction.equals(" W "))
            return WindDirection.W;
        else if (direction.equals(" WNW "))
            return WindDirection.WNW;
        else if (direction.equals(" NW "))
            return WindDirection.NW;
        else
            return WindDirection.NNW;
    }
    
    private void InsertDataPoint(DataPoint newData)
    {
        MyYear foundYear = null;
        MyMonth foundMonth = null;
        MyDay foundDay = null;
        for (MyYear year : years)
        {
            if (year.yearNumber == newData.date.getYear())
            {
                foundYear = year;
                for (MyMonth month : year.months)
                {
                    if (month.monthOfYear == newData.date.getMonthValue())
                    {
                        foundMonth = month;
                        for (MyDay day : month.days)
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
            foundYear = new MyYear(newData.date.getYear());
            years.add(foundYear);
        }
        
        if (foundMonth == null)
        {
            foundMonth = new MyMonth(newData.date.getMonthValue(), foundYear.yearNumber);
            foundYear.months.add(foundMonth);
        }
        
        if (foundDay == null)
        {
            foundDay = new MyDay(newData.date.getDayOfMonth(), foundMonth.monthOfYear, foundYear.yearNumber);
            foundMonth.days.add(foundDay);
        }
        
        foundDay.dataPoints.add(newData);
    }
    
    private LocalTime parseTime(String timeText)
    {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("H:mm");
        LocalTime time;
        
        try
        {
            time = LocalTime.parse(timeText.substring(1, timeText.length() - 3), format1);
        }
        catch(Exception e)
        {
            time = LocalTime.parse(timeText.substring(1, timeText.length() - 2), format2);
        }
        
        String t = timeText.substring(timeText.length() - 2);
        if (t.equals("P "))
        {
            if (time.getHour() != 12)
                time = time.plusHours(12);
        }
        else if (t.equals("A "))
        {
            if (time.getHour() == 12)
                time = time.minusHours(12);
        }
        
        return time;
    }
}
