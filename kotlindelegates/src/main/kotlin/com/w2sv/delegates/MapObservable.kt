@file:Suppress("unused")

package com.w2sv.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Delegate, combining the functionality of a map delegate and an observable.
 *
 * Reference: https://stackoverflow.com/a/52814429/12083276
 */
class MapObservable<T>(
    private val map: MutableMap<String, T>,
    private val observe: ((property: KProperty<*>, oldValue: T, newValue: T) -> Unit)
) : ReadWriteProperty<Any?, T> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): T =
        map.getValue(property.name)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        val oldValue = getValue(thisRef, property)
        map[property.name] = value
        observe(property, oldValue, value)
    }
}