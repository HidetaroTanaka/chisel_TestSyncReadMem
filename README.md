# chisel_TestSyncReadMem

ChiselのSyncReadMemをFPGAで使おう的なやつ

リポジトリをクローン
```sh
git clone https://github.com/HidetaroTanaka/chisel_TestSyncReadMem
```

IntelliJで該当フォルダでsbtのプロジェクトを作る

convertMainを実行

出てきた`Main.v`のSimpleMemモジュールの中に次のような記述がある
```verilog
  reg [15:0] m_mem [0:15]; // @[SimpleMem.scala 7:18]
  wire  m_mem_io_rddata_MPORT_en; // @[SimpleMem.scala 7:18]
```

この間に次のようにreadmemhを入れる

```verilog
  reg [15:0] m_mem [0:15]; // @[SimpleMem.scala 7:18]

  initial begin
    $readmemh("simple_mem_data.mem", m_mem);
  end

  wire  m_mem_io_rddata_MPORT_en; // @[SimpleMem.scala 7:18]
```

`Main.v`と`simple_mem_data.mem`をVivadoに入れる．Nexys4では動作確認済．
