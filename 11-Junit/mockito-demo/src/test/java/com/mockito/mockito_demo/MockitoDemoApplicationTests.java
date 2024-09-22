package com.mockito.mockito_demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class MockitoDemoApplicationTests {

	@Test
	void simpleTest() {
		List listMock = mock(List.class);

		//listMock.size() => 3
		when(listMock.size()).thenReturn(3);
		assertEquals(3, listMock.size());
	}

	@Test
	void multipleReturns() {
		List listMock = mock(List.class);

		when(listMock.size()).thenReturn(1).thenReturn(2);
		assertEquals(1, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}

	@Test
	void parameter() {
		List listMock = mock(List.class);

		when(listMock.get(0)).thenReturn("SomeString");
		assertEquals("SomeString", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	@Test
	void parameter_multiple() {
		List listMock = mock(List.class);

		when(listMock.get(Mockito.anyInt())).thenReturn("SomeString");
		assertEquals("SomeString", listMock.get(0));
		assertEquals("SomeString", listMock.get(1));
	}

}
