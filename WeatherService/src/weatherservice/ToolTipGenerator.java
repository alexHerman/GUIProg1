/*******************************************************************************
*
* Description - This class is used to generate tootip text for each individual
* data point displayed on a graph. Each tooltip displays all of the available
* data for the given data point, regardless of what is being plotted on the 
* graph. This class finds all relevant information and displays it in HTML.
* 
* Author - Austin Rotert
*******************************************************************************/

package weatherservice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author arotert
 */
public class ToolTipGenerator implements XYToolTipGenerator
{
    @Override
    public String generateToolTip(XYDataset dataSet, int series, int item)
    {
        //Create correct classes from our data
        TimeSeriesCollection collection = (TimeSeriesCollection)dataSet;
        TimeSeries timeSeries = collection.getSeries(series);
        TimePeriod timePeriod = timeSeries.getTimePeriod(item);

        //Get the date parsed correctly
        String string = timePeriod.toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd kk:mm:ss zzz yyyy");
        LocalDateTime dateTime = LocalDateTime.parse(string, formatter);

        //Store chunks of the date off to the side
        int year = dateTime.getYear();
        int month = dateTime.getMonthValue();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        int second = dateTime.getSecond();

        DataPoint tooltipPoint = null;
        //Loop through and see if we can find the correct date
        for(MyYear years : XMLParser.years)
        {
            if(years.yearNumber == year)
            {
                for(MyMonth months : years.months)
                {
                    if(months.monthOfYear == month)
                    {
                        for(MyDay days : months.days)
                        {
                            if(days.dayOfMonth == day)
                            {
                                for(DataPoint points : days.dataPoints)
                                {
                                    if(points.date.getHour() == hour &&
                                       points.date.getMinute() == minute &&
                                       points.date.getSecond() == second)
                                    {
                                        tooltipPoint = points;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        //If we found a date, generate a tooltip for the return, otherwise
        //just return null
        String result = null;
        if(tooltipPoint != null)
        {
                result = GenerateTooltip(tooltipPoint);
        }

        return result;
    }

    private String GenerateTooltip(DataPoint point)
    {
        String toolTip = "";

        toolTip += "<html>" + point.date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy kk:mm:ss")) + "<br />";
        toolTip += "Temperature: " + point.temperature + " degrees F<br />";
        toolTip += "Humidity: " + point.humidity + " % <br />";
        toolTip += "Barometer: " + point.barometer + " inHg <br />";
        toolTip += "Wind Speed: " + point.windspeed + " mph <br />";
        toolTip += "Wind Direction: " + point.winddirection + "<br />";
        toolTip += "Wind Gust: " + point.windgust + " mph <br />";
        toolTip += "Wind Chill: " + point.windchill + " degrees F <br />";
        toolTip += "Heat Index: " + point.heatindex + " degrees F <br />";
        toolTip += "UV Index: " + point.uvindex + "<br />";
        toolTip += "Rainfall: " + point.rainfall + " in</html>";

        return toolTip;
    }
}
