library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity MIPS is
    Port ( clk : in STD_LOGIC;
           btn : in STD_LOGIC_VECTOR (4 downto 0);
           sw : in STD_LOGIC_VECTOR (15 downto 0);
           led : out STD_LOGIC_VECTOR (15 downto 0);
           an : out STD_LOGIC_VECTOR (3 downto 0);
           cat : out STD_LOGIC_VECTOR (6 downto 0));
end MIPS;

architecture Behavioral of MIPS is

component MPG is
    Port ( buton_db : out STD_LOGIC;
           buton : in STD_LOGIC;
           clock : in STD_LOGIC);
end component;

component InstructionDecoder is
--  Port ( ); 
   PORT(RegWrite: in std_logic;
        Instr: in std_logic_vector(15 downto 0);
        RegDst: in std_logic;
        ExtOp: in std_logic;
        WD: in std_logic_vector(15 downto 0);
        WA:in std_logic_vector(2 downto 0);
        RD1: out std_logic_vector(15 downto 0);
        RD2: out std_logic_vector(15 downto 0);
        Ext_Imm: out std_logic_vector(15 downto 0);
        func: out std_logic_vector(2 downto 0);
        sa: out std_logic;
        en: in std_logic;
        clk:in std_logic);
        
end component;
 
component Afisor_7_segmente is
     Port( 
     
          DIGIT0: in std_logic_vector(3 downto 0); 
          DIGIT1:in std_logic_vector(3 downto 0); 
          DIGIT2: in std_logic_vector(3 downto 0); 
          DIGIT3:in std_logic_vector(3 downto 0);
          clk: in std_logic ;
          ANOD:out std_logic_vector(3 downto 0);
          CATOD:out std_logic_vector(6 downto 0));
end component;

component InstructionFetch is
    Port ( clk: in std_logic;
    PCSrc: in std_logic;
    Jump: in std_logic;
    JA: in std_logic_vector(15 downto 0);
    BA: in std_logic_vector(15 downto 0);
    Enable: in std_logic;
    Reset: in std_logic;
    Instruction: out std_logic_vector(15 downto 0);
    pc_1: out std_logic_vector(15 downto 0) );
end component;

 component UC is 
   Port( OpCode: in std_logic_vector(2 downto 0);
         RegDst : out std_logic  ;
         ExtOp : out std_logic ;
         ALUSrc : out std_logic ;
         Branch : out std_logic ;
         Jump : out std_logic ;
         ALUOp : out std_logic_vector(2 downto 0) ;
         MemWrite : out std_logic ;
         MemtoReg : out std_logic ;
         RegWrite : out std_logic );
 end component;  
   
 component EX is
     Port(
         RD1: in std_logic_vector(15 downto 0);
         AluSrc: in std_logic;
         RD2: in std_logic_vector(15 downto 0);
         Ext_Imm :in std_logic_vector(15 downto 0);
         sa : in std_logic;
         func: in std_logic_vector(2 downto 0);
         ALUOP : in std_logic_vector(2 downto 0);
         PCPlus1: in std_logic_vector(15 downto 0);
         Zero : out std_logic;
         ALURes: out std_logic_vector(15 downto 0);
         BranchAdress: out std_logic_vector(15 downto 0));
 end component;
 component Unitatea_MEM is
--  Port ( );
    Port ( MemWrite : in std_logic;
           MPG_EN : in std_logic;
           ALURes : in std_logic_vector(15 downto 0);
           RD2 : in std_logic_vector(15 downto 0);
           ALUResOut: out std_logic_vector( 15 downto 0);
           CLK: in std_logic;
           MemData : out std_logic_vector (15 downto 0));
end component;

component IF_ID is
Port (Instruction: in std_logic_vector(15 downto 0);
        pc_next: in std_logic_vector(15 downto 0 ) ;
        clock:in std_logic;
        enable: in std_logic;
        Instruction_out: out std_logic_vector(15 downto 0);
        pc_next_out: out std_logic_vector(15 downto 0 ) );
end component;

component ID_EX is
  Port ( clock:in std_logic;
       enable: in std_logic;
       Instruction: in std_logic_vector(15 downto 0);
       pc_next: in std_logic_vector(15 downto 0 ) ;
       Ext_imm:in std_logic_vector(15 downto 0);
       rd1: in std_logic_vector(15 downto 0);
       rd2: in std_logic_vector(15 downto 0);
       Ex: in std_logic_vector(4 downto 0);
       M: in std_logic_vector(1 downto 0);
       WB: in  std_logic_vector(1 downto 0);
       Instruction_out: out std_logic_vector(15 downto 0);
       pc_next_out: out std_logic_vector(15 downto 0 ) ;
       Ext_imm_out:out std_logic_vector(15 downto 0);
       rd1_out: out std_logic_vector(15 downto 0);
       rd2_out: out std_logic_vector(15 downto 0);
       Ex_out: out std_logic_vector(4 downto 0);
       M_out: out std_logic_vector(1 downto 0);
       WB_out: out  std_logic_vector(1 downto 0));
