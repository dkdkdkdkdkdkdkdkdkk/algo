package ru.vega;

import java.util.Arrays;

/**
 * Created by dk on 08/05/2020.
 */
public class TicketsTask implements Task {

    @Override
    public String run(String[] params) {
        if (params.length < 1 || params[0] == null) {
            return "0";
        }

        int n = Integer.parseInt(params[0]);
        long[] result = new long[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int x = 1; x < n; x++) {
            long[][] digitArrays = new long[10][n * 10];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < 10; j++) {
                    if (result[i] != 0) {
                        digitArrays[j][i + j] = result[i];
                    }
                }
            }
            result = new long[digitArrays[9].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < 10; j++) {
                    result[i] += digitArrays[j][i];
                }
            }
        }

        return Arrays.stream(result).map(y -> y * y).reduce(0, Long::sum) + "";
    }
}
