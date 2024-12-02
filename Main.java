import java.util.Scanner;

public class Main {
  public static String[][] products = {
    {"1","Panci Multi Guna", "250000", "Panci stainless steel anti karat dengan kapasitas 5 liter, cocok untuk berbagai jenis masakan", "50", "1", "1"},
    {"2","Blender Juice", "450000", "Blender dengan pisau tajam 6 mata, cocok untuk membuat jus dan smoothie", "30", "1", "1"},
    {"3","Earphone Wireless", "899000", "Earphone bluetooth dengan noise cancelling dan battery life 24 jam", "100", "1", "2", "2W"},
    {"4","Power Bank 10000mAh", "299000", "Power bank dengan kapasitas 10000mAh, mendukung fast charging", "75", "1", "2", "75W"},
    {"5","Serum Vitamin C", "189000", "Serum wajah dengan kandungan Vitamin C untuk mencerahkan kulit", "200", "1", "3"},
    {"6","Sunscreen SPF 50", "85000", "Tabir surya dengan SPF 50 dan PA++++ untuk perlindungan maksimal", "150", "1", "3"},
    {"7","Vitamin D3 1000IU", "125000", "Suplemen Vitamin D3 untuk kesehatan tulang, botol isi 60 tablet", "100", "1", "4", "1x Sehari", "Vitamin D3 1000mg", "2024"},
    {"8","Masker KN95", "75000", "Masker KN95 5 lapis, isi 10 pcs per pack", "300", "1", "4", null, null, "2026"},
    {"9","Puzzle 1000 Pcs", "199000", "Puzzle pemandangan alam dengan 1000 kepingan", "25", "1", "5"},
    {"10","Robot RC", "450000", "Robot remote control dengan baterai rechargeable", "15", "1", "5"},
    {"11","Kompor Listrik", "600000", "Kompor listrik 2 tungku dengan pengatur suhu digital, hemat energi", "40", "1", "1"},
    {"12","Setrika Uap", "450000", "Setrika uap berkualitas tinggi dengan kapasitas air 300ml", "35", "1", "1"},
    {"13","Smart TV 32 inch", "2500000", "Smart TV LED resolusi HD dengan fitur WiFi dan streaming", "24", "1", "2", "10W"},
    {"14","Laptop Entry Level", "5000000", "Laptop untuk kebutuhan perkantoran dengan prosesor Intel Core i3", "20", "1", "2", "175W"},
    {"15","Wireless Charger", "250000", "Charging pad dengan teknologi fast charging untuk smartphone", "60", "1", "2", "50W"},
    {"16","Pembersih Wajah", "95000", "Pembersih wajah dengan bahan alami, cocok untuk semua jenis kulit", "100", "1", "3"},
    {"17","Lipstik Matte", "125000", "Lipstik dengan warna tahan lama dan finish matte", "80", "1", "3"},
    {"18","Masker Rambut", "75000", "Masker rambut nutrisi untuk perawatan rambut kering dan rusak", "50", "1", "3"},
    {"19","Minyak Ikan Omega 3", "180000", "Suplemen minyak ikan dengan kandungan EPA dan DHA tinggi, isi 60 kapsul", "74", "1", "4", "1x Sehari", "Minyak Ikan", "2023"},
    {"20","Masker KF94", "65000", "Masker KF94 premium, isi 10 pcs, filtrasi tinggi", "198", "1", "4", null, null, "2020"},
    {"21","Vitamin C 1000mg", "95000", "Suplemen Vitamin C dengan dosis tinggi, mendukung sistem imun", "90", "1", "4", "1x Sehari", "Vitamin C 1000mg, Perisa Jeruk", "2027"},
    {"22","Drone Pemula", "1200000", "Drone dengan kamera HD dan fitur stabilisasi, cocok untuk pemula", "15", "1", "5"},
    {"23","Board Game Keluarga", "350000", "Board game strategis untuk 2-6 pemain, cocok untuk malam keluarga", "25", "1", "5"},
    {"24","Alat Sulap Profesional", "500000", "Set alat sulap lengkap dengan panduan untuk pemula hingga mahir", "20", "1", "5"},
    {"25","Hand Sanitizer", "85000", "Pembersih tangan, anti bakteri", "2", "1", "4", "Apply as needed", "Mint, Alcohol 70%, Aqua 30%", "2021"}
  };

