package edu.easternct.csc231.ch4;

/**
 * generate a centered diamond
 */
public class DiamondTile {

	/**
	 * build a row that contains black tiles
	 * <p>
	 * count is how many to build out from estimated
	 * middle
	 * <p>
	 * so a count of zero would mean one tile in center,
	 * a count of one would mean three tiles means one
	 * in the center and two on the flanks
	 *
	 * @param width width of row
	 * @param count number of tiles to the flanks
	 *              of the center tile
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
	 *
	 * @param args takes 2 numbers, first height, second width
	 */
	public static void main(String[] args) {

		// no, too many, or too little args
		if (args.length != 2)
		{
			System.out.printf("Not enough args\n");
			System.out.printf("Requires one height and width\n");
			return;
		}

		// (x/2) * 2 + 1 would calculate the next odd
		// odds will have perfect center 
		int height = Integer.parseInt(args[0]);
		int width = Integer.parseInt(args[1]);

		// too small
		if (height < 5 || width < 5)
		{	
			System.out.printf("Tile area too small\n");
			System.out.printf("Needs to be 5 or greater\n");
			return;
		}
		
		// note the integer casting
		// can't be floating position
		int approx_mid_height = (int) (height/2);	
		System.out.printf("%d\n",approx_mid_height);
		// pyramid will grow too large for a skinny wall
		// if the height is tall and width small
		// so this finds the smallest side
		int smallest_side = height > width ? width : height;

		// using the smallest side, I calculate
		// the start, end and in-between
		// insead of using the approximate height - 1
		// this makes a perfectly variable diamond for
		// 5x5 and greater dimensions
		int approx_pyramid_start_end = (int) (smallest_side/2-1);

		for (int i=0; i<height; ++i)
		{
			// if three rows to or
			// from approximate center row
			// plus center row
			if (Math.abs(approx_mid_height-i) >= 0 &&
				Math.abs(approx_mid_height-i) <= 
				approx_pyramid_start_end)
			{
				// note that center in this
				// context is refering to
				// the row's center position
				// any row printed here contains
				// at least one black tile
				// and at most 7 black tiles
				//
				// tile count is number of tiles to
				// the flank of the centermost tile
				// so a value of zero here will
				// result in only one tile
				// and a value of one will result
				// in two tiles to the left and
				// right of centermost tile
				int tileCount = 
					Math.abs(
						Math.abs(approx_mid_height-i)
						-(approx_pyramid_start_end));

				// print the row
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
