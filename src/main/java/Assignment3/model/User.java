package Assignment3.model;

import java.io.Serializable;

public class User implements Serializable
{
  private String username;

  public User(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != getClass()) {
      return false;
    }
    User other = (User) obj;
    return username.equals(other.getUsername());
  }

  public String toString() {
    return username + ": ";
  }

}