  public static void main(String[] args) {
    menu();
  }

  public static void menu() {
    Scanner scanner = new Scanner(System.in);
    Boolean isRunning = true;

    System.out.print("\nMasukkan ID Anda: ");
    String userId = scanner.nextLine();

    // OOP in Array
    Order[] orders = new Order[100];
    OrderDetail[] orderDetails = new OrderDetail[100];
    
    if (checkUser(userId)) {
      while (isRunning) {
        System.out.print("\n-------- Menu --------\n1. Tampilkan produk\n2. Beli produk\n3. Tampilkan order\n0. Tutup prompt\n\nPilih nomor: ");
        Integer choice = scanner.nextInt();
  
        switch (choice) {
          case 1:
            getProductsByOOP();
            break;
          case 2:
            System.out.print("Berapa produk yang ingin dipesan: ");
            int numProducts = scanner.nextInt();
            scanner.nextLine();
  
            String[] productName = new String[numProducts];
            Integer[] quantities = new Integer[numProducts];
  
            for (int i = 0; i < numProducts; i++) {
                System.out.printf("Masukkan nama produk ke-%d:\n", i + 1);
                productName[i] = scanner.nextLine();
                System.out.printf("Masukkan jumlah untuk produk ke-%d: ", i + 1);
                quantities[i] = Integer.parseInt(scanner.nextLine());
            }

            displayPayments();
            System.out.print("\nPilih pembayaran: ");
            Integer paymentId = scanner.nextInt();
  
            Integer orderId = getNextIndex(orders);
            orders = createOrders(orders, orderId, paymentId, userId);
  
            for (Integer i = 0; i < numProducts; i++) {
              orderDetails = createOrderDetails(orderDetails, quantities[i], productName[i], orderId);
            }
            break;
          case 3:
            displayOrders(orders, orderDetails);
            break;
          case 0:
            isRunning = false;
            scanner.close();
            break;
          default:
            System.out.println("Pilihan tidak valid. Silakan coba lagi");
            break;
        }
      }
    }
  }

  public static void displayOrders(Order[] orders, OrderDetail[] orderDetails) {
    for (Order i : orders) {
      if (i != null) {
        System.out.println(i.toString());
        for (OrderDetail j : orderDetails) {
          if (j != null) {
            if (j.getOrdersId().equals(i.getId())) {
              System.out.println(j.toString());
            }
          }
        }
      }

      System.out.println();
    }
  }

  public static void displayProducts() {
    for (int i = 0; i < products.length; i++) {
      if (products[i][4] != "0") {
        System.out.printf(
          "Nomor Produk: %d\nNama Produk: %s\nHarga: %d\nDeskripsi: %s\nKuantitas: %d\n\n",
          Integer.parseInt(products[i][0]),
          products[i][1],
          Integer.parseInt(products[i][2]),
          products[i][3],
          Integer.parseInt(products[i][4])
        );
      }
    } 
  }

  public static void displayPayments() {
    System.out.println();
    String[][] payments = getPayments();
    for (String[] i : payments) {
      System.out.println(i[0] + ". " + i[1]);
    }
  }

  public static void getProductsByOOP() {
    for (int i = 0; i < products.length; i++) {
      if (products[i][6].equals("4")) {
        HealthProduct newProduct = new HealthProduct(
          products[i][0], 
          products[i][1],
          products[i][2],
          products[i][3],
          products[i][4],
          products[i][5],
          products[i][6],
          products[i][7],
          products[i][8],
          products[i][9]
        );
        
        newProduct.printProduct();
      }

      if (products[i][6].equals("2")) {
        ElectronicProduct newProduct = new ElectronicProduct(
          products[i][0], 
          products[i][1],
          products[i][2],
          products[i][3],
          products[i][4],
          products[i][5],
          products[i][6],
          products[i][7]
        );

        newProduct.printProduct();
      };
    }
  }

