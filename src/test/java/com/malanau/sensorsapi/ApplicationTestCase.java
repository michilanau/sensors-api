package com.malanau.sensorsapi;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class ApplicationTestCase {
    @Autowired private MockMvc mockMvc;

    public void assertResponse(
            final String endpoint, final Integer expectedStatusCode, final String expectedResponse)
            throws Exception {

        final ResultMatcher response =
                expectedResponse.isEmpty()
                        ? content().string("")
                        : content().json(expectedResponse);

        mockMvc.perform(get(endpoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response);
    }

    public void assertRequestWithBody(
            final String method,
            final String endpoint,
            final String body,
            final Integer expectedStatusCode)
            throws Exception {

        mockMvc.perform(
                        request(HttpMethod.valueOf(method), endpoint)
                                .content(body)
                                .contentType(APPLICATION_JSON))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(content().string(""));
    }
}
