package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.UpdateClientRepository;
import com.exercise.personservice.person.application.port.UpdatePersonPort;
import com.exercise.personservice.person.domain.entities.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UpdateClientUseCaseTest {

    @Mock
    private UpdateClientRepository updateClientRepository;

    @Mock
    private UpdatePersonPort updatePersonPort;

    @InjectMocks
    private UpdateClientUseCase updateClientUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void update_ShouldUpdateClientAndPerson() {

        Client mockClient = new Client();
        Person mockPerson = new Person();
        mockClient.setPerson(mockPerson);

        when(updatePersonPort.update(mockPerson)).thenReturn(mockPerson);
        when(updateClientRepository.update(mockClient)).thenReturn(mockClient);
        
        Client updatedClient = updateClientUseCase.update(mockClient);

        assertNotNull(updatedClient, "El cliente actualizado no debe ser nulo");
        assertEquals(mockPerson, updatedClient.getPerson(), "La persona actualizada debe coincidir");
        verify(updatePersonPort).update(mockPerson);
        verify(updateClientRepository).update(mockClient);
    }
}
