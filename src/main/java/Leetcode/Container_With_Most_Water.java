package Leetcode;

// url: https://leetcode.com/problems/container-with-most-water/
public class Container_With_Most_Water {
    public static void main(String[] args) {
        Container_With_Most_Water con = new Container_With_Most_Water();
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(con.maxArea(ints));
    }

    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}