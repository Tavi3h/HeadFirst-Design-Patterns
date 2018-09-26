package ch_02_ObserverPattern.weatherStation;

// 主题接口
public interface Subject {
	public void registerObserver(Observer o); // 注册一个观察者
	public void removeObserver(Observer o); // 删除一个观察者
	public void notifyObservers(); // 当主题改变时，这个方法会被调用，以通知所有的观察者。
}
