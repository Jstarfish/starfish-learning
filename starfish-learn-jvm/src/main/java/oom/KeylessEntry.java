package oom;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: -Xmx14m -XX:+PrintGCDetails
 * @author: starfish
 * @data: 2020-07-05 15:34
 **/
public class KeylessEntry {

    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    public static void main(String[] args) {
        Map m = new HashMap();
        while (true){
            for (int i = 0; i < 1000; i++){
                if (!m.containsKey(new Key(i))){
                    m.put(new Key(i), "Number:" + i);
                }
            }
            System.out.println("m.size()=" + m.size());
        }
    }
}
