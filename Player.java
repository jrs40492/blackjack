public class Player {
  Hand hand = new Hand();
  private boolean allowHit = true;
  private boolean allowStay = true;

  public void setAllowHit(boolean value) {
    this.allowHit = value;
  }

  public void setAllowStay(boolean value) {
    this.allowStay = value;
  }

  public boolean allowHit() {
    return allowHit;
  }

  public boolean allowStay() {
    return allowStay;
  }
}