public class Main {

    String name;
    static int num;

    public Main(String rapName) {
        name = rapName;
    }

    public String hello() {
        return "Hello " + name;
    }

    public static int numberAddition() {
        return num += 1;
    }

    public static void main(String[] args) {
        Main youngThug = new Main("Young Thug");
        System.out.println(youngThug.name);
        System.out.println(youngThug.hello());
        numberAddition();
        System.out.println(num);

    }
}
