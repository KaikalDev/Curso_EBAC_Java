package kaique.luan.dev.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.Optional;

public class CookiesService {

    public static void setCookie(HttpServletResponse response, String userId) {
        Cookie userIdCookie = new Cookie("userId", userId);
        userIdCookie.setMaxAge(60 * 60 * 24);
        userIdCookie.setPath("/");
        userIdCookie.setSecure(true);
        userIdCookie.setHttpOnly(true);

        userIdCookie.setAttribute("SameSite", "None");

        response.addCookie(userIdCookie);
    }

    public static Long getCookie(HttpServletRequest request) {
        return Optional.ofNullable(request.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                        .filter(cookie -> "userId".equals(cookie.getName()))
                        .findAny()
                ).map(Cookie::getValue)
                .map(value -> {
                    try {
                        return Long.parseLong(value);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                })
                .orElse(null);
    }

}


