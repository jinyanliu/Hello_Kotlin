package aquarium.generics

fun main() {
    genericExample()
}

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false
        println("addChemicalCleaners")
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
        println("filter")
    }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }
        check(!waterSupply.needsProcessed) { "water supply needs processed!" }
        println("adding water from $waterSupply")
    }
}

inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean:${aquarium.waterSupply.needsProcessed}")
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added ${aquarium.waterSupply.needsProcessed}")

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

class LakeWaterCleaner : Cleaner<LakeWater> {
    override fun clean(waterSupply: LakeWater) {
        waterSupply.filter()
    }
}

inline fun <reified T : WaterSupply> WaterSupply.isOfType() = this is T

fun genericExample() {
    val aquarium = Aquarium(TapWater())
    val cleaner = TapWaterCleaner()
    aquarium.addWater(cleaner)
    addItemTo(aquarium)
    isWaterClean(aquarium)
    println(aquarium.hasWaterSupplyOfType<TapWater>())
    println(aquarium.hasWaterSupplyOfType<LakeWater>())
    println(aquarium.waterSupply.isOfType<LakeWater>())

    println("\n\n")

    val aquarium4 = Aquarium(LakeWater())
    val cleaner4 = LakeWaterCleaner()
    aquarium4.addWater(cleaner4)
    isWaterClean(aquarium4)
}