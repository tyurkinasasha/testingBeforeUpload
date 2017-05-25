package Unit2.Task4;

import Unit2.Task3.implementations.StarterKit;
import Unit2.Task3.interfaces.OfficeSupplies;

import java.util.Comparator;

/**
 * Created by TyurkinaAlexandra on 5/23/2017.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        StarterKit sk=new StarterKit();
        System.out.println("hey");
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
