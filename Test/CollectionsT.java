package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * CollectionsT
 */
public class CollectionsT {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        hashSet.add(1);
        linkedHashSet.add(1);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        hashMap.put(1, null);
    }
}