package Model

class Sapi(nama:String,type:String,usia:String):Hewan(nama,type,usia) {
    override fun makesound(): String {
        return "mow mow mow"
    }
}