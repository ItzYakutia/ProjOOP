package Models;

public class Message {
    private String content;
    private String sender;
    private String recipientId;
    private String timestamp;

    public Message(String content, String sender, String recipientId, String timestamp) {
        this.content = content;
        this.sender = sender;
        this.recipientId = recipientId;
        this.timestamp = timestamp;
    }

    // Getters
    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public String getTimestamp() {
        return timestamp;
    }


    @Override
    public String toString() {
        return "Message{" +
               "content='" + content + '\'' +
               ", sender='" + sender + '\'' +
               ", recipientId='" + recipientId + '\'' +
               ", timestamp='" + timestamp + '\'' +
               '}';
    }
}

