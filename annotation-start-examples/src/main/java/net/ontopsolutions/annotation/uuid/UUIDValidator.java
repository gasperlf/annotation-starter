package net.ontopsolutions.annotation.uuid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UUIDValidator implements ConstraintValidator<UUID, String> {

    protected String PATTERN = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$";
    Pattern pattern = Pattern.compile(PATTERN);
    private UUID uuid;

    @Override
    public void initialize(UUID constraintAnnotation) {
        this.uuid = constraintAnnotation;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (s.isEmpty() || s == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
