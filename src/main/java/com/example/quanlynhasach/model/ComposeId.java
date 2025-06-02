package com.example.quanlynhasach.model;

import java.io.Serializable;
import java.util.Objects;

public class ComposeId implements Serializable {

    private int productId;
    private int authorId;

    // Constructors
    public ComposeId() {
    }

    public ComposeId(int productId, int authorId) {
        this.productId = productId;
        this.authorId = authorId;
    }

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ComposeId))
            return false;
        ComposeId that = (ComposeId) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(authorId, that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, authorId);
    }
}