----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 05/22/2023 10:48:31 PM
-- Design Name: 
-- Module Name: MPG - Behavioral
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

entity MPG is
    Port ( buton_db : out STD_LOGIC;
           buton : in STD_LOGIC;
           clock : in STD_LOGIC);
end MPG;

architecture Behavioral of MPG is
signal q1,q2,q3: std_logic;
signal aux: std_logic_vector(15 downto 0);
begin
	process(clock)
	begin
		if(rising_edge(clock)) then
			aux <= aux + 1;
		end if;
	end process;
	process(clock,buton,aux)
	begin
		if(rising_edge(clock)) then
			if(aux = x"ffff") then
				q1 <= buton;
			end if;
		end if;
	end process;
	process(clock,buton)
	begin
		if(rising_edge(clock)) then
			q2 <= q1;
			q3 <= q2;
		end if;
	end process;
	buton_db <= q2 and not q3;
end Behavioral;