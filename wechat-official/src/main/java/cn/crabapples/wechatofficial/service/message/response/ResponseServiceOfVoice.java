package cn.crabapples.wechatofficial.service.message.response;

import cn.crabapples.wechatofficial.entity.RequestMessage;
import cn.crabapples.wechatofficial.entity.ResponseMessage;
import org.jdom2.Element;
import org.springframework.stereotype.Service;


@Service
public class ResponseServiceOfVoice implements ResponseService {
    @Override
    public String getMessage(RequestMessage request, ResponseTypeEnum type, Object object) {
        return null;
    }
}
