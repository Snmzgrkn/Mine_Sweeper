import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Mayın Tarlasına Hoşgeldin!!!");
        System.out.println("--------------------------------");
        int row;
        int column;

        //Kullanıcıdan Matris Boyutlarını alacağız
        //Boyutlar 2x2 den küçük ise Uyarı verip tekrar aldıracağız
        do {
            System.out.println("Lütfen Oynamak İstediğiniz Boyutları giriniz !");

            System.out.println("Satır Sayısı :");
            row = scanner.nextInt();
            System.out.println("Sütun Sayısı :");
            column = scanner.nextInt();

            if (row >=2 && column >= 2){
                MineSweeper mine = new MineSweeper(row,column);
                mine.run();
            }
            else {
                System.out.println("Lütfen 2x2 den büyük matris giriniz!");
            }

        }while (row<2 || column<2);




    }
}
