package usantatecla;

public class IntervalBuilder {

  private Min min;
  private Max max;
  private boolean minConfigured;
  private boolean maxConfigured;

  IntervalBuilder(){
    this.minConfigured = false;
    this.maxConfigured = false;
  }

	public IntervalBuilder open(double value) {
    assert !this.minConfigured || !this.maxConfigured;;
    if (!this.minConfigured){
      this.min = new Min(value);
      this.minConfigured = true;
    } else if (!this.maxConfigured){
      this.max = new Max(value);
      this.maxConfigured = true;
    }
		return this;
  }
  
  public IntervalBuilder closed(double value) {
    assert !this.minConfigured || !this.maxConfigured;;
    if (!this.minConfigured){
      this.min = new ClosedMin(value);
      this.minConfigured = true;
    } else if (!this.maxConfigured){
      this.max = new ClosedMax(value);
      this.maxConfigured = true;
    }
		return this;
	}

	public Interval build() {
    assert this.minConfigured && this.maxConfigured;
		return new Interval(this.min, this.max);
	} 

}
