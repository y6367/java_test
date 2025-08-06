public class Rapper {

    String name;
    static int num;

    public Rapper(String rapName) {
        name = rapName;
    }

    public String hello() {
        return "Hello " + name;
    }

    public static int numberAddition() {
        return num += 1;
    }

    public static void main(String[] args) {
        Rapper youngThug = new Rapper("Young Thug");
        System.out.println(youngThug.name);
        System.out.println(youngThug.hello());
        numberAddition();
        System.out.println(num);
        numberAddition();
        System.out.println(num);
    }
}
