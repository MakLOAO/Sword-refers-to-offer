import java.util.*;

public class test {

/**
 * @program: offer
 *
 * @description:
 *
 * @author: makaloo
 *
 * @create: 2019-04-14 21:10
 **/
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
//        ListIterator<Integer> listIterator = list.listIterator(); // | 0 1 2
//        listIterator.next(); // 0 | 1 2
//        listIterator.add(3); // 0 3 | 1 2
//        listIterator.add(4); // 0 3 4 | 1 2
//        listIterator.next(); // 0 3 4 1 | 2
//        listIterator.remove(); // 0 3 4 | 2
//        listIterator.previous(); // 0 3 | 4 2
//        listIterator.remove(); // 0 3 | 2
        Iterator<Integer> iterator = list.iterator();
        iterator.forEachRemaining(element -> System.out.print(element + " "));
    }
}
