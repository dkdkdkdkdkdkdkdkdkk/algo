package ru.vega;

import org.junit.Test;
import ru.vega.StringLengthTask;
import ru.vega.Task;
import ru.vega.TicketsTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by dk on 08/05/2020.
 */
public class TaskTest {

    @Test
    public void testStringLengthTask() {
        Task task = new StringLengthTask();
        testTaskByFile(task);
    }

    @Test
    public void testTicketsTask() {
        Task task = new TicketsTask();
        testTaskByFile(task);
    }

    private void testTaskByFile(Task task) {
        getTestCases(task.getClass().getSimpleName()).forEach(file -> {
            String path = file.getAbsolutePath();

            Scanner inScan = getFile(path);
            Scanner outScan = getFile(path.replace(".in", ".out"));

            String in = inScan.nextLine();
            String out = outScan.nextLine();

            String result = task.run(new String[]{in});

            inScan.close();
            outScan.close();

            System.out.println("result: " + result + ", expected: " + out + ", success: " + result.equals(out));
        });
    }

    private Collection<File> getTestCases(String taskName) {
        String path = this.getClass().getClassLoader().getResource(taskName).getFile();
        return Arrays.asList(new File(path).listFiles(pathname -> pathname.getName().endsWith(".in")));
    }

    private Scanner getFile(String path) {
        try {
            return new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
