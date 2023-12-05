library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity Afisor_7_segmente is
--  Port ( );
    Port( DIGIT0: in std_logic_vector(3 downto 0); 
          DIGIT1:in std_logic_vector(3 downto 0); 
          DIGIT2: in std_logic_vector(3 downto 0); 
          DIGIT3:in std_logic_vector(3 downto 0);
          clk: in std_logic ;
          ANOD:out std_logic_vector(3 downto 0);
          CATOD:out std_logic_vector(6 downto 0));
          
end Afisor_7_segmente;

architecture Behavioral of Afisor_7_segmente is
       signal temp : STD_LOGIC_VECTOR(15 downto 0) :=(others=>'0');
       signal sel1: STD_LOGIC_VECTOR(1 downto 0):=(others=>'0');
       signal sel2: STD_LOGIC_VECTOR(1 downto 0):=(others=>'0');
       signal mux_1: STD_LOGIC_VECTOR(3 downto 0):=(others=>'0');
       signal mux_2: STD_LOGIC_VECTOR(3 downto 0):=(others=>'0');
       type dcd_array is array (0 to 16) of Std_logic_vector(6 downto 0);
       signal dcd_out: dcd_array := ("1000000", "1111001", "0100100", "0110000", "0011001", "0010010",
								      "0000010", "1111000" , "0000000" , "0010000" , "0001000" , "0000011" , "1000110" , "0100001","0000110","0001110","1111111");
	   signal Y:  STD_LOGIC_VECTOR(6 downto 0):=(others=>'0');
begin
   
   counter:process(clk)
     begin
      if rising_edge(clk) then
       -- if btn(0)='1'  then
      -- if s_counter_enable='1' then
          --if sw(0)='1' then
            temp<=temp+1;
         -- else temp<=temp-1;
          --end if;
        -- end if;
      end if;
     end process;
    -- led<=temp;
     sel1(1)<=temp(15);
     sel1(0)<=temp(14);
     sel2(1)<=temp(15);
     sel2(0)<=temp(14);
    
   mux1:process
   begin
       case sel1 is
          when "00" => mux_1<=DIGIT0;
          when "01" => mux_1<=DIGIT1;
          when "10" => mux_1<=DIGIT2;
          when "11" => mux_1<=DIGIT3;
       end case;
   end process;
   
   mux2:process
     begin
        case sel2 is
           when "00" =>mux_2<="1110";
           when "01" =>mux_2<="1101";
           when "10" => mux_2<="1011";
           when "11"=>mux_2<="0111";
        end case;
     end process;
     
 ANOD<=mux_2;
           
     process(mux_1,dcd_out)
	begin
		case mux_1 is
			when "0000" => Y<=dcd_out(0);
			when "0001" => Y<=dcd_out(1);
			when "0010" => Y<=dcd_out(2);
			when "0011" => Y<=dcd_out(3);
			when "0100" => Y<=dcd_out(4);
			when "0101" => Y<=dcd_out(5);
			when "0110" => Y<=dcd_out(6);
			when "0111" => Y<=dcd_out(7);
			when "1000" => Y<=dcd_out(8);
			when "1001" => Y<=dcd_out(9);
			when "1010" =>Y<=dcd_out(10);
			when "1011" => Y<=dcd_out(11);
			when "1100" => Y<=dcd_out(12);
			when "1101" => Y<=dcd_out(13);
			when "1110" => Y<=dcd_out(14);
			when "1111" => Y<=dcd_out(15);
			when others => Y<=dcd_out(16);
		end case;
	end process;
	
	
	
     CATOD<=Y;
end Behavioral;