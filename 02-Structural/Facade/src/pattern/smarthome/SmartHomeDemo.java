package pattern.smarthome;

public class SmartHomeDemo {
    public static void main(String[] args) {
        
        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        SecuritySystem security = new SecuritySystem();

        SmartHomeFacade facade = new SmartHomeFacade(light, thermostat, security);

        facade.arriveHome();
        System.out.println();
        facade.leaveHome();

        System.out.println("\n Added DoorLock to Facade? Client doesn't care! It just calls leaveHome().");
    }
}
