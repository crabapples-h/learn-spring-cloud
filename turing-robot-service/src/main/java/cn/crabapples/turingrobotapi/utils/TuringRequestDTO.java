package cn.crabapples.turingrobotapi.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * TODO 图灵机器人api接口请求参数
 *
 * @author Mr.He
 * @date 2019/7/23 21:17
 * e-mail wishforyou.xia@gmail.com
 * pc-name 29404
 */
public class TuringRequestDTO {
    private String reqType;
    private Perception perception;
    private UserInfo userInfo;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getReqType() {
        return this.reqType;
    }

    public Perception getPerception() {
        return this.perception;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public void setPerception(Perception perception) {
        this.perception = perception;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public static class Perception {
        private InputText inputText;
        private InputImage inputImage;
        private SelfInfo selfInfo;

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }

        public InputText getInputText() {
            return this.inputText;
        }

        public InputImage getInputImage() {
            return this.inputImage;
        }

        public SelfInfo getSelfInfo() {
            return this.selfInfo;
        }

        public void setInputText(InputText inputText) {
            this.inputText = inputText;
        }

        public void setInputImage(InputImage inputImage) {
            this.inputImage = inputImage;
        }

        public void setSelfInfo(SelfInfo selfInfo) {
            this.selfInfo = selfInfo;
        }
    }

    public static class InputText {
        private String text;

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }

        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class InputImage {
        private String url;

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class SelfInfo {
        private Location location;

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }

        public Location getLocation() {
            return this.location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }
    }

    public static class Location {
        private String city;
        private String province;
        private String street;

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }

        public String getCity() {
            return this.city;
        }

        public String getProvince() {
            return this.province;
        }

        public String getStreet() {
            return this.street;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public void setStreet(String street) {
            this.street = street;
        }
    }

    public static class UserInfo {
        private String apiKey;
        private String userId;

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }

        public String getApiKey() {
            return this.apiKey;
        }

        public String getUserId() {
            return this.userId;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
