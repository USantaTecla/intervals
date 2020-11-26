package usantatecla;

public class IncludedMax extends Max {
  
  public IncludedMax(double value) {
    super(value);
	}

public boolean isOnLeft(double value) {
    return this.value >= value;
  } 
   
}
