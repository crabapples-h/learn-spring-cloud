package cn.crabapples.wechatofficial.service.message.response;

import cn.crabapples.wechatofficial.dao.repository.RequestMessageRepository;
import cn.crabapples.wechatofficial.dao.repository.ResponseMessageRepository;
import cn.crabapples.wechatofficial.entity.RequestMessage;
import cn.crabapples.wechatofficial.entity.ResponseMessage;
import org.jdom2.CDATA;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author Mr.He
 * 2020/7/25 18:56
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
@Service
public class ResponseServiceOfText implements ResponseService {
    private final RequestMessageRepository requestMessageRepository;
    private final ResponseMessageRepository responseMessageRepository;

    public ResponseServiceOfText(RequestMessageRepository requestMessageRepository,
                                 ResponseMessageRepository responseMessageRepository) {
        this.requestMessageRepository = requestMessageRepository;
        this.responseMessageRepository = responseMessageRepository;
    }

    @Override
    public String getMessage(RequestMessage request, ResponseTypeEnum type, Object object) {
        ResponseMessage response = request2response(request);
        response.setContent(String.valueOf(object));
        response.setMsgType(type.type);
        response = responseMessageRepository.saveAndFlush(response);
        request.setResponseMessage(response);
        requestMessageRepository.saveAndFlush(request);
        Element root = initDocument(response, type);
        root.addContent(new Element("Content").addContent(new CDATA(response.getContent())));
        return response2xml(root);
    }
}
