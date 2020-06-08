package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SortedSideBook {
    private List<SimpleBook> lst = new LinkedList<>();
    private int side;

    public SortedSideBook(int side) {
        this.side = side;
    }

    public void upsert(double price, double qty) {
        SimpleBook book = new SimpleBook();
        book.setPrice(price);
        book.setQty(qty);
        upsertBook(book);
    }

    private void upsertBook(SimpleBook book) {
        boolean isInsert = false;
        for(int i = 0 ; i < lst.size() ; i++) {
            SimpleBook simpleBook = lst.get(i);
            if(Double.compare(simpleBook.getPrice(), book.getPrice()) == 0) {
            	if(book.getQty() == 0) {
            		lst.remove(i);
            	} else {
            		simpleBook.setQty(book.getQty());
            	}
                isInsert = true;
                break;
            } else if((simpleBook.getPrice() < book.getPrice() && side == 1) ||
                    (simpleBook.getPrice() > book.getPrice() && side == 2)) {
                lst.add(i, book);
                isInsert = true;
                break;
            }
        }
        if(!isInsert) {
            lst.add(lst.size(), book);
        }
    }

    public int getSide() {
        return side;
    }

    public List<SimpleBook> getWholeBook() {
    	List<SimpleBook> lstClone = new ArrayList<>();
    	
    	for(SimpleBook book : lst) {
    		SimpleBook bookClone = new SimpleBook();
    		bookClone.setPrice(book.getPrice());
    		bookClone.setQty(book.getQty());
    		lstClone.add(bookClone);
    	}
        return lstClone;
    }

    public static void main(String[] s) {
//    	lstTest();
    	
    	lstCloneTest();
    }
    
    private static void lstCloneTest() {
    	SortedSideBook buyBook = new SortedSideBook(1);
    	buyBook.upsert(1000, 1);
    	buyBook.upsert(2000, 1);
    	buyBook.upsert(800, 1);
    	buyBook.upsert(800, 0);
    	
    	List<SimpleBook> lst = buyBook.getWholeBook();
    	for(SimpleBook book : lst) {
    		book.setQty(2d);
    	}
    	
    	print(buyBook.getWholeBook());
    }
    
    private static void lstTest() {
    	SortedSideBook buyBook = new SortedSideBook(1);

        buyBook.upsert(1000, 1);
        print(buyBook.getWholeBook());

        buyBook.upsert(500, 2);
        print(buyBook.getWholeBook());

        buyBook.upsert(1000, 2);
        print(buyBook.getWholeBook());

        buyBook.upsert(800, 1.11);
        print(buyBook.getWholeBook());

        SortedSideBook sellBook = new SortedSideBook(2);
        sellBook.upsert(1000, 1);
        print(sellBook.getWholeBook());

        sellBook.upsert(500, 2);
        print(sellBook.getWholeBook());

        sellBook.upsert(1000, 2);
        print(sellBook.getWholeBook());

        sellBook.upsert(800, 1.11);
        print(sellBook.getWholeBook());
    }

    private static void print(List<SimpleBook> lst) {
        System.out.println("----------------------");
        for(SimpleBook book : lst) {
            System.out.println(book.getPrice() + ":" + book.getQty());
        }
    }
}

