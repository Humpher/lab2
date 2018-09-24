package pkgHelper;

public class Sudoku extends LatinSquare {
	
	
	//private int [][] puzzle;

	

		private int iSqrtSize ;

		private int iSize;

		

	public Sudoku(int iSize) throws Exception {

		

		super();



		

		

		iSqrtSize = (int) Math.sqrt(iSize);



		try {

			if(Math.floor(iSize) == iSqrtSize) {

			iSqrtSize = (int) Math.sqrt(iSize);

		}}

			

		catch (Exception e) {

				throw e;	

				}

			

		

	}



	public Sudoku(int [][] puzzle) throws Exception {

		

		super(puzzle);

		

		//this.puzzle = puzzle;

		

		iSize = puzzle.length;

		

		iSqrtSize = (int) Math.sqrt(iSize);

			

		

		try {

			if(Math.floor(iSize) == iSqrtSize) {

			iSqrtSize = (int) Math.sqrt(iSize);

			

			}}

		catch (Exception e) {

			throw e;

		}
		

		

	}

		

	public int[] getRegion(int r) {

			

			int[] reg = new int[super.getLatinSquare().length];

			

			int i = (r % iSqrtSize) * iSqrtSize;

			int j = (r / iSqrtSize) * iSqrtSize;

			int iMax = i + iSqrtSize;

			int jMax = j + iSqrtSize;

			int iCnt = 0;

			

			for (; j < jMax; j++) {

				for (i = (r % iSqrtSize) * iSqrtSize; i < iMax; i++) {

					

					System.out.println("J: " + j + "   " + "I: " + i);

					

					

					

					reg[iCnt++] = super.getLatinSquare()[i][j];

				}

			}

			return reg;

		}







	public int[][] getPuzzle(){

		return super.getLatinSquare();

		

	}



		

	public int[] getRegion(int iCol, int iRow) {

		int r = (iCol/iSqrtSize) + ((iRow/iSqrtSize)*iSqrtSize);

				

		return getRegion(r);	

			}

			

		

	public boolean isPartialSudoku() {

		

		boolean isPartialSudoku = false;

		

		if (super.isLatinSquare() == true) {

			

			isPartialSudoku = true;

			

			for (int i = 0; i<super.getLatinSquare().length; i++)	{

		

				if (super.hasDuplicates(getRegion(i)) == false) {

					isPartialSudoku = true;

				}

				

			}

		

				

				if (super.ContainsZero() == true) {

					isPartialSudoku = true;

					

				}

			}

		return isPartialSudoku;

		

		

	}



	public boolean isSudoku() {

		

		boolean isSudoku = false;

		

		for(int j = 0; j<super.getLatinSquare().length;j++) {

			if (super.hasAllValues(super.getRow(0), getRegion(j)) == true) {

				isSudoku = true;

				

			}

		}

		return isSudoku;

		

		

	}



	public boolean isValidValue(int iRow, int iCol, int iValue) {

		 boolean isValidValue = false;

		

		 if((doesElementExist(getRow(iRow), iValue) == false)){

			 //isValidValue = true;

		 

		 	if((doesElementExist(getColumn(iCol), iValue) == false)){

		 		//isValidValue = true;

		 	

		 		if (iValue > 0 && iValue < 10) {

		 			isValidValue = true;

		 		}

		 	}

		

	}

		 

		 return isValidValue;





	}

}

	

