package Assignment3.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageList implements Serializable
{
  private ArrayList<Message> messages;
  private static MessageList instance;

  private MessageList() {
    messages = new ArrayList<>();
  }

  public static synchronized MessageList getInstance() {
    if (instance == null) {
      instance = new MessageList();
    }
    return instance;
  }

  public void setMessages(ArrayList<Message> messages)
  {
    this.messages = messages;
  }

  public void addMessage(Message message) {
    this.messages.add(message);
  }

  public ArrayList<Message> getMessages() {
    return messages;
  }

  public String toString() {
    String temp = "";
    for (int i = 0; i < messages.size(); i++)
    {
      temp += messages.get(i).toString() + "\n";
    }
    return temp;
  }
}
