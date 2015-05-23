package com.xperad.aries.service;

import com.xperad.aries.persistence.model.Message;
import com.xperad.aries.persistence.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/23
 */

@Service
@Transactional
public class WelcomeServiceImpl implements WelcomeService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> searchAllMessages() {
        try {
            return messageRepository.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}