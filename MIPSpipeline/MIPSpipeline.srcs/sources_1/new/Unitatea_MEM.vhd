library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity Unitatea_MEM is
--  Port ( );
    Port ( MemWrite : in std_logic;
           MPG_EN : in std_logic;
           ALURes : in std_logic_vector(15 downto 0);
           RD2 : in std_logic_vector(15 downto 0);
           ALUResOut: out std_logic_vector( 15 downto 0);
           CLK: in std_logic;
           MemData : out std_logic_vector (15 downto 0));
end Unitatea_MEM;
     
architecture Behavioral of Unitatea_MEM is
    type ram_type is array (0 to 15) of std_logic_vector (15 downto 0);
    signal RAM: ram_type;
begin
      
   process (clk)
     begin
       if clk'event and clk = '1' then
           if MPG_EN='1' then 
              if MemWrite = '1' then 
                 RAM(conv_integer(ALURes)) <= RD2;
              end if;
          end if;
      end if;
    end process;
    
    MemData<=RAM( conv_integer(ALURes));
    ALUResOut<=ALURes;
end Behavioral;