/*******************************************************************************
*
* Description - This class represents a tuple of a date and a wind speed
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
public class WindSpeedDateTuple
{
    public LocalDateTime date;
    public float windspeed;
}
