package zss.wechat.menu;

import com.alibaba.fastjson.JSONObject;
import zss.web.util.GlobalConstants;
import zss.wechat.util.HttpUtils;
import net.sf.json.JSONArray;

public class MenuMain {

    public static void main(String[] args) {

        ViewButton vbt1 = new ViewButton();
        vbt1.setUrl("http://www.baidu.com");
        vbt1.setName("对账");
        vbt1.setType("view");

        ViewButton vbt2 = new ViewButton();
        vbt2.setUrl("https://link.jiandaoyun.com/f/5cb2b258f834675ed47047e3");
        vbt2.setName("询价");
        vbt2.setType("view");

        ViewButton vbt3 = new ViewButton();
        vbt3.setUrl("https://link.jiandaoyun.com/f/5cb2ae9a4bea461c378600e4");
        vbt3.setName("报价");
        vbt3.setType("view");

//        JSONArray sub_button=new JSONArray();
//        sub_button.add(cbt);
//        sub_button.add(vbt);
//
//        JSONObject buttonOne=new JSONObject();
//        buttonOne.put("name", "菜单");
//        buttonOne.put("sub_button", sub_button);

        JSONArray button = new JSONArray();
        button.add(vbt1);
        button.add(vbt2);
        button.add(vbt3);

        JSONObject menujson = new JSONObject();
        menujson.put("button", button);
        System.out.println(menujson);
        //这里为请求接口的 url   +号后面的是 token，这里就不做过多对 token 获取的方法解释
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=20_0lINSnqzpCmzUsvHDuyRp1VyFmmgulNKC_gc_mWBu1gLjejpiIesHFfZ0ZaAi1-t5_Q6g-yJfI8gkSrPF-O0Eqs2ipKpC4-gKPj-LA2DhsKXT6k0yr1O3zSV6ZsK6-0YYZZuttjpd0CqcJ7MCKKhADAHPP";

        try {
            String rs = HttpUtils.sendPostBuffer(url, menujson.toJSONString());
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println("请求错误！");
        }

    }


}
