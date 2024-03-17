package nz.ac.auckland.se281;

public abstract class PolicyType {
  protected int sumInsured;

  public PolicyType(int sumInsured) {
    this.sumInsured = sumInsured;
  }

  // getters
  public int getSumInsured() {
    return sumInsured;
  }

  // setters
  public void setSumInsured(int sumInsured) {
    this.sumInsured = sumInsured;
  }

  // all policies have Base Premium
  public abstract int getBasePremium();

  // getting the policy type
  public abstract String getPolicyType();
}
