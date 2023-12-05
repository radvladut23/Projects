library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity InstructionFetch is
    Port ( clk: in std_logic;
    PCSrc: in std_logic;
    Jump: in std_logic;
    JA: in std_logic_vector(15 downto 0);
    BA: in std_logic_vector(15 downto 0);
    Enable: in std_logic;
    Reset: in std_logic;
    Instruction: out std_logic_vector(15 downto 0);
    pc_1: out std_logic_vector(15 downto 0) );
end InstructionFetch;

architecture Behavioral of InstructionFetch is

type ROM_type is array(0 to 255) of std_logic_vector(15 downto 0);
signal ROM: ROM_type :=(B"000_000_000_000_0_110", --0006
                        B"000_001_001_001_0_110",
                        B"000_010_010_010_0_110",
                        B"000_011_011_011_0_110",
                        B"001_000_000_0000000",
                        B"001_000_000_0000000",
                        B"001_000_000_0000000",
                        B"001_000_011_0010100",
                        B"001_010_010_0000010",
                        B"000_001_010_001_0_000",
                        B"001_000_000_0000000",
                        B"001_000_000_0000000",
                        B"001_000_000_0000000",--NoOp
                        B"100_001_011_0000001",
                        B"001_000_000_0000000",
                        B"001_000_000_0000000",
                        B"001_000_000_0000000",
                        B"111_0000000000101",
                        B"001_000_000_0000000",
                        others=>"0000000000000000"
                        );

signal PCout: std_logic_vector(15 downto 0) := (others => '0');
signal Mux2_out: std_logic_vector(15 downto 0) := (others => '0');
signal Mux1_out: std_logic_vector(15 downto 0) := (others => '0');
signal suma: std_logic_vector(15 downto 0) := (others => '0');

begin

    suma <= PCout + 1;

    PC_process: process(clk)
    begin
        if rising_edge(clk) then
            if reset = '1' then
                PCout <= x"0000";
            elsif Enable = '1' then
                PCout <= Mux2_out;
            end if;
        end if;
    end process;

    Mux1: process
    begin
        case PCSrc is
            when '0' => Mux1_out <= suma;
            when '1' => Mux1_out <= BA;
        end case;
    end process;
    
    Mux2: process
    begin
        case Jump is
            when '0' => Mux2_out <= Mux1_out;
            when '1' => Mux2_out <= JA;
        end case;
    end process;
    
    Instruction <= ROM(conv_integer(PCout(4 downto 0)));
    pc_1 <= suma;

end Behavioral;
