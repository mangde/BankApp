/*
 *
 *  COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 * /
 *
 */
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
import com.nuance.him.model.atm.AtmDetail;
import com.nuance.him.service.atm.AtmService;
import java.util.List;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for {@link com.nuance.him.controller.atm.AtmController}.
 */
@WebAppConfiguration
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes = TestControllerConfig.class)
public class AtmControllerTest extends AbstractTestNGSpringContextTests {

    private static final String BASE_URL = "baseURL";
    private static final String ISSUE_ATM = "Atm.issueAtm";
    private static final String DISPLAY_ALL_ATM="Atm.displayAllAtmDetail";
    private static final String IS_ATM_ALREADY_TAKEN="Atm.isAtmAlreadyTaken";
    private static final int ATM_NUMBER = 123456;
    private static final int ACC_NUMBER = 3;
    private static final int CVV_NUMBER = 723;
    private static final String CARD_TYPE = "visa";
    @Value("${" + BASE_URL + "}")
    private String bankURL;
    @Value("${" + ISSUE_ATM + "}")
    private String getIssueAtm;
    @Value("${" + DISPLAY_ALL_ATM + "}")
    private String getDisplayAllAtm;

    @Value("${" + IS_ATM_ALREADY_TAKEN + "}")
    private String getIsAtmAlreadyTaken;

    @Mock
    private AtmService atmService;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private String requestJson;
    private AtmDetail atmDetail;
    private List<AtmDetail> atmDetails;


    /**
     * Initial Setup.
     *
     * @throws Exception exception
     */
    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        atmDetail = new AtmDetail(ATM_NUMBER, ACC_NUMBER,CVV_NUMBER,  CARD_TYPE);
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        final ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        requestJson = ow.writeValueAsString(atmDetail);
    }

    /**
     * test url IssueAtm method.
     *
     * @throws Exception exception
     */
    @Test
    public void testIssueAtm() throws Exception {
        when(atmService.issueAtmCard(any(AtmDetail.class))).thenReturn(atmDetail);
        mockMvc.perform(MockMvcRequestBuilders.post(bankURL+getIssueAtm)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestJson)).andExpect(status().isCreated());
    }

    /**
     * customer display customer method.
     *
     * @throws Exception exception
     */
    @Test
    public void testDisplayAtmDetails() throws Exception {
        when(atmService.displayAllAtmDetail()).thenReturn(atmDetails);
        mockMvc.perform(MockMvcRequestBuilders.get(bankURL+getDisplayAllAtm))
            .andExpect(status().isOk());
    }

}
