package ra.practice03_session06.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogId;
    private boolean productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, Date created, int catalogId, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCategorie) {
        this.productId = inputProductId(scanner, arrProduct, indexProduct);
        this.productName = inputProductName(scanner, arrProduct, indexProduct);
        this.price = inputPrice(scanner);
        this.description = inputDescription(scanner);
        this.created = inputCreated(scanner);
//        this.catalogId = arrCategories[indexCategorie].getCatalogId();
        this.productStatus = inputProductStatus(scanner);
    }

    public boolean checkUnique(String strCheck, Product[] arrProduct, int indexProduct, String attName) {
        for (int i = 0; i < indexProduct; i++) {
            switch (attName) {
                case "productId":
                    if (arrProduct[i].getProductId().equals(strCheck)) {
                        return true;
                    }
                    break;
                case "productName":
                    if (arrProduct[i].getProductName().equals(strCheck)) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public String inputProductId(Scanner scanner, Product[] arrProduct, int indexProduct) {
        System.out.println("Nhập vào mã sản phẩm: ");
        do {
            String productId = scanner.nextLine();
            //Kiểm tra là 4 ký tự bắt đầu là C || S || A
//            if (productId.length()!=4 || (!productId.startsWith("C")&&!productId.startsWith("S")&&!productId.startsWith("A")){
//                System.err.println("Mã sản phẩm phải là chuỗi 4 ký tự bắt đầu là C hoặc S hoặc A");
//            }
            String productIdRegex = "[CSA][\\w]{3}";
            //Kiểm tra trùng lặp
            boolean isExist = checkUnique(productId, arrProduct, indexProduct, "productId");
            if (Pattern.matches(productIdRegex, productId)) {
                if (isExist) {
                    System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại");
                } else {
                    return productId;
                }
            } else {
                System.err.println("Mã sản phẩm phải gồm 4 ký tự bắt đầu là C: các đồ uống là café,\n" +
                        "S: các đồ uống là sinh tố, A: các đồ ăn nhanh, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputProductName(Scanner scanner, Product[] arrProduct, int indexProduct) {
        System.out.println("Nhập vào tên sản phẩm:");
        do {
            String productName = scanner.nextLine();
            if (productName.length() >= 10 && productName.length() <= 50) {
                //Duy nhất
                boolean isExist = checkUnique(productName, arrProduct, ShopManagement.indexProduct, "productName");
                if (isExist) {
                    System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại");
                } else {
                    return productName;
                }
            } else {
                System.err.println("Tên sản phẩm có từ 10-50 ký tự, vui lòng nhập lại");
            }
        } while (true);
    }

    public float inputPrice(Scanner scanner) {
        System.out.println("Nhập vào giá nhập sản phẩm:");
        do {
            float importPrice = Float.parseFloat(scanner.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.err.println("Giá nhập phải có giá trị lớn hơn 0, vui lòng nhập lại");
            }
        } while (true);
    }

    public String inputDescription(Scanner scanner) {
        System.out.println("Nhập vào mô tả sản phẩm:");
        return scanner.nextLine();
    }

    public Date inputCreated(Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nhập vào ngày tạo:");
        do {
            String strCreated = scanner.nextLine();
            try {
                Date created = sdf.parse(strCreated);
                return created;
            } catch (Exception ex) {
                System.err.println("Ngày tạo không đúng định dạng dd/MM/yyyy, vui lòng nhập lại");
            }
        } while (true);
    }

    public boolean inputProductStatus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái sản phẩm:");
        return Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayProductData() {
        System.out.printf("Product ID: %d - Product Name: %s - Price: %f - Descriptions: %s - Date: dd/MM/yyyy - catalogId: %d", this.productId, this.productName, this.price, this.description, this.created, this.catalogId);
    }
}
