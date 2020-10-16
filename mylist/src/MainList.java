public class MainList
{
    public static void main(String[] args)
    {
        MyList myList = new MyList();
        myList.add(12);
        myList.add(15);
        myList.add(2);
        myList.add(9);
        myList.add(1);
        myList.add(19);
        System.out.println(myList);
        System.out.println(myList.indexAt(2).toString());
        myList.swap(2,4);
        System.out.println(myList);
        myList.sort();
        System.out.println(myList);
    }
}
