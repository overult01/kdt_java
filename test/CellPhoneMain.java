package test;

// 예외처리 실습 

class CellPhone {
	String model; // 핸드폰 모델
	double battery; // 남은 배터리 양  

	// 모델 번호를 인자로 받는 생성자를 생성& 초기화.
	CellPhone(String model) {
		this.model = model;
	}
	
	// 통화 시간(분)을 출력하고, 통화 시간에 따라 배터리 양을 감소시킨다.
	void call(int time) {

		try {
			battery -= time * 0.5;
			if (battery < 0) {
				battery = 0;
				throw new IllegalAccessError("통화시간입력오류");  // 출력이 안되고 있는 모습 
			}
			else {
				System.out.println("통화 시간: " + time);
			}
		}
		catch (IllegalAccessError error) {
			System.out.println("통화시간입력오류2");
		}
	}
	
	// 충전한 시간(분)을 출력하고, 충전한 시간에 따라 배터리 양을 증가시킨다.
	void charge(int time) throws IllegalArgumentException{
		try {
			battery += time * 3;  // 100까지로 수정필요 
			if (battery > 100) {
				throw new IllegalAccessError("충전시간입력오류");
			}
			else {
				System.out.println("충전 시간: " + time);
			}
		}
		catch (IllegalAccessError error) {
			System.out.println("충전시간입력오류");			
		}
	}

	void  printBattery() {	// 남은 배터리 양을 출력한다.
		System.out.println("남은 배터리: " + battery);
	}
	
	
//boolean  isSame(CellPhone other)	
////CellPhone 타입의 객체를 입력받고 (??), 입력받은 객체의
////모델 번호가 같은 경우에 true를 리턴한다.

	boolean isSame(CellPhone other) {
//		if ((other).equalsIgnoreCase(model.toString())) {
		if (other.model.equalsIgnoreCase(model)) {
			return true;
		}
		else {
			return false;
		}
		
	}
}


//========================================
///*<<CellPhoneMain 실행결과>>
//충전 시간 : 20분
//남은 배터리 양 : 60.0
//통화 시간 : 300분
//남은 배터리 양 : 0.0
//충전 시간 : 50분
//남은 배터리 양 : 100.0
//통화 시간 : 40분
//남은 배터리 양 : 80.0
//통화시간입력오류
//동일 모델입니다. 
//*/
public class CellPhoneMain {
 
public static void main(String[] args) { 
	CellPhone myPhone =  new CellPhone("GALAXY-9");
		
//charge, call 메소드 호출 포함하여 try-catch 블록 정의
// throws 하고 있는 예외 처리한다.
// 각 예외 발생시 어떤 메소드에서 어떤 원인으로 발생했는지 출력한다


		myPhone.charge( 20 );  //20분간 충전을 한다.
		myPhone.printBattery();
		
		myPhone.call( 300 );  //300분간 통화를 한다. (???? 말이 안되는데. 통화시간입력 오류가 나왔어야) 
		myPhone.printBattery();
		
		myPhone.charge( 50 );  //50분간 충전을 한다.
		myPhone.printBattery();
		
		myPhone.call( 40 );  //40분간 통화를 한다.
		myPhone.printBattery();
		
		myPhone.call( -20 );  //통화시간입력오류
		
		CellPhone yourPhone = new CellPhone("galaxy-9");
		
		if( myPhone.isSame(yourPhone) ) {
			System.out.println("동일 모델입니다.");
		} else {
			System.out.println("다른 모델입니다.");
		} 
	} 
}