end component;

component EX_MEM is
Port (  clock:in std_logic;
        enable: in std_logic;
        rd2: in std_logic_vector(15 downto 0);
        alu_res: in std_logic_vector(15 downto 0 ) ;
        WriteAddress: in std_logic_vector(2 downto 0);
        zero: in std_logic;
        M: in std_logic_vector(1 downto 0);
        WB: in std_logic_vector(1 downto 0);
        BranchAddress : in std_logic_vector(15 downto 0);
        rd2_out: out std_logic_vector(15 downto 0);
        alu_res_out: out std_logic_vector(15 downto 0 ) ;
        WriteAddress_out: out std_logic_vector(2 downto 0);
        zero_out: out std_logic;
        M_out: out std_logic_vector(1 downto 0);
        WB_out: out std_logic_vector(1 downto 0);
        BranchAddress_out : out std_logic_vector(15 downto 0));
end component;

component MEM_WB is
  Port (clock:in std_logic;
        enable: in std_logic;
        WriteData: in std_logic_vector(15 downto 0);
        WriteAddress: in std_logic_vector(2 downto 0 );
        WB: in std_logic_vector(1 downto 0);
        alu_res: in std_logic_vector(15 downto 0);
        WriteData_out: out std_logic_vector(15 downto 0);
        WriteAddress_out: out std_logic_vector(2 downto 0 );
        WB_out: out std_logic_vector(1 downto 0);
        alu_res_out: out std_logic_vector(15 downto 0) );
end component;

