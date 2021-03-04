package ru.geekbrains;

import javax.swing.*;

public class ChatMessageBuilder {
    private JTextArea chatArea;
    private JTextArea messageArea;
    private final StringBuilder sb = new StringBuilder();


    public ChatMessageBuilder() {
    }

    public void setChatArea(JTextArea chatArea) {
        this.chatArea = chatArea;
    }

    public void setMessageArea(JTextArea messageArea) {
        this.messageArea = messageArea;
    }

    public void addMessage() {
        addMessage(true);
    }

    public void addMessage(boolean whithNewLine){
        if (messageArea.getText().isBlank()){
            return;
        }
        sb.append(chatArea.getText());
        sb.append(messageArea.getText());
        if (whithNewLine){
            sb.append("\n");
        }
        chatArea.setText(sb.toString());

        sb.setLength(0);
        messageArea.setText("");
    }
}
