public class OrderDetail extends Order {
  private Integer id;
  private String quantity;
  private String priceAtOrder;
  private String isReturned;
  private String productsId;
  private String ordersId;

  public void setId(Integer id) {
    this.id = id;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public void setPriceAtOrder(String priceAtOrder) {
    this.priceAtOrder = priceAtOrder;
  }

  public void setProductsId(String productsId) {
    this.productsId = productsId;
  }

  public void setOrdersId(String ordersId) {
    this.ordersId = ordersId;
  }

  public String getOrdersId() {
    return ordersId;
  }

  @Override
  public void printOrder() {
    super.printOrder();
    System.out.println("Order Detail ID: " + id);
    System.out.println("Product ID    : " + productsId);
    System.out.println("Quantity      : " + quantity);
    System.out.println("Price At Order: " + priceAtOrder);
    System.out.println("Is Returned: " + isReturned);
  }
}
