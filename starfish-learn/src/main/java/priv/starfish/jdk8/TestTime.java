package priv.starfish.jdk8;

import org.w3c.dom.Node;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;


public class TestTime {



    Node reverse(Node node){
        Node cur = node;
        Node pre = null;

        while(cur != null){
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    class Node{
        int val;
        Node next;

    }
}
