package edu.easternct.csc231.ch4;

/**
 * generate a centered diamond
 */
public class DiamondTile {

	/**
	 * build a row that contains black tiles
	 * count is how many to build out from estimated
	 * middle
	 */
	public static String buildRow(int width, int count) {

		String retString = "";
		int approx_mid_width = (int) (width/2);
		for (int i=0; i<width; ++i) {
			if (i >= approx_mid_width-count &&
				i <= approx_mid_width+count)
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

	/**
	 * entry point
	 * @param args takes 2 numbers, first height, second width
	 */
	public static void main(String[] args) {

		int height = Integer.parseInt(args[0]);
		int width = Integer.parseInt(args[1]);
		// too small
		if (height < 7 && width < 7)
		{	
			System.out.printf("Tile area too small\n");
			System.out.printf("Needs to be 7 or greater\n");
		}
		
		// note the integer casting
		// can't be floating position
		int approx_mid_height = (int) (height/2);

		for (int i=0; i<height; ++i)
		{
			// if two rows to or
			// from approximate center row
			// plus center row
			if (Math.abs(approx_mid_height-i) >= 0 &&
				Math.abs(approx_mid_height-i) <= 2)
			{
				// note that center in this
				// context is refering to
				// the row's center position
				// any row printed here contains
				// at least one black tile
				// and at most 5 black tiles
				//
				// this will output abs of
				// rows from center minus -3
				// also minux another -1
				// will give a
				// value which represents
				// the number of tiles from
				// the center most black tile
				// in a row
				//
				// so, 2 rows from center will
				// result in 0
				// 0 means that there is only
				// a center tile
				//
				// 1 row from center results
				// in 1 which means that
				// there are one tile to the
				// left and another to theright 
				// of the center tile
				// and the center row will result
				// in 2 tiles to the left of center
				// and another 2 to the right of 
				// center
				int tileCount = Math.abs(Math.abs(approx_mid_height-i)-3)-1;
				System.out.printf("%s\n", 
					buildRow(width,tileCount));
			}
			else 
			{
				System.out.printf("\n");
			}
		}
	}
}
