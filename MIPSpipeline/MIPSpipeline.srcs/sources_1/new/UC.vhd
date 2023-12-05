library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity UC is
--  Port ( );
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
         
         
end UC;

  architecture Behavioral of UC is
   
begin

 process(OpCode)
  
  
  begin
    
   
      case OpCode is
        when "000" =>    --INSTRUCTIUNI TIP R
           RegDst<='1';
           ExtOp<='0';
           ALUSrc<='0';
           Branch<='0';
           Jump<='0';
           ALUOp<="000";
           MemWrite<='0';
           MemtoReg<='0';
           RegWrite<='1';
         
        when "001" =>    --ADDI
           RegDst<='0';
           ExtOp<='0';
           ALUSrc<='1';
           Branch<='0';
           Jump<='0';
           ALUOp<="001";
           MemWrite<='0';
           MemtoReg<='0';
           RegWrite<='1';
           
        when "010"=>   --LW
            RegDst<='0';
           ExtOp<='0';
           ALUSrc<='1';
           Branch<='0';
           Jump<='0';
           ALUOp<="010";
           MemWrite<='0';
           MemtoReg<='1';
           RegWrite<='1';
        when "011" =>       --SW
             RegDst<='0';
           ExtOp<='0';
           ALUSrc<='1';
           Branch<='0';
           Jump<='0';
           ALUOp<="011";
           MemWrite<='0';
           MemtoReg<='0';
           RegWrite<='1';
           
        when "100" =>   --BEG
            RegDst<='0';
           ExtOp<='1';
           ALUSrc<='0';
           Branch<='1';
           Jump<='0';
           ALUOp<="100";
           MemWrite<='0';
           MemtoReg<='0';
           RegWrite<='0';
           
       when "111" =>   --JMP
           RegDst<='0';
           ExtOp<='0';
           ALUSrc<='0';
           Branch<='0';
           Jump<='1';
           ALUOp<="111";
           MemWrite<='0';
           MemtoReg<='0';
           RegWrite<='0';
           
         when "110" =>    --SUBI
          RegDst<='0';
           ExtOp<='0';
           ALUSrc<='1';
           Branch<='0';
           Jump<='0';
           ALUOp<="110";
           MemWrite<='0';
           MemtoReg<='0';
           RegWrite<='1';
       
       
          when "101" =>   --ORI
           RegDst<='0';
           ExtOp<='0';
           ALUSrc<='1';
           Branch<='0';
           Jump<='0';
           ALUOp<="101";
           MemWrite<='0';
           MemtoReg<='0';
           RegWrite<='1';
       end case;
     end process;
end Behavioral;
