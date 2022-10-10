package com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.contact;

import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.model.Product;
import com.example.NguyenMinhThuan_KienTrucPhanMem_ThiGK.repository.ProductRepository;
import com.google.gson.Gson;

@Component
public class Listener {
	@Autowired
	private ProductRepository repository;
    @JmsListener(destination = "inbound.queue")
    @SendTo("outbound.queue")
    public String receiveMessage(final Message jsonMessage) throws JMSException {
        String messageData = null;
        System.out.println("Tin nhắn nhận được: " + jsonMessage);
        String response = null;
        List<Product> list = repository.getAllProduct();
        for(Product pd : list) {
        	response = response.concat(pd.toString());
        }
        TextMessage textMessage = (TextMessage)jsonMessage;
        messageData = textMessage.getText();
        Map map = new Gson().fromJson(messageData, Map.class);
        response  =  (String) map.get("name");
        return response;
    }
}
