public class ElectronicProduct extends Product {
  private String powerConsumption;

  public String getPowerConsumption() {
    return powerConsumption;
  }

  public void setPowerConsumption(String powerConsumption) {
    this.powerConsumption = powerConsumption;
  }

  @Override
  protected void printProduct() {
    super.printProduct();
    System.out.printf("Power Consumption: %s\n", powerConsumption);
  }

  @Override
  public String getSpecificDetails() {
    return "Power Consumption: " + powerConsumption;
  }
}
