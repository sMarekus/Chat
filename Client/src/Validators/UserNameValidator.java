package Validators;

public class UserNameValidator
{
  public static final int MINIMAL_LENGTH=4;

  public static void validateUserName(String username)
  {
    if (username==null || username.length()<MINIMAL_LENGTH){
      throw new IllegalArgumentException("User name needs " + MINIMAL_LENGTH + "or more characters" );
    }
  }

}
