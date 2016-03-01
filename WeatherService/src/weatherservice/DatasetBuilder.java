/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Alex
 */
public class DatasetBuilder {
    public XYDataset createTempDataSet(MyDay day) {
        TimeSeries s1 = new TimeSeries("Temperature for Day " + day.dayOfMonth);
        
        for (DataPoint point : day.dataPoints)
        {
            s1.add(point, point.temperature);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createTempDataSet(MyMonth month) {
        TimeSeries s1 = new TimeSeries("Temperature for Month " + month.monthOfYear);
        
        for (MyDay day : month.days)
        {
            s1.add(day, StatisticsCalculator.MeanTemperature(day));
            /*for (DataPoint point : day.dataPoints)
            {
                s1.add(point, point.temperature);
            }*/
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createTempDataSet(MyYear year) {
        TimeSeries s1 = new TimeSeries("Temperature for Year " + year.yearNumber);
        TimeSeries s2 = new TimeSeries("Temperature for Year " + year.yearNumber);
        
        for (MyMonth month : year.months)
        {
            for (MyDay day : month.days)
            {
                s1.add(day, StatisticsCalculator.MinTemperature(day).temperature);
                s2.add(day, StatisticsCalculator.MaxTemperature(day).temperature);
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);

        return dataset;
   }
}
