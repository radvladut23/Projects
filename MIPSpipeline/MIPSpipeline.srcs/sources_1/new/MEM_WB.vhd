----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 05/15/2023 08:54:04 PM
-- Design Name: 
-- Module Name: EX_MEM - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity MEM_WB is
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
end MEM_WB;

architecture Behavioral of MEM_WB is

begin
process(WriteData, WriteAddress, clock,enable, WB, alu_res)
begin
if rising_edge(clock) and enable='1' then
WriteData_out<=WriteData;
WriteAddress_out<=WriteAddress;
WB_out<=WB;
alu_res_out<=alu_res;

end if;
end process;

end Behavioral;
