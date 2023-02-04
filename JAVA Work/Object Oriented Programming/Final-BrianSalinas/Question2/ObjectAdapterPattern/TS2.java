import java.time.LocalDate;
import java.time.LocalTime;

public class TS2 implements V1Sensors{
    @Override
    public double getTemp(LocalDate date, LocalTime time) {
        return 90.7; //return a random temp in Fahrenheit
    }
}
