package naive;



class Light{
    public void turnOn(){ System.out.println("Lights are ON"); }
    public void turnOff() { System.out.println("Lights are OFF"); }
}

class Thermostat {
    public void setTemperature(int temp){
        System.out.println("Thermostat set to " + temp + " degrees ");
    }
}

class SecuritySystem{
    public void arm() { System.out.println("Security sysetm ARMED"); }
    public void disarm() { System.out.println("Security system DISARMED"); }
} 

public class WithoutFacade {
    public static void main(String[] args) {
        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        SecuritySystem security = new SecuritySystem();

        System.out.println("=== Leaving Home (Manual) ===");
        light.turnOff();;
        thermostat.setTemperature(18);
        security.arm();

        System.out.println("\n=== Arriving Home (Manual) ===");
        security.disarm();
        light.turnOn();
    }
    
}
