package com.xperad.aries.service;

import com.xperad.aries.persistence.model.Message;

import java.util.List;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/23
 */

public interface WelcomeService {

    List<Message> searchAllMessages();
}
