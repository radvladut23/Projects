----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 05/22/2023 10:50:03 PM
-- Design Name: 
-- Module Name: IF_ID - Behavioral
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
use IEEE.STD_LOGIC_UNSIGNED.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity IF_ID is
 Port (Instruction: in std_logic_vector(15 downto 0);
        pc_next: in std_logic_vector(15 downto 0 ) ;
        clock:in std_logic;
        enable: in std_logic;
        Instruction_out: out std_logic_vector(15 downto 0);
        pc_next_out: out std_logic_vector(15 downto 0 ) );
end IF_ID;

architecture Behavioral of IF_ID is

begin
process(Instruction, pc_next, clock,enable)
begin
if rising_edge(clock) and enable='1' then
pc_next_out<=pc_next;
Instruction_out<=Instruction;
end if;
end process;


end Behavioral;
