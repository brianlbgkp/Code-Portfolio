import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SensorsData implements V1Sensors{
    V2Adapter v2Adapter;

    @Override
    public double getTemp(LocalDate myDate, LocalTime myTime){
        V1Sensors ts1 = new TS1();
        V1Sensors ts2 = new TS2();
        V1Sensors ts3 = new TS3();

        v2Adapter = new V2Adapter();

        double ts1Temp = ts1.getTemp(myDate, myTime);
        double ts2Temp = ts2.getTemp(myDate, myTime);
        double ts3Temp = ts3.getTemp(myDate, myTime);
        double v2Temps = v2Adapter.getTemp(myDate, myTime);

        double average = (ts1Temp + ts2Temp + ts3Temp + v2Temps) / 4; //average temp of all sensors

        return average;
    }
}
