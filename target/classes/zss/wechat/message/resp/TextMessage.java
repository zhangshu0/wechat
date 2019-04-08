package zss.wechat.message.resp;

/**
 * ClassName: TextMessage
 * @Description: 文本消息消息体
 * @author zs
 * @date 2018/11/15 Pm 2:30:00
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}