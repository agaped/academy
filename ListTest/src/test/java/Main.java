import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {

        try {
            MethodCaller.run();
        } catch (InvocationTargetException | IllegalAccessException e) {
            System.out.println(e.getMessage());

        }

    }

}
