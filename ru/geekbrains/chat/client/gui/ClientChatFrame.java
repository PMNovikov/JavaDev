package ru.geekbrains.chat.client.gui;


import java.util.function.Consumer;

public class ClientChatFrame implements ChatFrameInteraction {
    private final ChatFrame chatFrame;

    public ClientChatFrame(Consumer<String> messageConsumer, String name) {
        this.chatFrame = new ChatFrame("Client Chat v1.0 (" + name + ")", messageConsumer);
    }

    @Override
    public void append(String message) {
        chatFrame.getChatArea().append(message);
        chatFrame.getChatArea().append("\n");
    }
}
