//package cn.crabapples.wechatofficial;
//
//import cn.crabapples.wechatofficial.dto.WechatBaseDTO;
//import cn.crabapples.wechatofficial.entity.RequestMessage;
//import cn.crabapples.wechatofficial.service.WeChatService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ClientWeChatApplicationTests {
//    @Autowired
//    WeChatService weChatService;
//    WechatBaseDTO weChatRequestDTO = new WechatBaseDTO();
//    @Before
//    public void before(){
//        weChatRequestDTO.setNonce("1328238075");
//        RequestMessage requestMessage = new RequestMessage();
//        requestMessage.setContent("123~~~喜欢你");
//        requestMessage.setCreateTime("1563808410");
//        requestMessage.setFromUserName("oxF9Y6CD0X_jjAO7X8o-mfrcTI4I");
//        requestMessage.setMsgId("22388350416034813");
//        requestMessage.setMsgType("text");
//        requestMessage.setToUserName("gh_58a7a8173b10");
//        weChatRequestDTO.setSignature("signature");
//        weChatRequestDTO.setTimestamp("1563808411");
//        weChatRequestDTO.setRequestMessage(requestMessage);
//    }
//    @Test
//    public void contextLoads() {
//    }
//
//    @Test
//    public void case1(){
//        weChatService.getMessage(weChatRequestDTO);
//    }
//}
