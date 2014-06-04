package com.givemewish.giftweb.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class GiftwebUtils {
    
    public static String getCurrentLoggedInUserId() {
        String uid = (String)SecurityContextHolder.getContext().getAuthentication().getName();
        return uid;
    }

}
