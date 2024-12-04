public class HouseholdProduct extends Product {
  private String dimensions;
  private String weight;
  private String material;
  
  public String getDimensions() {
    return dimensions;
  }
  
  public void setDimensions(String dimensions) {
    this.dimensions = dimensions;
  }
  
  public String getWeight() {
    return weight;
  }
  
  public void setWeight(String weight) {
    this.weight = weight;
  }
  
  public String getMaterial() {
    return material;
  }
  
  public void setMaterial(String material) {
    this.material = material;
  }

  @Override
  public String getSpecificDetails() {
    return "Dimension: " + dimensions + "\nWeight: " + weight + "\nMaterial: " + material;
  }

  // @Override
  // protected void printProduct() {
  //   super.printProduct();
  //   System.out.printf("Dimensions: %s\nWeight: %s\nMaterial: %s\n", dimensions, weight, material);
  // }
}
