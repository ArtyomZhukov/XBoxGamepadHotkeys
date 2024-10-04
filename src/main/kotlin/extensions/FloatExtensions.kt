package extensions

fun Float.normalized(value: Float = NORMALIZATION_VALUE): Boolean {
    return this < -value || value < this
}

private const val NORMALIZATION_VALUE = 0.05f
