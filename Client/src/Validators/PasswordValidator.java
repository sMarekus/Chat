package Validators;

public class PasswordValidator
{
  public final static int MINIMAL_LENGTH=6;

  public static void validatePassword(String password) throws IllegalAccessException
  {
    if (password==null || password.length()<MINIMAL_LENGTH)
    {
      throw new IllegalAccessException("Illegal input, Password needs " + MINIMAL_LENGTH + "or more characters ");
    }
    
  }

}
