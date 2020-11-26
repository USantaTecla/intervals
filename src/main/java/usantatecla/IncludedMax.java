package usantatecla;

public class IncludedMax extends Max {
  
  public IncludedMax(int i, boolean b) {
    super(i,b);
	}

public boolean greaterOrEquals(double value) {
    return this.value >= value;
  } 
   
}
