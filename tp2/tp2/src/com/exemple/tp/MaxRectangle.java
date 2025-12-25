package com.exemple.tp;

public class MaxRectangle {

    static class Rectangle {
        int top;
        int left;
        int bottom;
        int right;
        int area;

        @Override
        public String toString() {
            return "Rectangle [top=" + top + ", left=" + left +
                   ", bottom=" + bottom + ", right=" + right +
                   ", area=" + area + "]";
        }
    }

    public static Rectangle trouverMaxRectangle(int[][] m) {
        if (m == null || m.length == 0) return null;

        int R = m.length;
        int C = m[0].length;

        int[] h = new int[C];
        Rectangle best = new Rectangle();
        best.area = 0;

        for (int i = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {
                if (m[i][j] == 0) h[j] = 0;
                else h[j]++;
            }

            java.util.Stack<Integer> stack = new java.util.Stack<>();

            for (int j = 0; j <= C; j++) {

                int curHeight = (j == C ? 0 : h[j]);

                while (!stack.isEmpty() && curHeight < h[stack.peek()]) {

                    int height = h[stack.pop()];
                    int right = j - 1;
                    int left = stack.isEmpty() ? 0 : stack.peek() + 1;

                    int area = height * (right - left + 1);

                    if (area > best.area) {
                        best.area = area;
                        best.bottom = i;
                        best.top = i - height + 1;
                        best.left = left;
                        best.right = right;
                    }
                }

                stack.push(j);
            }
        }

        return best;
    }

    public static int maxRectangle(int[][] m) {
        Rectangle r = trouverMaxRectangle(m);
        return (r == null ? 0 : r.area);
    }

    public static void main(String[] args) {

        int[][] M = {
            {0,1,1,0,1},
            {1,1,1,1,0},
            {1,1,1,1,0},
            {1,1,0,0,1}
        };

        Rectangle r = trouverMaxRectangle(M);

        System.out.println("Aire maximale = " + r.area);
        System.out.println(r);
    }
}
