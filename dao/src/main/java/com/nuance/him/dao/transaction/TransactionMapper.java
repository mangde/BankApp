/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.dao.transaction;

import org.springframework.jdbc.core.RowMapper;
import com.nuance.him.model.transaction.Transaction;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Transaction Mapper class.
 */
public class TransactionMapper implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        Transaction transaction = new
            Transaction(resultSet.getInt("accFrom"), resultSet.getInt("accTo"),
            resultSet.getDouble("amount"),
            resultSet.getString("description"));
        transaction.setTransactionId(resultSet.getInt(1));
        transaction.setDate(resultSet.getDate("dateTime"));
        return transaction;
    }
}
