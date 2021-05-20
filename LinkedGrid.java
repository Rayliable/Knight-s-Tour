package codes;

public class LinkedGrid {
		
	private Node first;
	private int dimension;
	private boolean SPoints = false;
	
	public LinkedGrid(){
		first=null;
	}
	
	public LinkedGrid(int dimension)
	{
		this.dimension = dimension;
		if(dimension == 1)
			first = new Node();
		else if(dimension <= 0)
			first = null;
		else
		{
			first = new Node();
			Node temp = null;
			Node rowMarker = first;
			Node columnMarker = first;
			for(int x = 0; x<dimension-1; x++)
			{
				temp = new Node();
				columnMarker.setRight(temp);
				temp.setLeft(columnMarker);
				columnMarker = temp;
			}
			for(int y = 0; y < dimension - 1; y++)
			{
				//making the first node in the row
				temp = new Node();
				rowMarker.setDown(temp);
				temp.setUp(rowMarker);
				rowMarker = temp;
				//making the rest of the row
				columnMarker = rowMarker;
				for(int x = 0; x < dimension-1; x++)
				{
					temp = new Node();
					temp.setLeft(columnMarker);
					columnMarker.setRight(temp);
					temp.setUp( temp.getLeft().getUp().getRight() );
					temp.getUp().setDown(temp);
					columnMarker = temp;
				}
			}
		}
	}
	
	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	
	public boolean isSPoints() {
		return SPoints;
	}

	public void setSPoints(boolean sPoints) {
		SPoints = sPoints;
	}

	public Node getFirst() {
		return first;
	}

	public void display()
	{
		Node temp = first;
		Node rowMarker = first;
		while(temp != null)
		{
			while(temp != null)
			{
				if(temp.getData() > 99)
					System.out.print(temp.getData() + " ");
				else if(temp.getData() > 9)
					System.out.print(temp.getData() + "  ");
				else 
					System.out.print(temp.getData() + "   ");
				temp = temp.getRight();
			}
			System.out.println();
			rowMarker = rowMarker.getDown();
			temp = rowMarker;
		}
	}
	
	public void setSecondaryPoints()
	{
		Node temp = first;
		Node rowMarker = first;
		while(temp != null)
		{
			while(temp != null)
			{
				if(temp.getUp()!=null&&temp.getUp().getUp()!=null&&temp.getUp().getUp().getLeft()!=null)
					temp.setUUL(temp.getUp().getUp().getLeft());
				if(temp.getUp()!=null&&temp.getUp().getUp()!=null&&temp.getUp().getUp().getRight()!=null)
					temp.setUUR(temp.getUp().getUp().getRight());
				
				if(temp.getRight()!=null&&temp.getRight().getRight()!=null&&temp.getRight().getRight().getUp()!=null)
					temp.setRRU(temp.getRight().getRight().getUp());
				if(temp.getRight()!=null&&temp.getRight().getRight()!=null&&temp.getRight().getRight().getDown()!=null)
					temp.setRRD(temp.getRight().getRight().getDown());

				if(temp.getDown()!=null&&temp.getDown().getDown()!=null&&temp.getDown().getDown().getLeft()!=null)
					temp.setDDL(temp.getDown().getDown().getLeft());
				if(temp.getDown()!=null&&temp.getDown().getDown()!=null&&temp.getDown().getDown().getRight()!=null)
					temp.setDDR(temp.getDown().getDown().getRight());
				
				if(temp.getLeft()!=null&&temp.getLeft().getLeft()!=null&&temp.getLeft().getLeft().getUp()!=null)
					temp.setLLU(temp.getLeft().getLeft().getUp());
				if(temp.getLeft()!=null&&temp.getLeft().getLeft()!=null&&temp.getLeft().getLeft().getDown()!=null)
					temp.setLLD(temp.getLeft().getLeft().getDown());
				
				
				temp = temp.getRight();
			}
			rowMarker = rowMarker.getDown();
			temp = rowMarker;
		}
		SPoints=true;
	}
}