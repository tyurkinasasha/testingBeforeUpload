
import implementations.StarterKit;
import interfaces.OfficeSupplies;

import java.util.Comparator;

/**
 * Created by TyurkinaAlexandra on 5/23/2017.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        StarterKit sk=new StarterKit();
        Comparator <OfficeSupplies>nameComparator= new Comparator<OfficeSupplies>() {
            @Override
            public int compare(OfficeSupplies o1, OfficeSupplies o2) {
                return 0;
            }
        };
        Comparator <OfficeSupplies>priceComparator= new Comparator<OfficeSupplies>() {
            @Override
            public int compare(OfficeSupplies o1, OfficeSupplies o2) {
                return 0;
            }
        };
        Comparator <OfficeSupplies>priceAndNameComparator= new Comparator<OfficeSupplies>() {
            @Override
            public int compare(OfficeSupplies o1, OfficeSupplies o2) {
                return 0;
            }
        };


    }
}
