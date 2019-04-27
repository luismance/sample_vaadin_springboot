package com.accenture.devcon;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;

@Route("component")
public class OpensourceComponent extends VerticalLayout {

	public OpensourceComponent() {
		/*
		 * DatePicker datePicker = new DatePicker("I'm a date picker");
		 * datePicker.addValueChangeListener(listener -> {
		 * Notification.show(listener.getValue().toString(), 5000, Position.MIDDLE); });
		 * 
		 * MemoryBuffer memoryBuffer = new MemoryBuffer(); Upload upload = new
		 * Upload(memoryBuffer); upload.setAcceptedFileTypes("image/jpg", "image/png",
		 * "image/gif"); upload.addSucceededListener(listener -> {
		 * Notification.show("File " + listener.getFileName() +
		 * " uploaded successfully!");
		 * 
		 * Files.copy(memoryBuffer.getInputStream(), (new File("D://")).getPath(),
		 * StandardCopyOption.REPLACE_EXISTING);
		 * 
		 * });
		 * 
		 * Button btnGreet = new Button("Button with Text", VaadinIcon.PLUG.create());
		 * add(btnGreet); add(datePicker); add(upload);
		 */

		LoginForm loginForm = new LoginForm();
		loginForm.addLoginListener(listener -> {
			if (authenticate(listener)) {
				Notification.show("Login Successful!");
			} else {
				loginForm.setError(true);
			}
		});

		add(loginForm);
	}

	public boolean authenticate(LoginEvent e) {
		if (e.getUsername().equals("admin") && e.getPassword().equals("admin")) {
			return true;
		}
		return false;
	}

}
