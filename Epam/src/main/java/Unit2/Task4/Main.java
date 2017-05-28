package Unit2.Task4;

import Unit2.Task3.implementations.StarterKit;
import Unit2.Task3.interfaces.OfficeSupplies;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by TyurkinaAlexandra on 5/23/2017.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        StarterKit sk=new StarterKit();
        NameComparator nc=new NameComparator();
        PriceComparator pc=new PriceComparator();
        NameAndPriceComparator npc=new NameAndPriceComparator(nc,pc);
        Collections.sort(sk.officeSuppliesList,nc);
        System.out.println();
        Collections.sort(sk.officeSuppliesList,pc);
        OfficeSupplies os[]=sk.officeSuppliesList.toArray(new OfficeSupplies[sk.officeSuppliesList.size()]);
        System.out.println(Arrays.toString(os));
        Arrays.sort(os,nc);
        System.out.println(Arrays.toString(os));
        Arrays.sort(os,pc);
        System.out.println(Arrays.toString(os));


    }
}
