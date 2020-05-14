package ru.vega;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by dk on 07/05/2020.
 */
public class Main {

    private static final int SIZE = 25;

    private static final Map<String, BiFunction<Integer, Integer, Boolean>> SPELLS = new HashMap<String, BiFunction<Integer, Integer, Boolean>>() {{
        put("1", (i, j) -> j > i);
        put("2", Integer::equals);
        put("3", (i, j) -> j == SIZE - i - 1);
        put("4", (i, j) -> !(i + j > SIZE + 5 - 1));
        put("6", (i, j) -> i < SIZE - 15 || j < SIZE - 15);
        put("7", (i, j) -> i >= SIZE - 9 && j >= SIZE - 9);
        put("8", (i, j) -> i == 0 || j == 0);
        put("20", (i, j) -> (i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0));
        put("22", (i, j) -> (i % 3 == 0 && j % 3 == 0) || ((i - 2) % 3 == 0 && (j - 1) % 3 == 0) || ((i - 1) % 3 == 0 && (j - 2) % 3 == 0));
        put("23", (i, j) -> i % 3 == 0 && j % 2 == 0);
        put("24", (i, j) -> i.equals(j) || j == SIZE - i - 1);
        put("25", (i, j) -> j == 0 || i == 0 || i % (5 + 1) == 0 || j % (5 + 1) == 0);
    }};

    private static String MESSAGE = "Enter one of the numbers ("
            + SPELLS.keySet().stream().map(Integer::parseInt).sorted().map(Objects::toString).collect(Collectors.joining(", "))
            + ") or 'exit'";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String value = null;
        while (value == null || !value.trim().equals("exit")) {
            System.out.println(MESSAGE);
            value = in.nextLine();
            if (SPELLS.containsKey(value)) {
                BiFunction<Integer, Integer, Boolean> spell = SPELLS.get(value);
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (spell.apply(i, j)) {
                            System.out.print("# ");
                        } else {
                            System.out.print(". ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
