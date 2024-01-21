package oopSeminar5HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class TeacherView {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void printTheachers (List<Teacher> teachers) {
        System.out.println("Список учителей: ");
        for (Teacher teacher: teachers) {
            System.out.println(teacher.toString());
        }
        System.out.println();
    }

    public String userInput (String message) throws IOException {
        System.out.print(message);
        return reader.readLine();
    }
}
