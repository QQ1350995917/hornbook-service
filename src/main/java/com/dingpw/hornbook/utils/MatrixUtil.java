package com.dingpw.hornbook.utils;

/**
 * TODO
 *
 * @author 丁朋伟@600100@18511694468 on 2018-07-05 11:31.
 */
public class MatrixUtil {

    public static final String DEFAULT_SPLIT = "\n";
    public static final String DEFAULT_PLACEHOLDER = "*";
    public static final String DEFAULT_TAB_HOLDER = "    ";

    public static String[][] matrix(String originText, String split, String placeholder) {
        String[] origins = originText.split(split);
        int rows = origins.length;
        int columns = 0;
        for (String line : origins) {
            if (line.length() > columns) {
                columns = line.length();
            }
        }

        String[][] result = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            String temp = origins[i];
            for (int j = 0; j < columns; j++) {
                if (j < temp.length()) {
                    result[i][j] = temp.substring(j, j + 1);
                } else {
                    result[i][j] = placeholder;
                }
            }
        }
        return result;
    }


    public static String[][] rotate(String[][] originMatrix) {
        String[][] result = new String[originMatrix[0].length][originMatrix.length];
        int dst = originMatrix.length - 1;
        for (int i = 0; i < originMatrix.length; i++, dst--) {
            for (int j = 0; j < originMatrix[0].length; j++) {
                result[j][dst] = originMatrix[i][j];
            }
        }
        return result;
    }

    public static String toString(String[][] originMatrix, String split, String placeHolder) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String[] rowLine : originMatrix) {
            for (String text : rowLine) {
                if (text.equals(placeHolder)) {
                    text = placeHolder;
                }
                stringBuilder.append(text);
            }
            stringBuilder.append(split);
        }
        stringBuilder.delete(stringBuilder.length() - split.length(), stringBuilder.length());
        return stringBuilder.toString();
    }

    public static void printMatrix(String[][] textMatrix) {
        for (String[] rowLine : textMatrix) {
            for (String text : rowLine) {
                System.out.print(text);
            }
            System.out.println();
        }
    }
}
