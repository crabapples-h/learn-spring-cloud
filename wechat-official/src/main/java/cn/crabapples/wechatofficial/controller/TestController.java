package cn.crabapples.wechatofficial.controller;

import cn.crabapples.common.utils.turing.TuringRequestDTO;
import cn.crabapples.common.utils.turing.TuringResponseDTO;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hequan@gogpay.cn
 * @date 2019/7/23 16:53
 */
@RestController
public class TestController {

    private final RestTemplate restTemplate;

    public TestController(@Qualifier(value = "restTemplateNotLoadBalanced") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("test")
    public String apiTest(){
        String url = "http://openapi.tuling123.com/openapi/api/v2";
        ResponseEntity<String> result = restTemplate.postForEntity(url,createTest().toString(),String.class);
        TuringResponseDTO turingResponseDTO = JSON.parseObject(result.getBody(),TuringResponseDTO.class);

        System.err.println(turingResponseDTO);

        return "收到";
    }
    private TuringRequestDTO createTest(){
        TuringRequestDTO turingRequestDTO = new TuringRequestDTO();

        TuringRequestDTO.Perception perception = new TuringRequestDTO.Perception();
        TuringRequestDTO.InputText inputText = new TuringRequestDTO.InputText();
        inputText.setText("喜欢你");
        perception.setInputText(inputText);

        TuringRequestDTO.UserInfo userInfo = new TuringRequestDTO.UserInfo();
        userInfo.setApiKey("67e51f0bc2864cdc8256f24dadf218f8");
        userInfo.setUserId("1");

        turingRequestDTO.setReqType("0");
        turingRequestDTO.setPerception(perception);
        turingRequestDTO.setUserInfo(userInfo);
        System.err.println(turingRequestDTO);
        return turingRequestDTO;

    }
}
