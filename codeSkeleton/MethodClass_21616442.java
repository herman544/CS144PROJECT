
/** You should rename this class but it is often helpful to put methods of a certain theme in a different class
(i.e. you create your own library). This would prevent your main program .java file from becoming overly long
 and complex but its up to you if you would like to do this.**/
import stdlib.*;
import java.util.Arrays;
import java.util.InputMismatchException;

//	Please excuse the messy code, 
//	I lost all my project progress
//	due to a computer crash last week.
//	I had the file backed up, but due to
//	the crash my hard drive was corrupted.
//	I have tried to recreate my code in time,
//	so I please ask that you excuse 
//	that my program doesn't run correctly
//	and have a look at my code/methods and logic.
//	Any feedback/suggestions would be welcome.


public class MethodClass_21616442 {
	private int rowx, colx, iter;
	private int currentiter = 0;
	String[] values = null;
	int counter = 0;
	int counter2 = 0;

	WarriorTypeInterface_21616442[] warriorArray = new WarriorTypeInterface_21616442[15];

	StoneWarrior_21616442 stwarrior = new StoneWarrior_21616442();
	FlameWarrior_21616442 flwarrior = new FlameWarrior_21616442();
	AirWarrior_21616442 airwarrior = new AirWarrior_21616442();
	WaterWarrior_21616442 watwarrior = new WaterWarrior_21616442();

	WaterCrystalPeace_21616442[] wcpArr = new WaterCrystalPeace_21616442[20];
	NeigborhoodPieceClass_21616442[] nbrArray = new NeigborhoodPieceClass_21616442[8];

	public void readFile(String pathname) {

		In in = new In(pathname);
		rowx = in.readInt();
		colx = in.readInt();
		iter = in.readInt();

		String nextline = in.readString();

		int linelength = nextline.length();
		String type = nextline.substring(0, linelength - 1);
		int amount = in.readInt();

		switch (type) {

		case "Warrior":

			int row, col, id;
			String wtype, movements;
			int age, OP, DS, IS;
			double health;

			String first = in.readLine();

			for (int i = 0; i < amount; i++) {

				nextline = in.readLine();

				values = nextline.split(" ");

				row = Integer.parseInt(values[0]);
				col = Integer.parseInt(values[1]);
				id = Integer.parseInt(values[2]);
				wtype = values[3];
				age = Integer.parseInt(values[4]);
				health = Double.parseDouble(values[5]);
				OP = Integer.parseInt(values[6]);
				DS = Integer.parseInt(values[7]);
				IS = Integer.parseInt(values[8]);
				movements = values[9];

				createWarrior(row, col, id, wtype, age, health, OP, DS, IS, movements);

				// System.out.println(warriorArray[i].toString());

			}

		case "Water":

			if (in.hasNextLine()) {
				nextline = in.readLine();
				linelength = nextline.length();
				type = nextline.substring(0, linelength - 3);
				amount = Integer.parseInt(String.valueOf(nextline.charAt(linelength - 1)));
			}

			for (int i = 0; i < amount; i++) {

				if (in.hasNextLine()) {
					nextline = in.readLine();
					row = Integer.parseInt(String.valueOf(nextline.charAt(0)));
					col = Integer.parseInt(String.valueOf(nextline.charAt(2)));

					createWaterCrystalPeace(row, col, type);

					// System.out.println(wcpArr[i]);
				}

			}

		case "Weapon":

			for (int i = 0; i < amount; i++) {

			}

		default:
			// code block
		}

	}

