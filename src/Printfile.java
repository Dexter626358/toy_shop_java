import java.util.List;

public class Printfile {
    public static void printFile(List<Toy> toyList){
        for (Toy item: toyList) {
            System.out.print(String.format("%s. ", item.getId()));
            System.out.print(String.format("%s, ", item.getName()));
            System.out.print(String.format("%s, ", item.getQuantity()));
            System.out.println(String.format("%s ", item.getFreaquecy()));
        }
    }
}
