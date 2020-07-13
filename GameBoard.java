package alex.andrew.monoplyproject;

import alex.andrew.monoplyproject.Square;
import alex.andrew.monoplyproject.Owner;
public class GameBoard {
		Player player = new Player();
		public Square[] sqs = new Square[160];
		public Owner[] own = new Owner[40];
		
		public void init() {
			for (int i = 0; i < sqs.length; i ++) {
				sqs[i] = new Square();
			}
			for (int i = 0; i < own.length; i ++) {
				own[i] = new Owner();
			}
		}
		
		public void buyProperty (int spot, Player[] owner) {
			if (own[spot] != null) {
				own[spot] = player.owner;	
			}
		}
		
		public int takeSquare(int spot, Player[] player) {
			if (sqs[spot].occupiedBy != null) {
				sqs[spot + 40].occupiedBy = player;
			}
			return spot;
		}
	
	public void randomChance(){
			Game gm = new Game();
			Random random = new Random();
			gm.drawChance(random.nextInt(15));
		}
		
		public void randomCC(){
			Game gm = new Game();
			Random random = new Random();
			gm.drawCC(random.nextInt(15));
		}
		public void gameBoard() {
			System.out.println("______________________________________________________________________________________________________________________________________________________________________");
			System.out.println("|" +own[20]+  "|"  +own[21]+ "|"  +own[22]+ "|" +own[23]+  "|" +own[24]+  "|" +own[25]+  "|"  +own[26]+ "|"  +own[27]+ "|"  +own[28]+ "|"  +own[29]+ "|"  +own[30]+ "|");
			System.out.println("|    Free      |   Kentucky   |    Chance    |   Indiana    |  Illinois    |     B&O      |   Atlantic   |   Ventnor    |    Water     |   Marvin     |      Go      |");
			System.out.println("|   Parking    |    Avenue    |              |    Avenue    |  Avenue      |   Railroad   |    Avenue    |   Avenue     |    Works     |   Gardens    |      To      |");
			System.out.println("|              |              |              |              |              |              |              |              |              |              |     Jail     |");
			System.out.println("|"  +sqs[20]+ "|"  +sqs[21]+ "|"   +sqs[22]+"|"   +sqs[23]+"|"   +sqs[24]+"|" +sqs[25]+  "|"  +sqs[26]+ "|"  +sqs[27]+ "|"  +sqs[28]+ "|" +sqs[29]+  "|" +sqs[30]+  "|");
			System.out.println("|"  +sqs[60]+ "|"  +sqs[61]+ "|"   +sqs[62]+"|"   +sqs[63]+"|"   +sqs[64]+"|" +sqs[65]+  "|"  +sqs[66]+ "|"  +sqs[67]+ "|"  +sqs[68]+ "|" +sqs[69]+  "|" +sqs[70]+  "|");
			System.out.println("|"  +sqs[100]+"|" +sqs[101]+ "|"  +sqs[102]+"|"  +sqs[103]+"|"  +sqs[104]+"|" +sqs[105]+ "|" +sqs[106]+ "|" +sqs[107]+ "|"  +sqs[108]+"|" +sqs[109]+ "|" +sqs[110]+ "|");
			System.out.println("|"  +sqs[140]+"|" +sqs[141]+ "|"  +sqs[142]+"|"  +sqs[143]+"|"  +sqs[144]+"|" +sqs[145]+ "|" +sqs[146]+ "|" +sqs[147]+ "|" +sqs[148]+ "|" +sqs[149]+ "|" +sqs[150]+ "|");
			System.out.println("|              |     $220     |       ?      |     $220     |    $240      |     $200     |     $260     |    $260      |     $150     |     $280     |              |");
			System.out.println("|______________|______________|______________|______________|______________|______________|______________|______________|______________|______________|______________|");
			System.out.println("|" +own[19]+  "|                                                                                                                                      |" +own[31]+  "|");
			System.out.println("|   New York   |                                                                                                                                      |   Pacific    |");
			System.out.println("|    Avenue    |                                                                                                                                      |    Avenue    |");
			System.out.println("|              |                                                                                                                                      |              |");
			System.out.println("|" +sqs[19]+  "|                                                                                                                                      |" +sqs[31]+  "|");
			System.out.println("|" +sqs[59]+  "|                                                                                                                                      |" +sqs[71]+  "|");
			System.out.println("|" +sqs[99]+  "|                                                                                                                                      |" +sqs[111]+ "|");
			System.out.println("|" +sqs[139]+ "|                                                                                                                                      |" +sqs[151]+ "|");
			System.out.println("|     $200     |                                                                                                                                      |     $300     |");
			System.out.println("|______________|                                                                                                                                      |______________|");
			System.out.println("|" +own[18]+  "|                                                                                                                                      |" +own[32]+  "|");
			System.out.println("|  Tennessee   |                                                                                                                                      |North Carolina|");
			System.out.println("|   Avenue     |                                                                                                                                      |    Avenue    |");
			System.out.println("|              |                                                                                                                                      |              |");
			System.out.println("|" +sqs[18]+  "|                                                                                                                                      |" +sqs[32]+  "|");
			System.out.println("|" +sqs[58]+  "|                                                                                                                                      |" +sqs[72]+  "|");
			System.out.println("|" +sqs[98]+  "|                                                                                                                                      |" +sqs[112]+ "|");
			System.out.println("|" +sqs[138]+ "|                                                                                                                                      |" +sqs[152]+ "|");
			System.out.println("|     $180     |                                                                                                                                      |    $300      |");
			System.out.println("|______________|                                                                                                                                      |______________|");
			System.out.println("|" +own[17]+  "|                                                                                                                                      |" +own[33]+  "|");
			System.out.println("|   Community  |                                                                                                                                      |   Community  |");
			System.out.println("|     Chest    |                                                                                                                                      |    Chest     |");
			System.out.println("|              |                                                                                                                                      |              |");
			System.out.println("|" +sqs[17]+  "|                                                                                                                                      |" +sqs[33]+  "|");
			System.out.println("|" +sqs[57]+  "|                                                                                                                                      |" +sqs[73]+  "|");
			System.out.println("|" +sqs[97]+  "|                                                                                                                                      |" +sqs[113]+ "|");
			System.out.println("|" +sqs[137]+ "|                                                                                                                                      |" +sqs[153]+ "|");
			System.out.println("|              |                                                                                                                                      |              |");
			System.out.println("|______________|                                                                                                                                      |______________|");
			System.out.println("|" +own[16]+  "|                                                                                                                                      |" +own[34]+  "|");
			System.out.println("|   St. James  |                                                                                                                                      | Pennsylvania |");
			System.out.println("|     Place    |                                                                                                                                      |    Avenue    |");
			System.out.println("|              |                                                                                                                                      |              |");
			System.out.println("|" +sqs[16]+  "|                                                                                                                                      |" +sqs[34]+  "|");
			System.out.println("|" +sqs[56]+  "|                                                                                                                                      |" +sqs[74]+  "|");
			System.out.println("|" +sqs[96]+  "|                                                                                                                                      |" +sqs[114]+ "|");
			System.out.println("|" +sqs[136]+ "|                                                                                                                                      |" +sqs[154]+ "|");
			System.out.println("|     $180     |                                                                                                                                      |     $320     |");
			System.out.println("|______________|                                                                                                                                      |______________|");
			System.out.println("|" +own[15]+  "|                                                                                                                                      |" +own[35]+  "|");
			System.out.println("| Pennslyvania |                                                                                                                                      |     Short    |");
			System.out.println("|   Railroad   |                                                                                                                                      |     Line     |");
			System.out.println("|              |                                                                                                                                      |              |");
			System.out.println("|" +sqs[15]+  "|                                                                                                                                      |" +sqs[35]+  "|");
			System.out.println("|" +sqs[55]+  "|                                                                                                                                      |" +sqs[75]+  "|");
			System.out.println("|" +sqs[95]+  "|                                                                                                                                      |" +sqs[115]+ "|");
			System.out.println("|" +sqs[135]+ "|                                                                                                                                      |" +sqs[155]+ "|");
			System.out.println("|     $200     |                                                                                                                                      |     $200     |");
			System.out.println("|______________|                                                                                                                                      |______________|");
			System.out.println("|" +own[14]+  "|                                                                                                                                      |" +own[36]+   "|");
			System.out.println("|   Virgina    |                                                                                                                                      |    Chance    |");
			System.out.println("|    Avenue    |                                                                                                                                      |              |");
			System.out.println("|              |                                                                                                                                      |              |");
			System.out.println("|" +sqs[14]+  "|                                                                                                                                      |" +sqs[36]+  "|");
			System.out.println("|" +sqs[54]+  "|                                                                                                                                      |" +sqs[76]+  "|");
			System.out.println("|" +sqs[94]+  "|                                                                                                                                      |" +sqs[116]+ "|");
			System.out.println("|" +sqs[134]+ "|                                                                                                                                      |" +sqs[156]+ "|");
			System.out.println("|     $160     |                                                                                                                                      |       ?      |");
			System.out.println("|______________|                                                                                                                                      |______________|");
			System.out.println("|" +own[13]+  "|                                                                                                                                      |" +own[37]+   "|");
			System.out.println("|    States    |                                                                                                                                      |     Park     |");
			System.out.println("|    Avenue    |                                                                                                                                      |     Place    |");
			System.out.println("|              |                                                                                                                                      |              |");
			System.out.println("|" +sqs[13]+  "|                                                                                                                                      |" +sqs[37]+  "|");
			System.out.println("|" +sqs[53]+  "|                                                                                                                                      |" +sqs[77]+  "|");
			System.out.println("|" +sqs[93]+  "|                                                                                                                                      |" +sqs[117]+ "|");
			System.out.println("|" +sqs[133]+ "|                                                                                                                                      |" +sqs[157]+ "|");
			System.out.println("|     $140     |                                                                                                                                      |     $350     |");
			System.out.println("|______________|                                                                                                                                      |______________|");
			System.out.println("|" +own[12]+  "|                                                                                                                                      |" +own[38]+  "|");
			System.out.println("|   Electric   |                                                                                                                                      |    Luxury    |");
			System.out.println("|   Compnay    |                                                                                                                                      |     Tax      |");
			System.out.println("|              |                                                                                                                                      |              |");
			System.out.println("|" +sqs[12]+  "|                                                                                                                                      |" +sqs[38]+  "|");
			System.out.println("|" +sqs[52]+  "|                                                                                                                                      |" +sqs[78]+  "|");
			System.out.println("|" +sqs[92]+  "|                                                                                                                                      |" +sqs[118]+ "|");
			System.out.println("|" +sqs[132]+ "|                                                                                                                                      |" +sqs[158]+ "|");
			System.out.println("|     $150     |                                                                                                                                      |   Pay: $100  |");
			System.out.println("|______________|                                                                                                                                      |______________|");
			System.out.println("|" +own[11]+  "|                                                                                                                                      |" +own[39]+  "|");
			System.out.println("|  St. Charles |                                                                                                                                      |   Boardwalk  |");
			System.out.println("|     Place    |                                                                                                                                      |              |");
			System.out.println("|              |                                                                                                                                      |              |");
			System.out.println("|" +sqs[11]+  "|                                                                                                                                      |" +sqs[39]+  "|");
			System.out.println("|" +sqs[51]+  "|                                                                                                                                      |" +sqs[79]+  "|");
			System.out.println("|" +sqs[91]+  "|                                                                                                                                      |" +sqs[119]+ "|");
			System.out.println("|" +sqs[131]+ "|                                                                                                                                      |" +sqs[159]+ "|");
			System.out.println("|     $140     |                                                                                                                                      |     $400     |");
			System.out.println("|______________|______________________________________________________________________________________________________________________________________|______________|");
			System.out.println("|" +own[10]+  "|"  +own[9]+  "|"  +own[8]+  "|" +own[7]+   "|" +own[6]+   "|" +own[5]+   "|"  +own[4]+  "|"   +own[3]+ "|"   +own[2]+ "|"  +own[1]+  "|"  +own[0]+  "|");
			System.out.println("|    Free      |  Connecticut |   Vermont    |    Chance    |   Oriental   |   Reading    |    Income    |    Baltic    |   Community  | Mediterranean| Collect $200 |");
			System.out.println("|   Parking    |    Avenue    |   Avenue     |              |    Avenue    |   Railroad   |     Tax      |    Avenue    |     Chest    |    Avenue    | As You Pass  |");
			System.out.println("|              |              |              |              |              |              |              |              |              |              |              |");
			System.out.println("|"  +sqs[10]+ "|"  +sqs[9]+  "|"   +sqs[8]+ "|"   +sqs[7]+ "|"    +sqs[6]+"|"  +sqs[5]+  "|"   +sqs[4]+ "|"   +sqs[3]+ "|"  +sqs[2]+  "|"  +sqs[1]+  "|"  +sqs[0]+  "|");
			System.out.println("|"  +sqs[50]+ "|"  +sqs[49]+ "|"  +sqs[48]+ "|"  +sqs[47]+ "|"   +sqs[46]+"|" +sqs[45]+  "|"  +sqs[44]+ "|"  +sqs[43]+ "|" +sqs[42]+  "|" +sqs[41]+  "|"  +sqs[40]+ "|");
			System.out.println("|"  +sqs[90]+ "|" +sqs[89]+  "|"  +sqs[88]+ "|"  +sqs[87]+ "|"   +sqs[86]+"|" +sqs[85]+  "|"  +sqs[84]+ "|"  +sqs[83]+ "|"  +sqs[82]+ "|" +sqs[81]+  "|"  +sqs[80]+ "|");
			System.out.println("|" +sqs[130]+ "|"+sqs[129]+  "|" +sqs[128]+ "|" +sqs[127]+ "|"  +sqs[126]+"|"+sqs[125]+  "|" +sqs[124]+ "|"  +sqs[123]+"|" +sqs[122]+ "|"  +sqs[121]+"|"  +sqs[120]+"|");
			System.out.println("|              |     $120     |     $100     |      ?       |     $100     |     $200     |   Pay: $200  |      $60     |              |      $60     |      GO      |");
			System.out.println("|______________|______________|______________|______________|______________|______________|______________|______________|______________|______________|______________|");
		}
		
