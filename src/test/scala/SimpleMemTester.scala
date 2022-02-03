import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SimpleMemTester extends AnyFlatSpec with ChiselScalatestTester with Matchers {
  behavior of "Alexi"
  it should "Alive" in {
    test(new SimpleMem) { c =>
      c.reset.poke(true.B)
      c.clock.step()
      c.reset.poke(false.B)
      c.io.addr.poke("b0010".U)
      println(c.io.rddata.peek())
      c.io.wren.poke(true.B)
      c.io.wrdata.poke("h1234".U)
      c.clock.step()
      println(c.io.rddata.peek())
    }
  }
}
