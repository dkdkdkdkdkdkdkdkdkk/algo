package ru.vega;

/**
 * Created by dk on 08/05/2020.
 */
public class StringLengthTask implements Task {

    @Override
    public String run(String[] params) {
        if (params.length < 1 || params[0] == null) {
            return "0";
        }
        return params[0].length() + "";
    }
}
