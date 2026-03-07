package Priority3.Mediator.ChatRoomExample;

public class ChatUser extends User {
    public ChatUser(ChatMediator m, String name) { super(m, name); }
    public void send(String msg) { System.out.println(name + " sends: " + msg); mediator.sendMessage(msg, this); }
    public void receive(String msg) { System.out.println(name + " receives: " + msg); }
}
