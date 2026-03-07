package Priority3.Mediator.ChatRoomExample;

public abstract class User {
    protected ChatMediator mediator;
    protected String name;
    public User(ChatMediator m, String name) { this.mediator = m; this.name = name; }
    public abstract void send(String msg);
    public abstract void receive(String msg);
}
