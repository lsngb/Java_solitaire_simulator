package project1;
public class CardOperations {
	private char s;
	private int v;
	private boolean f;
/*	Constructor Card(Suit s, value v, status f)
    pre - Card does not exist
    post - Card exists with attributes s,v,f*/
	public CardOperations(char s,int v,boolean f){
		this.s=s;
		this.v=v;
		this.f=f;
	}
/*	void FaceUp()
 	pre - Card exists
    post - Card.status := FaceUp
    FaceUp - f=true*/
	public void Faceup(){
		f=true;
	}
/*	void FaceDown()
    pre - Card exists
    post - Card.status := FaceDown*/
	public void FaceDown(){
		f=false;
	}
/*	status CardStatus()
    pre - Card exists
    post - Card is unchanged; current status value of C is returned to user*/
	public boolean CardStatus(){
		return f;
	}
/*	value CardValue()
    pre - Card exists
    post - Card is unchanged; current value of C is returned to user*/
	public int CardValue(){
		return v;
	}
/*	suit CardSuit()
    pre - Card exists
    post - Card is unchanged; Suit of C is returned to user*/
	public char CardSuit(){
		return s;
	}
	//card features to string
	public String toString(){
		StringBuilder card = new StringBuilder();
		if (f==false){
			card.append("XX");
		}
		
		else{
			card.append(s);
			if(v==1){
				card.append("A");
			}
			else if(v==11){
				card.append("J");
			}
			else if(v==12){
				card.append("Q");
			}
			else if(v==13){
				card.append("K");
			}
			else{
				card.append(v);
			}
		}
		card.append("\t");
		return card.toString();
	}
}