		public void housingDisplay(int houses) {
			if(houses == 1) {
				propertyView1House();
			}
			if(houses == 2) {
				propertyView2Houses();
			}
			if(houses == 3) {
				propertyView3Houses();
			}
			if(houses == 4) {
				propertyView4Houses();
			}
			if(houses == 5) {
				hotelView();
			}
		}
			
		public void propertyView1House() {
			System.out.println("     _    ");
			System.out.println("   __||   ");
			System.out.println("  /    \\ ");
			System.out.println(" |  _   | ");
			System.out.println(" |_| |__| ");
		}
		
		public void propertyView2Houses() {
			System.out.println("     _         _    ");
			System.out.println("   __||      __||   ");
			System.out.println("  /    \\   /    \\ ");
			System.out.println(" |  _   |  |  _   | ");
			System.out.println(" |_| |__|  |_| |__| ");
		}
		
		public void propertyView3Houses() {
			System.out.println("     _         _         _    ");
			System.out.println("   __||      __||      __||   ");
			System.out.println("  /    \\   /    \\   /    \\ ");
			System.out.println(" |  _   |  |  _   |  |  _   | ");
			System.out.println(" |_| |__|  |_| |__|  |_| |__| ");
		}
		
		public void propertyView4Houses() {
			System.out.println("     _         _         _         _    ");
			System.out.println("   __||      __||      __||      __||   ");
			System.out.println("  /    \\   /    \\   /    \\   /    \\ ");
			System.out.println(" |  _   |  |  _   |  |  _   |  |  _   | ");
			System.out.println(" |_| |__|  |_| |__|  |_| |__|  |_| |__| ");
		}
		
		public void hotelView() {
			System.out.println("    __           ");
			System.out.println("   _||________   ");
			System.out.println("  /           \\ ");
			System.out.println(" /  _      _   \\");
			System.out.println(" | |_|    |_|  | ");
			System.out.println(" |     __      | ");
			System.out.println(" |_____||______| ");
		}
		
}
