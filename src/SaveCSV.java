import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SaveCSV {
        public void writeResult(Toy toy){
            File file = new File("Toys.csv");
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(toy.getId() + ";");
                sb.append(toy.getName() + ";");
                sb.append(toy.getQuantity() + ";");
                sb.append(toy.getFreaquecy() + ";");
                FileWriter fr = new FileWriter(file, true);
                fr.write(sb.toString() + "\n");
                fr.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
}
