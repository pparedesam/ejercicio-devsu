package com.exercise.personservice.client.application.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.application.mapper.ClientMapper;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

public class GetClientUseCaseTest {

    @Mock
    private GetClientRepository getClientRepository;

    @InjectMocks
    private GetClientUseCase getClientUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void execute_ShouldReturnListOfClients() {
        Long idClient = 1L; // ID de cliente de ejemplo
        Client mockClient = mock(Client.class,RETURNS_MOCKS);

        when(getClientRepository.findById(idClient)).thenReturn(mockClient);

        ClientResponseDto result =  getClientUseCase.findById(1L);

        // Verificar el resultado
        assertNotNull(result);

        verify(getClientRepository,times(1)).findById(idClient);
    }
}
