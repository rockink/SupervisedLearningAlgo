import java.util.Random;

/**
 * Created by rockink on 4/19/17.
 */
public class Schedule {

    private  double temp;
    Random random = new Random();

    public Schedule(double initialTemp){
        this.temp = initialTemp;
    }

    public double schedule(double temp){
        this.temp = this.temp - 0.05;
        return this.temp;
    }



}
