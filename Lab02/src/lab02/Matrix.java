package lab02;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// default constructor
	public Matrix(){}
	
	// constructor 1 - Constructor for new zero matrix
	
	public Matrix(int rowDim, int colDim){
		numRows = rowDim;
		numColumns = colDim;
		data = new int[numRows][numColumns];
		
	}
	
	// constructor 2 - Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{  
		int i;
		int j;
		numRows = d.length;
		if(d.length != 0) {
			numColumns = d[0].length;
		}
		data = new int [numRows][numColumns];
		
		for(i = 0; i < numRows; i++) {
			for(j = 0; j < numColumns; j++) {
				data[i][j] = d[i][j];
			}
		}
		
		
		/* 1) put the numRows to be the number of 1D arrays in the 2D array
		*  2) specify the numColumns and set it
		*  3) be careful of special cases you are supposed to handle them properly
		*  4) create a new matrix to hold the data
		*  5) copy the data over
		*/
	} 

	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		String dataString="";
		
		int i;
		int j;

		for(i = 0; i < numRows; i++) {
			dataString += "\n";
			for(j = 0; j < numColumns; j++) {
				dataString = (dataString + data[i][j] + " ");
			}
		}
		dataString += "\n";
		/*
		 * TODO: replace the below return statement with the correct code, you must return a String that represents this 
		 * 			matrix, as specified in the instruction for M1 - anything else IS NOT acceptable
		 */
		return dataString; // placeholder		
	}
	
	// *** you will implement the rest of the methods for your assignment
	// *** don't touch them before finishing the lab portion
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		
		int i;
		int j; 
		
		if(numRows == m.numRows) {
			if(numColumns == m.numColumns) {
				for(i = 0; i<numRows; i++) {
					for(j=0; j<numColumns; j++) {
						if(data[i][j] != m.data[i][j]) {
							return false;
						}
					}
				} return true;
				
			}else {
				return false;
			}
			
		}else {
			return false;
		}
		/*
		 * TODO: replace the below return statement with the correct code, you must return the correct value
		 * 			after determining if this matrix is equal to the input matrix
		 */
		//return false; // placeholder
	}

	public Matrix mult(Matrix m)
	{
		
		if(numColumns == m.numRows){
			Matrix matrixMult = new Matrix (numRows, m.numColumns);
			
		for(int i = 0; i< numRows; i++){
			
			for(int j = 0; j< m.numColumns; j++){
				
				for(int k = 0; k<numColumns; k++){
					matrixMult.data[i][j] += data[i][k] * m.data[k][j];
					}
				 
			}
		}return matrixMult;
			
		}else {
			return null;
		}
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for multiplication, if not, return null.
		 *  If they are compatible, determine the dimensions of the resulting matrix, and fill it in with
		 *  the correct values for matrix multiplication
		 */
		//return null; // placeholder
	}
	
	public Matrix add(Matrix m)
	{
		if(numRows == m.numRows) {
			if(numColumns == m.numColumns) {
				Matrix matrixAdd = new Matrix(numRows, numColumns);
				for(int i = 0; i < numRows; i++) {
					for(int j = 0; j < numColumns; j++) {
						matrixAdd.data[i][j] =  data[i][j] + m.data[i][j];
					}
				} return matrixAdd;
				
			}else {
				return null;
			}
		}else {
			return null;
		}
		/*
		 * TODO: replace the below return statement with the correct code, 
		 *  This function must check if the two matrices are compatible for addition, if not, return null.
		 *  If they are compatible, create a new matrix and fill it in with
		 *  the correct values for matrix addition
		 */
		//return null; // placeholder
	}
    
    public Matrix transpose()
    {
    	Matrix matrixTranspose = new Matrix(data[0].length, data.length);
    	
    	for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numColumns; j++) {
				matrixTranspose.data[j][i] =  data[i][j];
			}
		}
    
        /*
         * TODO: replace the below return statement with the correct code,
         */
        return matrixTranspose; // placeholder
    }
}
