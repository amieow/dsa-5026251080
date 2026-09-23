package lw01.unguided;

public abstract class WashService implements Billable {
  private String id;
  private int days;

  WashService(String id, int days) {
    if (days <= 0) {
      throw new IllegalArgumentException("hari harus positif");
    }
    this.id = id;
    this.days = days;
  }

  public String getId() {
    return this.id;
  }

  public int getDays() {
    return this.days;
  }

  public int calculateCharge(int units) {
    if (units <= 0) {
      throw new IllegalArgumentException("unit harus positif");
    }
    return units * calculateCharge();
  }

  public String label() {
    return "Service";
  }

  public String summary() {
    return id + " | " + label() + " | " + calculateCharge();
  }
}
