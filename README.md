# Kotlin-Delegates

Just some rather experimental custom kotlin delegates. Use with caution.

## Usage Examples

### AutoSwitch

`AutoSwitch` is a delegate that automatically inverts its value upon calling its getter if the current value is equal to the specified switch condition.

```kotlin
// Create an AutoSwitch delegate with an initial value of false and switch condition true
var flag by AutoSwitch(value = false, switchOn = true)

// Access the value, automatically inverting it if it equals the switch condition
println(flag) // Output: false
println(flag) // Output: true
```

### AutoSwitch.Mapped

`AutoSwitch.Mapped` combines the functionality of `AutoSwitch` with that of a map delegate, allowing you to toggle boolean values stored in a mutable map.

```kotlin
// Create a mutable map to store boolean values
val booleanMap = mutableMapOf("isEnabled" to false, "isActivated" to true)

// Create an AutoSwitch.Mapped delegate using the map and a switch condition
val isEnabled by AutoSwitch.Mapped(booleanMap, switchOn = true)

// Access the value, automatically toggling it in the map
println(isEnabled) // Output: false
println(isEnabled) // Output: true

// The boolean value in the map has been toggled
println(booleanMap["isEnabled"]) // Output: true
```

### Consumable

`Consumable` is a delegate for objects that should be retrieved exactly once. After getting its value, it will be automatically set to null.

```kotlin
// Create a Consumable delegate with an initial value
val data by Consumable("Hello, World!")

// Access the value, consuming it and setting it to null
println(data) // Output: Hello, World!
println(data) // Output: null

// Check if the value has been consumed
println(data.isConsumable) // Output: false
```

### MapObservable

`MapObservable` is a delegate that combines the functionality of a map delegate with that of an observable. It notifies a callback function when a property's value changes.

```kotlin
// Create a mutable map to store values
val dataMap = mutableMapOf("counter" to 0)

// Create a MapObservable delegate with a callback function
val counter by MapObservable(dataMap) { property, oldValue, newValue ->
    println("${property.name} changed from $oldValue to $newValue")
}

// Access the value, triggering the callback function
counter = 42
// Output: counter changed from 0 to 42
```
