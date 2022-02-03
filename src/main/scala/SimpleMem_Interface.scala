import chisel3._

class SimpleMem_Interface extends Bundle {
  val addr = Input(UInt(4.W))
  val wren = Input(Bool())
  val wrdata = Input(UInt(16.W))
  val rddata = Output(UInt(16.W))
}
