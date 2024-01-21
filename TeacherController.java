package oopSeminar5HW;

import java.io.IOException;

public class TeacherController {
    private TeacherService teacherService;
    private TeacherView teacherView;

    public TeacherController(TeacherService teacherService, TeacherView teacherView) {
        this.teacherService = teacherService;
        this.teacherView = teacherView;
    }

    public Teacher createTeacher() throws IOException {
        System.out.println("Создаем новую запись Учитель");
        String name = teacherView.userInput("Введите имя учителя: ");
        String surname = teacherView.userInput("Введите фамилию учителя: ");
        int age = Integer.parseInt(teacherView.userInput("Введите возраст учителя: "));
        String subject = teacherView.userInput("Введите предмет: ");
        System.out.println();
        return new Teacher(name, surname, age, subject);
    }

    public void run() throws IOException {
        boolean isRun = true;
        while (isRun) {
            System.out.println("""
                    Главное меню:
                    1 - Вывести список учителей на экран
                    2 - Добавить нового учителя в список
                    3 - Заменить учителя в списке
                    4 - Удалить учителя из списка
                    5 - Завершить работу программы
                    """);

            String userInput = teacherView.userInput("");

            if (!userInput.matches("[1-5]")) {
                System.out.println("Не правильный ввод пункта меню. Повторите ввод.\n");
            } else {
                switch (Integer.parseInt(userInput)) {
                    case 1:
                        teacherView.printTheachers(teacherService.getTeachers());
                        break;
                    case 2:
                        teacherService.addTeacher(createTeacher());
                        break;
                    case 3:
                        int index1 = Integer.parseInt(teacherView.userInput("Введите индекс для замены: "));
                        teacherService.changeTeacher(index1, createTeacher());
                        break;
                    case 4:
                        int index2 = Integer.parseInt(teacherView.userInput("Введите индекс для удаления: "));
                        teacherService.removeTeacher(index2);
                        break;
                    case 5:
                        isRun = false;
                }
            }
        }
    }
}
