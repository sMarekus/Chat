package View;

import ViewModel.ViewModelFactory;

import javax.swing.plaf.synth.Region;

public abstract class ViewController
{
  private Region root;

  private ViewHandler viewHandler;

  private ViewModelFactory viewModelFactory;

  protected abstract void init();

  public void init(ViewHandler viewHandler,ViewModelFactory viewModelFactory,Region root){
    this.root=root;
    this.viewHandler=viewHandler;
    this.viewModelFactory=viewModelFactory;
    init();
  }

  public Region getRoot(){
    return root;
  }
  public ViewModelFactory getViewModelFactory(){
    return viewModelFactory;
  }

  public ViewHandler getViewHandler(){
    return viewHandler;
  }
}
