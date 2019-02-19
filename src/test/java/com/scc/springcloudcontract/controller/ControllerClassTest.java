package com.scc.springcloudcontract.controller;

import org.junit.Assert;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
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
    public void given_Stubs_When_CallingStubsLocally_Then_ReturnSuccessReponse() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/endpoint1");

        this.mvc.perform(builder)
                .andDo(print())
                .andExpect(status()
                        .isOk())
        .andExpect(content().json("[\n" +
                "\t{\n" +
                "\t\t'userId': 1,\n" +
                "\t\t'id': 1,\n" +
                "\t\t'title': 'sunt aut facere repellat provident occaecati excepturi optio reprehenderit',\n" +
                "\t\t'body': 'quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto'\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t'userId': 1,\n" +
                "\t\t'id': 2,\n" +
                "\t\t'title': 'qui est esse',\n" +
                "\t\t'body': 'est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla'\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t'userId': 1,\n" +
                "\t\t'id': 3,\n" +
                "\t\t'title': 'ea molestias quasi exercitationem repellat qui ipsa sit aut',\n" +
                "\t\t'body': 'et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut'\n" +
                "\t}\n" +
                "]"));
    }


    @Test(expected = AssertionError.class)
    public void given_Stubs_When_AssertingIncorrectJsonStaticResponse_Then_ThrowAssertionError() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/endpoint1");

        this.mvc.perform(builder)
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(content().json("[\n" +
                        "\t{\n" +
                        "\t\t'userId': 1,\n" +
                        "\t\t'id': 1,\n" +
                        "\t\t'title': 'sunt aut facere repellat provident occaecati excepturi optio reprehenderit',\n" +
                        "\t\t'body': 'quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto'\n" +
                        "\t},\n" +
                        "\t{\n" +
                        "\t\t'userId': 1,\n" +
                        "\t\t'id': 2,\n" +
                        "\t\t'title': 'qui est esse',\n" +
                        "\t\t'body': 'est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla'\n" +
                        "\t},\n" +
                        "\t{\n" +
                        "\t\t'userId': 1,\n" +
                        "\t\t'id': 3,\n" +
                        "\t\t'title': 'ea molestias quasi exercitationem repellat qui ipsa sit aut',\n" +
                        "\t\t'body': 'et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut'\n" +
                        "\t},\n" +
                        "\t{\n" +
                        "\t\t'userId': 1,\n" +
                        "\t\t'id': 4,\n" +
                        "\t\t'title': 'ea molestias quasi exercitationem repellat qui ipsa sit aut',\n" +
                        "\t\t'body': 'et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut'\n" +
                        "\t}\n" +
                        "]"));

    }
}