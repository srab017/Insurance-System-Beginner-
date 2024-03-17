package nz.ac.auckland.se281;

public class Details {
  private String policyType;
  private String sumInsured;
  private String address;
  private String makeModel;
  private int premiume;

  public Details(
      String policyType, String sumInsured, String address, String makeModel, int premiume) {
    this.policyType = policyType;
    this.sumInsured = sumInsured;
    this.address = address;
    this.makeModel = makeModel;
    this.premiume = premiume;
  }

  // getters

  public String getSumInsured() {
    return sumInsured;
  }

  public String getAddress() {
    return address;
  }

  public String getMakeModel() {
    return makeModel;
  }

  public int getPremiume() {
    return premiume;
  }

  public String getPolicyType() {
    return policyType;
  }

  // setters

  public void setSumInsured(String sumInsured) {
    this.sumInsured = sumInsured;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setMakeModel(String makeModel) {
    this.makeModel = makeModel;
  }

  public static Details get(int i) {
    return null;
  }

  public void setPremiume(int premiume) {
    this.premiume = premiume;
  }

  public void setPolicyType(String policyType) {
    this.policyType = policyType;
  }
}
