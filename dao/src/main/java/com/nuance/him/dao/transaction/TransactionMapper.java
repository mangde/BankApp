/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.dao.transaction;

import org.springframework.jdbc.core.RowMapper;
import com.nuance.him.model.transaction.TransferAmount;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TransferAmount Mapper class.
 */
public class TransactionMapper implements RowMapper<TransferAmount> {

    @Override
    public TransferAmount mapRow(ResultSet resultSet, int i) throws SQLException {
        TransferAmount transferAmount = new
            TransferAmount(resultSet.getInt("accFrom"), resultSet.getInt("accTo"),
            resultSet.getDouble("amount"),
            resultSet.getString("description"));
        transferAmount.setTransactionId(resultSet.getInt(1));
        transferAmount.setDate(resultSet.getDate("dateTime"));
        return transferAmount;
    }
}
