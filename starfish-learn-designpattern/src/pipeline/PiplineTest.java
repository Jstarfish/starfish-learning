package pipeline;

/**
 * @description: 客户端调用
 * @author: starfish
 * @date: 2021/5/25 17:31
 */
public class PiplineTest {

    public static void main(String[] args) {

        StandardPipeline pipeline = new StandardPipeline();
        BasicValue basic = new BasicValue();
        SecondValve secondValve = new SecondValve();
        ThirdValueValve thirdValueValve = new ThirdValueValve();

        pipeline.setNext(basic);
        pipeline.addValue(thirdValueValve);
        pipeline.addValue(secondValve);


        pipeline.getFirst().invoke(new PipeLineContext(3));
    }


}
