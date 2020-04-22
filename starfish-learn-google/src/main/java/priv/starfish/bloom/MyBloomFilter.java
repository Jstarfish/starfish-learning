package priv.starfish.bloom;

import java.util.BitSet;

/**
 * @description: 自定义布隆过滤器
 * @author: starfish
 * @create: 2020-04-20 15:09
 **/
public class MyBloomFilter {

        /**
         * 初始化布隆过滤器的 bitmap 大小
         */
        private static final int DEFAULT_SIZE = 2 << 24;
        /**
         * 为了降低错误率，这里选取一些数字作为基准数
         */
        private static final int[] seeds = {3, 5, 7, 11, 13, 31, 37, 61};
        /**
         * 设置 bitmap
         */
        private static BitSet bitset = new BitSet(DEFAULT_SIZE);
        /**
         * 设置 hash 函数数量
         */
        private static HashFunction[] functions = new HashFunction[seeds.length];


        /**
         * 添加数据
         * @param value  需要加入的值
         */
        public static void put(String value) {
            if (value != null) {
                for (HashFunction f : functions) {
                    //计算 hash 值并修改 bitmap 中相应位置为 true
                    bitset.set(f.hash(value), true);
                }
            }
        }

        /**
         * 判断相应元素是否存在
         *
         * @param value 需要判断的元素
         * @return 结果
         */
        public static boolean check(String value) {
            if (value == null) {
                return false;
            }
            boolean ret = true;
            for (HashFunction f : functions) {
                ret = bitset.get(f.hash(value));
                //一个 hash 函数返回 false 则跳出循环
                if (!ret) {
                    break;
                }
            }
            return ret;
        }

        public static void main(String[] args) {
            String value = "test";
            for (int i = 0; i < seeds.length; i++) {
                functions[i] = new HashFunction(DEFAULT_SIZE, seeds[i]);
            }
            put(value);
            System.out.println(check("value"));
        }
    }

    class HashFunction {

        private int size;
        private int seed;

        public HashFunction(int size, int seed) {
            this.size = size;
            this.seed = seed;
        }

        public int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            int r = (size - 1) & result;
            return (size - 1) & result;
        }

    }
