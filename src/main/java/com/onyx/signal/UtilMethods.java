package com.onyx.signal;

import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.SingularValueDecomposition;

public class UtilMethods {

    public static double[] linspace(int start, int stop, int Fs, int samples) {
        double[] time = new double[samples*Fs];
        double T = 1.0/Fs;
        double i = start;

        int index = 0;
        time[index] = i;

        while (i<=stop) {
            i = i + T;
            index++;
            time[index] = i;
        }
        return time;
    }

    public static int[] arange(int start, int stop, int step) {
        if (start > stop) {
            throw new IllegalArgumentException("start cannot be greater than stop");
        }
        int size = (stop - start)/step;
        int[] arr = new int[size];

        int temp = start;
        for (int i=0; i<size; i++){
            arr[i] = temp;
            temp = temp + step;
        }
        return arr;
    }

    public static double[] arange(double start, double stop, int step) {
        if (start > stop) {
            throw new IllegalArgumentException("start cannot be greater than stop");
        }
        int size = (int)(stop-start)/step;
        double[] arr = new double[size];

        double temp = start;
        for (int i=0; i<size; i++){
            arr[i] = temp;
            temp = temp + step;
        }
        return arr;
    }

    // Reverse Array
    public static double[] reverse(double[] arr) {
        double[] inv = new double[arr.length];
        int index = 0;
        for (int i=(arr.length-1); i>=0; i--) {
            inv[index] = arr[i];
            index++;
        }
        return inv;
    }

    public static int[] reverse(int[] arr) {
        int[] inv = new int[arr.length];
        int index = 0;
        for (int i=(arr.length-1); i>=0; i--) {
            inv[index] = arr[i];
            index++;
        }
        return inv;
    }

    // Concatenate 2 arrays
    public static double[] concatenateArray(double[] arr1, double[] arr2) {
        double[] out = new double[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, out, 0, arr1.length);
        System.arraycopy(arr1, 0, out, arr1.length, arr2.length);
        return out;
    }

    public static int[] concatenateArray(int[] arr1, int[] arr2) {
        int[] out = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, out, 0, arr1.length);
        System.arraycopy(arr1, 0, out, arr1.length, arr2.length);
        return out;
    }

    // Split an array by indices
    public static double[] splitByIndex(double[] arr, int start, int end) {
        double[] out = new double[end-start];
        System.arraycopy(arr, start, out, 0, out.length);
        return out;
    }

    public static int[] splitByIndex(int[] arr, int start, int end) {
        int[] out = new int[end-start];
        System.arraycopy(arr, start, out, 0, out.length);
        return out;
    }

    // Finc pseudo-inverse of a 2D array
    public static double[][] pseudoInverse(double[][] mtrx) {
        RealMatrix M = MatrixUtils.createRealMatrix(mtrx);
        DecompositionSolver solver = new SingularValueDecomposition(M).getSolver();
        return solver.getInverse().getData();
    }

    public static double[] padSignalforConvolution(double[] signal, String mode) {
        double[] newSignal = new double[signal.length];
        if (mode.equals("reflect")) {

        }
        else if (mode.equals("constant")) {

        }
        else if (mode.equals("nearest")) {

        }
        else if (mode.equals("mirror")) {

        }
        else if (mode.equals("wrap")) {

        }
        else {
            throw new IllegalArgumentException("padSignalforConvolution modes can only be reflect, constant, " +
                    "nearest, mirror, wrap or interp (default)");
        }
        return newSignal;
    }
}