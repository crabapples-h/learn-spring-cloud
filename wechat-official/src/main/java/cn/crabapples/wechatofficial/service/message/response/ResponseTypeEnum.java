package cn.crabapples.wechatofficial.service.message.response;
/**
 * TODO 
 *
 * @author Mr.He`
 * 2020/7/25 18:24
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
public enum ResponseTypeEnum {
    TEXT("text", ResponseServiceOfText.class),
    IMAGE("image", ResponseServiceOfMusic.class),
    VOICE("voice", ResponseServiceOfVideo.class),
    VIDEO("video", ResponseServiceOfVideo.class),
    MUSIC("music", ResponseServiceOfMusic.class),
    NEWS("news", ResponseServiceOfNews.class);
    public String type;
    Class<? extends ResponseService> clazz;

    ResponseTypeEnum(String type, Class<? extends ResponseService> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public static ResponseTypeEnum getInstanceByType(String type) {
        for (ResponseTypeEnum value : ResponseTypeEnum.values()) {
            if (value.type.equals(type)) {
                return value;
            }
        }
        return null;
    }

}
