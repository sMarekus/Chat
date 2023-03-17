package Model;

public class User
{
 private final String userName;
 private final String password;

  public User(String userName, String password)
  {
    this.userName = userName;
    this.password = password;
  }

  public String getUserName(){
    return userName;
  }

  public String getPassword(){
    return password;
  }

  @Override public String toString()
  {
    return "User{" + "userName='" + userName + '\'' + ", password='" + password
        + '\'' + '}';
  }
}
