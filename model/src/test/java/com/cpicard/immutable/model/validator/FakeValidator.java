package com.cpicard.immutable.model.validator;

public class FakeValidator extends ValidatorAbs {
    public FakeValidator(final String name) {
        super(name);
    }

    @Override
    public String validate() {
        return null;
    }
}
