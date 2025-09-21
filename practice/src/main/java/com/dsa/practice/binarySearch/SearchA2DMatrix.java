package com.dsa.practice.binarySearch;

class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while ( left <= right ) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols];
            if (midValue == target) {
                return true;
            } else if ( midValue < target ) {
                left = mid + 1;
            } else {
                right = mid - 1;    
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        SearchA2DMatrix solver = new SearchA2DMatrix();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        }; // Example input
        int target = 3;
        boolean result = solver.searchMatrix(matrix, target);
        System.out.println("Search a 2D Matrix Example: " + result); // Expected output: true
    }
}