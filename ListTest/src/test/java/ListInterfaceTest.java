import java.util.Arrays;
import java.util.List;

public class ListInterfaceTest {

    public static void addElementToList(List list) {
        //given
        Object object = new Object();
        //when
        list.add(object);

        //then
        assert list.size() == 1 : "element not added";
    }

    public static void addNullToList(List list) {
        //given

        //when
        list.add(null);

        //then
        assert list.size() == 1 : "more than one element on the list";
    }

    //-----------------------------------------------------
    public static void addElementToFirstIndex(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        list.add(object);

        //when
        list.add(0, object1);

        //then
        assert list.get(0).equals(object1) : "element not added to the position 0";
    }

    public static void addElementToNegativeIndex(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        list.add(object);
        list.add(object1);

        //when
        boolean flag = false;
        try {
            list.add(-1, object);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }

        //then
        assert flag : "element added to the negative position";
    }

    public static void addElementToIndexInTheMiddle(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        list.add(object);
        list.add(object1);

        //when
        list.add(2, object2);

        //then
        assert list.get(2).equals(object2) : "element not added to the specified position";
    }

    //-------------------------------------------------------
    public static void addNewCollectionAtTheEndOfEmptyList(List list) {
        //given
        List secondList = list;

        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        secondList.add(object);
        secondList.add(object1);
        secondList.add(object2);

        //when
        list.addAll(secondList);

        //then
        assert list.equals(secondList) : "list not added";
    }

    public static void addNewCollectionAtTheEnd(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1);

        list.add(object2);

        //when
        list.addAll(secondList);

        //then
        assert list.size() == 3 : "list not added";
    }

    //---------------------------------------------------------
    public static void addNewCollectionAtTheBeginning(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        List secondList = Arrays.asList(object, object1);

        list.add(object);
        list.add(object1);

        //when
        list.addAll(0, secondList);

        //then
        assert list.size() == 4 : "list not added at the begining";
        assert list.get(0) == secondList.get(0) : "list not added ate the begining";

    }

    public static void addNewCollectionAtMissingIndex(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        List secondList = Arrays.asList(object, object1);

        list.add(object);
        list.add(object1);

        //when
        boolean flag = false;
        try {
            list.addAll(5, secondList);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }

        //then
        assert flag : "list added at missing index";

    }

    public static void addNewCollectionAtNegativeIndex(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        List secondList = Arrays.asList(object, object1);

        list.add(object);
        list.add(object1);

        //when
        boolean flag = false;
        try {
            list.addAll(-1, secondList);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }

        //then
        assert flag : "list added at negative index";

    }


    //---------------------------------------------------------
    public static void clearEmptyList(List list) {
        //given
        List secondList = list;

        //when
        list.clear();

        //then
        assert list.size() == 0 : "list not cleared";
    }

    public static void clearNotEmptyList(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        List secondList = Arrays.asList(object, object1);
        //when
        list.add(object);
        list.add(object1);
        list.clear();

        //then
        assert list.size() == 0 : "list not cleared";
    }

    //--------------------------------------------------
    public static void emptyListContainsAnyElement(List list) {
        //given
        Object object = new Object();

        //when and then

        assert list.contains(object) == false : "empty list is not empty";
    }


    public static void listContainsExistingElement(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        //when
        list.add(object);
        list.add(object1);

        //then
        assert list.contains(object1) : "existing element not on the list";
    }

    public static void listContainsMissingElement(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        //when
        list.add(object);
        list.add(object1);

        //then
        assert list.contains(object2) == false : "missing element on the list";
    }

    //----------------------------------------------------
    public static void emptyListContainsCollection(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1, object2);

        //when
        boolean result = list.containsAll(secondList);

        // then
        assert result == false : "emptyList contains list with elements";
    }

    public static void listContainsCollection(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object);

        list.add(object);
        list.add(object1);
        list.add(object2);

        //when
        boolean result = list.containsAll(secondList);

        //then
        assert result == true : "firstList does not contain secondList";
    }

    public static void listContainsEmptyCollection(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = list;

        list.add(object);
        list.add(object1);
        list.add(object2);

        //when
        boolean result = list.containsAll(secondList);

        //then
        assert result : "firstList does not contain empty list";
    }

    //--------------------------------------------------
    public static void checkEqualityOfReferences(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = list;

        list.add(object);
        list.add(object1);
        list.add(object2);
        //when
        boolean result = list.equals(secondList);

        //then
        assert result : "references are not the same";
    }

    public static void checkEqualityOfValues(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1, object2);
        list = Arrays.asList(object, object1, object2);

        //when
        boolean result = list.equals(secondList);

        //then
        assert result : "lists have different values";
    }

    public static void checkEqualityOfDiffrentLists(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1);

        list.add(object);
        list.add(object1);
        list.add(object2);
        //when
        boolean result = list.equals(secondList);

        //then
        assert result == false : "list are equal";
    }

    //--------------------------------------------------
    public static void checkHashcodeOnEqualLists(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();


        List secondList = Arrays.asList(object, object1);

        list.add(object);
        list.add(object1);
        //when
        int hashcode1 = list.hashCode();
        int hashcode2 = secondList.hashCode();

        //then
        assert hashcode1 == hashcode2 : "hashcodes are diffrent";
    }

    public static void checkHashcodeOnNotEqualsLists(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        List secondList = Arrays.asList(object, object1);

        list.add(object);
        list.add(object);
        //when
        int hashcode1 = list.hashCode();
        int hashcode2 = secondList.hashCode();

        //then
        assert hashcode1 != hashcode2 : "hashcodes are the same";
    }

    //-----------------------------------------------------
    public static void isEmptyListEmpty(List list) {
        //given

        //when

        //then
        assert list.isEmpty() : "list is not empty";
    }

    public static void isNotEmptyListEmpty(List list) {
        //given
        Object object = new Object();
        list.add(object);

        //when

        //then
        assert list.isEmpty() == false : "list is empty";
    }

    //----------------------------------------------------------
    public static void returnIndexOfMissingElement(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        list.add(object);

        //when
        boolean flag = false;
        try {
            list.get(4);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }
        //then
        assert flag : "list contains missing element";
    }

    public static void returnIndexOfExistingElement(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        list.add(object);
        list.add(object1);

        //when
        Object result = list.get(0);

        //then
        assert result.equals(object) : "list does not contain existing element";
    }

    //----------------------------------------------------------
    public static void returnLastIndexOfElementInEmptyList(List list) {
        //given
        Object object = new Object();

        //when
        Object result = list.lastIndexOf(object);

        //then
        assert result.equals(-1) : "should return -1";
    }

    public static void returnLastIndexOfExistingElement(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        list.add(object);
        list.add(object1);
        list.add(object2);
        list.add(object2);
        //when
        Object result = list.lastIndexOf(object2);

        //then
        assert result.equals(3) : "does not return last index of the element";
    }

    //----------------------------------------------------------
    public static void removeElementFromEmptyList(List list) {
        //given
        Object object = new Object();

        //when
        boolean flag= list.remove(object);

        //then
        assert flag==false : "removes element not from the list";
    }

    public static void removeExistingElement(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        list.add(object);
        list.add(object1);

        //when
        boolean result = list.remove(object);

        //then
        assert result : "element not removed";
    }

    public static void checkIfElementsAreShiftedTotheLeft(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        list.add(object);
        list.add(object1);
        list.add(object2);

        //when
        list.remove(object);

        //then
        assert list.get(0).equals(object1) : "element not shifted to the left";
        assert list.get(1).equals(object2) : "element not shifted to the left";
    }

    //---------------------------------------------------------------

}