	public void createWarrior(int row, int col, int id, String type, int age, double health, int OP, int DS, int IS,
			String movements) {

		if (type.equals("Stone")) {

			stwarrior.setRow(row);
			stwarrior.setCol(col);
			stwarrior.setId(id);
			stwarrior.setWtype(type);
			stwarrior.setAge(age);
			stwarrior.setHealth(health);
			stwarrior.setOP(OP);
			stwarrior.setDS(DS);
			stwarrior.setIS(IS);
			stwarrior.setMovements(movements);

			warriorArray[counter] = stwarrior;
			counter++;

			System.out.println(stwarrior.toString());
		}

		if (type.equals("Flame")) {

			flwarrior.setRow(row);
			flwarrior.setCol(col);
			flwarrior.setId(id);
			flwarrior.setWtype(type);
			flwarrior.setAge(age);
			flwarrior.setHealth(health);
			flwarrior.setOP(OP);
			flwarrior.setDS(DS);
			flwarrior.setIS(IS);
			flwarrior.setMovements(movements);

			warriorArray[counter] = flwarrior;
			counter++;

			System.out.println(flwarrior.toString());
		}
		if (type.equals("Air")) {

			airwarrior.setRow(row);
			airwarrior.setCol(col);
			airwarrior.setId(id);
			airwarrior.setWtype(type);
			airwarrior.setAge(age);
			airwarrior.setHealth(health);
			airwarrior.setOP(OP);
			airwarrior.setDS(DS);
			airwarrior.setIS(IS);
			airwarrior.setMovements(movements);

			warriorArray[counter] = airwarrior;
			counter++;

			System.out.println(airwarrior.toString());
		}
		if (type.equals("Water")) {

			watwarrior.setRow(row);
			watwarrior.setCol(col);
			watwarrior.setId(id);
			watwarrior.setWtype(type);
			watwarrior.setAge(age);
			watwarrior.setHealth(health);
			watwarrior.setOP(OP);
			watwarrior.setDS(DS);
			watwarrior.setIS(IS);
			watwarrior.setMovements(movements);

			warriorArray[counter] = watwarrior;
			counter++;

			System.out.println(watwarrior.toString());
		}

	}

	public void createWaterCrystalPeace(int row, int col, String type) {

		WaterCrystalPeace_21616442 wcp = new WaterCrystalPeace_21616442();
		wcp.setRow(row);
		wcp.setCol(col);
		wcp.setType(type);

		wcpArr[counter2] = wcp;
		counter2++;

		// System.out.println(wcp.toString());

	}

	public void createRestWeapon(int row, int col, double benefit) {

	}

	public void createPotion(int row, int col, int type, int iter) {

	}

