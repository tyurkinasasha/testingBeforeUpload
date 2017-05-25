package implementations;

import interfaces.CanBeWrittenOn;
import interfaces.CanWrite;

import java.awt.*;

/**
 * Created by TyurkinaAlexandra on 10.05.2017.
 */
public class Pencil implements CanWrite {
    private Color color;
    private final String name = "pencil";
    private final int price = 25;

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

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {

        return color;
    }

    @Override
    public String toString() {
        return "Pencil{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
