/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.service.test.customer;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.dao.daoexception.TransactionDaoException;
import com.nuance.him.dao.transaction.TransactionDao;
import com.nuance.him.model.transaction.Transaction;
import com.nuance.him.service.test.serviceexception.TransactionServiceException;
import com.nuance.him.service.test.transaction.TransactionServices;
import com.nuance.him.service.test.transaction.TransactionServicesImpl;
import java.util.List;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/***
 * {@link TransactionServices} implementation.
 */
public class TransactionServiceImplTest {

    private static final double AMOUNT = 500;
    private static final int FROM_ACC = 1;
    private static final int TO_ACC = 2;
    private static final String DESCRIPTION = "Loan";
    private static final double CURRENT_BALANCE = 1000;
    @Mock
    private TransactionDao transactionDAO;
    private TransactionServices transactionService;
    private Transaction transaction;

    /**
     * initial setup.
     */
    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        transactionService = new TransactionServicesImpl(transactionDAO);
        transaction = new Transaction(FROM_ACC, TO_ACC, AMOUNT, DESCRIPTION);
    }

    /**
     * test TransferAmount.
     *
     * @throws Exception exception
     */
    @Test
    public void testTransferAmount() throws Exception {
        when(transactionDAO.transferAmount(any(Transaction.class), anyDouble())).thenReturn(1);
        int result = transactionService.transferAmount(transaction, CURRENT_BALANCE);
        assertNotNull(result);
        Mockito.verify(transactionDAO).transferAmount(any(Transaction.class), anyDouble());
    }

    /**
     * check exception of method transferAmount.
     *
     * @throws Exception {@link TransactionServiceException}
     */
    @Test(expectedExceptions = TransactionServiceException.class)
    public void testTransferAmountException() throws Exception {
        doThrow(TransactionDaoException.class).when(transactionDAO).transferAmount(any(Transaction.class), anyDouble());
        try {
            int result = transactionService.transferAmount(transaction, CURRENT_BALANCE);
        }
        catch (TransactionServiceException e) {
            assertEquals(TransactionDaoException.class, e.getCause().getClass());
            Mockito.verify(transactionDAO).transferAmount(any(Transaction.class), anyDouble());
            throw e;
        }
    }

    /**
     * Test Transaction History of account.
     *
     * @throws Exception exception
     */
    @Test
    public void testTransactionHistory() throws Exception {
        when(transactionDAO.getTransactionHistory(anyInt())).thenReturn(anyListOf(Transaction.class));
        List<Transaction> transactions = transactionService.getTransactionHistory(FROM_ACC);
        assertNotNull(transactions);
        Mockito.verify(transactionDAO).getTransactionHistory(anyInt());
    }

    /**
     * test exception thrown by method transactionHistory.
     *
     * @throws Exception {@link TransactionServiceException}
     */
    @Test(expectedExceptions = TransactionServiceException.class)
    public void testTransactionHistoryException() throws Exception {
        doThrow(TransactionDaoException.class).when(transactionDAO).getTransactionHistory(anyInt());
        try {
            List<Transaction> transactions = transactionService.getTransactionHistory(FROM_ACC);
        }
        catch (TransactionServiceException e) {
            assertEquals(TransactionDaoException.class, e.getCause().getClass());
            Mockito.verify(transactionDAO).getTransactionHistory(anyInt());
            throw e;
        }
    }
}
