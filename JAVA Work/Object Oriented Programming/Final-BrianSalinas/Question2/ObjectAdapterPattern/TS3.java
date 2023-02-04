import java.time.LocalDate;
import java.time.LocalTime;

public class TS3 implements V1Sensors{
    @Override
    public double getTemp(LocalDate date, LocalTime Time) {
        return 80.26; //return a random temp in Fahrenheit
    }
}
