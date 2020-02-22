package fr.jbe.jfxspringboot.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.jbe.jfxspringboot.db.domain.User;
import fr.jbe.jfxspringboot.db.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;

	@FXML
	private TextField name;
	
	@FXML
	private Label displayName;
	
	@FXML
	private TextArea userList;
	
	@FXML
	private void initialize() {
		name.clear();
		displayName.setText("");
		
		User user = userService.findByFirstname("Julien");
		if (user == null) {
			user = new User("Julien", "B");
			userService.save(user);
		}
		User user2 = userService.findByFirstname("David");
		if (user2 == null) {
			user2 = new User("David", "M");
			userService.save(user2);
		}
	}
	
	@FXML
	public void handleHello() {
		if (!name.getText().isEmpty()) {
			displayName.setText(name.getText());
		}
	}
	
	@FXML
	public void handleDisplay() {
		List<User> users = userService.findAll();
		for (User user : users) {
			userList.appendText(user.getFirstname().concat(" ").concat(user.getLastname().concat("\n")));
		}
	}
	
}
