package tk.hadeslee.BJ8LF.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Project: java8-examples
 * FileName: ExpandingArray
 * Date: 2016-01-11
 * Time: 오전 9:48
 * Author: redfo
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class ExpandingArray {
    public static void main(String[] args) {
        // Create an array of length 2
        int[] ids = {101, 102};
        System.out.println("Old array length: " + ids.length);
        System.out.println("Old array elements:" + Arrays.toString(ids));
        // Expand the array by 1
        ids = (int[]) expandBy(ids, 1);
        // Set the third element to 103
        ids[2] = 103; // This is newly added element
        System.out.println("New array length: " + ids.length);
        System.out.println("New array elements:" + Arrays.toString(ids));
    }

    public static Object expandBy(Object oldArray, int increment) {
        Object newArray = null;
        // Get the length of old array using reflection
        int oldLength = Array.getLength(oldArray);
        int newLength = oldLength + increment;
        // Get the class of the old array
        Class<?> c = oldArray.getClass();
        // Create a new array of the new length
        newArray = Array.newInstance(c.getComponentType(), newLength);
        // Copy the old array elements to new array
        System.arraycopy(oldArray, 0, newArray, 0, oldLength);
        return newArray;
    }
}
