package org.codewithsoly.shopservice.model;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER");
    private final String authority;

    Role(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
