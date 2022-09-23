package Model

class Ayam(nama:String,type:String,usia:String):Hewan(nama,type,usia) {
    override fun makesound(): String {
        return "Pok pok pok"
    }
}