package View;

import ViewModel.ViewModelFactory;

import javafx.scene.layout.Region;

public abstract class ViewController
{

  private ViewHandler viewHandler;

  private ViewModelFactory viewModelFactory;

  protected abstract void init();

  public void init(ViewHandler viewHandler,ViewModelFactory viewModelFactory){
    this.viewHandler=viewHandler;
    this.viewModelFactory=viewModelFactory;
    init();
  }

  public ViewModelFactory getViewModelFactory(){
    return viewModelFactory;
  }

  public ViewHandler getViewHandler(){
    return viewHandler;
  }
}
