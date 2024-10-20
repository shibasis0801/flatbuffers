// automatically generated by the FlatBuffers compiler, do not modify

package reaktor.sample

import com.google.flatbuffers.kotlin.*
import kotlin.jvm.JvmInline
@Suppress("unused")
class Weapon : Table() {

    fun init(i: Int, buffer: ReadWriteBuffer) : Weapon = reset(i, buffer)

    val name : String? get() = lookupField(4, null ) { string(it + bufferPos) }
    fun nameAsBuffer() : ReadBuffer = vectorAsBuffer(bb, 4, 1)

    val damage : Short get() = lookupField(6, 0 ) { bb.getShort(it + bufferPos) }

    companion object {
        fun validateVersion() = VERSION_2_0_8
        fun asRoot(buffer: ReadWriteBuffer) : Weapon = asRoot(buffer, Weapon())
        fun asRoot(buffer: ReadWriteBuffer, obj: Weapon) : Weapon = obj.init(buffer.getInt(buffer.limit) + buffer.limit, buffer)
        fun createWeapon(builder: FlatBufferBuilder, nameOffset: Offset<String>, damage: Short) : Offset<Weapon> {
            builder.startTable(2)
            addName(builder, nameOffset)
            addDamage(builder, damage)
            return endWeapon(builder)
        }
        fun startWeapon(builder: FlatBufferBuilder) = builder.startTable(2)
        fun addName(builder: FlatBufferBuilder, name: Offset<String>) = builder.add(0, name, 0)
        fun addDamage(builder: FlatBufferBuilder, damage: Short) = builder.add(1, damage, 0)
        fun endWeapon(builder: FlatBufferBuilder) : Offset<Weapon> {
            val o: Offset<Weapon> = builder.endTable()
            return o
        }
    }
}

typealias WeaponOffsetArray = OffsetArray<Weapon>

inline fun WeaponOffsetArray(size: Int, crossinline call: (Int) -> Offset<Weapon>): WeaponOffsetArray =
    WeaponOffsetArray(IntArray(size) { call(it).value })
