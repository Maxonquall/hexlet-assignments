package exercise;

import io.javalin.Javalin;

import java.util.Collections;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            List<User> users;

            if (term != null) {
                users = USERS.stream()
                        .filter(u -> StringUtils.startsWithIgnoreCase(u.getFirstName(), term))
                        .toList();
            } else {
                users = USERS;
            }

            var usersPage = new UsersPage(users, term);
            ctx.render("users/index.jte", Collections.singletonMap("page", usersPage));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
