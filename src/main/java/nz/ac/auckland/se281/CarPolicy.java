package nz.ac.auckland.se281;

public class CarPolicy extends PolicyType {
  private String make;
  private String licensePlate;
  private boolean mechanicalBreakdown;
  private int age;

  public CarPolicy(
      int sumInsured, String make, String licensePlate, boolean mechanicalBreakdown, int age) {
    super(sumInsured);
    this.make = make;
    this.licensePlate = licensePlate;
    this.mechanicalBreakdown = mechanicalBreakdown;
    this.age = age;
  }

  // getters
  public String getMake() {
    return make;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public boolean getMechanicalBreakdown() {
    return mechanicalBreakdown;
  }

  // setters

  public void setMake(String make) {
    this.make = make;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public void setMechanicalBreakdown(boolean mechanicalBreakdown) {
    this.mechanicalBreakdown = mechanicalBreakdown;
  }

  // override the Base premium method so its checks for the age of the user

  @Override
  // overrriding the base premium method from the abstract class
  public int getBasePremium() {
    double basePremium;
    if (this.age < 25) { // if the user is under 25 then the base premium is 15% of the sum insured
      basePremium = 0.15 * sumInsured;
    } else { // if the user is over 25 then the base premium is 10% of the sum insured
      basePremium = 0.10 * sumInsured;
    }

    if (mechanicalBreakdown) { //  mechanical breakdown then add 80 to the basepremium

      basePremium += 80;
    }

    return (int) basePremium;
  }

  @Override
  public String getPolicyType() {
    return "Car";
  }
}
