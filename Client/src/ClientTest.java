import Model.Model;
import Model.ModelManager;

import java.io.IOException;

public class ClientTest
{
  public static void main(String[] args) throws IOException
  {
    Model model=ModelManager.getInstance();
    model.getNumberOfUsers();
    model.sendMessage("funguje to? ");
  }
}
