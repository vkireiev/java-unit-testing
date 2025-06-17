package ua.vkireiev.testing.module04.exercise0404;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class CartTest {
    private List<String> list = List.of("org", "junit", "jupiter", "api", "extension", "ExtendWith");

    @Spy
    private List<String> spyArrayList = new ArrayList<>(list);

    @InjectMocks
    private Cart cartTest;

    @Test
    void test() {
        final int unboundIndex = list.size();

        Mockito.when(spyArrayList.remove(Mockito.anyInt()))
            .then(invocation -> {
                return "Item" + invocation.getArgument(0);
            });

        assertNull(cartTest.removeItem(-1));
        assertNull(cartTest.removeItem(unboundIndex));

        assertEquals("Item1", cartTest.removeItem(1));
        assertEquals("Item0", cartTest.removeItem(0));

        Mockito.verify(spyArrayList, Mockito.never()).remove(-1);
        Mockito.verify(spyArrayList, Mockito.never()).remove(unboundIndex);
        Mockito.verify(spyArrayList, Mockito.times(1)).remove(1);
        Mockito.verify(spyArrayList, Mockito.times(1)).remove(0);
    }
}
