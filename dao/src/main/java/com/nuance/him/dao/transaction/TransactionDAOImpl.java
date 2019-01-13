/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */

package com.nuance.him.dao.transaction;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class TransactionDAOImpl implements TransactionDAO {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public TransactionDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        namedParameterJdbcTemplate=jdbcTemplate;
    }
}
