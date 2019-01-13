/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law.
  *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */

package com.nuance.him.model.accountmodel;

import javax.persistence.Id;

public class AccountType {

    @Id
    private final int accTypeId;
    private final String accTypeDesc;

    public AccountType(final int accTypeId, final String accTypeDesc) {
        this.accTypeId = accTypeId;
        this.accTypeDesc = accTypeDesc;
    }

    public String getAccTypeDesc(){
        return accTypeDesc;
}

    public int getAccTypeId() {
        return this.accTypeId;
    }


}
