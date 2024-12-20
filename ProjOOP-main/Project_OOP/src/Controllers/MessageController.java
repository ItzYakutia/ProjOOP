package Controllers;

import Models.Message;
import java.util.ArrayList;
import java.util.List;

public class MessageController {
    private List<Message> messages;

    public MessageController() {
        this.messages = new ArrayList<>();
    }

    public void sendMessage(Message message) {
        messages.add(message);
        System.out.println("Message sent from " + message.getSenderId() + " to " + message.getRecipientId());
    }

    public void listMessages(String recipientId) {
        System.out.println("Messages for recipient ID: " + recipientId);
        for (Message message : messages) {
            if (message.getRecipientId().equals(recipientId)) {
                System.out.println(message);
            }
        }
    }
}
