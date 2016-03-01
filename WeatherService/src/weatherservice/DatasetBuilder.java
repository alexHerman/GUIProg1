/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Alex
 */
public class DatasetBuilder {
    public XYDataset createDayDataSet(MyDay day) {
        TimeSeries s1 = new TimeSeries("Temperature for Day");
        
        for (DataPoint point : day.dataPoints)
        {
            s1.add(point, point.temperature);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
}
