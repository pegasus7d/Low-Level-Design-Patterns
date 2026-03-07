package Priority3.Mediator.ChatRoomExample;

// Test for Mediator (Chat Room)
// TODO: Implement testChat() - ChatRoom room = new ChatRoom(); add two ChatUsers, one sends "Hi"

public class MediatorTest {

    public static void main(String[] args) {
        System.out.println("=== Mediator (Chat Room) Tests ===\n");
        testChat();
        System.out.println("\n=== All tests passed ===");
    }

    // TODO: Build: ChatRoom room; User u1, u2 (ChatUser); room.addUser(u1); room.addUser(u2); u1.send("Hi");
    private static void testChat() {
        System.out.println("Test 1: Chat");
        ChatRoom room = null; // TODO: new ChatRoom(), new ChatUser(room,"Alice"), new ChatUser(room,"Bob"), add both, u1.send("Hi")
        assert room != null : "Room should not be null";
        System.out.println("  ✓ Passed\n");
    }
}
