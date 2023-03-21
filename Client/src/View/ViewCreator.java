package View;

import javafx.scene.layout.Region;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
public  abstract class ViewCreator
{
  private Map<String,ViewController> views=new HashMap<>();

  public ViewCreator(){

  }

  protected abstract void  initViewController(ViewController viewController,
      Region root);

  public ViewController getViewController(String id){
    ViewController viewItem=views.get(id);
    if (viewItem==null){
      viewItem=loadFromFxml(id);
      views.put(id,viewItem);
    }
    return viewItem;
  }

  private ViewController loadFromFxml(String fxmlFile){
    ViewController viewController=null;
    try
    {
      FXMLLoader loader= new FXMLLoader();
      loader.setLocation(getClass().getResource(fxmlFile));
      Region root=loader.load();
      viewController=loader.getController();
      initViewController(viewController,root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return viewController;
  }

}
