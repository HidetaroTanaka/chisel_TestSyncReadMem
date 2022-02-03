import chisel3._
import chisel3.util._
import chisel3.stage.ChiselStage

class Main extends Module{
  val io = IO(new SimpleMem_Interface())
  val sMem0 = Module(new SimpleMem())
  val wren_reg = RegInit(false.B)
  wren_reg := io.wren
  io <> sMem0.io
  sMem0.io.wren := !wren_reg && io.wren
}

object convertMain extends App {
  (new ChiselStage).emitVerilog(new Main)
}

