package practice.stacks;

/**
 * Created by Tyurkina Alexandra on 5/30/2017.
 */
public class LinkedListStack<E> implements Stack<E> {
    Entry<E> top;
    int size=0;

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "top=" + top +
                '}';
    }

    public  LinkedListStack(){
//        top=new Entry<>();
    }



    @Override
    public void push(E obj) {
        if (top.data == null) {
            top.data = obj;
        } else {
            top.next = top.data;
            top.data=obj;
        }
        size++;

    }

    @Override
    public E pop() {
        E tmp=top.data;
        top.data=top.next;
        size--;
        return tmp;
    }

    @Override
    public int size() {
        return size;
    }

    public static class Entry<E> {
        private E data=null;
        private E next = null;
        public Entry(E data){
            this.data=data;
        }
    }
}
