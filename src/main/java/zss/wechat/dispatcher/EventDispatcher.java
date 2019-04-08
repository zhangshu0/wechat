package zss.wechat.dispatcher;

import zss.web.util.MessageUtil;
import zss.wechat.common.GetUseInfo;
import zss.wechat.message.resp.Article;
import zss.wechat.message.resp.NewsMessage;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * ClassName: EventDispatcher
 *
 * @author zs
 * @Description: 事件消息业务分发器
 * @date 2018/11/16 Pm 5:30:00
 */
public class EventDispatcher {
    private static Logger logger = Logger.getLogger(EventDispatcher.class);

    public static String processEvent(Map<String, String> map) {
        String openid = map.get("FromUserName"); // 用户 openid
        String mpid = map.get("ToUserName"); // 公众号原始 ID
//        ImageMessage imgmsg = new ImageMessage();
//        imgmsg.setToUserName(openid);
//        imgmsg.setFromUserName(mpid);
//        imgmsg.setCreateTime(new Date().getTime());
//        imgmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);
//        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { // 关注事件
//            System.out.println("==============这是关注事件！");
//            Image img = new Image();
//            HttpPostUploadUtil util = new HttpPostUploadUtil();
//            String filepath = "/Users/zhangshuo/wechat/src/main/webapp/WEB-INF/img/stt.jpg";
//            Map<String, String> textMap = new HashMap<String, String>();
//            textMap.put("name", "STT");
//            Map<String, String> fileMap = new HashMap<String, String>();
//            fileMap.put("userfile", filepath);
//            String mediaidrs = util.formUpload(textMap, fileMap);
//            System.out.println(mediaidrs);
//            String mediaid = JSONObject.fromObject(mediaidrs).getString("media_id");
//            img.setMediaId(mediaid);
//            imgmsg.setImage(img);
//            logger.info(MessageUtil.imageMessageToXml(imgmsg));
//            return MessageUtil.imageMessageToXml(imgmsg);
//        }
        //对图文消息
        NewsMessage newmsg = new NewsMessage();
        newmsg.setToUserName(openid);
        newmsg.setFromUserName(mpid);
        newmsg.setCreateTime(new Date().getTime());
        newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { // 关注事件
            System.out.println("==============这是关注事件！");
            try {
                HashMap<String, String> userinfo = GetUseInfo.Openid_userinfo(openid);
                Article article = new Article();
                article.setDescription("欢迎来到zs的个人博客：菜鸟程序员成长之路！"); //图文消息的描述
                article.setPicUrl(userinfo.get("headimgurl")); //图文消息图片地址
                article.setTitle("尊敬的：" + userinfo.get("nickname") + ",你好！");  //图文消息标题
                article.setUrl("https://www.baidu.com/");  //图文 url 链接
                List<Article> list = new ArrayList<Article>();
                list.add(article);//这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
                newmsg.setArticleCount(list.size());
                newmsg.setArticles(list);
                return MessageUtil.newsMessageToXml(newmsg);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println("====代码有问题额☺！");
                logger.error(e, e);
            }

        }
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //关注事件
            System.out.println("==============这是关注事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //取消关注事件
            System.out.println("==============这是取消关注事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //扫描二维码事件
            System.out.println("==============这是扫描二维码事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //位置上报事件
            System.out.println("==============这是位置上报事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //自定义菜单点击事件
            System.out.println("==============这是自定义菜单点击事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //自定义菜单 View 事件
            System.out.println("==============这是自定义菜单 View 事件！");
        }

        return null;
    }
}
