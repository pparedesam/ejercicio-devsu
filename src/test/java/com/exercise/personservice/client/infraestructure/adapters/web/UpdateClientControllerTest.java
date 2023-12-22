package com.exercise.personservice.client.infraestructure.adapters.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.application.port.UpdateClientPort;
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
@WebMvcTest(UpdateClientController.class)
public class UpdateClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UpdateClientPort updateClientPort;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateClient_ShouldUpdateClient() throws Exception {
        Client client = new Client(); // Configura esta entidad según tus necesidades
        when(updateClientPort.update(any(Client.class))).thenReturn(client);

        mockMvc.perform(put("/v1/client")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(client)))
                .andExpect(status().isOk());

        verify(updateClientPort, times(1)).update(any(Client.class));
    }
}
