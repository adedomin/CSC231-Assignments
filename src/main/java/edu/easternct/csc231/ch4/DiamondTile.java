package edu.easternct.csc231.ch4;

/**
 * generate a centered diamond
 */
public class DiamondTile {

	public static String buildRow(int width, int count) {

		String retString = "";
		int approx_mid_width = (int) (width/2);
		for (int i=0; i<width; ++i) {
	
			if (width >= approx_mid_width-count &&
				width <= approx_mid_width+count)
			{
				retString = retString.concat("*");
			}
			else
			{
				retString = retString.concat(" ");
			}
		}

		return retString;
	}
	public static void main(String[] args) {

		int height = Integer.parseInt(args[0]);
		int width = Integer.parseInt(args[1]);
		if (height < 7 && width < 7)
		{	
			System.out.printf("Tile area too small\n");
			System.out.printf("Needs to be 7 or greater\n");
		}
		
		int approx_mid_height = (int) (height/2);

		boolean countUp = true;
		int black_tile_amount_at_row = 0;
		for (int i=0; i<height; ++i)
		{
			if (i >= approx_mid_height-3 &&
				i <= approx_mid_height+3)	
			{
				System.out.printf("t%s\n", 
					buildRow(width,black_tile_amount_at_row));
				if (countUp) {
					++black_tile_amount_at_row;
					if (black_tile_amount_at_row > 1) {
						countUp = false;
					}
				}
				else
				{
					--black_tile_amount_at_row;
				}
			}
			else 
			{
				System.out.printf("\n");
			}
		}
	}
}
