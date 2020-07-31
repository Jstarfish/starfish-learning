package array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description: 数组类算法题测试
 * @author: starfish
 * @create: 2020-07-30 16:53
 */
public class ArrayTest {




    @Test
    public void twoSumNoSolution() {
        TwoSum_1 twoSum = new TwoSum_1();
        int target = 10;
        int[] nums = new int[]{-2, 0, 5, 4, -4, 7};
        int[] result = twoSum.twoSum(nums, target);
        //Assert.assertArrayEquals(expected, result);
    }

}
