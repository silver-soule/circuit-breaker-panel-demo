package edu.knoldus.repository;

import java.util.NoSuchElementException;

public class SillyRepositoryImpl implements SillyRepository {
    
    @Override
    public String getSomethingRandom(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        } else if (index == 0) {
            throw new NullPointerException();
        } else if (index == 1) {
            throw new NoSuchElementException();
        } else {
            return String.format("Welcome user %d", index);
        }
    }
}
