package builder;

/**
 * @description: 产品特征
 * @author: starfish
 * @date: 2021/6/9 11:29
 */
public class GPS {

    private String route;

    public GPS() {
        this.route = "国贸到五道口";
    }

    public GPS(String manualRoute) {
        this.route = manualRoute;
    }

    public String getRoute() {
        return route;
    }
}
