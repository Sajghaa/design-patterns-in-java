package naive;


class WeatherData {
    private double temperature;
    private double humidity;

    public void setMeasurements(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }
}

class Display {
    public void update(double temperature, double humidity) {
        System.out.println("Display: Temp=" + temperature + "°C, Humidity=" + humidity + "%");
    }
}

public class WithoutObserver {
    
    WeatherData data = new WeatherData();
    Display display = new Display();

    double lastTemp = -1, lastHumid = -1;
    for (int i =0;  i < 5; i++) {

        if (i == 2) {
            data.setMeasurements(25.0, 60.0);
        }
        if (i == 4) {
            data.setMeasurements(28.0, 55.0);
        }

        double currentTemp = data.getTemperature();
        double currentHumid = data.getHumidity();
        if (currentTemp != lastTemp || currentHumid != lastHumid) {
            lastTemp = currentTemp;
            lastHumid = currentHumid;
        }

        Thread.sleep(1000);
    } 
    System.out.println("Problem: Polling is wastefull and can miss updates!");

}

