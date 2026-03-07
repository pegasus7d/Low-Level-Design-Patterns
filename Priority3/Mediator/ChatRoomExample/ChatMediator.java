package Priority3.Mediator.ChatRoomExample;

// Mediator - central communication
public interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}
