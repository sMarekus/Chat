package View;

import javafx.scene.layout.Region;
import java.util.HashMap;
import java.util.Map;

public  abstract class ViewCreator
{
  private Map<String,ViewController> views=new HashMap<>();

  public ViewCreator(){

  }

  protected abstract void  initViewController(ViewController viewController,
      Region root);

  public ViewController getViewController(String id){
    ViewController item=views.get(id);
    if (item==null){
      item=loadFromFXML
    }
  }

}
