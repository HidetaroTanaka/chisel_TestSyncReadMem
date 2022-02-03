# chisel_TestSyncReadMem

ChiselのSyncReadMemをFPGAで使おう的なやつ

メモリ書き込みを手動でやる前提なので`wren`の挙動に注意

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

`Main.v`と`simple_mem_data.mem`をVivadoに入れて適当になんやかんやする．Nexys4では動作確認済．
