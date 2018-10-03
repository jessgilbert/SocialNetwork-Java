package org.softwire.training.views;

import io.dropwizard.views.View;

import java.nio.charset.StandardCharsets;

public class InvalidUsernameView extends View {
    public InvalidUsernameView() {
        super("InvalidUsernameView.mustache", StandardCharsets.UTF_8);
    }
}
