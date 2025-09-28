package cn.crabapples.wechatofficial.service.message.request;

/**
 * TODO
 *
 * @author Mr.He
 * 2020/7/25 17:01
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
public enum RequestTypeEnum {
    EVENT("event", RequestServiceOfEvent.class),
    TEXT("text", RequestServiceOfText.class),
    IMAGE("image", RequestServiceOfImage.class),
    LOCATION("location", RequestServiceOfLocation.class),
    LINK("link", RequestServiceOfLink.class),
    VIDEO("video", RequestServiceOfVideo.class);
    public String type;
    Class<? extends RequestService> clazz;

    RequestTypeEnum(String type, Class<? extends RequestService> clazz) {
        this.type = type;
        this.clazz = clazz;
    }

    public static RequestTypeEnum getInstanceByType(String type) {
        for (RequestTypeEnum value : RequestTypeEnum.values()) {
            if (value.type.equals(type)) {
                return value;
            }
        }
        return null;
    }

}
