public class ElectronicProduct extends Product {
  private String powerConsumption;

  public ElectronicProduct(
    String id, 
    String name, 
    String price, 
    String description, 
    String stock, 
    String status, 
    String categoryId, 
    String powerConsumption
  ) {
    super(id, name, price, description, stock, status, categoryId);
    this.powerConsumption = powerConsumption;
  }

  @Override
  protected void printProduct() {
    super.printProduct();
    System.out.printf("Power Consumption: %s\n", powerConsumption);
  }
}
