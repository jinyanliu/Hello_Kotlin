package buildings

fun main() {
    val woodBuilding = Building(Wood())
    woodBuilding.build()
}

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood : BaseBuildingMaterial(4)

class Brick : BaseBuildingMaterial(8)

class Building<T : BaseBuildingMaterial>(
    val buildingMaterial: T,
    val baseMaterialsNeeded: Int = 100,
    val actualMaterialsNeeded: Int = buildingMaterial.numberNeeded * baseMaterialsNeeded
) {
    fun build() {
        println("$actualMaterialsNeeded ${buildingMaterial::class.simpleName} required")
    }
}