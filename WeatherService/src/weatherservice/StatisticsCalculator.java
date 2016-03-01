package weatherservice;

/**
 *
 * @author Austin Rotert
 */
//Contains static methods for every calculation that needs to be provided, with
//overloads of each calculation for different types of input (year, month, etc.)
public class StatisticsCalculator
{
    /**
    *
    * @author Austin Rotert
    * @param year Year object to calculate the mean temperature of
    * @return Returns a floating point representing the average temperature
    */
    //Calculates and returns the average temperature over a given year
    public static float MeanTemperature(MyYear year)
    {
        float avg = 0;

        for(MyMonth month : year.months)
        {
            avg += MeanTemperature(month);
        }

        return avg / year.months.size();
    }

    /**
    *
    * @author Austin Rotert
    * @param month Month object to calculate the mean temperature of
    * @return Returns a floating point representing the average temperature
    */
    //Calculates and returns the average temperature over a given month
    public static float MeanTemperature(MyMonth month)
    {
        float avg = 0;

        for(MyDay day : month.days)
        {
            avg += MeanTemperature(day);
        }

        return avg / month.days.size();
    }

    /**
    *
    * @author Austin Rotert
    * @param day Day object to calculate the mean temperature of
    * @return Returns a floating point representing the average temperature
    */
    //Calculates and returns the average temperature over a given day
    public static float MeanTemperature(MyDay day)
    {
        float avg = 0;

        for(DataPoint point : day.dataPoints)
        {
            avg += point.temperature;
        }

        return avg / day.dataPoints.size();
    }

    /**
    *
    * @author Austin Rotert
    * @param year Year object to calculate the max temperature of
    * @return Returns a floating point representing the max temperature
    */
    //Returns a tuple with the highest temperature and the time it occurred
    //over a given year
    public static TemperatureDateTuple MaxTemperature(MyYear year)
    {
        TemperatureDateTuple max = new TemperatureDateTuple();
        TemperatureDateTuple current;

        for(MyMonth month : year.months)
        {
            current = MaxTemperature(month);

            if(current.temperature > max.temperature)
            {
                max = current;
            }
        }

        return max;
    }

    /**
    *
    * @author Austin Rotert
    * @param month Month object to calculate the max temperature of
    * @return Returns a floating point representing the max temperature
    */
    //Returns a tuple with the highest temperature and the time it occurred
    //over a given month
    public static TemperatureDateTuple MaxTemperature(MyMonth month)
    {
        TemperatureDateTuple max = new TemperatureDateTuple();
        TemperatureDateTuple current;

        for(MyDay day : month.days)
        {
            current = MaxTemperature(day);

            if(current.temperature > max.temperature)
            {
                max = current;
            }
        }

        return max;
    }

    /**
    *
    * @author Austin Rotert
    * @param day Day object to calculate the max temperature of
    * @return Returns a floating point representing the max temperature
    */
    //Returns a tuple with the highest temperature and the time it occurred
    //over a given day
    public static TemperatureDateTuple MaxTemperature(MyDay day)
    {
        TemperatureDateTuple max = new TemperatureDateTuple();

        for(DataPoint point : day.dataPoints)
        {
            if(point.temperature > max.temperature)
            {
                max.temperature = point.temperature;
                max.date = point.date;
            }
        }

        return max;
    }
    
    /**
    *
    * @author Austin Rotert
    * @param year Year object to calculate the min temperature of
    * @return Returns a floating point representing the min temperature
    */
    //Returns a tuple with the highest temperature and the time it occurred
    //over a given year
    public static TemperatureDateTuple MinTemperature(MyYear year)
    {
        TemperatureDateTuple min = new TemperatureDateTuple();
        TemperatureDateTuple current;

        for(MyMonth month : year.months)
        {
            current = MaxTemperature(month);

            if(current.temperature < min.temperature)
            {
                min = current;
            }
        }

        return min;
    }

    /**
    *
    * @author Austin Rotert
    * @param month Month object to calculate the min temperature of
    * @return Returns a floating point representing the min temperature
    */
    //Returns a tuple with the highest temperature and the time it occurred
    //over a given month
    public static TemperatureDateTuple MinTemperature(MyMonth month)
    {
        TemperatureDateTuple min = new TemperatureDateTuple();
        TemperatureDateTuple current;

        for(MyDay day : month.days)
        {
            current = MaxTemperature(day);

            if(current.temperature < min.temperature)
            {
                min = current;
            }
        }

        return min;
    }

