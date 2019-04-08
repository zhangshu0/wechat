package zss.wechat.message.req;

/**
 * ClassName: VoiceMessage
 * @Description: 语音消息
 * @author zs
 * @date 2018/11/15 Pm 2:30:00
 */
public class VoiceMessage extends BaseMessage {
    // 媒体 ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
