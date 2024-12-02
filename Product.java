public class Product {
  private String id, name, price, description, stock, status, categoryId;

  public Product(String id, String name, String price, String description, String stock, String status, String categoryId) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.stock = stock;
    this.status = status;
    this.categoryId = categoryId;
  }

  protected void printProduct(){
    System.out.printf("\nNomor Produk: %s\nName: %s\nPrice: %s\nDescription: %s\nStock: %s\n", String.valueOf(Integer.parseInt(id)+1), name, price, description, stock);
  }
}