package sysviewsoft;

import java.util.*;
public class Mapit {
public static void main(String[] args) {
Set<Integer> set = new HashSet<>();
Integer i1 = 45;
Integer i2 = 46;
set.add(i1);
 set.add(i1);
 set.add(i2); System.out.print(set.size() + " ");
 set.remove(i1); System.out.print(set.size() + " ");
 i2 = 47;
 set.remove(i2); System.out.print(set.size() + " ");
 }
 }
//Nuevo84
//Respuesta: C) 2 1 1
