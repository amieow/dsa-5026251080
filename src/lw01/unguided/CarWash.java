package lw01.unguided;

public class CarWash extends WashService {
  private String id;
  private int days;

  CarWash(String id, int days) {
    super(id, days);
  }

  public int calculateCharge() {
    return (35000 * Math.min(3, getDays())) + 25000 * Math.max(0, getDays() - 3) + 15000;
  }

  public String label() {

    return "Car";
  }
}
