package Unit2.Task4;
import Unit2.Task3.interfaces.OfficeSupplies;

import java.util.Comparator;

/**
 * Created by TyurkinaAlexandra on 5/24/2017.
 */
public class NameComparator implements Comparator<OfficeSupplies> {
    @Override
    public int compare(OfficeSupplies o1, OfficeSupplies o2) {
        int res = o1.getName().compareTo(o2.getName());
        if (res == 0) {
            res = Integer.compare(o1.getPrice(),o2.getPrice());
        }
        System.out.println("hey");
        return res;
    }
}
