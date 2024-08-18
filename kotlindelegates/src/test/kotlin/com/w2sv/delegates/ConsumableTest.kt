package com.w2sv.delegates

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ConsumableTest {

    private var consumable by Consumable<Int>()

    @Test
    fun settingAndValueConsumptionOnGetValue() {
        Assertions.assertNull(consumable)

        consumable = 69
        Assertions.assertEquals(69, consumable)
        Assertions.assertNull(consumable)
    }
}