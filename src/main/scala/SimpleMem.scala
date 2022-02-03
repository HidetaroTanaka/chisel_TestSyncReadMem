import chisel3._
import chisel3.stage.ChiselStage
import chisel3.util.experimental.loadMemoryFromFile

class SimpleMem extends Module {
  val io = IO(new SimpleMem_Interface())
  val m_mem = Mem(16, UInt(16.W))
  loadMemoryFromFile(m_mem, "src/main/resources/simple_mem_data.mem")

  when(io.wren) {
    m_mem.write(io.addr, io.wrdata)
  }

  io.rddata := m_mem.read(io.addr)
}

object convertSimpleMem extends App {
  (new ChiselStage).emitVerilog(new SimpleMem)
}
