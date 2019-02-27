package com.nuance.him.dao.account;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.nuance.him.dao.daoexception.InterestDaoException;
import com.nuance.him.model.accountmodel.InterestCalculator;
import java.util.Date;

/**
 * {@link SpringInterestCalDaoImpl} class implementation of interface {@link SpringInterestCalcDao}.
 */
public class SpringInterestCalDaoImpl implements SpringInterestCalcDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String calMonthlyInterestUpdate;

    /**
     * Constructor of class {@link SpringInterestCalDaoImpl}.
     * @param namedParameterJdbcTemplate jdbcTemplate
     * @param calMonthlyInterestUpdate query for insert values in interest table.
     */
    public SpringInterestCalDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, String calMonthlyInterestUpdate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.calMonthlyInterestUpdate = calMonthlyInterestUpdate;
    }

    @Override
    public double calculateMonthlyInterest(final InterestCalculator interestCalculator) throws InterestDaoException {
        try {
            final MapSqlParameterSource paramSourceAcc = mapParameterSource(interestCalculator);
            namedParameterJdbcTemplate.update(calMonthlyInterestUpdate, paramSourceAcc);
        }
        catch (final DataAccessException dataAccessException) {
            throw new InterestDaoException("Failed to add monthly interest ", dataAccessException);
        }
        return interestCalculator.getMonthlyInterest();
    }

    /**
     * bind values.
     * @param interestCalculator instance of class {@link InterestCalculator}.
     * @return interest
     */
    private MapSqlParameterSource mapParameterSource(InterestCalculator interestCalculator) {
        final Date date = new Date();
        final Object param = new java.sql.Timestamp(date.getTime());

        final MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("accNumber", interestCalculator.getAccNumber());
        paramSource.addValue("balance", interestCalculator.getBalance());
        paramSource.addValue("monthlyInterest", interestCalculator.getMonthlyInterest());
        paramSource.addValue("date", param);

        return paramSource;
    }
}
