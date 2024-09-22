package com.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class BusinessImplMocksTest {

    @Mock DataService dataServiceMock;
    @InjectMocks BusinessImpl business;

    // Mockito manual without Annotation
    @Test
    void findTheGreatestFromAllData() {
        DataService dataServiceMock = mock(DataService.class);
        // dataServiceMock.retrieveAllData() => new int[] {25, 15, 5}
        // Khi method retrieveAllData được gọi thì sẽ return array int[] như dưới
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});

        BusinessImpl business = new BusinessImpl(dataServiceMock);
        int result = business.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

    // Mockito Annotation
    @Test
    void findTheGreatestFromAllData_OneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
        int result = business.findTheGreatestFromAllData();
        assertEquals(35, result);
    }
}