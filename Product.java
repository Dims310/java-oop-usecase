import repository.Utils;

public abstract class Product {
  private String id;
  private String name;
  private String price;
  private String description;
  private String stock;
  private String status;
  private String categoryId;

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStock() {
    return stock;
  }

  public void setStock(String stock) {
    this.stock = stock;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public abstract String getSpecificDetails();

  public double calculateDiscount(double percentage) {
    return Double.parseDouble(price) * (percentage / 100);
  }

  public double calculateDiscount(String promoCode) {
    switch(promoCode) {
      case "1010": return Double.parseDouble(price) * 0.1;
      case "1212": return Double.parseDouble(price) * 0.12;
      default: return 0;
    }
  }

  protected void printProduct(){
    if (status.equals("1")) {
      this.status = "Tersedia";
    }
    System.out.printf("\nNomor Produk: %s\nName: %s\nPrice: %s\nDescription: %s\nStock: %s\nStatus: %s\n", String.valueOf(Integer.parseInt(id)+1), name, Utils.currencyFormat(price), description, stock, status);
  }
}