package com.xperad.aries.persistence.repository;

import com.xperad.aries.persistence.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/23
 */

@Repository
@Transactional(readOnly = true)
public class UserRepository extends AbstractRepository<User, Integer> {
}