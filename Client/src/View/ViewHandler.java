package View;

import ViewModel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ViewModel.*;
import javafx.scene.layout.Region;

import java.io.IOException;

public class ViewHandler
{
  private Stage primaryStage;
  private Scene currentScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory=viewModelFactory;
  }

  public void startStage(Stage primaryStage){
    this.primaryStage=primaryStage;
    this.currentScene=new Scene(new Region());
    openView("LoginView.fxml");
  }

  public void openView(String id)
  {
    try
    {
      Parent root = loadFromFxml(id);
      currentScene.setRoot(root);
      String title="";
      if (root.getUserData() !=null)
      {
        title += root.getUserData();
      }
      primaryStage.setTitle(title);
      primaryStage.setScene(currentScene);
      primaryStage.show();
    }catch (IOException e){
      e.printStackTrace();
    }

  }


  private Parent loadFromFxml(String fxmlFile) throws IOException
  {
    ViewController viewController=null;
    Parent root;
      FXMLLoader loader= new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      root=loader.load();
      viewController=loader.getController();
      viewController.init(this,viewModelFactory);

    return root;
  }

}

