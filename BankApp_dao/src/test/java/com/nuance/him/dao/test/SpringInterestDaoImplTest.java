package com.nuance.him.dao.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.config.DatabaseConfig;
import com.nuance.him.dao.account.SpringInterestCalDaoImpl;
import com.nuance.him.model.accountmodel.InterestCalculator;
import static org.testng.Assert.assertNotNull;

/**
 * test interestDao class.
 */
@TestPropertySource("classpath:sql-queries.xml")
@ContextConfiguration(classes = DatabaseConfig.class)
@Transactional
public class SpringInterestDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {

    private static final String CAL_MONTHLY_INTEREST = "calMonthlyInterest";
    private static final int ACCOUNT_NUMBER = 3;
    private static final double AMOUNT = 500.00;
    private static final int INTEREST_RATE = 4;
    @Value("${" + CAL_MONTHLY_INTEREST + "}")
    private String getCalMonthlyInterest;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private InterestCalculator interestCalculator;
    private SpringInterestCalDaoImpl springInterestCalDao;

    /**
     * initial setup before test.
     */
    @BeforeMethod
    public void setUp() {
        springInterestCalDao = new SpringInterestCalDaoImpl(namedParameterJdbcTemplate, getCalMonthlyInterest);
        interestCalculator = new InterestCalculator(ACCOUNT_NUMBER, AMOUNT, INTEREST_RATE);
    }

    /**
     * test method monthlyCalculate Interestand rollback the transaction.
     * @throws Exception exception
     */
    @Test
    @Transactional
    public void testCalMonthlyInterest()throws Exception{
        assertNotNull(springInterestCalDao,"springInterestCalDao should not be null");
        double intrest=springInterestCalDao.calculateMonthlyInterest(interestCalculator);
        assertNotNull(intrest,"interest should not be null");


    }
}
