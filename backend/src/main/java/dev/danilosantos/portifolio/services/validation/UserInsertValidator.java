package dev.danilosantos.portifolio.services.validation;

import java.util.ArrayList;
import java.util.List;

import dev.danilosantos.portifolio.controllers.exceptions.FieldMessage;
import dev.danilosantos.portifolio.dto.AuthRegisterDTO;
import dev.danilosantos.portifolio.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, AuthRegisterDTO> {
	
	private UserRepository repository;
	
	public UserInsertValidator(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UserInsertValid ann) {
	}
	
	@Override
	public boolean isValid(AuthRegisterDTO dto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if (!repository.findByEmail(dto.getEmail()).isEmpty()) {
			list.add(new FieldMessage("email", "Email já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
