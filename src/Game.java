import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Game {
    public Toy elementWeight(List<Toy> toyList){
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
                    return item;

                }
            }
        }else{
            System.out.println("Игрушки отсуствуют");
        }

        return null;
    }
}
