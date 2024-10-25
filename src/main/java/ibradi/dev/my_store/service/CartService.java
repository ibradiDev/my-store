package ibradi.dev.my_store.service;


import ibradi.dev.my_store.model.Cart;
import ibradi.dev.my_store.model.Customer;

import java.util.List;


public interface CartService {

	Cart addCart(Cart cart, long productId, long customerId);

	List<Cart> getAllCarts();

	Cart getCartById(long cartId);

	Cart updateCart(Cart cart, long cartId);

	void deleteCart(long cartId);

	void deleteCartByCustomer(Customer c);


}