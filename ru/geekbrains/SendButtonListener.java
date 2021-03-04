package ru.geekbrains;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendButtonListener implements ActionListener {
    private final ChatMessageBuilder chatMessageBuilder;
    private final StringBuilder sb = new StringBuilder();

    public SendButtonListener(ChatMessageBuilder chatMessageBuilder) {
        this.chatMessageBuilder = chatMessageBuilder;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chatMessageBuilder.addMessage();
    }
}
