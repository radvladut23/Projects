library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity InstructionDecoder is
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
        
end InstructionDecoder;

architecture Behavioral of InstructionDecoder is

   

   signal RA1: std_logic_vector (2 downto 0 );
   signal RA2: std_logic_vector(2 downto 0);
   
   type reg_array is array(0 to 15) of STD_LOGIC_VECTOR(15 downto 0);
    signal RF : reg_array := (
		X"0000",
		X"0001",
		X"0002",
		others => X"0000");
begin

     RA1<=Instr(12 downto 10);
     RA2<=Instr(9 downto 7);

    write: process(clk)			
    begin
        if rising_edge(clk) then
          if en='1' then
            if RegWrite = '1' then
                RF(conv_integer(WA)) <= WD;		
            end if;
        end if;
        end if;
    end process;		

    RD1 <= RF(conv_integer(RA1));
    RD2 <= RF(conv_integer(RA2));
   
   EXTUNIT: process
   begin
     if ExtOp='0' then
        Ext_Imm <= "000000000" & Instr(6 downto 0) ;
      elsif ExtOp='1' then
           if Instr(6)='0' then Ext_Imm <="000000000" & Instr(6 downto 0) ;
           else if Instr(6) ='1' then Ext_Imm <="111111111" & Instr(6 downto 0);
           end if;
       end if;
       end if;
    end process;
    
    func<= Instr(2 downto 0);
    sa<=Instr(3);
    
end Behavioral;