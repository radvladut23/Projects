library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity EX is
--  Port ( );
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

end EX;

architecture Behavioral of EX is
    signal ALUCtr : std_logic_vector(2 downto 0);
    signal MUX_out :std_logic_vector(15 downto 0);
    signal res:std_logic_vector(15 downto 0);
begin
      process(ALUOP)
      begin
         case ALUOP is
           when "000"=> ALUCtr<=func;   --TIP R
           when "001"=> ALUCtr<="000";     --ADDI
           when "010"=> ALUCtr <="000";     --LW (adunare)
           when "011" => ALUCtr <= "000"; -- sw (adunare)  
           when "100" => ALUCtr <= "001"; -- beq   -- scadere
           when "110" => ALUCtr <= "100"; --    --andi scadere
           when "101" => ALUCtr <= "101"; --    --ori -or
           when others => ALUCtr <= (others => 'X');
          
          end case;
     end process;
     
     process(AluSrc)
     begin
        case AluSrc is
         when '0' => MUX_out <=RD2;
         when '1' => MUX_out <=Ext_Imm;
         end case;
      end process;
      
       BranchAdress<= PCplus1 + EXT_Imm;

    process(MUX_out ,RD1 , sa, ALUCtr)
    begin
     
      case ALUCtr is
      
      when "000" => res<= RD1 +  MUX_out;
      when "001" => res<= RD1 - MUX_out;
      when "010" => case sa is 
                    when '0'  => res<= MUX_out;
                    when '1' => res<= MUX_out(14 downto 0)  & '0';
                    end case;
      when "011" => case sa is 
                    when '0' => res<=MUX_out;
                    when '1' => res<= '0' & MUX_out (15 downto 1);
                   end case;
       when "100" => res<= RD1 and MUX_out;
       when "101" => res<=RD1 or MUX_out;
       when "110" =>res<=RD1 xor MUX_out;
       when "111" =>
                   case sa is when '0' => res<=res;
                              when '1' => res<=MUX_out(0)& MUX_out(15 downto 1);
                   end case;
       when others=>   res<=X"0000";
      end case;
    end process;
   
    zero<='1' when res = X"0000" else '0';
    ALURes<=res;
end Behavioral;