import chisel3._

class VecMem_Interface extends Bundle{
  val addr = Input(UInt(4.W))
  val wren = Input(Bool())
  val wrstrb = Input(UInt(4.W))
  val wrdata = Input(Vec(4, UInt(4.W)))
  val rddata = Output(UInt(16.W))
}
