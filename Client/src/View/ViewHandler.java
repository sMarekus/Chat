package View;

import ViewModel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ViewModel.*;


import javafx.scene.layout.Region;

public class ViewHandler extends ViewCreator
{
  private Stage primaryStage;
  private Scene currentScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory=viewModelFactory;
  }


  @Override protected void initViewController(ViewController viewController,
      Region root)
  {
    viewController.init(this,viewModelFactory,root);
  }

  public void startStage(Stage primaryStage){
    this.primaryStage=primaryStage;
    this.currentScene=new Scene(new javafx.scene.layout.Region());
    openView("LoginView.fxml");
  }

  public void openView(String id){
    Region root=getViewController(id).getRoot();

    currentScene.setRoot(root);
    String title="";
    if (root.getUserData() !=null)
    {
      title += root.getUserData();
    }


  }

  @Override protected void initViewController(ViewController viewController,
      javax.swing.plaf.synth.Region root)
  {

  }
}
