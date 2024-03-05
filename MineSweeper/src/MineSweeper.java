import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    int rowNumber;      // Oyun tahtasının satır sayısı
    int columnNumber;   // Oyun tahtasının sütun sayısı
    int size;           // Oyun tahtasının toplam hücre sayısı
    String[][] map;        // Mayınların konumlarını tutan matris
    String[][] board;      // Kullanıcıya gösterilen oyun tahtası

    boolean game =true;     // Oyunun devam edip etmediğini kontrol eden boolean değeri

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    //MineSweeper sınıfının constructor'ı
    MineSweeper(int rowNumber,int columnNumber){
        this.rowNumber=rowNumber;
        this.columnNumber=columnNumber;
        this.map = new  String[rowNumber][columnNumber];
        this.board=new String[rowNumber][columnNumber];
        this.size=rowNumber*columnNumber;  //Oyun tahtasının toplam hücre sayısı
    }

    // Oyunun başladığı ana metot
    void run(){
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                board[i][j] = "-";
            }
        }
        int row;
        int column;
        int success = 0;
        prepareGame(); // Oyun tahtasını hazırla
        print(map);    // Mayınların yerini göster

        System.out.println("Oyun Başladı !");

        //Kullanıcı eğer mayına basarsa Oyun bitecek, basmaz ise devam edecek
        while (game){
            print(board); // Tahtayı yazdır
            System.out.print("Satır : ");
            row = scanner.nextInt();
            System.out.print("Sütun : ");
            column = scanner.nextInt();
            System.out.println("=========================");
            if(row < 0 || row >= rowNumber || column < 0 || column >= columnNumber){
                System.out.println("Geçersiz koordinat girdiniz!!!");
                continue;
            }

            if (!board[row][column].equals("-")) {
                System.out.println("Bu koordinatları zaten seçtiniz, lütfen başka bir koordinat girin!");
                continue;
            }

            if(!map[row][column].equals("*")){
                checkMine(row,column);
                success++;
                if(success == (size - (size/4))){
                    System.out.println("Oyunu Kazandınız!!!");
                    game=false;

                }
            }
            else { //Kullanıcının seçtiği yerde mayın var ise
                game=false;
                System.out.println("Oyun Bitti, Kaybettin!");
            }
        }
    }

    // Oyun tahtasını mayınlarla dolduran metot
    void prepareGame(){
        int randomRow;
        int randomColumn;
        int count =0;

        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                map[i][j] = "-";
            }
        }
        
        while (count!= (size/4)) {
            randomRow=random.nextInt(rowNumber); //Row sayısı kadar rastgele sayı tutucak
            randomColumn=random.nextInt(columnNumber); //Column Sayısı kadar rastgele sayı tutacak
            if(!map[randomRow][randomColumn].equals("*")){
                map[randomRow][randomColumn] = "*";
                count++; // Eğer random ürettiği yer aynı çıkarsa çakışmayı önlemek için
            }


        }
    }

    // Oyun tahtasını ekrana yazdıran metot
    void print(String[][] array){
        //Çok boyutlu arrayi yazdırma
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j].equals("-")) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" " + array[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    //Hücrede mayın olup olmadığını kontrol eder
    //Eğer hücrede mayın yok ise,etrafındaki komşu hücrelerdeki (8 Komşudada) mayın sayısını hesaplar ve o hücreye yazar
    void checkMine(int row, int column) {
        if (!map[row][column].equals("*")) {
            int mineCount = countAdjacentMines(row, column);
            board[row][column] = String.valueOf(mineCount);
        }
    }

    // Hücrenin etrafındaki komşu hücrelerdeki mayın sayısını hesaplar
    int countAdjacentMines(int row, int column) {
        int mineCount = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < rowNumber && j >= 0 && j < columnNumber && map[i][j].equals("*")) {
                    mineCount++;
                }
            }
        }
        return mineCount;
    }

}