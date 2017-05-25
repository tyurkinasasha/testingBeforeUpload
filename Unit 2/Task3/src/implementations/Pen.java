package implementations;

import interfaces.CanBeWrittenOn;
import interfaces.CanWrite;

import java.awt.*;

/**
 * Created by TyurkinaAlexandra on 10.05.2017.
 */


public class Pen implements CanWrite{
    private Color color;
    private final String name= "pen";
    private final int price=30;

    @Override
    public void write(CanBeWrittenOn paperType) {
        //implement here
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
