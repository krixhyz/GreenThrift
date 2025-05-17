package DAO;

import Model.CartItem;
import Model.Product;

import java.util.List;

public class CartDAO {

    private final ProductDAO productDAO;

    public CartDAO() {
        this.productDAO = new ProductDAO();
    }

    public void addToCart(List<CartItem> cart, int productId) {
        boolean found = false;

        for (CartItem item : cart) {
            if (item.getProduct().getProductID() == productId) {
                item.setQuantity(item.getQuantity() + 1);
                found = true;
                break;
            }
        }

        if (!found) {
            Product product = productDAO.getProductById(productId);
            if (product != null) {
                cart.add(new CartItem(product, 1));
            }
        }
    }

    // Optional: other cart operations
    public void removeFromCart(List<CartItem> cart, int productId) {
        cart.removeIf(item -> item.getProduct().getProductID() == productId);
    }

    public void clearCart(List<CartItem> cart) {
        cart.clear();
    }
}
