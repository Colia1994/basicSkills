package org.kly.designPatterns.行为型模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 *
 * @Author konglingyao
 * @Date 2020/7/7
 */
public abstract class Subject {

    private List<Observer> observerList = new ArrayList<>();

    public void attachObserver(Observer observer) {
        observerList.add(observer);
    }

    public void detachObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObserver(int[] xy) {
        for (Observer observer : observerList) {
            observer.update(xy);
        }
    }
}
