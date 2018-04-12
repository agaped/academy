import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Class testClass= ListInterfaceTest.class;
        Method[] testMethods=testClass.getDeclaredMethods();

        List<Integer> linkedList=new LinkedList<Integer>();
        List<Integer> arrayList=new ArrayList<Integer>();

        for (Method m : testMethods) {

            m.invoke(null, linkedList);
            linkedList.clear();
            m.invoke(null, arrayList);
            arrayList.clear();
        }

    }

}
