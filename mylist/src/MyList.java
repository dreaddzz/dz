public class MyList
{
    class Node
    {
        private int value;
        private MyList.Node next;

        public Node(int value)
        {
            this.value = value;
            this.next = null;
        }

        public int getValue()
        {
            return value;
        }

        public MyList.Node getNext()
        {
            return next;
        }

        public void setNext(MyList.Node next)
        {
            this.next = next;
        }

        public String toString()
        {
            return Integer.toString(this.value);
        }

        public boolean hasNext()
        {
            return (this.next != null ? true : false);
        }
    }

    MyList.Node begin;                      // Ссылка на первый элемент
    long length;

    public MyList()
    {
        this.begin = null;
        this.length = 0;
    }

    public void add(int value)
    {                                       //Добавление элемента в список
        if (this.begin == null)
        {
            this.begin = new MyList.Node(value);
        }
        else
        {
            this.end().setNext(new MyList.Node(value));
        }
        this.length++;
    }

    public MyList.Node end()
    {  //Ссылка на последний элемент
        if (this.begin == null)
            return null;

        MyList.Node iter = this.begin;
        while (iter.hasNext())
        {
            iter = iter.getNext();
        }
        return iter;
    }

    public String toString()
    {                                      //Превращение нашего списка в строку
        String result = "[ ";
        if (this.begin != null)
        {
            MyList.Node iter = this.begin;
            while (iter.hasNext())
            {
                result += iter.toString() + ", ";
                iter = iter.getNext();
            }
            result += iter.toString() + " ";
        }
        result += "]";
        return result;
    }

    public void swap(int firstPos, int secondPos)
    {
        Node preFirst = indexAt(firstPos - 1);
        Node first = indexAt(firstPos);
        Node aftFirst = indexAt(firstPos + 1);
        Node preSecond = indexAt(secondPos - 1);
        Node second = indexAt(secondPos);
        Node aftSecond = indexAt(secondPos + 1);
        if (preFirst != null)
        {
            preFirst.setNext(second);
        }
        else
        {
            this.begin = second;
        }
        first.setNext(aftSecond);
        if (preSecond == first)
        {
            second.setNext(first);
        }
        else
        {
            second.setNext(aftFirst);
            preSecond.setNext(first);
        }
    }

    public Node indexAt(int index)
    {
        Node iter = this.begin;
        if (0 <= index && index <= this.length)
        {
            for (int i = 1; i < index; ++i)
            {
                iter = iter.getNext();
            }
            return iter;
        }
        else
        {
            return null;
        }
    }
    public void sort()
    {
        long leight = this.length;
        Node a;
        Node b;
        for (int i = 1; i < leight; ++i)
        {
            for (int j = 2; j < leight - i; ++j)
            {
                a = indexAt(i);
                b = indexAt(j);
                if (a.getValue() > b.getValue())
                {
                    swap(i, j);
                    a = indexAt(i);
                    b = indexAt(j);
                }
                else if (a.getValue() <= b.getValue())
                {
                    a = a.getNext();
                    b = b.getNext();
                }
            }
        }

    }
}