/*******************************************************************************
*
* Description - This class represents a tuple of a date and a temperature
* measurement. It is used for statistics calculations when the date of a 
* statistic needs to be displayed along with the value.
* 
* Author - Austin Rotert
*******************************************************************************/

package weatherservice;

import java.time.LocalDateTime;

/**
 *
 * @author arotert
 */
public class TemperatureDateTuple
{
    public LocalDateTime date;
    public float temperature;
}
