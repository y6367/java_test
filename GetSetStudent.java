public class GetSetStudent {
    private String name;
    private int age;
    private double grade;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String newName) {
        if (newName != null && !newName.isEmpty()) {
            name = newName;
        } else {
            System.out.println("Name cannot be empty.");
        }
    }

    public void setAge(int newAge) {
        if (newAge >= 1) {
            age = newAge;
        } else {
            System.out.println("Age cannot be less than 1.");
        }
    }

    public void setGrade(double newGrade) {
        if (newGrade >= 0) {
            grade = newGrade;
        } else {
            System.out.println("Grade cannot be less than 0.");
        }
    }


    public static void main(String[] args) {
        GetSetStudent s1 = new GetSetStudent();

        s1.setName("John");
        s1.setAge(20);
        s1.setGrade(3.5);
        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        System.out.println(s1.getGrade());
    }
}
