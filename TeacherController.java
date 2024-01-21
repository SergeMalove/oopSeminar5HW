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
        System.out.println("������� ����� ������ �������");
        String name = teacherView.userInput("������� ��� �������: ");
        String surname = teacherView.userInput("������� ������� �������: ");
        int age = Integer.parseInt(teacherView.userInput("������� ������� �������: "));
        String subject = teacherView.userInput("������� �������: ");
        System.out.println();
        return new Teacher(name, surname, age, subject);
    }

    public void run() throws IOException {
        boolean isRun = true;
        while (isRun) {
            System.out.println("""
                    ������� ����:
                    1 - ������� ������ �������� �� �����
                    2 - �������� ������ ������� � ������
                    3 - �������� ������� � ������
                    4 - ������� ������� �� ������
                    5 - ��������� ������ ���������
                    """);

            String userInput = teacherView.userInput("");

            if (!userInput.matches("[1-5]")) {
                System.out.println("�� ���������� ���� ������ ����. ��������� ����.\n");
            } else {
                switch (Integer.parseInt(userInput)) {
                    case 1:
                        teacherView.printTheachers(teacherService.getTeachers());
                        break;
                    case 2:
                        teacherService.addTeacher(createTeacher());
                        break;
                    case 3:
                        int index1 = Integer.parseInt(teacherView.userInput("������� ������ ��� ������: "));
                        teacherService.changeTeacher(index1, createTeacher());
                        break;
                    case 4:
                        int index2 = Integer.parseInt(teacherView.userInput("������� ������ ��� ��������: "));
                        teacherService.removeTeacher(index2);
                        break;
                    case 5:
                        isRun = false;
                }
            }
        }
    }
}
