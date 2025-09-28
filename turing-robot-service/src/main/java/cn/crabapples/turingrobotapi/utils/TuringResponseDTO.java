package cn.crabapples.turingrobotapi.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * TODO 图灵机器人api接口返回参数
 *
 * @author Mr.He
 * @date 2019/7/23 21:30
 * e-mail wishforyou.xia@gmail.com
 * pc-name 29404
 */
public class TuringResponseDTO {
    private Intent intent;
    private List<Results> results;

    public Intent getIntent() {
        return this.intent;
    }

    public List<Results> getResults() {
        return this.results;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public static class Intent {
        private String code;
        private String intentName;
        private String actionName;
        private Parameters parameters;

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }

        public String getCode() {
            return this.code;
        }

        public String getIntentName() {
            return this.intentName;
        }

        public String getActionName() {
            return this.actionName;
        }

        public Parameters getParameters() {
            return this.parameters;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setIntentName(String intentName) {
            this.intentName = intentName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public void setParameters(Parameters parameters) {
            this.parameters = parameters;
        }
    }

    public static class Parameters {
        private String nearby_place;

        public String toString() {
            return JSONObject.toJSONString(this);
        }

        public String getNearby_place() {
            return this.nearby_place;
        }

        public void setNearby_place(String nearby_place) {
            this.nearby_place = nearby_place;
        }
    }

    public static class Results {
        private String groupType;
        private String resultType;
        private Values values;

        @Override
        public String toString() {
            return JSONObject.toJSONString(this);
        }

        public String getGroupType() {
            return this.groupType;
        }

        public String getResultType() {
            return this.resultType;
        }

        public Values getValues() {
            return this.values;
        }

        public void setGroupType(String groupType) {
            this.groupType = groupType;
        }

        public void setResultType(String resultType) {
            this.resultType = resultType;
        }

        public void setValues(Values values) {
            this.values = values;
        }
    }

    public static class Values {
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

    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
