package pattern.modern;

import java.beans.PropertyChangeListener;

public class ModernDisplay implements PropertyChangeListener {

    private double temperature;
    private double humidity;


    @Override
    public void propertyChange(PropertyChangeListener evt) {
        String propertyName = evt.getPropertyName();
        Object newValue = evt.getNewValue();

        if ("temperature".equals(propertyName)) {
            this.temperature = (double) newValue;
        } else if ("humidity".equals(propertyName)) {
            this.humidity = (double) newValue;
        }

        if (this.temperature != 0 && this.humidity != 0) {
            System.out.println("Modern Display: Temp=" + temperature + "°C, Humidity=" + humidity + "%");
        }
    }
    
}
