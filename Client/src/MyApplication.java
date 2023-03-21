import Model.Model;
import View.ViewHandler;
import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import Model.ModelManager;

import java.io.IOException;

public class MyApplication extends Application
{
  public void start(Stage primaryStage) throws IOException

  {
    Model model=null;
    model=ModelManager.getInstance();
    ViewModelFactory viewModelFactory=new ViewModelFactory(model);
    ViewHandler viewHandler=new ViewHandler(viewModelFactory);
    viewHandler.startStage(primaryStage);
  }
}
