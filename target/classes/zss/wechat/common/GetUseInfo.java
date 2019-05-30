package zss.wechat.common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zss.web.util.GlobalConstants;
import zss.wechat.util.HttpUtils;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: GetUseInfo
 *
 * @author zs
 * @Description: 获取微信用户信息
 * @date 2018/11/16 Pm 2:40:00
 */
public class GetUseInfo {
    /**
     * @Description: 通过 openid 获取用户微信信息
     * @param @param openid
     * @param @return
     * @param @throws Exception
     * @author zs
     * @date 2018/11/16 Pm 2:40:00
     */
    private static Logger logger = Logger.getLogger(GetUseInfo.class);

    public static HashMap<String, String> Openid_userinfo(String openid)
            throws Exception {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("access_token",
                GlobalConstants.getInterfaceUrl("access_token"));  //定时器中获取到的 token
        params.put("openid", openid);  //需要获取的用户的 openid
        params.put("lang", "zh_CN");
        String subscribers = HttpUtils.sendGet(
                GlobalConstants.getInterfaceUrl("OpenidUserinfoUrl"), params);
        System.out.println(subscribers);
        params.clear();
        //这里返回参数只取了昵称、头像、和性别
        params.put("nickname",
                JSONObject.fromObject(subscribers).getString("nickname")); //昵称
        params.put("headimgurl",
                JSONObject.fromObject(subscribers).getString("headimgurl"));  //图像
        params.put("sex", JSONObject.fromObject(subscribers).getString("sex"));  //性别
        return params;
    }

    /**
     * 获取所有的关注用户
     *
     * @return
     */

    public List<String> getAllWeiXinUser() {

        GetExistAccessToken getExistAccessToken = GetExistAccessToken.getInstance();

        String accessToken = getExistAccessToken.getExistAccessToken();

        List<String> openIds = new ArrayList<String>();

        // 上传文件请求路径

        String action = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="

                + accessToken;

        try {

            URL urlGet = new URL(action);

            HttpURLConnection http = (HttpURLConnection) urlGet

                    .openConnection();

            http.setRequestMethod("GET"); // 必须是get方式请求

            http.setRequestProperty("Content-Type",

                    "application/x-www-form-urlencoded");

            http.setDoOutput(true);

            http.setDoInput(true);

            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒

            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

            http.connect();

            InputStream is = http.getInputStream();

            int size = is.available();

            byte[] jsonBytes = new byte[size];

            is.read(jsonBytes);

            String result = new String(jsonBytes, "UTF-8");

            JSONObject jsonObj = JSONObject.fromObject(result);

            System.out.println("users" + jsonObj.get("data"));

            JSONObject json1 = JSONObject.fromObject(jsonObj.get("data").toString());

            System.out.println(json1.toString());

            JSONArray json2 = JSONArray.fromObject(json1.get("openid").toString());

            for (int i = 0; i < json2.size(); i++) {

                openIds.add(i, json2.getString(i));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return openIds;

    }


}
