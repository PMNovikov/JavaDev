package ru.geekbrains;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MessageAreaKeyListener implements KeyListener {
    private final ChatMessageBuilder chatMessageBuilder;

    public MessageAreaKeyListener(ChatMessageBuilder chatMessageBuilder) {
        this.chatMessageBuilder = chatMessageBuilder;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            chatMessageBuilder.addMessage(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