	public void neighborhoodCheck(int col, int row, int width, int height) {
		// takes in coordinates, determines the neighborhood of that piece
		// total 8 neighborhood pieces

		// commented out for testing
		// width = getColx();
		// height = getRowx();

		int x = col;
		int y = row;

		for (int i = 0; i < nbrArray.length; i++) {
			NeigborhoodPieceClass_21616442 nbr = new NeigborhoodPieceClass_21616442();
			nbrArray[i] = nbr;
		}

		// corner pieces wrapping
		if (y == 0 && x == 0) {
			// nBot, nR, nBr are normal

			nbrArray[0].setNamePosition("nTop");
			nbrArray[0].setX(x);
			nbrArray[0].setY(height - 1); // correct special

			nbrArray[1].setNamePosition("nBot");
			nbrArray[1].setX(x);
			nbrArray[1].setY(y + 1);// correct

			nbrArray[2].setNamePosition("nL");
			nbrArray[2].setX(width - 1);
			nbrArray[2].setY(y);// correct special

			nbrArray[3].setNamePosition("nR");
			nbrArray[3].setX(x + 1);
			nbrArray[3].setY(y);// correct

			nbrArray[4].setNamePosition("nTL");
			nbrArray[4].setX(width - 1);
			nbrArray[4].setY(height - 1);// correct special

			nbrArray[5].setNamePosition("nTR");
			nbrArray[5].setX(x + 1);
			nbrArray[5].setY(height - 1);// correct special

			nbrArray[6].setNamePosition("nBL");
			nbrArray[6].setX(width - 1);
			nbrArray[6].setY(y + 1);// correct special

			nbrArray[7].setNamePosition("nBR");
			nbrArray[7].setX(x + 1);
			nbrArray[7].setY(y + 1);// correct

		} else if (y == 0 && x == (width - 1)) {
			// nBot, nL, nBl are normal

			nbrArray[0].setNamePosition("nTop");
			nbrArray[0].setX(width - 1);
			nbrArray[0].setY(height - 1);// correct special

			nbrArray[1].setNamePosition("nBot");
			nbrArray[1].setX(x);
			nbrArray[1].setY(y + 1);// correct

			nbrArray[2].setNamePosition("nL");
			nbrArray[2].setX(x - 1);
			nbrArray[2].setY(y);// correct

			nbrArray[3].setNamePosition("nR");
			nbrArray[3].setX(0);
			nbrArray[3].setY(y);// correct special

			nbrArray[4].setNamePosition("nTL");
			nbrArray[4].setX(x - 1);
			nbrArray[4].setY(height - 1);// correct special

			nbrArray[5].setNamePosition("nTR");
			nbrArray[5].setX(0);
			nbrArray[5].setY(height - 1);

			nbrArray[6].setNamePosition("nBL");
			nbrArray[6].setX(x - 1);
			nbrArray[6].setY(y + 1);// correct

			nbrArray[7].setNamePosition("nBR");
			nbrArray[7].setX(0);
			nbrArray[7].setY(y + 1);// correct special

		} else if (x == 0 && y == (height - 1)) {
			// nTop, nTr, nR are normal

			nbrArray[0].setNamePosition("nTop");
			nbrArray[0].setX(x);
			nbrArray[0].setY(y - 1);// correct

			nbrArray[1].setNamePosition("nBot");
			nbrArray[1].setX(x);
			nbrArray[1].setY(0);// correct special

			nbrArray[2].setNamePosition("nL");
			nbrArray[2].setX(width - 1);
			nbrArray[2].setY(y);// correct special

			nbrArray[3].setNamePosition("nR");
			nbrArray[3].setX(x + 1);
			nbrArray[3].setY(y);// correct

			nbrArray[4].setNamePosition("nTL");
			nbrArray[4].setX(width - 1);
			nbrArray[4].setY(y - 1);// correct special

			nbrArray[5].setNamePosition("nTR");
			nbrArray[5].setX(x + 1);
			nbrArray[5].setY(y - 1);// correct

			nbrArray[6].setNamePosition("nBL");
			nbrArray[6].setX(width - 1);
			nbrArray[6].setY(0);// correct special

			nbrArray[7].setNamePosition("nBR");
			nbrArray[7].setX(x + 1);
			nbrArray[7].setY(0);// correct special

		} else if (x == (width - 1) && y == (height - 1)) {
			// nTop, nTl, nL are normal

			nbrArray[0].setNamePosition("nTop");
			nbrArray[0].setX(x);
			nbrArray[0].setY(y - 1); // correct

			nbrArray[1].setNamePosition("nBot");
			nbrArray[1].setX(x);
			nbrArray[1].setY(0);// correct special

			nbrArray[2].setNamePosition("nL");
			nbrArray[2].setX(x - 1);
			nbrArray[2].setY(y);// correct

			nbrArray[3].setNamePosition("nR");
			nbrArray[3].setX(0);
			nbrArray[3].setY(y);// correct special

			nbrArray[4].setNamePosition("nTL");
			nbrArray[4].setX(x - 1);
			nbrArray[4].setY(y - 1);// correct

			nbrArray[5].setNamePosition("nTR");
			nbrArray[5].setX(0);
			nbrArray[5].setY(y - 1);// correct special

			nbrArray[6].setNamePosition("nBL");
			nbrArray[6].setX(x - 1);
			nbrArray[6].setY(0);// correct special

			nbrArray[7].setNamePosition("nBR");
			nbrArray[7].setX(0);
			nbrArray[7].setY(0);// correct special

		}

		// top and bottom wrapping
		else if (y == 0 && x != 0 && x != (width - 1)) {

			nbrArray[0].setNamePosition("nTop");
			nbrArray[0].setX(x);
			nbrArray[0].setY(height - 1);// correct special

			nbrArray[1].setNamePosition("nBot");
			nbrArray[1].setX(x);
			nbrArray[1].setY(y + 1);// correct

			nbrArray[2].setNamePosition("nL");
			nbrArray[2].setX(x - 1);
			nbrArray[2].setY(y);// correct

			nbrArray[3].setNamePosition("nR");
			nbrArray[3].setX(x + 1);
			nbrArray[3].setY(y);// correct

			nbrArray[4].setNamePosition("nTL");
			nbrArray[4].setX(x - 1);
			nbrArray[4].setY(height - 1); // correct special

			nbrArray[5].setNamePosition("nTR");
			nbrArray[5].setX(x + 1);
			nbrArray[5].setY(height - 1);// correct special

			nbrArray[6].setNamePosition("nBL");
			nbrArray[6].setX(x - 1);
			nbrArray[6].setY(y + 1);// correct

			nbrArray[7].setNamePosition("nBR");
			nbrArray[7].setX(x + 1);
			nbrArray[7].setY(y + 1);// correct

		} else if (y == (height - 1) && x != 0 && x != (width - 1)) {

			nbrArray[0].setNamePosition("nTop");
			nbrArray[0].setX(x);
			nbrArray[0].setY(y - 1);// correct

			nbrArray[1].setNamePosition("nBot");
			nbrArray[1].setX(x);
			nbrArray[1].setY(0);// correct special

			nbrArray[2].setNamePosition("nL");
			nbrArray[2].setX(x - 1);
			nbrArray[2].setY(y);// correct

			nbrArray[3].setNamePosition("nR");
			nbrArray[3].setX(x + 1);
			nbrArray[3].setY(y);// correct

			nbrArray[4].setNamePosition("nTL");
			nbrArray[4].setX(x - 1);
			nbrArray[4].setY(y - 1);// correct

			nbrArray[5].setNamePosition("nTR");
			nbrArray[5].setX(x + 1);
			nbrArray[5].setY(y - 1);// correct

			nbrArray[6].setNamePosition("nBL");
			nbrArray[6].setX(x - 1);
			nbrArray[6].setY(0);// correct special

			nbrArray[7].setNamePosition("nBR");
			nbrArray[7].setX(x + 1);
			nbrArray[7].setY(0);// correct special

		}

		// left and right wrapping
		else if (x == 0 && y != 0 && y != (height - 1)) {

			nbrArray[0].setNamePosition("nTop");
			nbrArray[0].setX(x);
			nbrArray[0].setY(y - 1);// correct

			nbrArray[1].setNamePosition("nBot");
			nbrArray[1].setX(x);
			nbrArray[1].setY(y + 1);// correct

			nbrArray[2].setNamePosition("nL");
			nbrArray[2].setX(width - 1);
			nbrArray[2].setY(y);// correct special

			nbrArray[3].setNamePosition("nR");
			nbrArray[3].setX(x + 1);
			nbrArray[3].setY(y);// correct

			nbrArray[4].setNamePosition("nTL");
			nbrArray[4].setX(width - 1);
			nbrArray[4].setY(y - 1);// correct special

			nbrArray[5].setNamePosition("nTR");
			nbrArray[5].setX(x + 1);
			nbrArray[5].setY(y - 1);// correct

			nbrArray[6].setNamePosition("nBL");
			nbrArray[6].setX(width - 1);
			nbrArray[6].setY(y + 1);// correct special

			nbrArray[7].setNamePosition("nBR");
			nbrArray[7].setX(x + 1);
			nbrArray[7].setY(y + 1);// correct

		} else if (x == (width - 1) && y != 0 && y != (height - 1)) {

			nbrArray[0].setNamePosition("nTop");
			nbrArray[0].setX(x);
			nbrArray[0].setY(y - 1);// correct

			nbrArray[1].setNamePosition("nBot");
			nbrArray[1].setX(x);
			nbrArray[1].setY(y + 1);// correct

			nbrArray[2].setNamePosition("nL");
			nbrArray[2].setX(x - 1);
			nbrArray[2].setY(y);// correct

			nbrArray[3].setNamePosition("nR");
			nbrArray[3].setX(0);
			nbrArray[3].setY(y);// correct special

			nbrArray[4].setNamePosition("nTL");
			nbrArray[4].setX(x - 1);
			nbrArray[4].setY(y - 1);// correct

			nbrArray[5].setNamePosition("nTR");
			nbrArray[5].setX(0);
			nbrArray[5].setY(y - 1);// correct special

			nbrArray[6].setNamePosition("nBL");
			nbrArray[6].setX(x - 1);
			nbrArray[6].setY(y + 1);// correct

			nbrArray[7].setNamePosition("nBR");
			nbrArray[7].setX(0);
			nbrArray[7].setY(y + 1);// correct special

		} else {

			nbrArray[0].setNamePosition("nTop");
			nbrArray[0].setX(x);
			nbrArray[0].setY(y - 1);

			nbrArray[1].setNamePosition("nBot");
			nbrArray[1].setX(x);
			nbrArray[1].setY(y + 1);

			nbrArray[2].setNamePosition("nL");
			nbrArray[2].setX(x - 1);
			nbrArray[2].setY(y);

			nbrArray[3].setNamePosition("nR");
			nbrArray[3].setX(x + 1);
			nbrArray[3].setY(y);

			nbrArray[4].setNamePosition("nTL");
			nbrArray[4].setX(x - 1);
			nbrArray[4].setY(y - 1);

			nbrArray[5].setNamePosition("nTR");
			nbrArray[5].setX(x + 1);
			nbrArray[5].setY(y - 1);

			nbrArray[6].setNamePosition("nBL");
			nbrArray[6].setX(x - 1);
			nbrArray[6].setY(y + 1);

			nbrArray[7].setNamePosition("nBR");
			nbrArray[7].setX(x + 1);
			nbrArray[7].setY(y + 1);

		}
		// standard (no wrapping)

		for (int i = 0; i < nbrArray.length; i++) {
			// System.out.println(nbrArray[i].toString());
		}

	}

