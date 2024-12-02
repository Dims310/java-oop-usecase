public class HealthProduct extends Product{
  private String dosage;
  private String composition;  
  private String expirationDate;
  
  public HealthProduct(String id, String name, String price, String description, String stock, String status,
      String categoryId, String dosage, String composition, String expirationDate) {
    super(id, name, price, description, stock, status, categoryId);
    this.dosage = dosage;
    this.composition = composition;
    this.expirationDate = expirationDate;
  }

 @Override
 protected void printProduct() {
   super.printProduct();
   System.out.printf("Dosage: %s\nComposition: %s\nExpired Date: %s\n", dosage, composition, expirationDate);
 }
}
