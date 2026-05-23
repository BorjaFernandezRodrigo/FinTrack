package com.desenrola.katas;

public record Pair<A, B>(A first, B second) {
    public Pair<B, A> swap() {
        return new Pair<>(this.second, this.first);
    }
}
