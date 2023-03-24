import Model.Model;
import View.ViewHandler;
import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import Model.ModelManager;
import mediator.ChatMediatorClient;

import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;

public class MyApplication extends Application
{
  public void start(Stage primaryStage) throws IOException

  {
    try
    {
      Model model=null;
      model=new ModelManager();
      ViewModelFactory viewModelFactory=new ViewModelFactory(model);
      ViewHandler viewHandler=new ViewHandler(viewModelFactory);
      viewHandler.startStage(primaryStage);
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }
}
