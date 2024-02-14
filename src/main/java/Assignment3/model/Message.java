package Assignment3.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Message
{
  private String message;
  private User user;
  private String type;
  private String id; //DE MODIFICAT

  public String getType()
  {
    return type;
  }
  public void setType(String type)
  {
    this.type = type;
  }

  public Message(String message, User user) {
    this.message = message;
    this.user = user;
    //it generates a random String as an id for each message
    this.id = UUID.randomUUID().toString();
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Message message1 = (Message) o;
    return Objects.equals(message, message1.message) && Objects.equals(user,
        message1.user) && Objects.equals(type, message1.type) && Objects.equals(
        id, message1.id);
  }

  public String getMessage()
  {
    return message;
  }

  public User getUser() {
    return user;
  }

  @Override public String toString()
  {
    if (type != null && type.equals("general")) {
      return message;
    }
    return user.getUsername() + " : " + message;
  }

}
