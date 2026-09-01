package pattern.classic;

public class DisplayScreen implements Observer {
    
    private WeatherData weatherData;
    private double temperature;
    private double humidity;

    public DisplayScreen(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.attach(this);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    private void display() {
        System.out.println("Display: Temp=" + temperature + "°C, Humidity=" + humidity + "%");
    }
}
