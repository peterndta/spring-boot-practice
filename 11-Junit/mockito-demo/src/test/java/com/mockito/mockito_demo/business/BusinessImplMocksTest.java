package com.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BusinessImplMocksTest {

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

    @Test
    void findTheGreatestFromAllData_OneValue() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});

        BusinessImpl business = new BusinessImpl(dataServiceMock);
        int result = business.findTheGreatestFromAllData();
        assertEquals(35, result);
    }
}