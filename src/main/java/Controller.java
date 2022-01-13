import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Service service;
    ArrayList<Movie> movies;
    Scanner sc;

    public Controller() {
        service = new Service();
        movies = service.getAllMovie();
        sc = new Scanner(System.in);
    }

    public void mainMenu() {
        boolean isContinue = true;
        while (isContinue) {
            menu();
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    service.show(movies);
                    break;
                case 2:
                    System.out.println("Sap xep theo nam xuat ban");
                    service.sortYear(movies);
                    break;

                case 3:
                    System.out.println("Sap xep theo ten");
                    service.sortName(movies);
                    break;

                case 4:
                    System.out.println("Nhap ten phim can tim:");
                    Scanner sc = new Scanner(System.in);
                    String tittle = sc.nextLine();
                    service.searchName(movies, tittle);
                    break;
                case 5:
                    System.out.println("3 phim co luot xem cao nhat:");
                    service.index(movies);
                    break;

                case 6:
                    System.out.println("Nhap the loai phim muon tim:");
                    sc = new Scanner(System.in);
                    String category = sc.nextLine();
                    service.searchCategory(movies, category);
                    break;

                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
            }
        }
    }

    public static void menu() {
        System.out.println("Bạn có thể thực hiện: ");
        System.out.println("1 - Xem toan bo phim");
        System.out.println("2 - Sắp xếp phim theo năm xuất bản");
        System.out.println("3 - Sắp xếp phim theo tên");
        System.out.println("4 - Tìm phim theo tên");
        System.out.println("5 - Lấy ra 3 phim có lượt xem cao nhất");
        System.out.println("6 - Tìm phim theo thể loại");
        System.out.println("0 - Thoát chương trình");
    }

}
