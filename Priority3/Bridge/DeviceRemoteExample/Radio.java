package Priority3.Bridge.DeviceRemoteExample;

public class Radio implements Device {
    private boolean on;
    public void turnOn() { on = true; System.out.println("Radio On"); }
    public void turnOff() { on = false; System.out.println("Radio Off"); }
    public boolean isOn() { return on; }
}
