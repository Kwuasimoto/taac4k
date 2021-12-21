package lib.ta4j.indicators

interface SMAIndicatorNodes {
    val close: Close
}

interface MACDIndicatorNodes : SMAIndicatorNodes {
    val sma: SMA
}