# taac4k 📉✔️📈

### Technical Analysis and Conditions 4 Kotlin (Alpha 0.0.1)

---

*A developer friendly library built with ease of use and extension of functionality in mind.*<br>

Utilizes market data providers to supply transformed data that is compatible with <br>
technical analysis indicators and their respective conditions.

Dokka docs: https://www.taac4k.org/<br>

---

*Help motivate me, and allow me to survive off of coffee*☕.<br>
Wallet Chain: BTC <br>
Bitcoin Wallet: 19PK3apvaQ54MP62nYULtYXH6SWenv81a9

---

### Basic Usage


1. Instantiate a data provider to fetch a MutableList of MarketData
```kotlin
// PolygonDataProvider() OR Polygon()
// NOTE: Apple stock data is fetched by default 
// if the ticker is not overriden in the constructor.

// instantiate a provider
val polygonDataProvider: PolygonDataProvider = PolygonDataProvider()

// get data prepared for conditions.
val aaplMarketData: MutableList<MarketData> = 
    polygonDataProvider.getAggregates(1, "minute", "2019-01-01")
```

2. Create a ConditionalIndicator with the fetched data.<br>
```kotlin
// RSI() or Close()
val aaplClose: Close = Close(aaplDataList)
```

3. Compare the booleans returned from conditions methods
```kotlin
// Better Examples coming soon, check tests for most stuff.

/**
 * Compare data against itself.
 */
// Check if the immediate candles are rising.
aaplClose.conditions.isRising()

// Check if x number of candles in a range are rising.
aaplClose.conditions.isRising(leftBarIndex = appleDataList.size - 5)

// ---------------------------------------------------------------------------------------

/** 
 * Compare data against another MutableList<MarketData>.
 */

// Create a line to cross 
// (Could be any list of values, all searches default to the close value of a bar of data)
val fakeDataList: MutableList<MarketData> = mutableListOf()
val builder: MarketDataBuilder = BaseMarketDataBuilder()

for (i in 0 until 100)
    fakeDataList.add(builder.close(303.24).build())

aaplClose.conditions.crossUnder(fakeDataList, startValueIndex = appleDataList.size - 9)
```


