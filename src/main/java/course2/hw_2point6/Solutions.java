package course2.hw_2point6;

import java.util.*;

public class Solutions {

    public void printOnlyOddNums(List<Integer> numbers) {
        List<Integer> result = new LinkedList<>();

        for (Integer num : numbers) {

            if (num % 2 != 0) {
                result.add(num);
            }
        }
        System.out.println(result);
    }

    public void printEvenNumsOnce(List<Integer> numbers) {
        Set<Integer> result = new TreeSet<>();

        for (Integer num : numbers) {

            if (num % 2 == 0) {
                result.add(num);
            }
        }
        System.out.println(result);
    }

    public void printUniques(List<String> strings) {
        Map<String, Integer> counter = new HashMap<>();
        List<String> result = new LinkedList<>();

        for (String s : strings) {
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {

            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        System.out.println(result);
    }

    public void printAmountOfEachElement(List<String> strings) {
        Map<String, Integer> counter = new HashMap<>();
        List<Integer> result = new LinkedList<>();

        for (String s : strings) {
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }

        for (Integer integer : counter.values()) {
            result.add(integer);
        }
        System.out.println(result);
    }
}
