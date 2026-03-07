package Priority3.Mediator.ChatRoomExample;

// Concrete mediator - broadcasts to all users except sender
import java.util.ArrayList;
import java.util.List;
public class ChatRoom implements ChatMediator {
    private final List<User> users = new ArrayList<>();
    public void addUser(User user) { users.add(user); }
    public void sendMessage(String msg, User sender) {
        for (User u : users) if (u != sender) u.receive(msg);
    }
}
