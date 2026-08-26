package pattern.smarthome;

public class SmartHomeFacade {

    private Light light;
    private Thermostat thermostat;
    private SecuritySystem security;

    public SmartHomeFacade(Light light, Thermostat thermostat, SecuritySystem security) {
        this.light = light;
        this.thermostat = thermostat;
        this.security = security;
    }

    public void leaveHome() {
        System.out.println("=== Leaving Home (via Facade) ===");
        light.turnOff();
        thermostat.setTemperature(18);
        security.arm();
        System.out.println("Leaving home... Goodbye!");
    }

    public void arriveHome() {
        System.out.println("=== Arriving Home (via Facade) ===");
        security.disarm();
        light.turnOn();
        System.out.println("Arriving home... Welcome back!");
    }
    
}
