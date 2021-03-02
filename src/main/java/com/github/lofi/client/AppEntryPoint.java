package com.github.lofi.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.user.client.ui.RootPanel;

public class AppEntryPoint implements EntryPoint {

	private static Logger logger = Logger.getLogger(AppEntryPoint.class.getName());

	@Override
	public void onModuleLoad() {
		// Add CalculatorPanel to the HTML file
		RootPanel rootPanel = RootPanel.get("panel");
		rootPanel.add(new Calculator("From GWT"));

		// Inject JS nowait
		injectScript();
	}

	private void injectScript() {
		ScriptInjector.fromUrl("testcalculator-nowait.js").setCallback(new Callback<Void, Exception>() {
			public void onFailure(Exception reason) {
				logger.info("Script load failed.");
			}

			public void onSuccess(Void result) {
				logger.info("Script load success.");
			}
		}).setWindow(ScriptInjector.TOP_WINDOW).inject();
	}
}
