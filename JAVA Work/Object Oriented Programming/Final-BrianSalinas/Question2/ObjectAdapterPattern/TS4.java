public class TS4 implements V2Sensors{
    @Override
    public double getTemp(String year, String month, String date, String time, String when){
        //return Temp in 1/10 Celsius
        //Fahrenheit = (Celsius - 32) * 5/9
        //t is in PST time
        //t is specified in the AM/PM format (12-hour clock)
        //PST = EST - 3
        //when = AM or when = PM
        //Code Goes here
        return 3.77; //random temp in 1/10 Celsius
    }
}
