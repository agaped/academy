import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static void addElementToList() {

        //given
        List<Integer> firstList = new LinkedList<Integer>();

        //when
        firstList.add(3);

        //then
        assert firstList.size() == 1 : "element not added";
    }

    public static void addNullToList() {

        //given
        List<Integer> firstList = new LinkedList<Integer>();

        //when
        firstList.add(null);

        //then
        assert firstList.size() == 1 : "more than one element on the list";
    }

    //-----------------------------------------------------

    public static void addElementToFirstIndex() {

        //given
        List<Integer> list = new LinkedList<Integer>();
        list.add(4);
        list.add(6);

        //when
        list.add(0, 5);

        //then
        assert list.get(0) == 5 : "element not added to the position 0";
    }

    public static void addElementToNegativeIndex() {
        //given
        List<Integer> list = new LinkedList<Integer>();
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

    public static void addElementToIndexInTheMiddle() {

        //given
        List<Integer> list = new LinkedList<Integer>();
        list.add(4);
        list.add(6);

        //when
        list.add(2, 5);

        //then
        assert list.get(2) == 5 : "element not added to the specified position";
    }

    //-------------------------------------------------------

    public static void addNewCollectionAtTheEndOfEmptyList() {

        //given
        List<Integer> firstlist = new LinkedList();
        List<Integer> secondlist = new LinkedList();

        secondlist.add(2);
        secondlist.add(3);
        secondlist.add(4);

        //when
        firstlist.addAll(secondlist);

        //then
        assert firstlist.equals(secondlist) : "list not added";
    }

    public static void addNewCollectionAtTheEnd() {

        //given
        List<Integer> firstlist = new LinkedList();
        List<Integer> secondlist = new LinkedList();

        firstlist.add(7);
        secondlist.add(2);
        secondlist.add(3);
        secondlist.add(4);

        //when
        firstlist.addAll(secondlist);

        //then
        assert firstlist.size() == 4 : "list not added";
    }

    //---------------------------------------------------------

    public static void addNewCollectionAtTheBeginning() {

        //given
        List<Integer> firstlist = new LinkedList();
        List<Integer> secondlist = new LinkedList();

        firstlist.add(3);
        firstlist.add(4);
        secondlist.add(5);
        secondlist.add(6);

        //when
        firstlist.addAll(0, secondlist);

        //then
        assert firstlist.size() == 4 : "list not added at the begining";
        assert firstlist.get(0) == secondlist.get(0) : "list not added ate the begining";

    }

    public static void addNewCollectionAtMissingIndex() {
        List<Integer> firstlist = new LinkedList();
        List<Integer> secondlist = new LinkedList();

        firstlist.add(3);
        firstlist.add(4);
        secondlist.add(5);
        secondlist.add(6);

        try {
            firstlist.addAll(5, secondlist);
        } catch (IndexOutOfBoundsException e) {

        }

        assert firstlist.size() == 2 : "list added at missing index";

    }

    public static void addNewCollectionAtNegativeIndex() {
        List<Integer> firstlist = new LinkedList();
        List<Integer> secondlist = new LinkedList();

        firstlist.add(3);
        firstlist.add(4);
        secondlist.add(5);
        secondlist.add(6);

        try {
            firstlist.addAll(-1, secondlist);
        } catch (IndexOutOfBoundsException e) {

        }

        assert firstlist.size() == 2 : "list added at negative index";

    }


    //---------------------------------------------------------
    public static void clearEmptyList() {

        List<Integer> emptylist = new LinkedList<Integer>();

        emptylist.clear();

        assert emptylist.size() == 0 : "list not cleared";
    }

    public static void clearNotEmptyList() {

        List<Integer> list = new LinkedList<Integer>();

        list.add(3);
        list.add(4);

        list.clear();

        assert list.size() == 0 : "list not cleared";
    }


    //--------------------------------------------------


    public static void emptyListContainsAnyElement() {

        List<Integer> emptyList = new LinkedList();

        assert emptyList.contains(3) == false : "empty list is not empty";
    }


    public static void listContainsExistingElement() {

        List<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(3);

        assert list.contains(3) : "existing element not on the list";
    }

    public static void listContainsMissingElement() {

        List<Integer> list = new LinkedList<Integer>();

        list.add(1);
        list.add(3);

        assert list.contains(2) == false : "missing element on the list";
    }

    //----------------------------------------------------

    public static void emptyListContainsCollection() {

        List<Integer> emptyList = new LinkedList<Integer>();

        List<Integer> list = new LinkedList<Integer>();
        list.add(2);
        list.add(3);
        list.add(6);

        assert emptyList.containsAll(list) == false : "emptyList contains list with elements";
    }

    public static void listContainsCollection() {

        List<Integer> firstList = new LinkedList<Integer>();
        List<Integer> secondList = new LinkedList<Integer>();

        firstList.add(3);
        firstList.add(5);
        firstList.add(7);

        secondList.add(5);

        assert firstList.containsAll(secondList) == true : "firstList does not contain secondList";
    }

    public static void listContainsEmptyCollection() {

        List<Integer> firstList = new LinkedList<Integer>();
        List<Integer> secondList = new LinkedList<Integer>();

        firstList.add(4);
        firstList.add(5);
        firstList.add(6);

        assert firstList.containsAll(secondList) : "firstList does not contain empty list";
    }

    //--------------------------------------------------
//    public static void (){
//    //given
//
//    //when
//
//    //then
//    assert  :"";
//    }

    //--------------------------------------------------


    public static void isEmptyListEmpty() {

        List<Integer> emptyList = new LinkedList();

        assert emptyList.isEmpty() : "list is not empty";
    }

    public static void isNotEmptyListEmpty() {

        List<Integer> notEmptyList = new LinkedList();

        notEmptyList.add(2);

        assert notEmptyList.isEmpty() == false : "list is empty";
    }

    //----------------------------------------------------------


    public static void testRemoveElementFromEmptyList() {
        //given
        List<Integer> emptyList = new LinkedList<Integer>();
        //when

        //then
        //assert  emptyList.remove():"";
    }

    public static void testRemoveExistingElement() {
        //given
        List<Integer> firstList = new LinkedList<Integer>();
        //when
        firstList = Arrays.asList(2, 4, 6);
        //then

    }


    public static void main(String[] args) {

        LinkedListTest.isEmptyListEmpty();
        LinkedListTest.isNotEmptyListEmpty();

        LinkedListTest.emptyListContainsAnyElement();
        LinkedListTest.listContainsExistingElement();
        LinkedListTest.listContainsMissingElement();

        LinkedListTest.emptyListContainsCollection();
        LinkedListTest.listContainsCollection();
        LinkedListTest.listContainsEmptyCollection();

        LinkedListTest.addElementToList();
        LinkedListTest.addNullToList();

        LinkedListTest.addElementToFirstIndex();
        LinkedListTest.addElementToNegativeIndex();
        LinkedListTest.addElementToIndexInTheMiddle();

        LinkedListTest.addNewCollectionAtTheEndOfEmptyList();
        LinkedListTest.addNewCollectionAtTheEnd();

        LinkedListTest.addNewCollectionAtTheBeginning();
        LinkedListTest.addNewCollectionAtMissingIndex();
        LinkedListTest.addNewCollectionAtNegativeIndex();

        LinkedListTest.clearEmptyList();
        LinkedListTest.clearNotEmptyList();


    }

}
