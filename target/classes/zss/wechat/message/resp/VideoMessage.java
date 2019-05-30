package zss.wechat.message.resp;

/**
 * ClassName: VideoMessage
 * @Description: 视频消息
 * @author zs
 * @date 2018/11/15 Pm 2:30:00
 */
public class VideoMessage extends BaseMessage{

    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }

}