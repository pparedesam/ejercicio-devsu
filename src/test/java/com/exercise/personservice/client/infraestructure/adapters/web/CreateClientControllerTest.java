package com.exercise.personservice.client.infraestructure.adapters.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

import com.exercise.personservice.client.application.dtos.ClientRequestDto;
import com.exercise.personservice.client.application.port.CreateClientPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CreateClientController.class)
public class CreateClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateClientPort createClientPort;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createClient_ShouldCreateClient() throws Exception {
        ClientRequestDto clientRequestDto = mock(ClientRequestDto.class,RETURNS_MOCKS); // Configura este objeto según tus necesidades

        mockMvc.perform(post("/v1/client")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(clientRequestDto)))
                .andExpect(status().isOk());

        verify(createClientPort, times(1)).execute(any(ClientRequestDto.class));
    }
}
