/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.dao.account;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import com.nuance.him.model.accountmodel.AccountType;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountTypeMapper implements RowMapper {

    public AccountType mapRow(ResultSet resultSet,int rowNum) throws SQLException {
        AccountType account= new AccountType();
        return account;
    }

    @Override
    public int[] getRowsForPaths(TreePath[] path) {
        return new int[0];
    }
}
