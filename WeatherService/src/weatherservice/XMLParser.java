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
import org.w3c.dom.*;
import static weatherservice.XmlUtil.asList;

/**
 *
 * @author Alex
 */
public class XMLParser {
    private String[] months = { "January", "February", "March", "April", "May", 
        "June", "July", "August", "September", "October", "November", "December" };
    public void Parse(String fileName)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YY");
        File dataFile = new File(fileName);
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(dataFile);
            doc.getDocumentElement().normalize();
            
            NodeList dataPoints = doc.getElementsByTagName("weather");
            for (Node point : asList(dataPoints)){
                Element dataPoint = (Element)point;
                
                String date = dataPoint.getElementsByTagName("date").item(0).getTextContent();
                dateFormat.parse(date);
                
            }
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
