/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.service;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.dao.daoexception.TransferDaoException;
import com.nuance.him.dao.transaction.TransferDao;
import com.nuance.him.model.transaction.TransferAmount;
import com.nuance.him.service.account.AccountService;
import com.nuance.him.service.serviceexception.TransferAmountServiceException;
import com.nuance.him.service.transaction.TransferAmountService;
import com.nuance.him.service.transaction.TransferAmountServiceImpl;
import java.util.List;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/***
 * {@link TransferAmountService} implementation.
 */
public class TransferAmountServiceImplTest {

    private static final double AMOUNT = 500;
    private static final int FROM_ACC = 1;
    private static final int TO_ACC = 2;
    private static final String DESCRIPTION = "Loan";
    @Mock
    private TransferDao transferDAO;
    @Mock
    private AccountService accountService;
    private TransferAmountService transactionService;
    private TransferAmount transferAmount;

    /**
     * initial setup.
     */
    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        transactionService = new TransferAmountServiceImpl(transferDAO, accountService);
        transferAmount = new TransferAmount(FROM_ACC, TO_ACC, AMOUNT, DESCRIPTION);
    }

    /**
     * test TransferAmount.
     *
     * @throws Exception exception
     */
    @Test
    public void testTransferAmount() throws Exception {
        when(transferDAO.transferAmount(any(TransferAmount.class))).thenReturn(1);
        int result = transactionService.transferAmount(transferAmount);
        assertNotNull(result);
        Mockito.verify(transferDAO).transferAmount(any(TransferAmount.class));
    }

    /**
     * check exception of method transferAmount.
     *
     * @throws Exception exception {@link TransferAmountServiceException}
     */
    @Test(expectedExceptions = TransferAmountServiceException.class)
    public void testTransferAmountException() throws Exception {
        doThrow(TransferDaoException.class).when(transferDAO).transferAmount(any(TransferAmount.class));
        try {
            int result = transactionService.transferAmount(transferAmount);
        }
        catch (TransferAmountServiceException e) {
            assertEquals(TransferDaoException.class, e.getCause().getClass());
            Mockito.verify(transferDAO).transferAmount(any(TransferAmount.class));
            throw e;
        }
    }

    /**
     * Test TransferAmount History of account.
     *
     * @throws Exception exception
     */
    @Test
    public void testTransactionHistory() throws Exception {
        when(transferDAO.getTransactionHistory(anyInt())).thenReturn(anyListOf(TransferAmount.class));
        List<TransferAmount> transferAmounts = transactionService.getTransactionHistory(FROM_ACC);
        assertNotNull(transferAmounts);
        Mockito.verify(transferDAO).getTransactionHistory(anyInt());
    }

    /**
     * test exception thrown by method transactionHistory.
     *
     * @throws Exception exception {@link TransferAmountServiceException}
     */
    @Test(expectedExceptions = TransferAmountServiceException.class)
    public void testTransactionHistoryException() throws Exception {
        doThrow(TransferDaoException.class).when(transferDAO).getTransactionHistory(anyInt());
        try {
            List<TransferAmount> transferAmounts = transactionService.getTransactionHistory(FROM_ACC);
        }
        catch (TransferAmountServiceException e) {
            assertEquals(TransferDaoException.class, e.getCause().getClass());
            Mockito.verify(transferDAO).getTransactionHistory(anyInt());
            throw e;
        }
    }
}
