package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Profile {
  private String username;
  private int userAge;
  private boolean isLife;
  private boolean isLoaded;
  private ArrayList<Details> details = new ArrayList<Details>();
  private ArrayList<Integer> sum = new ArrayList<Integer>();
  private ArrayList<String> policyOrder = new ArrayList<String>();

  public Profile(String userName, int age) {
    this.username = userName;
    this.userAge = age;
    this.isLife = false;
  }

  // setter
  public void setName(String userName) {
    this.username = userName;
  }

  public void setIsLife(boolean isLife) {
    this.isLife = isLife;
  }

  public void setIsLoaded(boolean isLoaded) {
    this.isLoaded = isLoaded;
  }

  public void setDetials(
      String policyType, String sumInsured, String address, String makeModel, int premiume) {
    // add the polciyName to the policyOrder list
    this.details.add(new Details(policyType, sumInsured, address, makeModel, premiume));
  }

  public void setPolicyOrder(String policyName) {
    // add the polciyName to the policyOrder list
    this.policyOrder.add(policyName);
  }

  public void setSum(int value) {
    // add the sum to the sum list
    sum.add(value);
  }

  // getter

  public String getName() {
    return username;
  }

  public int getAge() {
    return userAge;
  }

  public boolean getIsLife() {
    return isLife;
  }

  public boolean getIsLoaded() {
    return isLoaded;
  }

  public List<Details> getDetails() {
    return details;
  }

  public List<String> getPolicyOrder() {
    return policyOrder;
  }

  public int getSum() {
    // return the sum of all the values in the sum list

    int totalSum = 0;
    for (int i = 0; i < sum.size(); i++) {
      totalSum += sum.get(i);
    }
    return totalSum;
  }

  // getting the discounted value for each policy
  public int getDiscountValue() {
    int discountValue = 0;
    if (getPolicyOrder().size() == 2) {
      discountValue = (int) (0.9 * (getSum())); // cast the value to prevent loss of values

    } else if (getPolicyOrder().size() >= 3) {
      discountValue = (int) (0.8 * (getSum())); // cast the value to prevent loss of values
    } else {
      discountValue = getSum();
    }
    return discountValue;
  }
}
