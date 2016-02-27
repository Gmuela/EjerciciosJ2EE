package Ejercicios2.helper;

import javax.servlet.http.HttpServletRequest;

public class Helper {

    public static String getBaseUrl(HttpServletRequest request) {

        String baseUrl = request.getRequestURL().toString().substring(0, request.getRequestURL().toString().length() - request.getRequestURI().length()) + request.getContextPath() + "/";

        return baseUrl;

    }

}
