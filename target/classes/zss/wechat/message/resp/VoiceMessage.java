package zss.wechat.message.resp;

/**
 * ClassName: VoiceMessage
 * @Description: 语音消息
 * @author zs
 * @date 2018/11/15 Pm 2:30:00
 */
public class VoiceMessage extends BaseMessage{

    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }

}
