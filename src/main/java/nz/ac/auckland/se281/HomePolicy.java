package nz.ac.auckland.se281;

public class HomePolicy extends PolicyType {
  private String address;
  private boolean rental;

  public HomePolicy(int sumInsured, String address, boolean rental) {
    super(sumInsured);
    this.address = address;
    this.rental = rental;
  }

  // getters
  public String getAddress() {
    return address;
  }

  public boolean getRental() {
    return rental;
  }

  // setters
  public void setAddress(String address) {
    this.address = address;
  }

  public void setRental(boolean rental) {
    this.rental = rental;
  }

  @Override
  public int getBasePremium() { // overrriding the base premium method from the abstract class
    if (rental) {
      double basePremium =
          0.02 * sumInsured; // if the user has rental then the base premium is 2% of
      // the sum insured
      return (int) basePremium;
    } else {
      double basePremium = 0.01 * sumInsured; // if the user does not have rental then the base
      // premium is 1% of the sum insured
      return (int) basePremium;
    }
  }

  @Override
  public String getPolicyType() {
    return "Home";
  }
}
