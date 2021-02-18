/* Program to convert a geographical longitude
 * into a customized time zone.
 * Developed by Alejandro Silva */
package longitudetimezone;
import java.util.Scanner; // import Scanner class (keyboard input)
public class LongitudeTimeZone
{
    static Scanner input = new Scanner(System.in); // initialize keyboard input
    static double degrees, minutes, seconds; // declare geographical longitude variables
    static char hemisphere; // declare hemisphere variable
    
    // longitude degrees getter
    // (function with no parameters)
    public static double getDegrees()
    {
        return degrees;
    } // end method getDegrees
    
    // longitude minutes getter
    // (function with no parameters)
    public static double getMinutes()
    {
        return minutes;
    } // end method getMinutes
    
    // longitude seconds getter
    // (function with no parameters)
    public static double getSeconds()
    {
        return seconds;
    } // end method getSeconds
    
    // method: enter degrees
    // (procedure with no parameters)
    public static void enterDegrees()
    {
        System.out.print("Degrees: "); // request degrees
        degrees = input.nextDouble(); // input degrees
        // while loop, if values smaller than 0
        // or greater than 180 are entered
        while (degrees < 0 || degrees > 180)
        {
            System.out.print("Degrees: "); // request again
            degrees = input.nextDouble(); // input again
        } // end while loop
    } // end method enterDegrees
    
    // method: enter minutes
    // (procedure with no parameters)
    public static void enterMinutes()
    {
        System.out.print("Minutes: "); // request minutes
        minutes = input.nextDouble(); // input minutes
        // while loop, if values smaller than 0
        // or greater than 59 are entered
        while (minutes < 0 || minutes > 59)
        {
            System.out.print("Minutes: "); // request again
            minutes = input.nextDouble(); // input again
        } // end while loop
    } // end method enterMinutes
    
    // method: enter seconds
    // (procedure with no parameters)
    public static void enterSeconds()
    {
        System.out.print("Seconds: "); // request seconds
        seconds = input.nextDouble(); // input seconds
        // while loop, if values smaller than 0
        // or greater than 59 are entered
        while (seconds < 0 || seconds > 59)
        {
            System.out.print("Seconds: "); // request again
            seconds = input.nextDouble(); // input again
        } // end while loop
    } // end method enterSeconds
    
    // method: enter hemisphere
    // (procedure with no parameters)
    public static void enterHemisphere()
    {
        System.out.print("Hemisphere (W: Western, E: Eastern): "); // request hemisphere
        hemisphere = input.next().charAt(0); // input hemisphere (W = Western; E = Eastern)
    } // end method enterHemisphere
    
    // method: hours
    // (procedure with three parameters)
    public static void hours (int h, int m, int s)
    {
        // if-else statement
        // if hours, minutes and seconds are 0
        // (no matter the hemisphere)
        if ((h == 0 && m == 0 && s == 0))
        {
            System.out.print("±" + h); // plus-minus aside the hours
        }
        // if hemisphere is Western
        // and regardless of whether the letter is uppercase or lowercase
        else if (hemisphere == 'W' || hemisphere == 'w')
        {
            System.out.print("-" + h); // minus hours
        }
        // if hemisphere is Eastern
        // and regardless of whether the letter is uppercase or lowercase
        else if (hemisphere == 'E' || hemisphere == 'e')
        {
            System.out.print("+" + h); // plus hours
        } // end if-else statement
    } // end method hours
    
    // method: minutes
    // (procedure with a parameter)
    public static void minutes (int m)
    {
        // if-else statement
        // if minutes is smaller than 10
        if (m < 10)
        {
            System.out.print(":0" + m); // print colon and a 0
        }
        // if minutes is greater than 10
        else
        {
            System.out.print(":" + m); // print colon only
        } // end if-else statement
    } // end method minutes
    
    // method: seconds
    // (procedure with a parameter)
    public static void seconds (int s)
    {
        // if-else statement
        // if seconds is smaller than 10
        if (s < 10)
        {
            System.out.print(":0" + s); // print colon and a 0
        }
        // if seconds is greater than 10
        else
        {
            System.out.print(":" + s); // print colon only
        } // end if-else statement
    } // end method seconds
    
    // method: show time zone
    // (procedure with no parameters)
    public static void showTimeZone()
    {
        // convert longitude units to time units
        double longitude_sec = getDegrees() * 3600 + getMinutes() * 60 + getSeconds();
        // divide longitude_sec by 15 to get
        // seconds of difference with GMT
        double time_sec = longitude_sec / 15;
        // divide time_sec by 3600
        // to get number of hours
        double time_hours = time_sec / 3600;
        // get integer part of hours
        int time_hours_int = (int) time_hours;
        // multiply fractional part of hours by 60
        // to get number of minutes
        double time_minutes = (time_hours - time_hours_int) * 60;
        // get integer part of minutes
        int time_minutes_int = (int) time_minutes;
        // multiply fractional part of minutes by 60
        // and round result to get number of seconds
        double time_seconds = Math.round((time_minutes - time_minutes_int) * 60);
        
        // if-else statement
        // if seconds equals 60
        if (time_seconds == 60)
        {
            time_minutes++; // increase minutes by 1
            time_seconds = time_seconds * 0; // multiply seconds by 0
        } // end if-else statement
        
        // Results: customized time zone
        System.out.println("\nCustomized time zone is: ");
        System.out.print("GMT ");
        // print hours (invoke method hours and pass its corresponding parameters)
        hours((int) time_hours, (int) time_minutes, (int) time_seconds);
        // print minutes (invoke method minutes and pass its corresponding parameter)
        minutes((int) time_minutes);
        // print seconds (invoke method seconds and pass its corresponding parameter)
        seconds((int) time_seconds);
        System.out.println(""); // line break
    } // end method showTimeZone

    // main method
    public static void main(String args[])
    {
        // Request longitude (degrees, minutes and seconds)
        System.out.println("Enter longitude: ");
        // Invoke method enterDegrees
        enterDegrees();
        // Invoke method enterMinutes
        enterMinutes();
        // Invoke method enterSeconds
        enterSeconds();
        // Invoke method enterHemisphere
        enterHemisphere();
        // Invoke method showTimeZone
        showTimeZone();
    } // end main method
} // end class LongitudeTimeZone