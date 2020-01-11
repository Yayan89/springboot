package com.datyan.testingunits;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

//1. Use RunWith -Junit4
//@RunWith(MockitoJUnitRunner.class)
//2. In this case we using  MockitoExtension - Junit5
@ExtendWith(MockitoExtension.class)
public class TestWithout_Spring {
    //3. Run with Mockito Rule - Junit4
//    @Rule
//    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    Person person;

    @Test
    public void testMockito() {
        Mockito.when(person.getFirstName())
            .thenAnswer(invocation -> "Stub worked");

        String firstName = person.getFirstName();

        Mockito.verify(person).getFirstName();
    }
}
