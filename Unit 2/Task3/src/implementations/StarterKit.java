package implementations;

import interfaces.OfficeSupplies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TyurkinaAlexandra on 10.05.2017.
 */


public class StarterKit implements Comparable{
    private final int count=5;
    public List<OfficeSupplies> officeSuppliesList=new ArrayList<>();
    public StarterKit() throws InstantiationException, IllegalAccessException {
        addSuppliesToList(Pen.class,count);
        addSuppliesToList(Eraser.class,count);
        addSuppliesToList(Pencil.class,count);
        addSuppliesToList(calendarBook.class,count);
        addSuppliesToList(PencilWithEraser.class,count);
        addSuppliesToList(Copybook.class,count);

    }
    private void addSuppliesToList(Class <? extends OfficeSupplies> c, int count) throws IllegalAccessException, InstantiationException {
        for (int i=0;i<count;i++){
            officeSuppliesList.add(c.newInstance());
        }
    }

    @Override
    public String toString() {
        return "StarterKit{" +
                "officeSuppliesList=" + officeSuppliesList +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
