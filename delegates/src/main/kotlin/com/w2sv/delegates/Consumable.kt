@file:Suppress("unused")

package com.w2sv.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Delegate of objects, who are to be retrieved exactly once.
 * After getting (consuming) its value, it will be automatically set to null.
 */
class Consumable<T>(private var value: T? = null) : ReadWriteProperty<Any, T?> {

    val isConsumable: Boolean
        get() = value != null

    override fun getValue(thisRef: Any, property: KProperty<*>): T? =
        value
            .also { value = null }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T?) {
        this.value = value
    }
}