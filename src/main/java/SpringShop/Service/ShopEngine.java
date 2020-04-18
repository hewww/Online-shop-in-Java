package SpringShop.Service;

import SpringShop.model.User;

public class ShopEngine {

    private User user;

    public void changeActivate() {
        if (user.getAddress() != null) {
            user.setActivated(true);
        }
    }



}
