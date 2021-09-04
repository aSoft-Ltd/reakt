package reakt

class Action<T>(val name: String, val handler: (T) -> Unit)