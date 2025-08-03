public class Main {

    String name;

    public Main(String rapName) {
        name = rapName;
    }

    public static void main(String[] args) {
        Main youngThug = new Main("Young Thug");
        System.out.println(youngThug.name);

    }
}
