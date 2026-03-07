package Priority3.Bridge.DeviceRemoteExample;

// Abstraction - holds a Device (implementation), delegates to it
// TODO: protected Device device; constructor RemoteControl(Device d). powerOn() -> device.turnOn(), powerOff() -> device.turnOff()
public abstract class RemoteControl {
    protected Device device;
    public RemoteControl(Device device) { this.device = device; }
    public void powerOn() { device.turnOn(); }
    public void powerOff() { device.turnOff(); }
}
