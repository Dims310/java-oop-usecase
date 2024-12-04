public class HealthProduct extends Product {
  private String dosage;
  private String composition;  
  private String expirationDate;

  public String getDosage() {
    return dosage;
  }

  public void setDosage(String dosage) {
    this.dosage = dosage;
  }

  public String getComposition() {
    return composition;
  }

  public void setComposition(String composition) {
    this.composition = composition;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  @Override
  public String getSpecificDetails() {
    return "Dosage: " + dosage + "\nComposition: " + composition + "\n Expired: " + expirationDate;
  }

  // @Override
  // protected void printProduct() {
  //   super.printProduct();
  //   System.out.printf("Dosage: %s\nComposition: %s\nExpired Date: %s\n", dosage, composition, expirationDate);
  // }
}
