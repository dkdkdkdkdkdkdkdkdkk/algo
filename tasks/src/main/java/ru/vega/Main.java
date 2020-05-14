package ru.vega;

/**
 * Created by dk on 08/05/2020.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Task task = (Task) Class.forName("ru.vega." + args[0]).newInstance();
        String[] params = new String[args.length - 1];
        System.arraycopy(args, 1, params, 0, args.length - 1);
        System.out.println(task.run(params));
    }
}
