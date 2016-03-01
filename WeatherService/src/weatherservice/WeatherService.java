/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

/**
 *
 * @author Evan Hammer
 */
public class WeatherService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.ParseDirectory("C:\\Users\\Alex\\Documents\\NetBeansProjects\\GUIProg1\\Data");
        //DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        //JFreeChart lineChart = ChartFactory.createLineChart("Data", "Years", "x",)
    }
    
}
