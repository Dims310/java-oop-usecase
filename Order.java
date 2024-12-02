import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order implements OrderInterface {
  private String id;
  private String location;
  private String expiredAt; 
  private String createdAt; 
  private String updatedAt; 
  private String userId; 
  private String paymentId; 
  private String orderStatusId; 
  private String courierId;

  public Order() {
    this.location = "Belum ditentukan";
    this.expiredAt = getDeadlinePayments();
    this.createdAt = getTimestampNow();
    this.updatedAt = getTimestampNow();
    this.orderStatusId = "1";
    this.courierId = "Belum ditentukan";
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }

  public String getId() {
    return id;
  }

  public String getTimestampNow() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return now.format(formatter);
  }

  public String getDeadlinePayments() {
      LocalDateTime now = LocalDateTime.now();
      LocalDateTime oneHourLater = now.plusHours(1);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      return oneHourLater.format(formatter);
  }

  public void printOrder() {
    System.out.println("Order ID      : " + id);
    System.out.println("Location     : " + location);
    System.out.println("Expired At   : " + expiredAt);
    System.out.println("Created At   : " + createdAt);
    System.out.println("Updated At   : " + updatedAt);
    System.out.println("User ID      : " + userId);
    System.out.println("Payment ID   : " + paymentId);
    System.out.println("Order Status : " + orderStatusId);
    System.out.println("Courier ID   : " + courierId);
}
}
