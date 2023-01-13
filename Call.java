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

class O <T extends Callable> extends Observer <T>{
    public void update(T s) {
        s.call("String from Observer");
    }
}
interface Callable{
    default void call(String str){
        System.out.println(this + ".call(" + str + ")");
    }
}
class S01 extends Subject implements Callable{}
class S02 extends Subject implements Callable{}

public class Call {
    public static void main(String[] args) {
		O o = new O();
		S01 s1 = new S01();
		S02 s2 = new S02();
		
		s1.attach(o);
		s2.attach(o);
		s1.doNotify();
		s2.doNotify();
	}
}