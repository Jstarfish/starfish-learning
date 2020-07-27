package priv.starfish.linkedlist;

/**
 * @description:
 * @author: starfish
 * @data: 2020-07-27 22:03
 **/
public class InvalidNodeException extends RuntimeException {
    public InvalidNodeException(String err) {
        super(err);
    }
}