	public void waterLogic(int row, int col) {
		// water drying, flowing, etc
		// check if cell contains water
		int counter = 0;

		// System.out.println(counter);

		for (int i = 0; i < wcpArr.length; i++) {

			try {
				if (wcpArr[i].getType().equals("Water")) {

					counter++;
					// System.out.println(counter);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		// if cell has water
		int checkX[] = new int[9];
		int checkY[] = new int[9];
		int checkXlong[] = new int[9 * counter];
		int checkYlong[] = new int[9 * counter];
		int k = 0;
		int z = 0;

		// creates coordinate arrays for x and y
		for (int i = 0; i < counter; i++) {

			checkX[0] = wcpArr[i].getCol();
			checkY[0] = wcpArr[i].getRow();

			// System.out.println(wcpArr[i]);

			for (int j = 0; j < nbrArray.length; j++) {

				neighborhoodCheck(wcpArr[i].getCol(), wcpArr[i].getRow(), colx, rowx);
				checkX[j + 1] = nbrArray[j].getX();
				checkY[j + 1] = nbrArray[j].getY();

				// System.out.println(nbrArray[j].toString());

			}
			// fills all x coordinates into single array
			for (int w = k; w < k + 9; w++) {
				// System.out.println(w +" "+(w-k));
				checkXlong[w] = checkX[w - k];
			}
			k = k + 9;
			// fills all y coordinates into single array
			for (int w = z; w < z + 9; w++) {
				// System.out.println(w +" "+(w-z));
				checkYlong[w] = checkY[w - z];
			}
			z = z + 9;
		}

		for (int i = 0; i < k; i++) {
			// System.out.println(checkXlong[i] +" "+ checkYlong[i]);
		}

		// check the big arrays for neighboring water blocks
		int c = 0;
		int index[];
		int WaterNbr[];

		// if water coordinates match another neighborhood coordinates
		// i=neighborhood piece influenced by xx, xx=specific water piece in that
		// neighborhood
		// need to work out to which water piece i belongs, e.g 0<i<9 is water[0] and
		// 9<i<18 is water[1]
		// (nr of different xx in a given range[0,9]etc) = count of water blocks in nbr

		for (int xx = 0; xx < checkYlong.length; xx = xx + 9) {

			for (int i = 0; i < checkYlong.length; i++) {

				// skips water coordinates
				if (i % 9 == 0) {
					continue;
				}

				// calculates size of array

				if (checkXlong[xx] == checkXlong[i] && checkYlong[xx] == checkYlong[i]) {
					// System.out.println(checkXlong[xx] + " " + checkYlong[xx] + ", " +
					// checkXlong[i] + " "
					// + checkYlong[i] + " ,i: " + i + " ,xx: " + xx);

					c++;

				}

			}
		}

		index = new int[c];// index of water block in wcpArr
		WaterNbr = new int[c];// number of water blocks in neighborhood
		int j = 0;
		for (int xx = 0; xx < checkYlong.length; xx = xx + 9) {

			for (int i = 0; i < checkYlong.length; i++) {

				// skips water coordinates
				if (i % 9 == 0) {
					continue;
				}

				// fills new array for calculations

				if (checkXlong[xx] == checkXlong[i] && checkYlong[xx] == checkYlong[i]) {

					index[j] = i;
					WaterNbr[j] = xx;
					j++;

				}

			}
		}

		int finalIndexArr[] = new int[10];
		int finalNbrArr[];
		int lcount1 = 0;
		int fcount1 = 0;
		int zz = 0;

		// while(zz<checkXlong.length) {
		for (int i = 0; i < index.length; i++) {

			// System.out.println(index[i] + " " + WaterNbr[i]);

			// if (index[i] > zz && index[i] < zz + 9) {
			// fcount1++;
			// System.out.println(fcount1);
			// finalIndexArr[lcount1] = WaterNbr[i]%8;
			// lcount1++;
			// }

			try {

				if (index[i] > 0 && index[i] < 9) {
					fcount1++;
					finalIndexArr[0] = fcount1;
				}
				if (index[i] > 9 && index[i] < 18) {
					fcount1++;
					finalIndexArr[1] = fcount1;
				}
				if (index[i] > 18 && index[i] < 27) {
					fcount1++;
					finalIndexArr[2] = fcount1;
				}
				if (index[i] > 27 && index[i] < 36) {
					fcount1++;
					finalIndexArr[3] = fcount1;
				}
				if (index[i] > 36 && index[i] < 45) {
					fcount1++;
					finalIndexArr[4] = fcount1;
				}
				if (index[i] > 45 && index[i] < 54) {
					fcount1++;
					finalIndexArr[5] = fcount1;
				}
				if (index[i] > 54 && index[i] < 63) {
					fcount1++;
					finalIndexArr[6] = fcount1;
				}

				// System.out.println("i:" +i + " "+ finalIndexArr[i]);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	public void waterRefresh() {
		// computes the stat increase for warriors from water blocks

		for (int ii = 0; ii < warriorArray.length; ii++) {
			neighborhoodCheck(warriorArray[ii].getCol(), warriorArray[ii].getRow(), colx, rowx);

			for (int i = 0; i < nbrArray.length; i++) {
				int watercount = 0;
				for (int j = 0; j < wcpArr.length; j++) {

					if (nbrArray[i].getX() == wcpArr[j].getCol() && nbrArray[i].getY() == wcpArr[j].getRow()) {
						watercount++;
						if (warriorArray[ii].getWtype().equals("Water")) {
							warriorArray[ii].setHealth(warriorArray[i].getHealth() + 3);
							warriorArray[ii].setHealth(warriorArray[i].getHealth() + watercount);

						}
						warriorArray[ii].setHealth(warriorArray[i].getHealth() + 3);
					} else {
						warriorArray[ii].setHealth(warriorArray[i].getHealth() - 0.5);
					}

				}

			}
		}

	}

	public void defenseCheckWarrior() {
		// takes values from neighborhoodCheck and compares defenses
		// removes HP under conditions

		WarriorTypeInterface_21616442[] warriorOGvalues = new WarriorTypeInterface_21616442[warriorArray.length];

		warriorOGvalues = warriorArray.clone();

		for (int i = 0; i < warriorArray.length; i++) {

			WarriorTypeInterface_21616442 currentWarrior = warriorOGvalues[i];

			for (int j = 0; j < nbrArray.length; j++) {

				for (int i2 = 0; i2 < warriorOGvalues.length; i2++) {

					neighborhoodCheck(warriorOGvalues[i2].getCol(), warriorOGvalues[i2].getRow(), colx, rowx);

					if (currentWarrior.getCol() == nbrArray[j].getX()
							&& currentWarrior.getRow() == nbrArray[j].getY()) {

						if (warriorOGvalues[i2].getDS() > currentWarrior.getDS()) {
							warriorArray[i].setHealth(warriorArray[i].getHealth() - warriorOGvalues[i2].getOP());
						}

					}

				}

			}
			if (warriorArray[i].getHealth() <= 0) {
				// not working
				warriorArray[i] = null;
				System.out.println("Warrior has left the game!");
			}
			warriorArray[i].setAge(warriorArray[i].getAge() + 1);
		}

	}

	public void moveWarrior() {
		for (int i = 0; i < warriorArray.length; i++) {

			if (warriorArray[i].getMovements().length() < iter) {
				warriorArray[i].setMovements(warriorArray[i].getMovements()
						+ warriorArray[i].getMovements().substring(0, iter - warriorArray[i].getMovements().length()));
			}

			neighborhoodCheck(warriorArray[i].getCol(), warriorArray[i].getRow(), colx, rowx);
			String mvm[] = warriorArray[i].getMovements().split("");
			int count = mvm.length;

			for (int j = 0; j < count; j++) {

				if (mvm[j].equals("d")) {
					// right
					warriorArray[i].setCol(nbrArray[3].getX());
					warriorArray[i].setRow(nbrArray[3].getY());

				}
				if (mvm[j].equals("a")) {
					// left
					warriorArray[i].setCol(nbrArray[2].getX());
					warriorArray[i].setRow(nbrArray[2].getY());
				}
				if (mvm[j].equals("w")) {
					// upwards
					warriorArray[i].setCol(nbrArray[0].getX());
					warriorArray[i].setRow(nbrArray[0].getY());
				}
				if (mvm[j].equals("x")) {
					// downwards
					warriorArray[i].setCol(nbrArray[1].getX());
					warriorArray[i].setRow(nbrArray[1].getY());
				}
				if (mvm[j].equals("e")) {
					// top right
					warriorArray[i].setCol(nbrArray[5].getX());
					warriorArray[i].setRow(nbrArray[5].getY());
				}
				if (mvm[j].equals("q")) {
					// top left
					warriorArray[i].setCol(nbrArray[4].getX());
					warriorArray[i].setRow(nbrArray[4].getY());
				}
				if (mvm[j].equals("c")) {
					// bottom right
					warriorArray[i].setCol(nbrArray[7].getX());
					warriorArray[i].setRow(nbrArray[7].getY());
				}
				if (mvm[j].equals("z")) {
					// bottom left
					warriorArray[i].setCol(nbrArray[6].getX());
					warriorArray[i].setRow(nbrArray[6].getY());
				}
				if (mvm[j].equals("n")) {
					// no movement

				}
			}
		}
	}

	public int ageCapCheck() {
		// computes the max ds for warriors
		for (int i = 0; i < warriorArray.length; i++) {

			if (warriorArray[i].getAge() > 15) {
				if (warriorArray[i].getDS() > 70) {
					warriorArray[i].setDS(70);
				}
			}

			if (warriorArray[i].getAge() > 25) {
				if (warriorArray[i].getDS() > 50) {
					warriorArray[i].setDS(50);
				}
			}

			if (warriorArray[i].getAge() > 50) {
				if (warriorArray[i].getDS() > 30) {
					warriorArray[i].setDS(30);
				}
			}
		}

		return 0;
	}

	public void allianceCheck() {
		// checks for same warriors on same square
		// boosts stats for alliances
		int counter = 0;
		int warriorcounter = 0;
		for (int i = 0; i < warriorArray.length; i++) {

			try {
				if (warriorArray[i].getWtype().contentEquals("Water")
						|| warriorArray[i].getWtype().contentEquals("Flame")
						|| warriorArray[i].getWtype().contentEquals("Stone")
						|| warriorArray[i].getWtype().contentEquals("Air")) {
					counter++;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		int wf = 0;
		int ws = 0;
		int wa = 0;
		int ww = 0;

		for (int i = 0; i < counter; i++) {
			for (int j = i + 1; j < counter; j++) {

				if (warriorArray[i].getCol() == warriorArray[j].getCol()
						&& warriorArray[i].getRow() == warriorArray[j].getRow()
				// && warriorArray[i].getId() != warriorArray[j].getId()
				) {
					// warriors of same type on same square
					// System.out.println("i:"+i+" j:"+j);

					if (warriorArray[j].getWtype().equals("Flame") && warriorArray[i].getWtype().equals("Flame")) {

						wf = wf % j;
						wf++;
					}

					if (warriorArray[j].getWtype().equals("Stone") && warriorArray[i].getWtype().equals("Stone")) {

						ws = ws % j;
						ws++;
					}

					if (warriorArray[j].getWtype().equals("Air") && warriorArray[i].getWtype().equals("Air")) {

						wa = wa % j;
						wa++;
					}

					if (warriorArray[j].getWtype().equals("Water") && warriorArray[i].getWtype().equals("Water")) {

						ww = ww % j;
						ww++;
					}

				}

			}
			// System.out.println("f" + wf + " s" + ws + " a" + wa + " w" + ww);
		}

	}

	public int getRowx() {
		return rowx;
	}

	public int getColx() {
		return colx;
	}

	public int getIter() {
		return iter;
	}

	public void setIter(int iter) {
		this.iter = iter;
	}

	public void visualDisplay() {

		String board[][] = new String[colx][rowx];

		
		//fills board with empty spaces
		for (int i = 0; i < colx; i++) {
			for (int j = 0; j < rowx; j++) {

				board[i][j] = ".";

			}

		}

		for (int j2 = 0; j2 < warriorArray.length; j2++) {

			//fills board with warriors
			if (warriorArray[j2].getWtype().equals("Flame")) {
				board[warriorArray[j2].getCol()][warriorArray[j2].getRow()] = "F";
			} else if (warriorArray[j2].getWtype().equals("Water")) {
				board[warriorArray[j2].getCol()][warriorArray[j2].getRow()] = "W";
			} else if (warriorArray[j2].getWtype().equals("Air")) {
				board[warriorArray[j2].getCol()][warriorArray[j2].getRow()] = "A";
			} else if (warriorArray[j2].getWtype().equals("Stone")) {
				board[warriorArray[j2].getCol()][warriorArray[j2].getRow()] = "S";
			} else {

				//fills board with water
				for (int i2 = 0; i2 < wcpArr.length; i2++) {
					if (wcpArr[i2].getType().equals("Water")) {
						board[wcpArr[i2].getCol()][wcpArr[i2].getRow()] = "w";
					}
				}

			}

		}
		
		for (int i = 0; i < colx; i++) {
			for (int j = 0; j < rowx; j++) {
					System.out.println(board[i][j]);
				}
			}
		}

}
