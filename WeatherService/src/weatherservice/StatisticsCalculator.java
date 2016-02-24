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
}
