package lw01.unguided;

public class MotorcycleWash extends WashService {
  private String id;
  private int days;

  public MotorcycleWash(String id, int days) {
    super(id, days);
  }

  public int calculateCharge() {
    return 15000 * getDays() + 5000;
  }

  public String label() {
    return "Motorcycle";
  }
}
