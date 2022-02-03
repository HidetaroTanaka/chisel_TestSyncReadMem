import chisel3._
import chisel3.util._
import chisel3.stage.ChiselStage
import chisel3.util.experimental.loadMemoryFromFile

class VecMem extends Module {
  val io = IO(new VecMem_Interface())
  val m_mem = Mem(16, Vec(4, UInt(4.W)))
  loadMemoryFromFile(m_mem, "src/main/resources/simple_mem_data.mem")

  when(io.wren) {
    m_mem.write(io.addr, io.wrdata, io.wrstrb.asBools)
  }

  io.rddata := Cat(m_mem.read(io.addr))
}

object convertVecMem extends App {
  (new ChiselStage).emitVerilog(new VecMem)
}
