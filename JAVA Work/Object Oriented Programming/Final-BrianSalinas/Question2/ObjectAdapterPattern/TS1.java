import java.time.LocalDate;
import java.time.LocalTime;

public class TS1 implements V1Sensors{
    @Override
    public double getTemp(LocalDate date, LocalTime time) {
        return 95.3; //return a random temp in Fahrenheit
    }
}
