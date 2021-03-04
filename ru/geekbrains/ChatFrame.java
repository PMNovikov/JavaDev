package ru.geekbrains;

import javax.swing.*;
import java.awt.*;

public class ChatFrame extends JFrame {
    private final JPanel chatPanel;
    private final JPanel messagePanel;
    private final ChatMessageBuilder chatMessageBuilder;
    public ChatFrame() {
        chatMessageBuilder = new ChatMessageBuilder();
        setTitle("Chat Frame 2.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,300,600);
        setLayout(new BorderLayout());

        this.chatPanel = createTopPanel();
        add(chatPanel, BorderLayout.CENTER);
        this.messagePanel = createMessagePanel();
        add(messagePanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createTopPanel(){
        JPanel topPanel = new JPanel();
        JTextArea chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        topPanel.setLayout(new BorderLayout());
        topPanel.add(chatTextArea, BorderLayout.CENTER);
        chatMessageBuilder.setChatArea(chatTextArea);
        return topPanel;
    }

    private JPanel createMessagePanel(){
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());

        JTextArea messageTextArea = new JTextArea();
        messageTextArea.setEditable(true);
        messagePanel.add(messageTextArea, BorderLayout.CENTER);
        chatMessageBuilder.setMessageArea(messageTextArea);
        messageTextArea.addKeyListener(new MessageAreaKeyListener(chatMessageBuilder));

        JButton sendButton = new JButton("Send");

        sendButton.addActionListener(new SendButtonListener(chatMessageBuilder));
        messagePanel.add(sendButton, BorderLayout.EAST);

        return messagePanel;
    }

    public void addMessageToChat(String message){

    }
}
