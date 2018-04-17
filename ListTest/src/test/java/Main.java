import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Class testClass= ListInterfaceTest.class;
        Method[] testMethods=testClass.getDeclaredMethods();

        List<String> linkedList=new LinkedList();
        List<Object> arrayList=new ArrayList();


        for (Method m : testMethods) {

            m.invoke(null, linkedList);
            linkedList.clear();
            m.invoke(null, arrayList);
            arrayList.clear();

        }

        System.out.println(testMethods.length);
    }

}
