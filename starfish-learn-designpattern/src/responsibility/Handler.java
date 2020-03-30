package responsibility;

/**
 * @description:
 * @author: starfish
 * @data: 2020-03-29 09:05
 **/
public abstract class Handler {

    private Handler nextHandler;
    private int level;

    public Handler(int level) {
        this.level = level;
    }

    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }

    public final void handlerRequest(Request request){
        if(level == request.getLevel()){
            this.response(request);
        }else{
            if (this.nextHandler != null){
                this.nextHandler.handlerRequest(request);
            }else{
                System.out.println("===已经没有处理器了===");
            }
        }

    }

    // 抽象方法，子类实现
    public abstract void response(Request request);
}



class Request {

    int level = 0;
    public Request(int level){
        this.level = level;
    }


    public int getLevel() {
        return level;
    }
//
//    public void setLevel(int level) {
//        this.level = level;
//    }
}