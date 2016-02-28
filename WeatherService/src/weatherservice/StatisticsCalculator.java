package weatherservice;

public class StatisticsCalculator
{
    //Calculates and returns the average temperature over a given year
    public static float MeanTemperature(Year year)
    {
        float avg = 0;

        for(Month month : year.months)
        {
            avg += MeanTemperature(month);
        }

        return avg / year.months.size();
    }

    //Calculates and returns the average temperature over a given month
    public static float MeanTemperature(Month month)
    {
        float avg = 0;

        for(Day day : month.days)
        {
            avg += MeanTemperature(day);
        }

        return avg / month.days.size();
    }

    //Calculates and returns the average temperature over a given day
    public static float MeanTemperature(Day day)
    {
        float avg = 0;

        for(DataPoint point : day.dataPoints)
        {
            avg += point.temperature;
        }

        return avg / day.dataPoints.size();
    }

    //Returns a tuple with the highest temperature and the time it occurred
    //over a given year
    public static TemperatureDateTuple MaxTemperature(Year year)
    {
        TemperatureDateTuple max = new TemperatureDateTuple();
        TemperatureDateTuple current;

        for(Month month : year.months)
        {
            current = MaxTemperature(month);

            if(current.temperature > max.temperature)
            {
                max = current;
            }
        }

        return max;
    }

    //Returns a tuple with the highest temperature and the time it occurred
    //over a given month
    public static TemperatureDateTuple MaxTemperature(Month month)
    {
        TemperatureDateTuple max = new TemperatureDateTuple();
        TemperatureDateTuple current;

        for(Day day : month.days)
        {
            current = MaxTemperature(day);

            if(current.temperature > max.temperature)
            {
                max = current;
            }
        }

        return max;
    }

    //Returns a tuple with the highest temperature and the time it occurred
    //over a given day
    public static TemperatureDateTuple MaxTemperature(Day day)
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
    
    //Returns a tuple with the highest temperature and the time it occurred
    //over a given year
    public static TemperatureDateTuple MinTemperature(Year year)
    {
        TemperatureDateTuple min = new TemperatureDateTuple();
        TemperatureDateTuple current;

        for(Month month : year.months)
        {
            current = MaxTemperature(month);

            if(current.temperature < min.temperature)
            {
                min = current;
            }
        }

        return min;
    }

    //Returns a tuple with the highest temperature and the time it occurred
    //over a given month
    public static TemperatureDateTuple MinTemperature(Month month)
    {
        TemperatureDateTuple min = new TemperatureDateTuple();
        TemperatureDateTuple current;

        for(Day day : month.days)
        {
            current = MaxTemperature(day);

            if(current.temperature < min.temperature)
            {
                min = current;
            }
        }

        return min;
    }

    //Returns a tuple with the highest temperature and the time it occurred
    //over a given day
    public static TemperatureDateTuple MinTemperature(Day day)
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
    
    //Calculates and returns the average wind speed over a given year
    public static float MeanWindSpeed(Year year)
    {
        float avg = 0;

        for(Month month : year.months)
        {
            avg += MeanWindSpeed(month);
        }

        return avg / year.months.size();
    }

    //Calculates and returns the average wind speed over a given month
    public static float MeanWindSpeed(Month month)
    {
        float avg = 0;

        for(Day day : month.days)
        {
            avg += MeanWindSpeed(day);
        }

        return avg / month.days.size();
    }

    //Calculates and returns the average wind speed over a given day
    public static float MeanWindSpeed(Day day)
    {
        float avg = 0;

        for(DataPoint point : day.dataPoints)
        {
            avg += point.windspeed;
        }

        return avg / day.dataPoints.size();
    }

    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given year
    public static WindSpeedDateTuple MaxWindSpeed(Year year)
    {
        WindSpeedDateTuple max = new WindSpeedDateTuple();
        WindSpeedDateTuple current;

        for(Month month : year.months)
        {
            current = MaxWindSpeed(month);

            if(current.windspeed > max.windspeed)
            {
                max = current;
            }
        }

        return max;
    }

    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given month
    public static WindSpeedDateTuple MaxWindSpeed(Month month)
    {
        WindSpeedDateTuple max = new WindSpeedDateTuple();
        WindSpeedDateTuple current;

        for(Day day : month.days)
        {
            current = MaxWindSpeed(day);

            if(current.windspeed > max.windspeed)
            {
                max = current;
            }
        }

        return max;
    }

    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given day
    public static WindSpeedDateTuple MaxWindSpeed(Day day)
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
    
    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given year
    public static WindSpeedDateTuple MinWindspeed(Year year)
    {
        WindSpeedDateTuple min = new WindSpeedDateTuple();
        WindSpeedDateTuple current;

        for(Month month : year.months)
        {
            current = MaxWindSpeed(month);

            if(current.windspeed < min.windspeed)
            {
                min = current;
            }
        }

        return min;
    }

    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given month
    public static WindSpeedDateTuple MinWindSpeed(Month month)
    {
        WindSpeedDateTuple min = new WindSpeedDateTuple();
        WindSpeedDateTuple current;

        for(Day day : month.days)
        {
            current = MaxWindSpeed(day);

            if(current.windspeed < min.windspeed)
            {
                min = current;
            }
        }

        return min;
    }

    //Returns a tuple with the highest wind speed and the time it occurred
    //over a given day
    public static WindSpeedDateTuple MinWindSpeed(Day day)
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
    
    //Calculates and returns the prevailing wind direction over a given year
    public static WindDirection PrevailingWindDirection(Year year)
    {
        int windDirection[] = new int[16];
        int prevailingDirection;
        WindDirection result;

        for(Month month : year.months)
        {
            prevailingDirection = PrevailingWindDirection(month).ordinal();
            windDirection[prevailingDirection]++;
        }
        
        result = FindWindDirectionMode(windDirection);

        return result;
    }

    //Calculates and returns the prevailing wind direction over a given month
    public static WindDirection PrevailingWindDirection(Month month)
    {
        int windDirection[] = new int[16];
        int prevailingDirection;
        WindDirection result;

        for(Day day : month.days)
        {
            prevailingDirection = PrevailingWindDirection(day).ordinal();
            windDirection[prevailingDirection]++;
        }

        result = FindWindDirectionMode(windDirection);

        return result;
    }

    //Calculates and returns the prevailing wind direction over a given day
    public static WindDirection PrevailingWindDirection(Day day)
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
        
    //Calculates and returns the prevailing wind direction over a given year
    public static float TotalRainfall(Year year)
    {
        float rainfall = 0;

        for(Month month : year.months)
        {
            rainfall += TotalRainfall(month);
        }

        return rainfall;
    }

    //Calculates and returns the prevailing wind direction over a given month
    public static float TotalRainfall(Month month)
    {
        float rainfall = 0;

        for(Day day : month.days)
        {
            rainfall += TotalRainfall(day);
        }

        return rainfall;
    }

    //Calculates and returns the prevailing wind direction over a given day
    public static float TotalRainfall(Day day)
    {
        float rainfall = 0;

        for(DataPoint point : day.dataPoints)
        {
            //Figure out how rainfall is stored (cumulative, amount at the time,
            //etc.) and make this loop do the right stuff
        }

        return rainfall;
    }
    
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
