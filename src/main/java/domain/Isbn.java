package domain;

import io.netty.util.internal.StringUtil;

public record Isbn(String isbn) {

    private static String isbnRegEx = "(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+";

    public Isbn {
        if (StringUtil.isNullOrEmpty(isbn) || !isbn.matches(isbnRegEx)) {
            throw new IllegalArgumentException("Isbn ne peut pas être null ou vide");
        }
    }
}
