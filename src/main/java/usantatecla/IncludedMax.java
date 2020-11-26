package usantatecla;

public class IncludedMax extends Max {
  
  public IncludedMax(int value) {
    super(value);
	}

public boolean isOnLeft(double value) {
    return this.value >= value;
  } 
   
}
