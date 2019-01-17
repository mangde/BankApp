/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.dao.account;

import org.springframework.jdbc.core.RowMapper;
import com.nuance.him.model.accountmodel.Account;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper to display the table rows mapping them to the objects.
 */
public class AccountMapper implements RowMapper<Account> {

    /**
     * Maps table row to the Customer object.
     *
     * @param rs result set
     * @param rowNum current row number
     * @return customer
     * @throws SQLException SQLException
     */
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account(rs.getString("accTypeId"), rs.getDouble("balance"), rs.getInt("customerId"));
        account.setAccountNo(rs.getInt("accNumber"));
        return account;
    }
}
