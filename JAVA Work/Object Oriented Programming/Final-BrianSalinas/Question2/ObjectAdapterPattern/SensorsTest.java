import java.time.LocalDate;
import java.time.LocalTime;

public class SensorsTest {
    public static void main(String[] args) {
        SensorsData sensorsData = new SensorsData();

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        /* one getTemp() call gets all temps of all sensors no matter the different Vendor format of the sensor */
        System.out.println(sensorsData.getTemp(date, time));
    }
}
