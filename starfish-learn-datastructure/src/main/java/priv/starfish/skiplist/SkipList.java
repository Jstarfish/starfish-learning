package priv.starfish.skiplist;


/**
 * @description: 元素节点
 * @author: starfish
 * @date: 2021/6/29 20:41
 */
public class SkipList {

    /**
     * 最大层数
     */
    private static int DEFAULT_MAX_LEVEL = 32;

    /**
     * 随机层数概率，也就是随机出的层数，在 第1层以上(不包括第一层)的概率，层数不超过maxLevel，层数的起始号为1
     */
    private static double DEFAULT_P_FACTOR = 0.25;

    Node head = new Node(null, DEFAULT_MAX_LEVEL); //头节点

    int currentLevel = 1; //表示当前nodes的实际层数，它从1开始


    public SkipList() {
    }

    public Node search(int target) {
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            while ((head.next[i]) != null && searchNode.next[i].value < target) {
                searchNode = searchNode.next[i];
            }
        }
        if (searchNode.next[0] != null && searchNode.next[0].value == target) {
            return searchNode.next[0];
        } else {
            return null;
        }
    }

    /**
     *
     * @param num
     */
    public void add(int num) {
        int level = randomLevel();
        Node newNode = new Node(num,level);

        Node updateNode = head;

        // 计算出当前num 索引的实际层数，从该层开始添加索引，逐步向下
        for (int i = currentLevel-1; i>=0; i--) {
            //找到本层最近离num最近的节点(刚好比它小的节点)
            while ((updateNode.next[i])!=null && updateNode.next[i].value < num){
                updateNode = updateNode.next[i];
            }
            //本次随机的最高层才设值，如果是最后一个直接指向newNode,否则将newNode 链入链表
            if (i<level){
                if (updateNode.next[i]==null){
                    updateNode.next[i] = newNode;
                }else{
                    Node temp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        //如果随机出来的层数比当前的层数还大，那么超过currentLevel的head 直接指向newNode
        if (level > currentLevel){
            for (int i = currentLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            //更新层数
            currentLevel = level;
        }
    }

    public boolean erase(int num) {
        boolean flag = false;
        Node searchNode = head;
        //从最高层开始遍历找
        for (int i = currentLevel-1; i >=0; i--) {
            //和新增一样也需要找到离要删除节点最近的辣个
            while ((searchNode.next[i])!=null && searchNode.next[i].value < num){
                searchNode = searchNode.next[i];
            }
            //如果有这样的数值
            if (searchNode.next[i]!=null && searchNode.next[i].value == num){
                //找到该层中该节点，把下一个节点过来，就删除了
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 找到level层 value 大于node 的节点
     * @param node
     * @param levelIndex
     * @param value
     * @return
     */
    private Node findClosest(Node node,int levelIndex,int value){
        while ((node.next[levelIndex])!=null && value >node.next[levelIndex].value){
            node = node.next[levelIndex];
        }
        return node;
    }


    /**
     * 随机一个层数
     */
    private static int randomLevel(){
        int level = 1;
        while (Math.random()<DEFAULT_P_FACTOR && level<DEFAULT_MAX_LEVEL){
            level ++ ;
        }
        return level;
    }


    class Node{
        Integer value;
        Node[] next;

        public Node(Integer value,int size) {
            this.value = value;
            this.next = new Node[size];
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }


    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.add(1);
        skipList.add(3);
        skipList.add(2);
        System.out.println(skipList.search(0)); // 返回 false
        skipList.add(4);
        System.out.println(skipList.search(1));  // 返回 true
        System.out.println(skipList.erase(0));  // 返回 false，0 不在跳表中
        System.out.println(skipList.erase(1));// 返回 true
        System.out.println(skipList.search(1)); // 返回 false，1 已被擦除

    }


}
