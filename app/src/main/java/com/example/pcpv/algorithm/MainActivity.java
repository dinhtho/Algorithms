package com.example.pcpv.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int arr[] = {0, 15, 20, 35, 40, 54, 62, 77, 84};
        Log.i(TAG, "onCreateRecursion : " + binarySearchRecursion(arr, 84));
        Log.i(TAG, "onCreate: " + binarySearch(arr, 84));

        int nDisks = 3;
        doTowers(nDisks, 'A', 'B', 'C');
    }

    private static final String TAG = "MainActivity";

    private static Integer binarySearchRecursion(int arr[], int number) {
        int start = 0;
        int end = arr.length;
        int middle = (end - start) / 2;
        if (end > start) {
            if (arr[middle] > number) {
                end = middle;
            } else if (arr[middle] < number) {
                start = middle + 1;
            } else {
                return middle;
            }
            return start + binarySearchRecursion(Arrays.copyOfRange(arr, start, end), number);
        }
        return null;
    }

    private static Integer binarySearch(int arr[], int number) {
        int start = 0;
        int end = arr.length;
        while (end > start) {
            int middle = start + (end - start) / 2;
            if (arr[middle] > number) {
                end = middle;
            } else if (arr[middle] < number) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return null;
    }

    public static void doTowers(int topN, char from,
                                char inter, char to) {
        if (topN == 1) {
            System.out.println("Disk " + topN + " from "
                    + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk "
                    + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }

    }
}
