import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Userinterface {
    final String MENU = "1. Добавить новую игрушку.\n" +
            "2. Загрузить все игрушки.\n" +
            "3. Изменить рейтинг игрушки.\n" +
            "4. Разыграть игрушки.\n" +
            "5. Выход.\n";

    public void menu() throws IOException {
        String name;
        int quantity;
        double freaquency;
        int lineNumber;
        Double newFreaquency;
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("Выбирите действие");
            System.out.println(MENU);
            String user_choose = scan.nextLine();
            if (user_choose.equals("1")){
                System.out.println("Введите данные новой игрушки");
                while (true) {
                    System.out.println("Введете название игрушки: ");
                    name = scan.nextLine();
                    if (Checker.isNotEmpty(name)) {
                        break;
                    } else {
                        System.out.println("Вы ввели пустую строку. Попробуйте сновва.");
                    }
                }
                while(true) {
                    System.out.println("Введите количество игрушек: ");
                    String quant = scan.nextLine();
                    if (Checker.isNumeric(quant)) {
                        quantity = Integer.parseInt(quant);
                        break;
                    } else {
                        System.out.println("Вы ввели не число. Поробуйте снова.");
                    }
                }
                while (true){
                    System.out.println("Введите частоту выпадения игрушки(от 0 до 100 %): ");
                    String freaquecyTemp = scan.nextLine();
                    if (Checker.isReal(freaquecyTemp) && Checker.isCorrectValue(freaquecyTemp)){
                        freaquency = Double.parseDouble(freaquecyTemp);
                        break;
                    }else {
                        System.out.println("Вы ввели не число. Поробуйте снова.");
                    }
                }
                ReadCSV rcvs = new ReadCSV();
                int len = rcvs.readFile().size() + 1;
                Toy toy = new Toy(len, name, quantity, freaquency);
                SaveCSV csv = new SaveCSV();
                csv.writeResult(toy, true);
            } else if (user_choose.equals("2")) {
                ReadCSV rcvs = new ReadCSV();
                Printfile.printFile(rcvs.readFile());
            } else if (user_choose.equals("3")) {
                while (true){
                    System.out.println("Введите номер записи, которую хотите изменить: ");
                    String lineNumb = scan.nextLine();
                    if (Checker.isNumeric(lineNumb)) {
                        lineNumber = Integer.parseInt(lineNumb);
                        break;
                    } else {
                        System.out.println("Вы ввели не число. Поробуйте снова.");
                    }
                }
                while (true){
                    System.out.println("Введите новое значение частоты выпадания игрушки в процентах от 0 до 100: ");
                    String freaquecyTemp1 = scan.nextLine();
                    if (Checker.isReal(freaquecyTemp1) && Checker.isCorrectValue(freaquecyTemp1)){
                        newFreaquency = Double.parseDouble(freaquecyTemp1);
                        break;
                    }else {
                        System.out.println("Вы ввели не число. Поробуйте снова.");
                    }
                }


                ReadCSV rcvs = new ReadCSV();
                List<Toy> changeFreaq = rcvs.readFile();
                changeFreaq.get(lineNumber - 1).setFreaquecy(newFreaquency);
                SaveCSV csv = new SaveCSV();
                csv.writeResult(changeFreaq.get(0), false);
                changeFreaq.remove(0);
                for (Toy item: changeFreaq) {
                    csv.writeResult(item, true);
                }
            } else if (user_choose.equals("4")) {
                System.out.println("4");
                ReadCSV rcvs = new ReadCSV();
                List<Toy> changeFreaq = rcvs.readFile();
                Game game = new Game();
                Toy toy = game.elementWeight(changeFreaq);
                Printfile.printFile(toy);
                changeFreaq.remove(toy);
                SaveCSV csv = new SaveCSV();
                csv.writeResult(changeFreaq.get(0), false);
                changeFreaq.remove(0);
                for (Toy item: changeFreaq) {
                    csv.writeResult(item, true);
                }

            } else if (user_choose.equals("5")) {
                System.out.println("Программа завершила свою работу.");
                break;
            }else {
                System.out.println("Некорректный ввод. Попробуйте еще раз");
            }
        }

    }
}
