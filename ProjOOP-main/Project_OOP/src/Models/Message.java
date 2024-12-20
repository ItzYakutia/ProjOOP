package Models;

public class Message {
    private String senderId;
    private String recipientId;
    private String content;

    public Message(String senderId, String recipientId, String content) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" + "from='" + senderId + '\'' + ", to='" + recipientId + '\'' + ", content='" + content + '\'' + '}';
    }
}
