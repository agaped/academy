import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MethodCaller {

    public static void run() throws IllegalAccessException, InvocationTargetException {
        Class testClass = ListInterfaceTest.class;
        Method[] testMethods = testClass.getDeclaredMethods();

        List<Integer> linkedList = new LinkedList();
        List<Object> arrayList = new ArrayList();


        for (Method m : testMethods) {

            m.invoke(null, linkedList);
            linkedList.clear();
            m.invoke(null, arrayList);
            arrayList.clear();

        }
    }

}
