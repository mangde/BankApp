/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */

package com.nuance.him.model.accountmodel;

import javax.persistence.Id;

public class AccountType {

    @Id
    private int accTypeId;
    private String accTypeDesc;

    public AccountType() {
        this.accTypeId = accTypeId;
        this.accTypeDesc = accTypeDesc;
    }
public String getAccTypeDesc(){
        return accTypeDesc;
}
    public void setAccTypeDesc(String accTypeDesc) {
        this.accTypeDesc = accTypeDesc;
    }

    public int getAccTypeId() {
        return this.accTypeId;
    }

    public void setAccTypeId(int accTypeId) {
        this.accTypeId = accTypeId;
    }
}
