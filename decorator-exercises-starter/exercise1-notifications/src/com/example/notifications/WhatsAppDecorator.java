
package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
	private final String waUser;

	public WhatsAppDecorator(Notifier notifier, String waUser) {
		super(notifier);
		this.waUser = waUser;
	}

	@Override
	public void notify(String text) {
		super.notify(text);
		System.out.println("[WhatsApp -> " + waUser + "]: " + text);
	}
}
