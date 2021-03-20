package course.Store;

import java.util.Collection;

public class TestCart {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Book book1 = new Book("111", "java", 40);
        Book book2 = new Book("222", "jsp", 36);
        Book book3 = new Book("333", "java", 40);

        for (int i = 0; i < 3; i++) cart.addItem(book1);

        cart.addItem(book2);
        cart.editItem("222", 2);

        cart.addItem(book3);
        Collection<CartItem> items = cart.findItems();
        for (CartItem item : items){
            System.out.println(item);
        }
        System.out.println("Total: " + cart.findTotal());

    }
}
