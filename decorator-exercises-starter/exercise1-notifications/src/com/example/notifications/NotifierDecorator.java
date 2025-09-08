package com.example.notifications;

public abstract class NotifierDecorator implements Notifier {
	protected Notifier wrappee;

	public NotifierDecorator(Notifier notifier) {
		this.wrappee = notifier;
	}

	@Override
	public void notify(String text) {
		wrappee.notify(text);
	}
}
