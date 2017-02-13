package basic.number.applications;

/**
 * Source: https://leetcode.com/problems/construct-the-rectangle/
 *
 * <p>For a web developer, it is very important to know how to design a
 * web page's size. So, given a specific rectangular web page’s area,
 * your job by now is to design a rectangular web page, whose length L
 * and width W satisfy the following requirements:
 * <li>The area of the rectangular web page you designed must equal to
 * the given target area.
 * <li>The width W should not be larger than the length L, which means L >= W.
 * <li>The difference between length L and width W should be as small as possible.
 * You need to output the length L and the width W of the web page you designed
 * in sequence.
 *
 * <p><b>Example:</b>
 * Input: 4<br>
 * Output: [2, 2]<br>
 * Explanation: The target area is 4, and all the possible ways to construct it
 * are [1,4], [2,2], [4,1]. But according to requirement 2, [1,4] is illegal;
 * according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the
 * length L is 2, and the width W is 2.<br>
 *
 * Created by zhou-jg on 2017/2/13.
 */
public class RectangleConstructor {
    public int[] constructRectangle(int area) {
        if (area == 1){
            return new int[]{1,1};
        }else{
            int w = (int) Math.floor(Math.sqrt(area));
            while (area % w != 0){
                w--;
            }
            return new int[]{area/w, w};
        }
    }
}
