package com.mkdlp.algorithm.leetcode.Q53;

import java.util.AbstractList;
import java.util.ListIterator;

public class Solution {

    public static void main(String[] args) {

        ListIterator<Integer> it = new ListIterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Integer previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(Integer integer) {

            }

            @Override
            public void add(Integer integer) {

            }
        };
    }
}
