import java.io.IOException;
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
                csv.writeResult(toy);
            } else if (user_choose.equals("2")) {
                ReadCSV rcvs = new ReadCSV();
                Printfile.printFile(rcvs.readFile());
            } else if (user_choose.equals("3")) {
                System.out.println("3");
            } else if (user_choose.equals("4")) {
                System.out.println("4");
            } else if (user_choose.equals("5")) {
                System.out.println("Программа завершила свою работу.");
                break;
            }else {
                System.out.println("Некорректный ввод. Попробуйте еще раз");
            }
        }

    }
}
