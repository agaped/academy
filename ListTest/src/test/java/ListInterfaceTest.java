import java.util.Arrays;
import java.util.List;

public class ListInterfaceTest {

    public static void addElementToList(List list) {
        //given

        //when
        list.add(3);

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
        list.add(4);
        list.add(6);

        //when
        list.add(0, 5);

        //then
        assert list.get(0).equals(5) : "element not added to the position 0";
    }

    public static void addElementToNegativeIndex(List list) {
        //given
        list.add(4);
        list.add(6);

        //when
        try {
            list.add(-1, 5);
        } catch (IndexOutOfBoundsException e) {

        }

        //then
        assert list.size() == 2 : "element added to the position -1";
    }

    public static void addElementToIndexInTheMiddle(List list) {
        //given
        list.add(4);
        list.add(6);

        //when
        list.add(2, 5);

        //then
        assert list.get(2).equals(5) : "element not added to the specified position";
    }

    //-------------------------------------------------------
    public static void addNewCollectionAtTheEndOfEmptyList(List list) {
        //given
        List secondList = list;

        secondList.add(2);
        secondList.add(3);
        secondList.add(4);

        //when
        list.addAll(secondList);

        //then
        assert list.equals(secondList) : "list not added";
    }

    public static void addNewCollectionAtTheEnd(List list) {
        //given
        List secondList = Arrays.asList(2, 3, 4);

        list.add(7);

        //when
        list.addAll(secondList);

        //then
        assert list.size() == 4 : "list not added";
    }

    //---------------------------------------------------------
    public static void addNewCollectionAtTheBeginning(List list) {
        //given
        List secondList = Arrays.asList(5, 6);

        list.add(3);
        list.add(4);

        //when
        list.addAll(0, secondList);

        //then
        assert list.size() == 4 : "list not added at the begining";
        assert list.get(0) == secondList.get(0) : "list not added ate the begining";

    }

    public static void addNewCollectionAtMissingIndex(List list) {
        //given
        List secondList = Arrays.asList(5, 6);

        list.add(3);
        list.add(4);

        //when
        try {
            list.addAll(5, secondList);
        } catch (IndexOutOfBoundsException e) {

        }

        //then
        assert list.size() == 2 : "list added at missing index";

    }

    public static void addNewCollectionAtNegativeIndex(List list) {
        //given
        List secondList = Arrays.asList(5, 6);

        list.add(3);
        list.add(4);

        //when
        try {
            list.addAll(-1, secondList);
        } catch (IndexOutOfBoundsException e) {

        }

        //then
        assert list.size() == 2 : "list added at negative index";

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
        List secondList = list;

        //when
        list.add(3);
        list.add(4);
        list.clear();

        //then
        assert list.size() == 0 : "list not cleared";
    }

    //--------------------------------------------------
    public static void emptyListContainsAnyElement(List list) {
        //given
        List secondList = list;

        //when and then

        assert list.contains(3) == false : "empty list is not empty";
    }


    public static void listContainsExistingElement(List list) {
        //given
        List secondList = list;

        //when
        list.add(1);
        list.add(3);

        //then
        assert list.contains(3) : "existing element not on the list";
    }

    public static void listContainsMissingElement(List list) {
        //given
        List secondlist = list;

        //when
        list.add(1);
        list.add(3);

        //then
        assert list.contains(2) == false : "missing element on the list";
    }

    //----------------------------------------------------
    public static void emptyListContainsCollection(List list) {
        //given
        List secondList = Arrays.asList(2, 3, 6);

        //when
        boolean result = list.containsAll(secondList);

        // then
        assert result == false : "emptyList contains list with elements";
    }

    public static void listContainsCollection(List list) {
        //given
        List secondList = Arrays.asList(5);

        list.add(3);
        list.add(5);
        list.add(7);

        //when
        boolean result = list.containsAll(secondList);

        //then
        assert result == true : "firstList does not contain secondList";
    }

    public static void listContainsEmptyCollection(List list) {
        //given
        List secondList = list;

        list.add(4);
        list.add(5);
        list.add(6);

        //when
        boolean result = list.containsAll(secondList);

        //then
        assert result : "firstList does not contain empty list";
    }

    //--------------------------------------------------
    public static void checkEqualityOfReferences(List list) {
        //given
        List secondList = list;

        list.add(4);
        list.add(5);
        list.add(6);
        //when
        boolean result = list.equals(secondList);

        //then
        assert result : "references are not the same";
    }

    public static void checkEqualityOfValues(List list) {
        //given
        List secondList = Arrays.asList(4, 5, 6);

        list.add(4);
        list.add(5);
        list.add(6);
        //when
        boolean result = list.equals(secondList);

        //then
        assert result : "lists have different values";
    }

    public static void checkEqualityOfDiffrentLists(List list) {
        //given
        List secondList = Arrays.asList(2, 1);

        list.add(4);
        list.add(5);
        list.add(6);
        //when
        boolean result = list.equals(secondList);

        //then
        assert result == false : "list are equal";
    }

    //--------------------------------------------------
    public static void checkHashcodeOnEqualLists(List list) {
        //given
        List secondList = Arrays.asList(2, 1);

        list.add(2);
        list.add(1);
        //when
        int hashcode1 = list.hashCode();
        int hashcode2 = secondList.hashCode();

        //then
        assert hashcode1 == hashcode2 : "hashcodes are diffrent";
    }

    public static void checkHashcodeOnNotEqualsLists(List list) {
        //given
        List secondList = Arrays.asList(1, 2);

        list.add(2);
        list.add(1);
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
        list.add(2);

        //when

        //then
        assert list.isEmpty() == false : "list is empty";
    }

    //----------------------------------------------------------
    public static void returnIndexOfMissingElement(List list) {
        //given
        list.add(2);
        Object result = -1;
        //when
        try {
            result = list.get(4);
        } catch (IndexOutOfBoundsException e) {

        }
        //then
        assert result.equals(-1) : "list contains missing element";
    }

    public static void returnIndexOfExistingElement(List list) {
        //given
        list.add(2);
        list.add(1);

        //when
        Object result = list.get(0);

        //then
        assert result.equals(2) : "list does not contain existing element";
    }

    //----------------------------------------------------------
    public static void returnLastIndexOfElementInEmptyList(List list) {
        //given

        //when
        Object result = list.lastIndexOf(2);

        //then
        assert result.equals(-1) : "should return -1";
    }

    public static void returnLastIndexOfExistingElement(List list) {
        //given
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(3);
        //when
        Object result = list.lastIndexOf(3);

        //then
        assert result.equals(3) : "does not return last index of the element";
    }

    //----------------------------------------------------------
    public static void removeElementFromEmptyList(List list) {
        //given

        //when
        try {
            list.remove(3);
        } catch (IndexOutOfBoundsException e) {

        }
        //then
        assert list.isEmpty() : "does not throw exception";
    }

    public static void removeExistingElement(List list) {
        //given
        list.add(1);
        list.add(3);

        //when
        Object result = list.remove(0);

        //then
        assert result.equals(1) : "element not removed";
    }

    public static void checkIfElementsAreShiftedTotheLeft(List list) {
        //given
        list.add(1);
        list.add(3);
        list.add(4);

        //when
        list.remove(0);

        //then
        assert list.get(0).equals(3) : "element not shifted to the left";
        assert list.get(1).equals(4) : "element not shifted to the left";
    }

    //---------------------------------------------------------------

}
