package ki36.derevianko.lab7;

import java.util.*;

/**
 * Class <code>NightStandDriver</code> Implements driver for NightStand class
 * @author Stanislav Derevianko
 * @version 1.0
 */
public class NightStandDriver {
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        NightStand<? super IReadableData> stand = new NightStand<IReadableData>();
        stand.AddData(new Book("Don Quixote", "Miguel de Cervantes", 720));
        stand.AddData(new Book("The Odyssey " , "Homer", 1256));
        stand.AddData(new CopyBook("graph" , 45));
        stand.AddData(new CopyBook("ruled" , 24));
        stand.AddData(new CopyBook("graph" , 99));
        stand.AddData(new CopyBook("graph" , 54));
        stand.AddData(new Magazine("The Washington Post Magazine " , "Andrea Barrett",20.99,123));
        stand.AddData(new Magazine("Chicago Magazine " , "Matthew Dicks",10.0,47));
        IReadableData res = stand.findMax();
        System.out.print("\nThe greatest data on night stand is: ");
        res.print();
        stand.DeleteData(1);
        IReadableData upRes = stand.findMax();
        System.out.print("\nThe greatest data on night stand (after pulling the certain book) is: ");
        upRes.print();
        IReadableData minRes = stand.findMin();
        System.out.print("\n\nThe minimal data on night stand is: ");
        minRes.print();
    }
}

/**
 * Class <code>NightStand</code> implements methods for adding, deleting and finding the max value of it`s element
 * @author Stanislav Derevianko
 * @version 1.0
 */
class NightStand<T extends IReadableData>
{
    private ArrayList<T> arr;
    /**
     * Default Constructor
     */
    public NightStand()
    {
        arr = new ArrayList<T>();
    }
    /**
     * Method will find the max value in night stand
     */
    public T findMax()
    {
        if (!arr.isEmpty())
        {
            T max = arr.get(0);
            for (int i=1; i< arr.size(); i++)
            {
                if ( arr.get(i).compareTo(max) > 0 )
                    max = arr.get(i);
            }
            return max;
        }
        return null;
    }
    /**
     * Method will find the min value in night stand
     */
    public T findMin()
    {
        if (!arr.isEmpty())
        {
            T min = arr.get(0);
            for (int i=1; i< arr.size(); i++)
            {
                if ( arr.get(i).compareTo(min) < 0 )
                    min = arr.get(i);
            }
            return min;
        }
        return null;
    }
    /**
     * Method simulates adding data into the night stand
     */
    public void AddData(T data)
    {
        arr.add(data);
        System.out.print("\nElement added: ");
        data.print();
    }
    /**
     * Method simulates deleting data from the night stand
     */
    public void DeleteData(int i)
    {
        arr.remove(i);
    }
}
interface IReadableData extends Comparable<IReadableData>
{
    public int getNumberOfPages();
    public void print();
}
/**
 * Class <code>Book</code> implements a book by
 * implementing the interface <code>IReadableData</code>
 * @author Stanislav Derevianko
 * @version 1.0
 */
class Book implements IReadableData
{
    private String bookTitle;
    private String authour;
    private int numberOfPages;
    /**
     * Constructor
     * @param authour Book`s authour
     * @param bookTitle Book`s title
     * @param numberOfPages Book`s number of pages
     */
    public Book(String bookTitle, String authour, int numberOfPages)
    {
        this.bookTitle = bookTitle;
        this.authour = authour;
        this.numberOfPages = numberOfPages;
    }
    public String getBookTitle()
    {
        return bookTitle;
    }
    public void setBookTitle(String name) { bookTitle = name;}
    public String getAuthour()
    {
        return authour;
    }
    public void setAuthour(String n)
    {
        authour = n;
    }
    public int getNumberOfPages()
    {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages;}
    public int compareTo(IReadableData p)
    {
        Integer s = numberOfPages;
        return s.compareTo(p.getNumberOfPages());
    }
    public void print()
    {
        System.out.print("\nBook title: " + bookTitle + ", has  been written by: " + authour + ", number of pages: " + numberOfPages + ";\n");
    }
}
/**
 * Class <code>CopyBook</code> implements a copy book by
 * implementing the interface <code>IReadableData</code>
 * @author Stanislav Derevianko
 * @version 1.0
 */
class CopyBook implements IReadableData
{
    private String copyBookType;
    private int numberOfPages;
    /**
     * Constructor
     * @param  copyBookType Copy book`s type
     * @param numberOfPages Copy book`s number of pages
     */
    public CopyBook(String copyBookType, int numberOfPages)
    {
        this.copyBookType = copyBookType;
        this.numberOfPages = numberOfPages;
    }
    public String getCopyBookType()
    {
        return copyBookType;
    }
    public void setCopyBookType(String type)
    {
        copyBookType = type;
    }
    public int getNumberOfPages()
    {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages;}

    public int compareTo(IReadableData p)
    {
        Integer s = numberOfPages;
        return s.compareTo(p.getNumberOfPages());
    }
    public void print()
    {
        System.out.print("\nCopybook`s type: " + copyBookType + ", number of pages: " + numberOfPages + ";\n");
    }
}
/**
 * Class <code>Magazine</code> implements a magazine by
 * implementing the interface <code>IReadableData</code>
 * @author Stanislav Derevianko
 * @version 1.0
 */
class Magazine implements IReadableData {
    private String magazineTitle;
    private String authour;
    private double price;
    private int numberOfPages;
    /**
     * Constructor
     * @param magazineTitle Magazine`s title
     * @param authour Magazine`s authour
     * @param numberOfPages Magazine`s number of pages
     * @param price Magazine`s price
     */
    Magazine(String magazineTitle, String authour,double price, int numberOfPages)
    {
        this.magazineTitle = magazineTitle;
        this.authour = authour;
        this.price = price;
        this.numberOfPages = numberOfPages;
    }
    public String getMagazineTitle() { return this.magazineTitle;}

    public void setMagazineTitle(String title) { this.magazineTitle = title;}

    public String getAuthour() { return this.authour;}

    public void setAuthour(String issue) { this.authour = issue;}

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price");
        }
    }
    public double getPrice() { return this.price;}

    public int getNumberOfPages() { return numberOfPages;}

    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages;}

    public int compareTo(IReadableData p)
    {
        Integer s = numberOfPages;
        return s.compareTo(p.getNumberOfPages());
    }
    public void print()
    {
        System.out.print("\nMagazine title: " + magazineTitle + ", has  been published by: " + authour +
                ", it costs: " + price + ", number of pages: " + numberOfPages + ";\n");
    }
}
