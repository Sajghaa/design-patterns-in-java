package pattern.modern;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModernWeatherData {

    private double temperature;
    private double humidity;
    private double pressure;

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        
        double oldTemp = this.temperature;
        double oldHumid = this.humidity;
        double oldPress = this.pressure;

        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        support.firePropertyChange("temperature", oldTemp, temperature);
        support.firePropertyChange("humidity", oldHumid, humidity);
        support.firePropertyChange("pressure", oldPress, pressure);
    }


    public double getTemperature() { return temperature; }
    public double getHumidity() { return humidity; }
    public double getPressure() { return pressure; }
    
}
