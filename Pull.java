import java.util.ArrayList;

class Observer <S> {
	public void update(S s) {}
}
class Subject {
	ArrayList<Observer> observers = new ArrayList<>();
	public void attach(Observer o) {
		observers.add(o);
	}
	public void detach(Observer o) {
		observers.remove(o);
	}
	public void doNotify() {
		observers.forEach(o->o.update(this));
	}
}

class O <T extends S> extends Observer <T> {
    public void update(T s){
        System.out.println(s.msg);       
    }
}
class S extends Subject {
    public String msg = "Something pulled from the Subject.";
}
public class Pull {
    public static void main(String[] args) {
		O o = new O();
		S s = new S();
		
		s.attach(o);
		s.doNotify();
	}
}