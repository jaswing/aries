package com.xperad.aries.persistence;

import com.xperad.aries.persistence.model.User;
import com.xperad.aries.persistence.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/23
 */

@Repository
public class UserRepository extends AbstractRepository<User, Integer> {
}