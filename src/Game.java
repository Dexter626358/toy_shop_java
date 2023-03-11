import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Game {
    public List<Toy> elementWeight(List<Toy> toyList){
        Printfile pf = new Printfile();
        if (toyList.size() > 0){
            ArrayList<Double> weights = new ArrayList<>();
            double sumWeight = 0;
            double count_freaq = 0;
            for (Toy item: toyList) {
                weights.add(item.getFreaquecy());
                sumWeight += item.getFreaquecy();
            }
            Random rnd = new Random();
            int rndNumber = rnd.nextInt(1, (int) sumWeight);

            for (Toy item: toyList) {
                count_freaq += item.getFreaquecy();
                if (count_freaq >= rndNumber){
                    if (item.getQuantity() > 0){
                        System.out.printf("Игрушка: %s, %d, %.2f\n", item.getName(), item.getQuantity(), item.getFreaquecy());
                        item.setQuantity(item.getQuantity() - 1);
                        break;
                    }else{
                        System.out.printf("Игрушка: %s, %d, %.2f", item.getName(), item.getQuantity(), item.getFreaquecy());
                        toyList.remove(item);
                        break;
                    }
                }
            }
        }else{
            System.out.println("Игрушки отсуствуют");
        }

        return toyList;
    }

    public List<Toy> addToy(List<Toy> toys, Toy toy){
        for (Toy item: toys) {
            if (item.getName().equals(toy.getName())){
                item.setQuantity(item.getQuantity() + toy.getQuantity());
                System.out.println("Такая игрушка уже есть");
                return toys;
            }
        }
        toys.add(toy);

        return toys;
    }

}