    /**
    *
    * @author Austin Rotert
    * @param day Day object to calculate the min temperature of
    * @return Returns a floating point representing the min temperature
    */
    //Returns a tuple with the highest temperature and the time it occurred
    //over a given day
    public static TemperatureDateTuple MinTemperature(MyDay day)
    {
        TemperatureDateTuple min = new TemperatureDateTuple();

        for(DataPoint point : day.dataPoints)
        {
            if(point.temperature < min.temperature)
            {
                min.temperature = point.temperature;
                min.date = point.date;
            }
        }

        return min;
    }
    
    /**
    *
    * @author Austin Rotert
    * @param year Year object to calculate the average wind speed of
    * @return Returns a floating point representing the average wind speed
    */
    //Calculates and returns the average wind speed over a given year
    public static float MeanWindSpeed(MyYear year)
    {
        float avg = 0;

        for(MyMonth month : year.months)
        {
            avg += MeanWindSpeed(month);
        }

        return avg / year.months.size();
    }

    /**
    *
    * @author Austin Rotert
    * @param month Month object to calculate the average wind speed of
    * @return Returns a floating point representing the average wind speed
    */
    //Calculates and returns the average wind speed over a given month
    public static float MeanWindSpeed(MyMonth month)
    {
        float avg = 0;

        for(MyDay day : month.days)
        {
            avg += MeanWindSpeed(day);
        }

        return avg / month.days.size();
    }

    /**
    *
    * @author Austin Rotert
    * @param day Day object to calculate the average wind speed of
    * @return Returns a floating point representing the average wind speed
    */
    //Calculates and returns the average wind speed over a given day
    public static float MeanWindSpeed(MyDay day)
    {
        float avg = 0;

        for(DataPoint point : day.dataPoints)
        {
            avg += point.windspeed;
        }

        return avg / day.dataPoints.size();
    }

    /**
    *
    * @author Austin Rotert
    * @param year Year object to calculate the max wind gust of
    * @return Returns a floating point representing the max wind gust
    */
    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given year
    public static WindSpeedDateTuple MaxWindSpeed(MyYear year)
    {
        WindSpeedDateTuple max = new WindSpeedDateTuple();
        WindSpeedDateTuple current;

        for(MyMonth month : year.months)
        {
            current = MaxWindSpeed(month);

            if(current.windspeed > max.windspeed)
            {
                max = current;
            }
        }

        return max;
    }

    /**
    *
    * @author Austin Rotert
    * @param month Month object to calculate the max wind gust of
    * @return Returns a floating point representing the max wind gust
    */
    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given month
    public static WindSpeedDateTuple MaxWindSpeed(MyMonth month)
    {
        WindSpeedDateTuple max = new WindSpeedDateTuple();
        WindSpeedDateTuple current;

        for(MyDay day : month.days)
        {
            current = MaxWindSpeed(day);

            if(current.windspeed > max.windspeed)
            {
                max = current;
            }
        }

        return max;
    }

    /**
    *
    * @author Austin Rotert
    * @param day Day object to calculate the max wind gust of
    * @return Returns a floating point representing the max wind gust
    */
    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given day
    public static WindSpeedDateTuple MaxWindSpeed(MyDay day)
    {
        WindSpeedDateTuple max = new WindSpeedDateTuple();

        for(DataPoint point : day.dataPoints)
        {
            if(point.windgust > max.windspeed)
            {
                max.windspeed = point.windgust;
                max.date = point.date;
            }
        }

        return max;
    }
    
    /**
    *
    * @author Austin Rotert
    * @param year Year object to calculate the min wind gust of
    * @return Returns a floating point representing the min wind gust
    */
    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given year
    public static WindSpeedDateTuple MinWindspeed(MyYear year)
    {
        WindSpeedDateTuple min = new WindSpeedDateTuple();
        WindSpeedDateTuple current;

        for(MyMonth month : year.months)
        {
            current = MaxWindSpeed(month);

            if(current.windspeed < min.windspeed)
            {
                min = current;
            }
        }

        return min;
    }

    /**
    *
    * @author Austin Rotert
    * @param month Month object to calculate the min wind gust of
    * @return Returns a floating point representing the min wind gust
    */
    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given month
    public static WindSpeedDateTuple MinWindSpeed(MyMonth month)
    {
        WindSpeedDateTuple min = new WindSpeedDateTuple();
        WindSpeedDateTuple current;

        for(MyDay day : month.days)
        {
            current = MaxWindSpeed(day);

            if(current.windspeed < min.windspeed)
            {
                min = current;
            }
        }

        return min;
    }

