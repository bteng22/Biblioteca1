package com.twu.biblioteca;

import java.util.List;

/**
 * Created by brandonteng on 6/20/14.
 */
public class StringLengthFinder {

    public int findMaxStringLength (List<String> list){
        int maxLength = 0;
        for (String string : list) {
            if(string.length() > maxLength){
                maxLength = string.length();
            }
        }

        return maxLength;
    }
}
