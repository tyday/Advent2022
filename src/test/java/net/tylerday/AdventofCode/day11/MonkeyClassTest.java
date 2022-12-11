package net.tylerday.AdventofCode.day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyClassTest {

    @Test
    void createMonkey() {
        List<String> data = List.of(
                "Monkey 0:",
                "  Starting items: 78, 53, 89, 51, 52, 59, 58, 85",
                "  Operation: new = old * 3",
                "  Test: divisible by 5",
                "    If true: throw to monkey 2",
                "    If false: throw to monkey 7"
        );
        Monkey monkey = new Monkey(data);

        assertEquals(0, monkey.number);

        assertEquals(8, monkey.itemList.size());
        assertEquals(78, monkey.itemList.get(0).val);
        assertEquals(85, monkey.itemList.get(7).val);

        assertEquals("new = old * 3", monkey.operation.descriptor);

        assertEquals("divisible by 5", monkey.test.descriptor);
        assertEquals(2, monkey.test.throwToIfTrue);
        assertEquals(7, monkey.test.throwToIfFalse);

    }
}