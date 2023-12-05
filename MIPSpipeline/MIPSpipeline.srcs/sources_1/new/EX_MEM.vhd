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

entity EX_MEM is
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
end EX_MEM;

architecture Behavioral of EX_MEM is

begin
process(clock,enable,rd2, alu_res, WriteAddress, zero, M, WB)
begin
if rising_edge(clock) and enable='1' then
rd2_out<=rd2;
alu_res_out<=alu_res;
WriteAddress_out<=WriteAddress;
zero_out<=zero;
M_out<=M;
WB_out<=WB;
BranchAddress_out <= BranchAddress;
end if;
end process;


end Behavioral;
