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

entity ID_EX is
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
end ID_EX;

architecture Behavioral of ID_EX is

begin
process(Instruction, pc_next, clock,enable,Ext_imm, rd1, rd2, Ex, M, WB)
begin
if rising_edge(clock) and enable='1' then

Instruction_out<=Instruction;
Ext_imm_out<=Ext_imm;
rd1_out<=rd1;
rd2_out<=rd2;
pc_next_out<=pc_next;
Ex_out<=Ex;
M_out<=M;
WB_out<=WB;

end if;
end process;


end Behavioral;
