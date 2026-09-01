package pattern.classic;

public class WeatherStationDemo {
    
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        DisplayScreen display1 = new DisplayScreen(weatherData);
        DisplayScreen display2 = new DisplayScreen(weatherData);

        System.out.println("=== Weather Station Running ===");
        weatherData.setMeasurements(25.0, 60.0, 1013.0);
        weatherData.setMeasurements(28.0, 55.0, 1012.0);
        weatherData.setMeasurements(22.0, 70.0, 1015.0);

        System.out.println("\n OCP Achieved! Adding new display requires ZERO changes to WeatherData.");
    }
}
