package homework6;


public class task1 {

    public static class Human {
        public int age;
        public Sex sex;
        String name;

        public Human(String name, Sex sex, int age) {
            this.age = age;
            this.sex = sex;
            this.name = name;
        }

        public void DuActiv() {
            System.out.println("A "+ name + " sam Axctiv!");
        }
    }

    enum Sex {
        man,
        woman
    }

    static class Student extends Human {
        int cours;
        int group;

        public Student(String name, Sex sex, int age, int cours, int group) {
            super(name, sex, age);
            this.cours = cours;
            this.group = group;
        }

        @Override
        public void DuActiv() {
            System.out.println("Student name: " + name +
                    ", sex: " + sex +
                    ", age: "+ age +
                    ", is studying in group: " + group +
                    " on cours: " + cours + ".");
        }
    }
    static class UniversityStudents{
        Student[][][] students = new Student[4][5][10];
        public void printUniversityStudents() {
            for (int i = 0; i < students.length; i++) {
                for (int ii = 0; ii < students[i].length; ii++) {
                    for (int iii = 0; iii < students[i][ii].length; iii++) {
                        if (students[i][ii][iii] != null) {
                            students[i][ii][iii].DuActiv();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
       UniversityStudents universitystudents = new UniversityStudents();
       universitystudents.students[1][1][1] = new Student("Toni", Sex.man, 18, 1, 1);
       universitystudents.students[2][1][1] = new Student("Katty", Sex.woman, 28, 2, 1);
       universitystudents.printUniversityStudents();

       }

}
