import java.util.*;

public class ListInterfaceTest {

    public static void add_addsElementToList(List list) {
        //given
        Object object = new Object();
        //when
        list.add(object);

        //then
        assert list.get(list.size() - 1) == object : "element not added";
    }

    public static void add_addsNullToList(List list) {
        //given

        //when
        list.add(null);

        //then
        assert list.get(list.size() - 1) == null : "more than one element on the list";
    }

    //-----------------------------------------------------
    public static void add_addsElementToTheFirstIndex(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        list.add(object);

        //when
        list.add(0, object1);

        //then
        assert list.get(0).equals(object1) : "element not added to the position 0";
    }

    public static void add_addsElementToTheNegativeIndex(List list) {
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

    public static void add_addsElementToTheIndexInTheMiddle(List list) {
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
    public static void addAll_addsNewCollectionAtTheEndOfEmptyList(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1, object2);
        list.clear();

        //when
        list.addAll(secondList);

        //then
        assert list.equals(secondList) : "list not added";
    }

    public static void addAll_addsNewCollectionAtTheEndOfNotEmptyList(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1);

        list.add(object2);

        //when
        list.addAll(secondList);

        //then
        assert list.get(list.size() - 1) == object1 : "list not added";
    }

    public static void addAll_CheckIfThrowsUnsopportedOperationException(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        List testList = Arrays.asList(object, object1);

        list.add(object);

        //when
        boolean flag = false;
        try {
            testList.addAll(list);
        } catch (UnsupportedOperationException e) {
            flag = true;
        }

        //then
        assert flag : "does not throw UnsupportedOperationException";

    }

    public static void addAll_CheckIfThrowsClassCastException(List list) {
        //given
        List StringList = Collections.checkedList(Arrays.asList("A", "B"), String.class);
        List IntegerList = Arrays.asList(1, 2, 3);

        //when
        boolean flag = false;
        try {
            StringList.addAll(IntegerList);
        } catch (ClassCastException e) {
            flag = true;
        }

        //then
        assert flag : "checked list view does not throw ClassCastException";

    }

    public static void addAllCheckIfThrowsUnsopportedOperationException(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        List testList = Arrays.asList(object, object1);

        list.add(object);

        //when
        boolean flag = false;
        try {
            testList.addAll(list);
        } catch (UnsupportedOperationException e) {
            flag = true;
        }

        //then
        assert flag : "does not throw UnsupportedOperationException";

    }

    //---------------------------------------------------------
    public static void addAll_addsNewCollectionAtTheBeginning(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        List secondList = Arrays.asList(object, object1);

        list.add(object);
        list.add(object1);

        //when
        list.addAll(0, secondList);

        //then
        assert list.get(0) == secondList.get(0) : "list not added ate the begining";

    }

    public static void addAll_addsNewCollectionAtMissingIndex(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        List secondList = Arrays.asList(object, object1);

        list.add(object);
        list.add(object1);

        //when
        boolean flag = false;
        try {
            list.addAll(list.size() + 1, secondList);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }

        //then
        assert flag : "list added at missing index";

    }

