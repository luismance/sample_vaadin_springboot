package com.accenture.devcon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route("")
public class HelloComponent extends VerticalLayout {

	private TextField firstName = new TextField("First Name");
	private TextField lastName = new TextField("Last Name");
	private TextField position = new TextField("Position");

	public HelloComponent() {
		Binder<Employee> binder = new BeanValidationBinder<Employee>(Employee.class);
		binder.bindInstanceFields(this);

		Dialog dialog = new Dialog(new Label("Add Employee"));

		Button btnSave = new Button("Save");
		btnSave.addClickListener(listener -> {
			if (binder.validate().isOk()) {

				RestTemplate rt = new RestTemplate();

				HttpEntity<Employee> request = new HttpEntity<>(
						new Employee(firstName.getValue(), lastName.getValue(), position.getValue()));
				rt.postForEntity("https://java-devcon.appspot.com/user/create", request, Employee.class);
				dialog.close();
				UI.getCurrent().getPage().reload();
			}
		});

		VerticalLayout vl = new VerticalLayout(firstName, lastName, position, btnSave);
		dialog.add(vl);

		add(dialog);

		Button btnCreateEmployee = new Button("Create Employee", new Icon(VaadinIcon.PLUS));
		btnCreateEmployee.addClickListener(listener -> dialog.open());
		btnCreateEmployee.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_PRIMARY);
		add(btnCreateEmployee);

		Grid<Employee> grid = new Grid<>(Employee.class);
		grid.setItems(getList());
		grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_ROW_STRIPES);

		add(grid);

	}

	public List<Employee> getList() {

		RestTemplate rt = new RestTemplate();

		Employee[] response = rt.getForObject("https://java-devcon.appspot.com/user/lists", Employee[].class);

		List<Employee> result = new ArrayList<Employee>();

		for (Employee emp : response) {
			result.add(emp);
		}

		return result;
	}
}
