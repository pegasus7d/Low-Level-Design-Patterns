package Priority3.Bridge.DeviceRemoteExample;

public class TV implements Device {
    private boolean on;
    public void turnOn() { on = true; System.out.println("TV On"); }
    public void turnOff() { on = false; System.out.println("TV Off"); }
    public boolean isOn() { return on; }
}
