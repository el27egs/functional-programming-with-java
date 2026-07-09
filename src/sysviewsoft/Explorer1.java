package sysviewsoft;

import java.util.TreeSet;

public class Explorer1 {
    public static void main(String[] args) {
        TreeSet<Integer> s = new TreeSet<>();
        TreeSet<Integer> subs = new TreeSet<>();
        for (int i = 606; i < 613; i++)
            if (i % 2 == 0) s.add(i);
        subs = (TreeSet)s.subSet(608,true,611,true);
        s.add(609);
        System.out.println(s + " " + subs);
    }
}
//Nuevo83
//Respuesta: B) [606, 608, 609, 610, 612] [608, 609, 610]
