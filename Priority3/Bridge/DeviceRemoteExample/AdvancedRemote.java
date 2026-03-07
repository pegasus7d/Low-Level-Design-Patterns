package Priority3.Bridge.DeviceRemoteExample;

// Refined abstraction - can mute (example extra behavior)
public class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) { super(device); }
    public void mute() { System.out.println("Mute"); }
}
