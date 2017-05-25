package Unit2.Task3.implementations;

import Unit2.Task3.interfaces.CanErase;

public class Eraser implements CanErase {
    private int name;

    @Override
    public String toString() {
        return "Eraser{" +
                "name=" + name +
                ", price=" + price +
                '}';
    }

    private final int price = 15;

    @Override

    public void erase() {
        //implement here
    }

    @Override
    public String getName() {
        return "eraser";
    }

    @Override
    public int getPrice() {
        return price;
    }

    private void doSomth() {

    }

}
