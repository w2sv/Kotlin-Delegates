package com.w2sv.delegates

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AutoSwitchTest {

    @Test
    fun test() {
        var autoSwitch by AutoSwitch(value = false, switchOn = false)
        Assertions.assertFalse(autoSwitch)
        Assertions.assertTrue(autoSwitch)

        autoSwitch = false
        Assertions.assertFalse(autoSwitch)
    }
}