    public static void addAll_addsNewCollectionAtNegativeIndex(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        List secondList = Arrays.asList(object, object1);

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
    public static void clear_clearsEmptyList(List list) {
        //given
        List secondList = Collections.emptyList();

        //when
        secondList.clear();

        //then
        assert secondList.size() == 0 : "list not cleared";
    }

    public static void clear_clearsNotEmptyList(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        list.add(object);
        list.add(object1);

        //when
        list.clear();

        //then
        assert list.size() == 0 : "list not cleared";
    }

    //--------------------------------------------------
    public static void contains_checkIfEmptyListContainsAnyElement(List list) {
        //given
        List secondList = Collections.emptyList();

        //when and then

        assert list.size() == 0 : "empty list is not empty";
    }


    public static void contains_checkIfListContainsAddedElement(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        //when
        list.add(object);
        list.add(object1);

        //then
        assert list.contains(object1) : "existing element not on the list";
    }

    public static void contains_checkIfListContainsMissingElement(List list) {
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
    public static void containsAll_checkIfEmptyListContainsCollection(List list) {
        //given
        list.clear();

        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1, object2);

        //when
        boolean result = list.containsAll(secondList);

        // then
        assert result == false : "emptyList contains list with elements";
    }

    public static void containsAll_checkIfListContainsCollection(List list) {
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

    public static void containsAll_checkIfListContainsEmptyCollection(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Collections.emptyList();

        list.add(object);
        list.add(object1);
        list.add(object2);

        //when
        boolean result = list.containsAll(secondList);

        //then
        assert result : "firstList does not contain empty list";
    }

    //--------------------------------------------------
    public static void equals_checkEqualityOfReferences(List list) {
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
        assert result : "list references are not the same";
    }

    public static void equals_checkEqualityOfValues(List list) {
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

    public static void equals_checkEqualityOfDiffrentLists(List list) {
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
        assert result == false : "lists are equal";
    }

    //--------------------------------------------------
    public static void hashode_checkHashcodeOnEqualLists(List list) {
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

    public static void hashcode_checkHashcodeOnNotEqualsLists(List list) {
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
    public static void isEmpty_checkIfEmptyListEmpty(List list) {
        //given
        list.clear();

        //when and then

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
    public static void get_returnIndexOfMissingElement(List list) {
        //given
        Object object = new Object();

        list.add(object);

        //when
        boolean flag = false;
        try {
            list.get(list.size());
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }
        //then
        assert flag : "list contains missing element";
    }

    public static void get_returnIndexOfExistingElement(List list) {
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
    public static void iterator_checkInstanceOfIterator(List list) {
        //given
        Iterator<Object> iterator = list.iterator();

        //when and then

        assert iterator instanceof Iterator : "wrong type of iterator";
    }

    //----------------------------------------------------------
    public static void listIterator_checkInstanceOfListIterator(List list) {
        //given
        Iterator<Object> listIterator = list.iterator();

        //when

        //then
        assert listIterator instanceof Iterator : "wrong type of iterator";
    }

    //----------------------------------------------------------

    public static void lastIndexOf_returnLastIndexOfElementInEmptyList(List list) {
        //given
        Object object = new Object();

        //when
        Object result = list.lastIndexOf(object);

        //then
        assert result.equals(-1) : "should return -1";
    }

    public static void lastIndexOf_returnLastIndexOfExistingElement(List list) {
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
    public static void remove_removesElementFromEmptyList(List list) {
        //given
        Object object = new Object();

        //when
        boolean flag = list.remove(object);

        //then
        assert flag == false : "removes element not from the list";
    }

    public static void remove_removesExistingElement(List list) {
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

    public static void remove_checksIfElementsAreShiftedTotheLeft(List list) {
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

    public static void remove_removesNegativeIndex(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        list.add(object);
        list.add(object1);
        list.add(object2);

        //when
        boolean flag = false;
        try {
            list.remove(-2);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }
        //then
        assert flag : "removes negative index";
    }

    public static void remove_removesExistingIndex(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        list.add(object);
        list.add(object1);
        list.add(object2);
        //when

        Object result = list.remove(1);

        //then
        assert result.equals(object1) : "removes wrong index";
    }

    public static void remove_removesIndexFromEmptyList(List list) {
        //given

        //when
        boolean flag = false;
        try {
            list.remove(5);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }
        //then
        assert flag : "removes not existing index";
    }

    //---------------------------------------------------------------
    public static void removeAll_removeAnotherListFromEmptyList(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1, object2);

        //when
        boolean result = list.removeAll(secondList);

        //then
        assert result == false : "removes elements from empty list";
    }

    public static void removeAll_removesAnotherListFromExistingList(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1, object2);

        list.add(object);

        //when
        boolean result = list.removeAll(secondList);

        //then
        assert result : "elements not removed";
    }

    public static void removeAll_removeListWithDiffrentElements(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1);

        list.add(object2);

        //when
        boolean result = list.removeAll(secondList);

        //then
        assert result == false : "elements removed";

    }

//---------------------------------------------------------------

    public static void retainAll_retainsCommonElements(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1);

        list.add(object);
        list.add(object1);
        list.add(object2);

        //when
        boolean result = list.retainAll(secondList);

        //then
        assert result : "elements not removed";
    }

    public static void retainAll_checkRetainAllOnNotEqualList(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        List secondList = Arrays.asList(object, object1, object2);


        //when
        boolean result = list.retainAll(secondList);

        //then
        assert result == false : "elements removed";
    }

    //---------------------------------------------------------------
    public static void set_setsElementInTheList(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        list.add(object);
        list.add(object1);

        //when
        list.set(0, object2);

        //then
        assert list.get(0).equals(object2) : "element not set";
    }

    public static void set_setsElementOnNegativeIndex(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        list.add(object);
        list.add(object1);

        //when
        boolean flag = false;
        try {
            list.set(-3, object2);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }
        //then
        assert flag : "element not set on negative index";
    }

    public static void set_setsNullElement(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        list.add(object);
        list.add(object1);

        //when
        Object result = list.set(0, null);
        //then
        assert result == object : "null element not set";
    }

    //---------------------------------------------------------------
    public static void size_sizeOfEmptyList(List list) {
        //given

        //when

        //then
        assert list.size() == 0 : "empty list is not empty";
    }

    public static void size_sizeOfListWithNullElements(List list) {
        //given

        //when
        list.add(null);
        list.add(null);
        list.add(null);
        //then
        assert list.size() == 3 : "size should be 3";
    }

    //---------------------------------------------------------------
    public static void spliterator_checkTypeOfSpliterator(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        //when
        list.add(object);
        Spliterator<Object> split = list.spliterator();

        //then
        assert split instanceof Spliterator : "wrong instance of Spliterator";
    }

    //---------------------------------------------------------------

<<<<<<< HEAD
    public static void sort_sortsByNullComparator(List list) {
=======
    public static void sortByNullComparator(List list) {
>>>>>>> 9605ff328636c7af7c769b4e3310e87633f5244e
        //given
        List<String> testList = Arrays.asList("B", "D", "A", "C");

        //when
        testList.sort(null);

        //then
        assert testList.get(0).equals("A") : "elements not sorted in a natural ordering";
    }

<<<<<<< HEAD
=======
    //IllegalAccessException

//    public static void sortByGivenComparator(List list) {
//        //given
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//
//        //when
//        list.sort((a, b) -> -a.toString().compareTo(b.toString()));
//
//        //then
//
//        assert list.get(0).equals("D") : "elements not sorted";
//    }

>>>>>>> 9605ff328636c7af7c769b4e3310e87633f5244e
    //---------------------------------------------------------------
    public static void sublistWhenEndIndexGreaterThanStartIndex(List list) {
        //given
        List<Object> result = list;

        Object object = new Object();
        Object object1 = new Object();

        list.add(object);
        list.add(object1);

        //when
        boolean flag = false;
        try {
            list.subList(2, 1);
        } catch (IllegalArgumentException e) {
            flag = true;
        }
        //then
        assert flag : "exception not thrown";
    }

    public static void sublistWhenStartIndexIsNegative(List list) {
        //given

        Object object = new Object();
        Object object1 = new Object();

        list.add(object);
        list.add(object1);

        //when
        boolean flag = false;
        try {
            list.subList(-11, 0);
        } catch (IndexOutOfBoundsException e) {
            flag = true;
        }
        //then
        assert flag : "exception not thrown";
    }

    //---------------------------------------------------------------
    public static void toArrayOnEmptyList(List list) {
        //given

        //when
        Object[] array = list.toArray();
        //then
        assert array.length == 0 : "array is not empty";
    }

    public static void toArrayOnNotEmptyList(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();

        list.add(object);
        list.add(object1);

        //when
        Object[] array = list.toArray();
        //then
        assert array.length == 2 : "wrong array length";
    }

    public static void checkSequenceInToArray(List list) {
        //given
        Object object = new Object();
        Object object1 = new Object();
        Object object2 = new Object();

        list.add(object);
        list.add(object1);
        list.add(object2);

        //when
        Object[] array = list.toArray();
        //then
        assert array[0].equals(object) : "elements in a wrong order";
        assert array[2].equals(object2) : "elements in a wrong order";
    }
    //---------------------------------------------------------------


}
