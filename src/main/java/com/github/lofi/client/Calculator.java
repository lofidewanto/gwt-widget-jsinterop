package com.github.lofi.client;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL)
public class Calculator extends Composite implements ClickHandler {

	private static Logger logger = Logger.getLogger(Calculator.class.getName());

	private TextBox textBox = new TextBox();

    private CheckBox checkBox = new CheckBox();

	public Calculator(String name) {
		logger.info("Calculator init begins... " + name);

		// Place the check above the text box using a vertical panel.
		VerticalPanel panel = new VerticalPanel();
		panel.add(checkBox);
		panel.add(textBox);
  
		// Set the check box's caption, and check it by default.
		String caption = "Enable / Disable TextBox";
		checkBox.setValue(true);
		checkBox.setText(caption);
		checkBox.addClickHandler(this);
  
		// All composites must call initWidget() in their constructors.
		initWidget(panel);
  
		// Give the overall composite a style name.
		setStyleName("example-OptionalCheckBox");

		logger.info("Calculator init ends... " + name);
	}

	public Element getAsElement() {
		return this.getElement();
	}

	public double calculateSum(Double[] values) {
		if (values != null) {
			List<Double> doubles = Arrays.asList(values);
			logger.info("Values size: " + doubles.size());
			Double sum = doubles.stream().mapToDouble(Double::doubleValue).sum();
			return sum;
		} else {
			logger.info("Values: null");
			return 0.0;
		}
	}

    @Override
    public void onClick(ClickEvent event) {
        Object sender = event.getSource();
      
		if (sender == checkBox) {
        // When the check box is clicked, update the text box's enabled state.
        textBox.setEnabled(checkBox.getValue());
      }
    }

    public void setCaption(String caption) {
		// Note how we use the use composition of the contained widgets to provide
		// only the methods that we want to.
		checkBox.setText(caption);
	  }

	  public String getCaption() {
		return checkBox.getText();
	  }
}