package com.zs.wechat.common;

import net.sf.json.JSONObject;
import com.zs.web.util.GlobalConstants;
import com.zs.wechat.util.HttpUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: WeChatTask
 * @Description: 微信两小时定时任务体
 * @author zs
 * @date 2018/11/15 Pm 2:30:00
 */
public class WeChatTask {
    /**
     * @Description: 任务执行体
     * @param @throws Exception
     * @author zs
     * @date 2018/11/15 Pm 2:30:00
     */
    public void getToken_getTicket() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        //获取 token 执行体
        params.put("grant_type", "client_credential");
        params.put("appid", GlobalConstants.getInterfaceUrl("appid"));
        params.put("secret", GlobalConstants.getInterfaceUrl("AppSecret"));
        String jstoken = HttpUtils.sendGet(
                GlobalConstants.getInterfaceUrl("tokenUrl"), params);
        String access_token = JSONObject.fromObject(jstoken).getString(
                "access_token"); // 获取到 token 并赋值保存
        GlobalConstants.interfaceUrlProperties.put("access_token", access_token);

        //获取 jsticket 的执行体
//        params.clear();
//        params.put("access_token", access_token);
//        params.put("type", "jsapi");
//        String jsticket = HttpUtils.sendGet(
//                GlobalConstants.getInterfaceUrl("ticketUrl"), params);
//        String jsapi_ticket = JSONObject.fromObject(jsticket).getString(
//                "ticket");
//        GlobalConstants.interfaceUrlProperties
//                .put("jsapi_ticket", jsapi_ticket); // 获取到 js-SDK 的 ticket 并赋值保存
//
//        System.out.println("jsapi_ticket================================================" + jsapi_ticket);
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"token 为=============================="+access_token);

    }

}