    /**
    *
    * @author Austin Rotert
    * @param day Day object to calculate the min wind gust of
    * @return Returns a floating point representing the min wind gust
    */
    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given day
    public static WindSpeedDateTuple MinWindSpeed(MyDay day)
    {
        WindSpeedDateTuple min = new WindSpeedDateTuple();

        for(DataPoint point : day.dataPoints)
        {
            if(point.windgust < min.windspeed)
            {
                min.windspeed = point.windgust;
                min.date = point.date;
            }
        }

        return min;
    }
    
    /**
    *
    * @author Austin Rotert
    * @param year Year object to calculate the prevailing wind direction of
    * @return Returns a floating point representing the prevailing wind direction
    */
    //Calculates and returns the prevailing wind direction over a given year
    public static WindDirection PrevailingWindDirection(MyYear year)
    {
        int windDirection[] = new int[16];
        int prevailingDirection;
        WindDirection result;

        for(MyMonth month : year.months)
        {
            prevailingDirection = PrevailingWindDirection(month).ordinal();
            windDirection[prevailingDirection]++;
        }
        
        result = FindWindDirectionMode(windDirection);

        return result;
    }

    /**
    *
    * @author Austin Rotert
    * @param month Month object to calculate the prevailing wind direction of
    * @return Returns a floating point representing the prevailing wind direction
    */
    //Calculates and returns the prevailing wind direction over a given month
    public static WindDirection PrevailingWindDirection(MyMonth month)
    {
        int windDirection[] = new int[16];
        int prevailingDirection;
        WindDirection result;

        for(MyDay day : month.days)
        {
            prevailingDirection = PrevailingWindDirection(day).ordinal();
            windDirection[prevailingDirection]++;
        }

        result = FindWindDirectionMode(windDirection);

        return result;
    }

    /**
    *
    * @author Austin Rotert
    * @param day Day object to calculate the prevailing wind direction of
    * @return Returns a floating point representing the prevailing wind direction
    */
    //Calculates and returns the prevailing wind direction over a given day
    public static WindDirection PrevailingWindDirection(MyDay day)
    {
        int windDirection[] = new int[16];
        WindDirection result;

        for(DataPoint point : day.dataPoints)
        {
            windDirection[point.winddirection.ordinal()]++;
        }

        result = FindWindDirectionMode(windDirection);

        return result;
    }
        
    /**
    *
    * @author Austin Rotert
    * @param year Year object to calculate the total rainfall of
    * @return Returns a floating point representing the total rainfall
    */
    //Calculates and returns the total rainfall over a given year
    public static float TotalRainfall(MyYear year)
    {
        float rainfall = 0;

        for(MyMonth month : year.months)
        {
            rainfall += TotalRainfall(month);
        }

        return rainfall;
    }

    /**
    *
    * @author Austin Rotert
    * @param month Month object to calculate the total rainfall of
    * @return Returns a floating point representing the total rainfall
    */
    //Calculates and returns the total rainfall over a given month
    public static float TotalRainfall(MyMonth month)
    {
        float rainfall = 0;

        for(MyDay day : month.days)
        {
            rainfall += TotalRainfall(day);
        }

        return rainfall;
    }

    /**
    *
    * @author Austin Rotert
    * @param day Day object to calculate the total rainfall of
    * @return Returns a floating point representing the total rainfall
    */
    //Calculates and returns the total rainfall over a given day
    public static float TotalRainfall(MyDay day)
    {
        float rainfall = 0;

        for(DataPoint point : day.dataPoints)
        {
            rainfall += point.rainfall;
        }

        return rainfall;
    }
    
    /**
    *
    * @author Austin Rotert
    * @param counts array of the count for each wind direction
    * @return The wind direction with the largest count
    */
    //Helper method for finding the most frequent wind direction
    private static WindDirection FindWindDirectionMode(int counts[])
    {
        int prevailingDirection;
        WindDirection result;
        WindDirection directions[] = WindDirection.values();
        
        prevailingDirection = counts[0];
        result = directions[0];
        for(int i = 1; i < counts.length; i++)
        {
            if(counts[i] > prevailingDirection)
            {
                prevailingDirection = counts[i];
                result = directions[i];
            }
        }
        
        return result;
    }
}
