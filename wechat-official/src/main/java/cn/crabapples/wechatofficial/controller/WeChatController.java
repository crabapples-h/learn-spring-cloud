package cn.crabapples.wechatofficial.controller;

import cn.crabapples.common.BaseController;
import cn.crabapples.common.ResponseDTO;
import cn.crabapples.wechatofficial.dto.WechatBaseDTO;
import cn.crabapples.wechatofficial.service.WeChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * HeQuan
 * PC-name 29404
 *
 * @author Wishfor_you@foxmail.com
 * 2019年2月19日 上午1:06:53
 */
@RestController
@RequestMapping("/api")
public class WeChatController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final WeChatService weChatService;

    public WeChatController(WeChatService weChatService) {
        this.weChatService = weChatService;
    }

    @RequestMapping("/server")
    public Object wxServer(WechatBaseDTO baseDTO, HttpServletRequest request) {
        logger.info("请求参数:[{}]", baseDTO);
        Object result = weChatService.getMessage(baseDTO, request);
        logger.info("返回的数据:[{}]", ResponseDTO.returnSuccess("处理完成", result));
        return result;
    }
}
