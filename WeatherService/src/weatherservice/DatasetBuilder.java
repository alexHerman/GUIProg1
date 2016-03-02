/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import java.util.ArrayList;
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
            s1.addOrUpdate(point, point.temperature);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createTempDataSet(MyMonth month) {
        TimeSeries s1 = new TimeSeries("Temperature for Month " + month.monthOfYear);
        
        for (MyDay day : month.days)
        {
            for (DataPoint point : day.dataPoints)
            {
                s1.addOrUpdate(point, point.temperature);
            }
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
                for(DataPoint point : day.dataPoints)
                {
                    s1.addOrUpdate(point, point.temperature);
                }
                //s1.addOrUpdate(day, StatisticsCalculator.MinTemperature(day).temperature);
                //s2.addOrUpdate(day, StatisticsCalculator.MaxTemperature(day).temperature);
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        //dataset.addSeries(s2);
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createTempDataSet(ArrayList<MyYear> years) 
    {
        TimeSeries s1 = new TimeSeries("Temperature for All Data");
        
        for (MyYear year : years)
        {
            for (MyMonth month : year.months)
            {
                for (MyDay day : month.days)
                {
                    for(DataPoint point : day.dataPoints)
                    {
                        s1.addOrUpdate(point, point.temperature);
                    }
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createBarometerDataSet(MyDay day) {
        TimeSeries s1 = new TimeSeries("Barometer for Day " + day.dayOfMonth);
        
        for (DataPoint point : day.dataPoints)
        {
            s1.addOrUpdate(point, point.barometer);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createBarometerDataSet(MyMonth month) {
        TimeSeries s1 = new TimeSeries("Barometer for Month " + month.monthOfYear);
        
        for (MyDay day : month.days)
        {
            for (DataPoint point : day.dataPoints)
            {
                s1.addOrUpdate(point, point.barometer);
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createBarometerDataSet(MyYear year) {
        TimeSeries s1 = new TimeSeries("Barometer for Year " + year.yearNumber);
        
        for (MyMonth month : year.months)
        {
            for (MyDay day : month.days)
            {
                for(DataPoint point : day.dataPoints)
                {
                    s1.addOrUpdate(point, point.barometer);
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createBarometerDataSet(ArrayList<MyYear> years) 
    {
        TimeSeries s1 = new TimeSeries("Barometer for All Data");
        
        for (MyYear year : years)
        {
            for (MyMonth month : year.months)
            {
                for (MyDay day : month.days)
                {
                    for(DataPoint point : day.dataPoints)
                    {
                        s1.addOrUpdate(point, point.barometer);
                    }
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createHumidityDataSet(MyDay day) {
        TimeSeries s1 = new TimeSeries("Humidity for Day " + day.dayOfMonth);
        
        for (DataPoint point : day.dataPoints)
        {
            s1.addOrUpdate(point, point.humidity);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createHumidityDataSet(MyMonth month) {
        TimeSeries s1 = new TimeSeries("Humidity for Month " + month.monthOfYear);
        
        for (MyDay day : month.days)
        {
            for (DataPoint point : day.dataPoints)
            {
                s1.addOrUpdate(point, point.humidity);
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createHumidityDataSet(MyYear year) {
        TimeSeries s1 = new TimeSeries("Humidity for Year " + year.yearNumber);
        
        for (MyMonth month : year.months)
        {
            for (MyDay day : month.days)
            {
                for(DataPoint point : day.dataPoints)
                {
                    s1.addOrUpdate(point, point.humidity);
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createHumidityDataSet(ArrayList<MyYear> years) 
    {
        TimeSeries s1 = new TimeSeries("Humidity for All Data");
        
        for (MyYear year : years)
        {
            for (MyMonth month : year.months)
            {
                for (MyDay day : month.days)
                {
                    for(DataPoint point : day.dataPoints)
                    {
                        s1.addOrUpdate(point, point.humidity);
                    }
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createWindSpeedDataSet(MyDay day) {
        TimeSeries s1 = new TimeSeries("WindSpeed for Day " + day.dayOfMonth);
        
        for (DataPoint point : day.dataPoints)
        {
            s1.addOrUpdate(point, point.windspeed);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createWindSpeedDataSet(MyMonth month) {
        TimeSeries s1 = new TimeSeries("WindSpeed for Month " + month.monthOfYear);
        
        for (MyDay day : month.days)
        {
            for (DataPoint point : day.dataPoints)
            {
                s1.addOrUpdate(point, point.windspeed);
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createWindSpeedDataSet(MyYear year) {
        TimeSeries s1 = new TimeSeries("WindSpeed for Year " + year.yearNumber);
        
        for (MyMonth month : year.months)
        {
            for (MyDay day : month.days)
            {
                for(DataPoint point : day.dataPoints)
                {
                    s1.addOrUpdate(point, point.windspeed);
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createWindSpeedDataSet(ArrayList<MyYear> years) 
    {
        TimeSeries s1 = new TimeSeries("WindSpeed for All Data");
        
        for (MyYear year : years)
        {
            for (MyMonth month : year.months)
            {
                for (MyDay day : month.days)
                {
                    for(DataPoint point : day.dataPoints)
                    {
                        s1.addOrUpdate(point, point.windspeed);
                    }
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createWindGustDataSet(MyDay day) {
        TimeSeries s1 = new TimeSeries("WindGust for Day " + day.dayOfMonth);
        
        for (DataPoint point : day.dataPoints)
        {
            s1.addOrUpdate(point, point.windgust);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createWindGustDataSet(MyMonth month) {
        TimeSeries s1 = new TimeSeries("WindGust for Month " + month.monthOfYear);
        
        for (MyDay day : month.days)
        {
            for (DataPoint point : day.dataPoints)
            {
                s1.addOrUpdate(point, point.windgust);
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createWindGustDataSet(MyYear year) {
        TimeSeries s1 = new TimeSeries("WindGust for Year " + year.yearNumber);
        
        for (MyMonth month : year.months)
        {
            for (MyDay day : month.days)
            {
                for(DataPoint point : day.dataPoints)
                {
                    s1.addOrUpdate(point, point.windgust);
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createWindGustDataSet(ArrayList<MyYear> years) 
    {
        TimeSeries s1 = new TimeSeries("WindGust for All Data");
        
        for (MyYear year : years)
        {
            for (MyMonth month : year.months)
            {
                for (MyDay day : month.days)
                {
                    for(DataPoint point : day.dataPoints)
                    {
                        s1.addOrUpdate(point, point.windgust);
                    }
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createWindChillDataSet(MyDay day) {
        TimeSeries s1 = new TimeSeries("WindChill for Day " + day.dayOfMonth);
        
        for (DataPoint point : day.dataPoints)
        {
            s1.addOrUpdate(point, point.windchill);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createWindChillDataSet(MyMonth month) {
        TimeSeries s1 = new TimeSeries("WindChill for Month " + month.monthOfYear);
        
        for (MyDay day : month.days)
        {
            for (DataPoint point : day.dataPoints)
            {
                s1.addOrUpdate(point, point.windchill);
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createWindChillDataSet(MyYear year) {
        TimeSeries s1 = new TimeSeries("WindChill for Year " + year.yearNumber);
        
        for (MyMonth month : year.months)
        {
            for (MyDay day : month.days)
            {
                for(DataPoint point : day.dataPoints)
                {
                    s1.addOrUpdate(point, point.windchill);
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createWindChillDataSet(ArrayList<MyYear> years) 
    {
        TimeSeries s1 = new TimeSeries("WindChill for All Data");
        
        for (MyYear year : years)
        {
            for (MyMonth month : year.months)
            {
                for (MyDay day : month.days)
                {
                    for(DataPoint point : day.dataPoints)
                    {
                        s1.addOrUpdate(point, point.windchill);
                    }
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createHeatIndexDataSet(MyDay day) {
        TimeSeries s1 = new TimeSeries("HeatIndex for Day " + day.dayOfMonth);
        
        for (DataPoint point : day.dataPoints)
        {
            s1.addOrUpdate(point, point.heatindex);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createHeatIndexDataSet(MyMonth month) {
        TimeSeries s1 = new TimeSeries("HeatIndex for Month " + month.monthOfYear);
        
        for (MyDay day : month.days)
        {
            for (DataPoint point : day.dataPoints)
            {
                s1.addOrUpdate(point, point.heatindex);
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createHeatIndexDataSet(MyYear year) {
        TimeSeries s1 = new TimeSeries("HeatIndex for Year " + year.yearNumber);
        
        for (MyMonth month : year.months)
        {
            for (MyDay day : month.days)
            {
                for(DataPoint point : day.dataPoints)
                {
                    s1.addOrUpdate(point, point.heatindex);
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createHeatIndexDataSet(ArrayList<MyYear> years) 
    {
        TimeSeries s1 = new TimeSeries("HeatIndex for All Data");
        
        for (MyYear year : years)
        {
            for (MyMonth month : year.months)
            {
                for (MyDay day : month.days)
                {
                    for(DataPoint point : day.dataPoints)
                    {
                        s1.addOrUpdate(point, point.heatindex);
                    }
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createUVIndexDataSet(MyDay day) {
        TimeSeries s1 = new TimeSeries("UVIndex for Day " + day.dayOfMonth);
        
        for (DataPoint point : day.dataPoints)
        {
            s1.addOrUpdate(point, point.uvindex);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createUVIndexDataSet(MyMonth month) {
        TimeSeries s1 = new TimeSeries("UVIndex for Month " + month.monthOfYear);
        
        for (MyDay day : month.days)
        {
            for (DataPoint point : day.dataPoints)
            {
                s1.addOrUpdate(point, point.uvindex);
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createUVIndexDataSet(MyYear year) {
        TimeSeries s1 = new TimeSeries("UVIndex for Year " + year.yearNumber);
        
        for (MyMonth month : year.months)
        {
            for (MyDay day : month.days)
            {
                for(DataPoint point : day.dataPoints)
                {
                    s1.addOrUpdate(point, point.uvindex);
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createUVIndexDataSet(ArrayList<MyYear> years) 
    {
        TimeSeries s1 = new TimeSeries("UVIndex for All Data");
        
        for (MyYear year : years)
        {
            for (MyMonth month : year.months)
            {
                for (MyDay day : month.days)
                {
                    for(DataPoint point : day.dataPoints)
                    {
                        s1.addOrUpdate(point, point.uvindex);
                    }
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createRainFallDataSet(MyDay day) {
        TimeSeries s1 = new TimeSeries("RainFall for Day " + day.dayOfMonth);
        
        for (DataPoint point : day.dataPoints)
        {
            s1.addOrUpdate(point, point.rainfall);
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createRainFallDataSet(MyMonth month) {
        TimeSeries s1 = new TimeSeries("RainFall for Month " + month.monthOfYear);
        
        for (MyDay day : month.days)
        {
            for (DataPoint point : day.dataPoints)
            {
                s1.addOrUpdate(point, point.rainfall);
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
   
    public XYDataset createRainFallDataSet(MyYear year) {
        TimeSeries s1 = new TimeSeries("RainFall for Year " + year.yearNumber);
        
        for (MyMonth month : year.months)
        {
            for (MyDay day : month.days)
            {
                for(DataPoint point : day.dataPoints)
                {
                    s1.addOrUpdate(point, point.rainfall);
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
    
    public XYDataset createRainFallDataSet(ArrayList<MyYear> years) 
    {
        TimeSeries s1 = new TimeSeries("RainFall for All Data");
        
        for (MyYear year : years)
        {
            for (MyMonth month : year.months)
            {
                for (MyDay day : month.days)
                {
                    for(DataPoint point : day.dataPoints)
                    {
                        s1.addOrUpdate(point, point.rainfall);
                    }
                }
            }
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);

        return dataset;
   }
}
