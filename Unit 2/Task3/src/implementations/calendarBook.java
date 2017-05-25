package implementations;

import interfaces.CanBeWrittenOn;

/**
 * Created by TyurkinaAlexandra on 10.05.2017.
 */
public class calendarBook implements CanBeWrittenOn {
    private final  String name="calendarBook";
    private final int price = 70;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "calendarBook{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
