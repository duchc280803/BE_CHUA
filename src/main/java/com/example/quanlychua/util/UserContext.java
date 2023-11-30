package com.example.quanlychua.util;

import com.example.quanlychua.entity.PhatTu;

public class UserContext {

    private static final ThreadLocal<PhatTu> currentUser = new ThreadLocal<>();

    public static void setCurrentUser(PhatTu phatTu) {
        currentUser.set(phatTu);
    }

    public static PhatTu getCurrentUser() {
        return currentUser.get();
    }

    public static void clear() {
        currentUser.remove();
    }
}
