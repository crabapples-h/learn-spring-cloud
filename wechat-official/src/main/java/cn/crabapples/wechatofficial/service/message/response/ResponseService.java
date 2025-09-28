package cn.crabapples.wechatofficial.service.message.response;


import cn.crabapples.wechatofficial.entity.RequestMessage;
import cn.crabapples.wechatofficial.entity.ResponseMessage;
import org.jdom2.CDATA;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.beans.BeanUtils;

import java.io.ByteArrayOutputStream;

/**
 * TODO
 *
 * @author Mr.He
 * 2020/7/25 18:10
 * mail crabapples.cn@gmail.com
 * qq 294046317
 * pc-name crabapples
 */
public interface ResponseService {
    default Element initDocument(ResponseMessage message, ResponseTypeEnum type) {
        Element root = new Element("xml");
        root.addContent(new Element("ToUserName").addContent(new CDATA(message.getToUserName())));
        root.addContent(new Element("FromUserName").addContent(new CDATA(message.getFromUserName())));
        root.addContent(new Element("CreateTime").addContent(String.valueOf(System.currentTimeMillis() / 1000)));
        root.addContent(new Element("MsgType").addContent(new CDATA(type.type)));
        return root;
    }


    default String response2xml(Element root) {
        try {
            Format format = Format.getPrettyFormat();
            format.setEncoding("UTF-8");
            XMLOutputter xmlOutputter = new XMLOutputter(format);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            xmlOutputter.output(root, byteArrayOutputStream);
            return byteArrayOutputStream.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    default ResponseMessage request2response(RequestMessage request) {
        ResponseMessage response = new ResponseMessage();
        BeanUtils.copyProperties(request, response);
        response.setFromUserName(request.getToUserName());
        response.setToUserName(request.getFromUserName());
        return response;
    }


    String getMessage(RequestMessage request, ResponseTypeEnum type, Object object);
}
