package org.softwire.training.views;

import io.dropwizard.views.View;

import java.nio.charset.StandardCharsets;

public class SignOutView extends View {
    public SignOutView() {
        super("SignOut.mustache", StandardCharsets.UTF_8);
    }
}