  public static Order[] createOrders(Order[] orders, Integer orderId, Integer paymentId, String userId) {
    Order newOrder = new Order();
    newOrder.setId(String.valueOf(orderId + 1));
    newOrder.setUserId(userId);
    newOrder.setPaymentId(String.valueOf(paymentId));

    orders[orderId] = newOrder;
    return orders;
  }

  public static OrderDetail[] createOrderDetails(OrderDetail[] orderDetails, Integer qty, String productName, Integer orderId) {
    String[] productByName = getProductsByName(productName, qty);

    OrderDetail newOrderDetail = new OrderDetail();
    newOrderDetail.setQuantity(productByName[4]);
    newOrderDetail.setPriceAtOrder(String.valueOf(productByName[2]));
    newOrderDetail.setProductsId(productByName[0]);
    newOrderDetail.setOrdersId(String.valueOf(orderId + 1));

    for (Integer i = 0; i < orderDetails.length; i++) {
      if (orderDetails[i] == null) {
        newOrderDetail.setId(i+1);
        orderDetails[i] = newOrderDetail;
        break;
      }
    }

    return orderDetails;
  }

  public static Integer getNextIndex(Order[] orders) {
    for (Integer i=0; i < orders.length; i++) {
      if (orders[i] == null) {
        return i;
      }
    }
    return -1;
  }

  public static String[] getProductsByName(String productName, Integer qty) {
    String[] detailProduct = null;

    for (String[] product : products) {
        if (product[1].equalsIgnoreCase(productName)) {
            detailProduct = product.clone(); // Buat salinan untuk menghindari referensi langsung
            break;
        }
    }

    if (detailProduct == null) {
        System.out.println("Produk tidak ditemukan!");
        return null;
    }

    int productStocks = Integer.parseInt(detailProduct[4]);

    int booked = Math.min(productStocks, qty);

    for (String[] product : products) {
        if (product[0].equals(detailProduct[0])) {
            product[4] = String.valueOf(productStocks - booked);
            break;
        }
    }

    detailProduct[4] = String.valueOf(booked);
    return detailProduct;
  }

  public static Boolean checkUser(String userId) {
    String[][] user = getUser(); 
    if (Integer.parseInt(userId) > user.length) {
      return false;
    }
    return true;
  }

  public static String[][] getUser() {
    return new String[][] {
      {"1", "Surya", "Wijaya", "Jl. Gatot Subroto No. 123, RT 02 RW 03, Kuningan, Jakarta Selatan"},
      {"2", "Dewi", "Kusuma", "Jl. Diponegoro Blok A5 No. 45, Tegalsari, Surabaya, Jawa Timur"},
      {"3", "Budi", "Santoso", "Komplek Griya Indah Blok C2 No. 17, Medan Selayang, Medan, Sumatera Utara"},
      {"4", "Ratna", "Sari", "Jl. Ahmad Yani Gang Melati No. 8, Denpasar Utara, Bali"},
      {"5", "Ahmad", "Hidayat", "Perumahan Bumi Asri Blok D4 No. 12, Bandung Timur, Jawa Barat"},
      {"6", "Siti", "Rahma", "Jl. Sudirman No. 234, RT 05 RW 02, Palembang, Sumatera Selatan"},
      {"7", "Eko", "Prasetyo", "Jl. Pahlawan No. 56, Malang, Jawa Timur"},
      {"8", "Rina", "Wulandari", "Komplek Villa Sentosa Blok F7 No. 23, Tangerang Selatan, Banten"},
      {"9", "Agus", "Setiawan", "Jl. Pemuda No. 78, RT 03 RW 04, Semarang, Jawa Tengah"},
      {"10", "Maya", "Putri", "Perumahan Graha Asri Blok B3 No. 15, Makassar, Sulawesi Selatan"}
    };
  }

  public static String[][] getPayments() {
    return new String[][] {
      {"1", "Akun Virtual"},
      {"2", "Paylater"},
      {"3", "COD"}
    };
  }
}