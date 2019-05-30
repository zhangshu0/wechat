package zss.wechat.common;

import zss.web.util.GlobalConstants;

public class GetExistAccessToken {
    //定义一个私有的静态全局变量来保存该类的唯一实例

    private static GetExistAccessToken getExistAccessToken;

    /// 构造函数必须是私有的

    /// 这样在外部便无法使用 new 来创建该类的实例

    private GetExistAccessToken()

    {

    }

    /// 定义一个全局访问点

    /// 设置为静态方法

    /// 则在类的外部便无需实例化就可以调用该方法

    public static GetExistAccessToken getInstance()

    {

        //这里可以保证只实例化一次

        //即在第一次调用时实例化

        //以后调用便不会再实例化

        if (getExistAccessToken == null)

        {

            getExistAccessToken = new GetExistAccessToken();

        }

        return getExistAccessToken;

    }

    public String getExistAccessToken() {

        return GlobalConstants.getInterfaceUrl("access_token");

    }


}
