package com.scc.springcloudcontract.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@AutoConfigureStubRunner(
//        stubsMode = StubRunnerProperties.StubsMode.REMOTE,
//        repositoryRoot = "git://https://github.com/jabrena/spring-cloud-contract-git.git",
//        ids = {
//                "org.jab.microservices:spring-cloud-contract-git-producer-poc:0.1.0-SNAPSHOT",
//                "org.jab.microservices:spring-cloud-contract-git-producer-poc2:0.1.0-SNAPSHOT"
//        })
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.REMOTE,
        repositoryRoot = "git://https://github.com/xjuste/sccpoc.git",
        ids = {"com.toutjuste:sccpoc:0.0.1-SNAPSHOT:stubs:8092"
}
)
@ActiveProfiles("test")
public class ControllerClassTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void getDetails() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/endpoint1");

        this.mvc.perform(builder)
                .andDo(print())
                .andExpect(status()
                        .isOk());
    }
}