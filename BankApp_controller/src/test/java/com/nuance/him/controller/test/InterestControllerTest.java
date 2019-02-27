package com.nuance.him.controller.test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nuance.him.model.accountmodel.InterestCalculator;
import com.nuance.him.service.account.InterestCalculatorService;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * test Interest controller.
 */
@WebAppConfiguration
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes = TestControllerConfig.class)
public class InterestControllerTest extends AbstractTestNGSpringContextTests {

    private static final String BASE_URL = "baseURL";
    private static final String CAL_MONTHLY_INTEREST = "Monthly.calInterest";
    private static final double BALANCE = 5025;
    private static final int ACCOUNT_NO = 3;
    private static final int INTEREST_RATE = 3;
    @Value("${" + BASE_URL + "}")
    private String bankURL;
    @Value("${" + CAL_MONTHLY_INTEREST + "}")
    private String getCalMonthlyInterest;
    @Mock
    private InterestCalculatorService interestCalculatorService;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private String requestJson;
    private InterestCalculator interestCalculator;

    /**
     * Initial Setup.
     *
     * @throws Exception exception
     */
    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        interestCalculator = new InterestCalculator(ACCOUNT_NO, BALANCE, INTEREST_RATE);
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        final ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        requestJson = ow.writeValueAsString(interestCalculator);
    }

    /**
     * test method calculate monthly interest.
     *
     * @throws Exception exception if fail
     */
    @Test
    public void testCalMonthlyInterest() throws Exception {
        when(interestCalculatorService.calculateMonthlyInterest(any(InterestCalculator.class))).thenReturn(BALANCE);
        mockMvc.perform(MockMvcRequestBuilders.post(bankURL + getCalMonthlyInterest)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestJson)).andExpect(status().isCreated());
    }
}
