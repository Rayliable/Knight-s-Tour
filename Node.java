package codes;

public class Node {
	
	//private static int counter;
	private int data;
	private Node up,down,left,right;
	private Node UUL, UUR, RRU, RRD, DDL, DDR, LLU, LLD;

	
	//constructor w/ variable
	public Node(int data){
		this.data = data;
		up=null;
		down=null;
		left=null;
		right=null;
	}
	
	//constructor w/o variable
	public Node(){
		//counter++;
		this.data = 0;
		up=null;
		down=null;
		left=null;
		right=null;
		
		
	}

	public Node getUUL() {
		return UUL;
	}

	public void setUUL(Node uUL) {
		UUL = uUL;
	}

	public Node getUUR() {
		return UUR;
	}

	public void setUUR(Node uUR) {
		UUR = uUR;
	}

	public Node getRRU() {
		return RRU;
	}

	public void setRRU(Node rRU) {
		RRU = rRU;
	}

	public Node getRRD() {
		return RRD;
	}

	public void setRRD(Node rRD) {
		RRD = rRD;
	}

	public Node getDDL() {
		return DDL;
	}

	public void setDDL(Node dDL) {
		DDL = dDL;
	}

	public Node getDDR() {
		return DDR;
	}

	public void setDDR(Node dDR) {
		DDR = dDR;
	}

	public Node getLLU() {
		return LLU;
	}

	public void setLLU(Node lLU) {
		LLU = lLU;
	}

	public Node getLLD() {
		return LLD;
	}

	public void setLLD(Node lLD) {
		LLD = lLD;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getUp() {
		return up;
	}

	public void setUp(Node up) {
		this.up = up;
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setSecondaryLinks(){
		//Secondary points
		
		//UUL
		if(up!=null&&up.getUp()!=null&&up.getUp().getLeft()!=null)
			UUL=up.getUp().getLeft();
		//UUR
		if(up!=null&&up.getUp()!=null&&up.getUp().getRight()!=null)
			UUR=up.getUp().getRight();
		
		//RRU
		if(right!=null&&right.getRight()!=null&&right.getRight().getUp()!=null)
			RRU=right.getRight().getUp();
		//RRD
		if(right!=null&&right.getRight()!=null&&right.getRight().getDown()!=null)
			RRD=right.getRight().getDown();

		//DDL
		if(down!=null&&down.getDown()!=null&&down.getDown().getLeft()!=null)
			DDL=down.getDown().getLeft();
		//DDR
		if(down!=null&&down.getDown()!=null&&down.getDown().getRight()!=null)
			DDR=down.getDown().getRight();
		
		//LLU
		if(left!=null&&left.getLeft()!=null&&left.getLeft().getUp()!=null)
			LLU=left.getLeft().getUp();
		//LLD
		if(left!=null&&left.getLeft()!=null&&left.getLeft().getDown()!=null)
			LLD=left.getLeft().getDown();
	}
	
	
	public void kTour(int number){
		data=number;
		
		if(data==(Main.Grid.getDimension()*Main.Grid.getDimension())){
			Main.Grid.display();
			System.out.println();
			Main.solutions++;
		}
		
		//Secondary points option
		
		if(Main.Grid.isSPoints()==true){
			
			//UUL
			if(UUL!=null&&UUL.getData()==0){
				UUL.kTour(number+1);
			}
			//UUR
			if(UUR!=null&&UUR.getData()==0){
				UUR.kTour(number+1);
			}
			
			//RRU
			if(RRU!=null&&RRU.getData()==0){
				RRU.kTour(number+1);
			}
			//RRD
			if(RRD!=null&&RRD.getData()==0){
				RRD.kTour(number+1);
			}
			
			//DDL
			if(DDL!=null&&DDL.getData()==0){
				DDL.kTour(number+1);
			}
			//DDR
			if(DDR!=null&&DDR.getData()==0){
				DDR.kTour(number+1);
			}
			
			//LLU
			if(LLU!=null&&LLU.getData()==0){
				LLU.kTour(number+1);
			}
			//LLD
			if(LLD!=null&&LLD.getData()==0){
				LLD.kTour(number+1);
			}
		}
		
		else{
		
			//Primary points option
			//UUL
			if(up!=null&&up.getUp()!=null&&up.getUp().getLeft()!=null&&up.getUp().getLeft().getData()==0){
				up.getUp().getLeft().kTour(number+1);
			}
			//UUR
			if(up!=null&&up.getUp()!=null&&up.getUp().getRight()!=null&&up.getUp().getRight().getData()==0){
				up.getUp().getRight().kTour(number+1);
			}
			
			//RRU
			if(right!=null&&right.getRight()!=null&&right.getRight().getUp()!=null&&right.getRight().getUp().getData()==0){
				right.getRight().getUp().kTour(number+1);
			}
			//RRD
			if(right!=null&&right.getRight()!=null&&right.getRight().getDown()!=null&&right.getRight().getDown().getData()==0){
				right.getRight().getDown().kTour(number+1);
			}
			
			//DDL
			if(down!=null&&down.getDown()!=null&&down.getDown().getLeft()!=null&&down.getDown().getLeft().getData()==0){
				down.getDown().getLeft().kTour(number+1);
			}
			//DDR
			if(down!=null&&down.getDown()!=null&&down.getDown().getRight()!=null&&down.getDown().getRight().getData()==0){
				down.getDown().getRight().kTour(number+1);
			}
			
			//LLU
			if(left!=null&&left.getLeft()!=null&&left.getLeft().getUp()!=null&&left.getLeft().getUp().getData()==0){
				left.getLeft().getUp().kTour(number+1);
			}
			//LLD
			if(left!=null&&left.getLeft()!=null&&left.getLeft().getDown()!=null&&left.getLeft().getDown().getData()==0){
				left.getLeft().getDown().kTour(number+1);
			}
		}
		
		data=0;		
				
	}
	
}
