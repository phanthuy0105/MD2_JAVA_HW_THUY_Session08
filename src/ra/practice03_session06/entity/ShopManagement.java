package ra.practice03_session06.entity;

import ra.practice03_session06.entity.Categories;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class ShopManagement {
    static Categories[] arrCategories = new Categories[100];
    static int indexCategories = 0;
    static Product[] arrProduct = new Product[100];
    static int indexProduct = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**************MENU**************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Danh mục sản phẩm");
                    do {
                        System.out.println("**************MENU**************");
                        System.out.println("1. Nhập thông tin các danh mục");
                        System.out.println("2. Hiển thị thông tin các danh mục");
                        System.out.println("3. Cập nhật thông tin danh mục");
                        System.out.println("4. Xóa danh mục");
                        System.out.println("5. Cập nhật trạng thái danh mục");
                        System.out.println("6. Thoát");
                        System.out.print("Lựa chọn của bạn: ");
                        int choiceCategories = Integer.parseInt(scanner.nextLine());
                        switch (choiceCategories) {
                            case 1:
                                ShopManagement.inputListCategories(scanner);
                                break;
                            case 2:
                                ShopManagement.displayListCategories();
                                break;
                            case 3:
                                ShopManagement.updateCategories(scanner);
                                break;
                            case 4:
                                ShopManagement.deleteCategories(scanner);
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            default:
                                System.err.println("Vui lòng nhập từ 1-6");
                        }
                        if (choiceCategories == 6) {
                            break;
                        }
                    } while (true);
                    break;
                case 2:
                    System.out.println("Sản phẩm");
                    do {
                        System.out.println("**************MENU**************");
                        System.out.println("1. Nhập thông tin các sản phẩm");
                        System.out.println("2. Hiển thị thông tin các sản phẩm");
                        System.out.println("3. Sắp xếp các sản phẩm theo giá");
                        System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
                        System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
                        System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
                        System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b\n" +
                                "(a,b nhập từ bàn phím)");
                        System.out.println("8. Thoát");
                        System.out.print("Lựa chọn của bạn: ");
                        int choiceProduct = Integer.parseInt(scanner.nextLine());
                        switch (choiceProduct) {
                            case 1:
                                ShopManagement.inputListProduct(scanner);
                                break;
                            case 2:
                                ShopManagement.displayListProduct();
                                break;
                            case 3:
                                ShopManagement.sortProductByPrice(scanner);
                                break;
                            case 4:
                                ShopManagement.updateProduct(scanner);
                                break;
                            case 5:
                                ShopManagement.deleteProduct(scanner);
                                break;
                            case 6:
                                ShopManagement.searchProductByName(scanner);
                                break;
                            case 7:
                                ShopManagement.staticProductByPrice(scanner);
                                break;
                            case 8:
                                break;
                            default:
                                System.err.println("Vui lòng nhập từ 1-8");
                        }
                        if (choiceProduct == 8) {
                            break;
                        }
                    } while (true);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-3");

            }
        } while (true);
    }

    public static void inputListCategories(Scanner scanner) {
        System.out.println("Nhập vào số danh mục cần nhập thông tin:");
        int lengthCate = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lengthCate; i++) {
            arrCategories[indexCategories] = new Categories();
            arrCategories[indexCategories].inputData(scanner, arrCategories, indexCategories);
        }
    }

    public static void displayListCategories() {
        System.out.println("Thông tin các danh mục: ");
        for (int i = 0; i < indexCategories; i++) {
            arrCategories[i].displayCateData();
        }
    }

    public static int getIndexByIdCategories(int categoriesId) {
        for (int i = 0; i < indexCategories; i++) {
            if (arrCategories[i].getCatalogId() == categoriesId) {
                return i;
            }
        }
        return -1;
    }

    public static void updateCategories(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần cập nhật thông tin:");
        int categoriesIdUpdate = Integer.parseInt(scanner.nextLine());
        //1. Tìm phần tử cần cập nhât trong mảng (chỉ số phần tử cần cập nhật)
        int indexCategoriesUpdate = getIndexByIdCategories(categoriesIdUpdate);
        //2. Nếu tồn tại thực hiện cập nhật danh mục (trừ mã danh mục)
        if (indexCategoriesUpdate >= 0) {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên danh mục");
                System.out.println("2. Cập nhật mô tả danh mục");
                System.out.println("3. Cập nhật trạng thái danh mục");
                System.out.println("4. Thoát");
                System.out.print("Lưa chọn của bạn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên danh mục cần cập nhập:");
                        arrCategories[indexCategoriesUpdate].setCatalogName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào mô tả danh mục cần cập nhật:");
                        arrCategories[indexCategoriesUpdate].setDescriptions(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập vào trạng thái cần cập nhật:");
                        arrCategories[indexCategoriesUpdate].setCatalogStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 4:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 1-4");
                }
            } while (isExit);
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static void deleteCategories(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần xóa:");
        String categoriesIdDelete = scanner.nextLine();
        int indexCategoriesDelete = getIndexById(categoriesIdDelete);
        if (indexCategoriesDelete >= 0) {
            for (int i = indexCategoriesDelete; i < indexCategories - 1; i++) {
                arrCategories[i] = arrCategories[i + 1];
            }
            arrCategories[indexCategories - 1] = null;
            indexCategories--;
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static void inputListProduct(Scanner scanner) {
        System.out.println("Nhập vào số sản phẩm cần nhập thông tin:");
        int lengthProduct = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lengthProduct; i++) {
            arrProduct[indexProduct] = new Product();
            arrProduct[indexProduct].inputData(scanner, arrProduct, indexProduct, arrCategories, indexCategories);
        }
    }

    public static void displayListProduct() {
        System.out.println("Thông tin các sản phẩm:");
        for (int i = 0; i < indexProduct; i++) {
            arrProduct[indexProduct].displayProductData();
        }
    }

    public static int getIndexById(String productId) {
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    public static void sortProductByPrice(Scanner scanner) {
        do {
            System.out.println("1. Sắp xếp sản phẩm giảm dần theo giá");
            System.out.println("2. Sắp xếp sản phẩm tăng dần theo giá");
            System.out.println("3. Thoát");
            System.out.print("Lưa chọn của bạn: ");
            int choiceSort = Integer.parseInt(scanner.nextLine());
            switch (choiceSort) {
                case 1:
                    System.out.println("Sắp xếp sản phẩm giảm dần theo giá: ");
                    for (int i = 0; i < indexProduct - 1; i++) {
                        for (int j = i + 1; j < indexProduct; j++) {
                            if (arrProduct[i].getPrice() < arrProduct[j].getPrice()) {
                                Product temp = arrProduct[i];
                                arrProduct[i] = arrProduct[j];
                                arrProduct[j] = temp;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Sắp xếp sản phẩm tăng dần theo giá: ");
                    for (int i = 0; i < indexProduct - 1; i++) {
                        for (int j = i + 1; j < indexProduct; j++) {
                            if (arrProduct[i].getPrice() > arrProduct[j].getPrice()) {
                                Product temp = arrProduct[i];
                                arrProduct[i] = arrProduct[j];
                                arrProduct[j] = temp;
                            }
                        }
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập từ 1-3");
            }
        } while (true);
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần cập nhật thông tin:");
        String productIdUpdate = scanner.nextLine();
        //1. Tìm phần tử cần cập nhât trong mảng (chỉ số phần tử cần cập nhật)
        int indexProductUpdate = getIndexById(productIdUpdate);
        //2. Nếu tồn tại thực hiện cập nhật sản phẩm (trừ mã sản phẩm)
        if (indexProductUpdate >= 0) {
            boolean isExit = true;
            do {
                System.out.println("1. Cập nhật tên sản phẩm");
                System.out.println("2. Cập nhật giá sản phẩm");
                System.out.println("3. Cập nhật mô tả sản phẩm");
                System.out.println("4. Cập nhật ngày nhập sản phẩm");
                System.out.println("5. Cập nhật mã danh mục sản phẩm");
                System.out.println("6. Cập nhật trạng thái sản phẩm");
                System.out.println("7. Thoát");
                System.out.print("Lưa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên sản phẩm cần cập nhập:");
                        arrProduct[indexProductUpdate].setProductName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào giá sản phẩm cần cập nhật:");
                        arrProduct[indexProductUpdate].setPrice(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Nhập vào mô tả sản phẩm cần cập nhật:");
                        arrProduct[indexProductUpdate].setDescription(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Nhập vào ngày sản phẩm cần cập nhật:");
//                        arrProduct[indexProductUpdate].setCreated(Date.from(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Nhập vào mã danh mục sản phẩm cần cập nhật:");
                        arrProduct[indexProductUpdate].setCatalogId(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 6:
                        System.out.println("Nhập vào trạng thái sản phẩm cần cập nhật:");
                        arrProduct[indexProductUpdate].setProductStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 7:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 1-7");
                }
            } while (isExit);
        } else {
            System.err.println("Mã sản phẩm không tồn tại");
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.println("Nhập vào mã danh mục cần xóa:");
        String productIdDelete = scanner.nextLine();
        int indexProductDelete = getIndexById(productIdDelete);
        if (indexProductDelete >= 0) {
            for (int i = indexProductDelete; i < indexProduct - 1; i++) {
                arrProduct[i] = arrProduct[i + 1];
            }
            arrProduct[indexProduct - 1] = null;
            indexProduct--;
        } else {
            System.err.println("Mã danh mục không tồn tại");
        }
    }

    public static void searchProductByName(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm cần tìm:");
        String productNameSearch = scanner.nextLine();
        //Tìm gần đúng
        System.out.println("KẾT QUẢ TÌM KIẾM:");
        for (int i = 0; i < indexProduct; i++) {
            if (arrProduct[i].getProductName().toLowerCase().contains(productNameSearch.toLowerCase())) {
                arrProduct[i].displayProductData();
            }
        }
    }

    public static void staticProductByPrice(Scanner scanner) {
        do {
            System.out.println("Nhập vào giá thống kê bắt đầu:");
            float formPrice = Float.parseFloat(scanner.nextLine());
            System.out.println("Nhập vào giá thống kê kết thúc:");
            float toPrice = Float.parseFloat(scanner.nextLine());
            if (formPrice <= toPrice) {
                //Thống kê theo giá bán
                System.out.printf("THÔNG TIN SẢN PHẨM TRONG KHOẢNG GIÁ TỪ %.2f ĐẾN %.2f:\n", formPrice, toPrice);
                for (int i = 0; i < indexProduct; i++) {
                    if (arrProduct[i].getPrice() >= formPrice && arrProduct[i].getPrice() <= toPrice) {
                        arrProduct[i].displayProductData();
                    }
                }

            }
        } while (true);
    }
}