signal enableEN: std_logic;
signal enableRESET: std_logic;
signal JumpControl: std_logic;
signal ZeroAlu: std_logic;
signal BranchControl:std_logic;
signal PcSrcM: std_logic;
signal JumpAdress : std_logic_vector(15 downto 0);
signal PcPlus1: std_logic_vector(15 downto 0);
signal Instr: std_logic_vector(15 downto 0);
signal BranchAdress: std_logic_vector(15 downto 0);
signal ExtUnit_IMM: std_logic_vector(15 downto 0);
signal RegWriteControl: std_logic;
signal RegDstControl:std_logic;
signal ExtOpControl:std_logic;
signal WDMemorie:std_logic_vector(15 downto 0);
signal RD1REG:std_logic_vector(15 downto 0);
signal RD2REG:std_logic_vector(15 downto 0);
signal Func_Reg: std_logic_vector(2 downto 0);
signal Sa_Reg: std_logic;
signal AluSrc_Control: std_logic ;
signal AluOpControl: std_logic_vector(2 downto 0);
signal MemWriteControl,Zero3: std_logic;
signal MemtoRegControl: std_logic;
signal AluRes: std_logic_vector (15 downto 0);
signal AluResMemoryOut: std_logic_vector(15 downto 0);
signal MemoryMemData: std_logic_vector(15 downto 0);
signal SSD_in :std_logic_vector(15 downto 0);
signal SSD_in1: std_logic_vector(3 downto 0);
signal SSD_in2: std_logic_vector(3 downto 0);
signal SSD_in3: std_logic_vector(3 downto 0);
signal SSD_in4: std_logic_vector(3 downto 0);
signal PcNext1,PcNext2,Instruction1,Instruction2,RD12,RD22,RD23,AluRes3,AluRes4,MemData4,Ext_imm2,BranchAddress3: STD_LOGIC_VECTOR(15 downto 0);
signal exReg,exReg2 : STD_LOGIC_VECTOR(4 downto 0);
signal mReg,mReg2,mReg3 : STD_LOGIC_VECTOR(1 downto 0);
signal wbReg,wbReg2,wbReg3,wbReg4 : STD_LOGIC_VECTOR(1 downto 0);
signal WriteAddress,WriteAddress3,WriteAddress4 : STD_LOGIC_VECTOR(2 downto 0);
begin

     MPG_map: MPG port map(buton => btn(0), buton_db => enableEN, clock => clk);
     MPG2_map: MPG port map(buton => btn(1), buton_db => enableRESET, clock => clk);
     wbReg(0)<=MemtoRegControl;
     wbReg(1)<=RegWriteControl;
     mReg(0)<=BranchControl;
     mReg(1)<=MemWriteControl;
     exReg(0)<=RegDstControl;
     exReg(1)<=AluSrc_Control;
     exReg(4 downto 2)<=AluOpControl;
     
     PcSrcM<=mReg3(0) and Zero3;
     JumpAdress<= PcNext1(15 downto 13) & Instruction1(12 downto 0);
     INSTFETCH_map: InstructionFetch port map(clk => clk, PCSrc => PcSrcM, Jump => JumpControl , JA => JumpAdress, BA => BranchAddress3, Enable => enableEN, 
     Reset => enableRESET, Instruction => Instr, pc_1 => PcPlus1);
    
     IF_ID_map: IF_ID port map(Instruction=>Instr, pc_next=>PcPlus1, clock=>clk, enable=>enableEN, Instruction_out => Instruction1, pc_next_out => PcNext1);
    
     INSTRDECODER_map: InstructionDecoder port map(RegWrite=>wbReg4(1), Instr=>Instruction1, RegDst=>RegDstControl, ExtOp=>ExtOpControl,WD=>WDMemorie,WA=>WriteAddress4, RD1=>RD1REG,RD2=>RD2REG,Ext_Imm=>ExtUnit_IMM, func=>Func_Reg, sa=>Sa_Reg, en=>enableEN  ,clk=>clk);
     MAINCONTROL_map: UC port map(OpCode=>Instr(15 downto 13) , RegDst=>RegDstControl, ExtOp=>ExtOpControl,AluSrc=>AluSrc_Control, Branch=>BranchControl, Jump=>JumpControl, ALUOp=>AluOpControl,MemWrite=>MemWriteControl, MemtoReg=>MemtoRegControl, RegWrite=>RegWriteControl);
    
    ID_EX_map: ID_EX port map(clock => clk, enable => enableEn,Instruction => Instruction1,pc_next => PcNext1,Ext_imm=>ExtUnit_IMM,rd1=>RD1REG,rd2=>RD2REG,Ex => exReg,M=>mReg,WB => wbReg,Instruction_out=>Instruction2,pc_next_out => PcNext2,Ext_imm_out=>Ext_imm2,rd1_out=>RD12,rd2_out=>RD22,Ex_out => exReg2,M_out=>mReg2,WB_out => wbReg2);
    
     EXECUTIE_map: EX port map(RD1=>RD12,AluSrc=>exReg2(1), RD2=>RD22, Ext_Imm=>Ext_imm2, sa=>Instruction2(3), func=>Instruction2(2 downto 0), ALUOp=>exReg2(4 downto 2),PCPlus1=>PcNext2, Zero=>ZeroAlu,ALURes=>AluRes, BranchAdress=> BranchAdress);  
     WriteAddress <=Instruction2(6 downto 4) when exReg2(0)='1' else Instruction2(9 downto 7);
     
     EX_MEM_map: EX_MEM port map(clock => clk, enable => enableEn, rd2=>RD22,alu_res=>AluRes,WriteAddress => WriteAddress,zero => ZeroAlu,M=>mReg2,WB=>wbReg2,BranchAddress=>BranchAdress,rd2_out=>RD23,alu_res_out=>AluRes3,WriteAddress_out => WriteAddress3,zero_out => Zero3,M_out=>mReg3,WB_out=>wbReg3,BranchAddress_out=>BranchAddress3);
     
     MEMORY_map: Unitatea_MEM port map( MemWrite=> mReg3(1), MPG_EN=>enableEN,  ALURes=>AluRes3,  RD2=>RD23,  ALUResOut => AluResMemoryOut,  CLK=>clk,   MemData=>MemoryMemData);
     
     MEM_WB_map: MEM_WB port map(clock=>clk,enable=>enableEn,WriteData=>MemoryMemData,WriteAddress=>WriteAddress3,WB=>wbReg3,alu_res=>AluResMemoryOut,WriteData_out=>MemData4,WriteAddress_out=>WriteAddress4,WB_out=>wbReg4,alu_res_out=>AluRes4);
     
      WDMemorie <=MemData4 when wbReg(0)='1' else AluRes4;
      
      process(sw(7 downto 5))
      begin
         case sw(7downto 5) is
          when "000" => SSD_in<=Instr;
          when "001" =>SSD_in<=PcPlus1;
          when "010" =>SSD_in <= RD1REG;
          when "011" => SSD_in <= RD2REG;
          when "100" => SSD_in<= ExtUnit_IMM;
          when "101" => SSD_in <=AluRes;
          when "110" =>SSD_in <=MemoryMemData;
          when "111" => SSD_in <=WDMemorie;
      end case;
      end process;
     
     SSD_in1 <= SSD_in(3 downto 0);
     SSD_in2 <=SSD_in(7 downto 4);
     SSD_in3<= SSD_in(11 downto 8);
     SSD_in4 <= SSD_in (15 downto 12);
     led(15) <=RegDstControl;
     led(14) <=ExtOpControl;
     led(13) <=AluSrc_Control;
     led(12) <=BranchControl;
     led(11) <=JumpControl;
     led(10 downto 8) <=AluOpControl;
     led(7) <=MemWriteControl;
     led(6) <=MemtoRegControl;  
     led(5) <=RegWriteControl;
     
    SSD_map: Afisor_7_segmente port map(DIGIT0 => SSD_in1, DIGIT1=>SSD_in2, DIGIT2=>SSD_in3, DIGIT3=>SSD_in4, CATOD => cat, ANOD => an, clk=>clk);
end Behavioral;
