package nz.ac.auckland.se281;

public class LifePolicy extends PolicyType {
  private int age;

  public LifePolicy(int sumInsured, int age) {
    super(sumInsured);
    this.age = age;
  }

  // getters
  public int getAge() {
    return age;
  }

  // setters
  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public int getBasePremium() {
    double basePremium;
    basePremium = ((1 + ((double) age / 100)) / 100) * sumInsured;
    return (int) basePremium;
  }

  @Override
  public String getPolicyType() {
    return "Life";
  }
}
