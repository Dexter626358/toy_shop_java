import java.util.Scanner;

public class Toy {

    private int id;
    private String name;
    private int quantity;
    private double freaquency;
    Scanner scan = new Scanner(System.in);

    public Toy(int id, String name, int quantity, double freaquency){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.freaquency = freaquency;
    }

    public int getId() {
        return id;
    }

    public double getFreaquecy() {
        return freaquency;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setFreaquecy(double freaquency) {
        this.freaquency = freaquency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
