package Model

class Kambing(nama:String,type:String,usia:String):Hewan(nama,type,usia) {
    override fun makesound(): String {
        return "mbek mbek mbek"
    }
}